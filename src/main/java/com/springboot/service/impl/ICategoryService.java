package com.springboot.service.impl;

import com.springboot.dto.ICategoryDocumentNumber;
import com.springboot.model.Category;

import java.util.List;

public interface ICategoryService extends IGenerateService<Category> {
    void deleteCategoryById(Long id);
    List<Category> findALl();
    List<ICategoryDocumentNumber> getCategoryDocumentNumber();
}