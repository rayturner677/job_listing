package com.joblisting.joblisting.repositories;
import java.util.List;
import java.util.Optional;

public interface Repository<E>{
    List<E> findAll();

    Optional<E> findById(Integer id);

    void save(E e);

    void delete(E e);
}
