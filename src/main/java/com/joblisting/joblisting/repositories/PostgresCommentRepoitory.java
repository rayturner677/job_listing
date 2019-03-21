package com.joblisting.joblisting.repositories;

import com.joblisting.joblisting.forms.CommentForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class PostgresCommentRepoitory {
    private JdbcTemplate jdbc;

    @Autowired
    public PostgresCommentRepoitory(JdbcTemplate jdbctemplate){
        jdbc = jdbctemplate;
    }

    CommentForm mapToRow(ResultSet row, int rowNum) throws SQLException {
        return new CommentForm(
                row.getInt("id"),
                row.getString("comment_body"),
                row.getInt("employer_id")
        );
    }
}
