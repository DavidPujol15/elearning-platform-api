package com.portfolio.elearning.repository;

import com.portfolio.elearning.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByName(String name);

    Optional<Category> findBySlug(String slug);

    boolean existsByName(String name);

    boolean existsBySlug(String slug);

    @Query("SELECT c FROM Category c WHERE c.parentId IS NULL ORDER BY c.displayOrder, c.name")
    List<Category> findRootCategories();

    @Query("SELECT c FROM Category c WHERE c.parentId = :parentId ORDER BY c.displayOrder, c.name")
    List<Category> findByParentId(@Param("parentId") Long parentId);

    @Query("SELECT c FROM Category c LEFT JOIN FETCH c.courses WHERE c.id = :categoryId")
    Optional<Category> findByIdWithCourses(@Param("categoryId") Long categoryId);

    @Query("SELECT COUNT(co) FROM Course co WHERE co.category.id = :categoryId")
    long countCoursesByCategoryId(@Param("categoryId") Long categoryId);
}