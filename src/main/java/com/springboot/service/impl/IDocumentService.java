package com.springboot.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.swing.text.Document;

public interface IDocumentService extends IGenerateService<Document> {
    Page<Document> findAll(Pageable pageable);
    Page<Document> findByNameContainingIgnoreCase(String name, Pageable pageable);
}
