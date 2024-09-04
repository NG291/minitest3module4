package com.springboot.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IGenerateService<T> {
    T findById(Long id);
    void save(T t);
    void delete(T t);
}