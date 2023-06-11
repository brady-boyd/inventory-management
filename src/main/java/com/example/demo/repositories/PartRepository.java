package com.example.demo.repositories;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 *
 *
 *
 *
 */
public interface PartRepository extends CrudRepository<Part, Long> {
    @Query("SELECT p FROM Part p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', ?1, '%'))")
    public List<Part> searchIgnoreCase(String keyword);

}

