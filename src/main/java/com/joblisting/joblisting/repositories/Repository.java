package com.joblisting.joblisting.repositories;

import com.joblisting.joblisting.forms.CommentForm;

import java.util.List;
import java.util.Optional;

public interface Repository<E>{
    List<E> findAll();

    Optional<E> findById(Integer id);

    void save(E e);

    void delete(Integer id);
}
