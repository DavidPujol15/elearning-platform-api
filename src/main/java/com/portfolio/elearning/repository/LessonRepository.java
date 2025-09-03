package com.portfolio.elearning.repository;

import com.portfolio.elearning.entity.Lesson;
import com.portfolio.elearning.entity.enums.LessonType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {

    List<Lesson> findByModuleIdOrderByOrderIndex(Long moduleId);

    List<Lesson> findByModuleIdAndLessonType(Long moduleId, LessonType lessonType);

    @Query("SELECT l FROM Lesson l WHERE l.module.course.id = :courseId ORDER BY l.module.orderIndex, l.orderIndex")
    List<Lesson> findByCourseId(@Param("courseId") Long courseId);

    @Query("SELECT COUNT(l) FROM Lesson l WHERE l.module.id = :moduleId")
    long countByModuleId(@Param("moduleId") Long moduleId);

    @Query("SELECT COUNT(l) FROM Lesson l WHERE l.module.course.id = :courseId")
    long countByCourseId(@Param("courseId") Long courseId);

    @Query("SELECT MAX(l.orderIndex) FROM Lesson l WHERE l.module.id = :moduleId")
    Integer findMaxOrderIndexByModuleId(@Param("moduleId") Long moduleId);
}