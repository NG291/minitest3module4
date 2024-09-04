package com.springboot.repository;

import com.springboot.dto.ICategoryDocumentNumber;
import com.springboot.model.Category;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.print.Book;
import java.util.List;

public interface ICategoryRepository extends JpaRepository<Category, Long> {

    // get data and parse to DTO: ICategoryDocumentNumber
    @Query(nativeQuery = true, value = "SELECT category.name, count(document.id) as number FROM category LEFT JOIN document ON category_id = category.id GROUP BY category.name")
    List<ICategoryDocumentNumber> getCategoryDocumentNumber();

    // use stored procedure to delete
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "CALL sp_delete_category(:id)")
    void deleteCategoryById(@Param("id") Long id);
}