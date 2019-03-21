package com.joblisting.joblisting.repositories;

import com.joblisting.joblisting.forms.CommentForm;
import com.joblisting.joblisting.forms.EmployerForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class PostgresEmployerRepository implements com.joblisting.joblisting.repositories.Repository<EmployerForm> {
    private JdbcTemplate jdbc;

    @Autowired
    public PostgresEmployerRepository(JdbcTemplate jdbctemplate) {
        jdbc = jdbctemplate;
    }

    public Optional<EmployerForm> findById(Integer id) {
        return Optional.ofNullable(jdbc.queryForObject("SELECT id, name, address, position, description, benefits, email, logo_url FROM employers WHERE id = ?", this::mapToRow, id));
    }

    public void save(EmployerForm employer) {
        jdbc.update("INSERT INTO employers (name, address, position, description, benefits, email, logo_url) VALUES(?,?,?,?,?,?,?)", employer.name,
                employer.address, employer.position, employer.description, employer.benefits, employer.email, employer.logo_url);
    }

    public List<EmployerForm> findAll() {
        return jdbc.query("SELECT id, name, address, position, description, benefits, email, logo_url FROM employers", this::mapToRow);
    }

    public void delete(Integer id) {
        jdbc.update("DELETE FROM employers WHERE id = ?", id);
    }

    public void saveComments(CommentForm form) {
        jdbc.update("INSERT INTO comments(comment_body, employer_id) VALUES(?,?)", form.comment_body, form.employer_id);
    }

    private EmployerForm mapToRow(ResultSet row, int rowNum) throws SQLException {
        return new EmployerForm(
                row.getInt("id"),
                row.getString("name"),
                row.getString("address"),
                row.getString("position"),
                row.getString("description"),
                row.getString("benefits"),
                row.getString("email"),
                row.getString("logo_url")
        );
    }
}