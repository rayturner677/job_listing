package com.joblisting.joblisting.forms;

public class CommentForm {
    public Integer id;
    public String comment_body;
    public Integer employer_id;

    public CommentForm(Integer id, String comment_body, Integer employer_id) {
        this.id = id;
        this.comment_body = comment_body;
        this.employer_id = employer_id;
    }


    public Integer getEmployer_id() {
        return employer_id;
    }

    public void setEmployer_id(Integer employer_id) {
        this.employer_id = employer_id;
    }

    public Integer getId() {
        return id;
    }

    public String getComment_body() {
        return comment_body;
    }

    public void setComment_body(String comment_body) {
        this.comment_body = comment_body;
    }
}
