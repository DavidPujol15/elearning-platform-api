package com.portfolio.elearning.repository;

import com.portfolio.elearning.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {

    List<Module> findByCourseIdOrderByOrderIndex(Long courseId);

    @Query("SELECT m FROM Module m LEFT JOIN FETCH m.lessons WHERE m.id = :moduleId")
    Optional<Module> findByIdWithLessons(@Param("moduleId") Long moduleId);

    @Query("SELECT COUNT(m) FROM Module m WHERE m.course.id = :courseId")
    long countByCourseId(@Param("courseId") Long courseId);

    @Query("SELECT MAX(m.orderIndex) FROM Module m WHERE m.course.id = :courseId")
    Integer findMaxOrderIndexByCourseId(@Param("courseId") Long courseId);
}