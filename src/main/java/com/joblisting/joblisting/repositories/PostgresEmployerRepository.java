package com.joblisting.joblisting.repositories;

import com.joblisting.joblisting.forms.EmployerForm;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class PostgresEmployerRepository implements com.joblisting.joblisting.repositories.Repository<EmployerForm> {
private JdbcTemplate jdbc;

    public Optional<EmployerForm> findById(Integer id) {
        return Optional.empty();
    }

    public void save(EmployerForm employer) {
        jdbc.update("INSERT INTO employers (name, address, position, description, benefits, email, logo_url VALUES(?,?,?,?,?,?,?)", employer.name,
                employer.address, employer.position, employer.description, employer.benefits, employer.email, employer.logo_url
        );
    }

    public List<EmployerForm> findAll(){
        return jdbc.query("SELECT id, name, address, position, description, benefits, email, logo_url FROM employers", this::mapToRow);
    }

    private EmployerForm mapToRow(ResultSet row, int rowNum) throws SQLException{
        return new EmployerForm(
                row.getString("name"),
                row.getString("address"),
                row.getString("position"),
                row.getString("description"),
                row.getString("benefits"),
                row.getString("email"),
                row.getNString("logo_url")
        );
    }
}
