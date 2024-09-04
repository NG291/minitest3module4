package com.springboot.repository;

import com.springboot.model.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IDocumentRepository extends PagingAndSortingRepository<Document,Long> {
    Page<Document> findByNameContainingIgnoreCase(String name, Pageable pageable);
}