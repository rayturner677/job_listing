package com.joblisting.joblisting.repositories;

import com.joblisting.joblisting.forms.CommentForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class PostgresCommentRepoitory implements com.joblisting.joblisting.repositories.Repository<CommentForm> {
    private JdbcTemplate jdbc;

    @Autowired
    public PostgresCommentRepoitory(JdbcTemplate jdbctemplate){
        jdbc = jdbctemplate;
    }

    public Optional<CommentForm> findById(Integer id){
        return Optional.ofNullable(jdbc.queryForObject("SELECT id, comment_body, employer_id FROM comments WHERE id = ?", this::mapToRow , id));
    }

    public List<CommentForm> findAll() {
        return jdbc.query("SELECT id, comment_body, employer_id FROM comments", this::mapToRow);
    }

    public void delete(Integer id){jdbc.update("DELETE FROM comments WHERE id = ?", id);}

    public void save(CommentForm form) {
        jdbc.update("INSERT INTO comments(comment_body, employer_id) VALUES(?,?)", form.comment_body, form.employer_id);
    }

    public List<CommentForm> abc(){
        return jdbc.query("SELECT id, name, address, position, description, benefits, email, logo_url FROM employers ORDER BY name ASC", this::mapToRow);
    }

    public List<CommentForm> newest(){
        return jdbc.query("SELECT id, name, address, position, description, benefits, email, logo_url FROM employers ORDER BY id DECS", this::mapToRow);
    }

    public List<CommentForm> oldest(){
        return jdbc.query("Select id, name, address, position, description, benefits, email, logo_url FROM employers ORDER BY id ASC", this::mapToRow);
    }

    CommentForm mapToRow(ResultSet row, int rowNum) throws SQLException {
        return new CommentForm(
                row.getInt("id"),
                row.getString("comment_body"),
                row.getInt("employer_id")
        );
    }
}
