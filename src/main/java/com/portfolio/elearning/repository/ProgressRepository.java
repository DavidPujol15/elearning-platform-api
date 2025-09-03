package com.portfolio.elearning.repository;

import com.portfolio.elearning.entity.Progress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProgressRepository extends JpaRepository<Progress, Long> {

    Optional<Progress> findByUserIdAndLessonId(Long userId, Long lessonId);

    List<Progress> findByUserId(Long userId);

    List<Progress> findByUserIdAndCompleted(Long userId, boolean completed);

    @Query("SELECT p FROM Progress p WHERE p.user.id = :userId AND p.lesson.module.course.id = :courseId")
    List<Progress> findByUserIdAndCourseId(@Param("userId") Long userId, @Param("courseId") Long courseId);

    @Query("SELECT COUNT(p) FROM Progress p WHERE p.user.id = :userId AND p.lesson.module.course.id = :courseId AND p.completed = true")
    long countCompletedByUserAndCourse(@Param("userId") Long userId, @Param("courseId") Long courseId);

    @Query("SELECT COUNT(DISTINCT p.lesson.module.id) FROM Progress p " +
            "WHERE p.user.id = :userId AND p.lesson.module.course.id = :courseId AND p.completed = true " +
            "GROUP BY p.lesson.module.id " +
            "HAVING COUNT(p.lesson.id) = (SELECT COUNT(l.id) FROM Lesson l WHERE l.module.id = p.lesson.module.id)")
    long countCompletedModulesByUserAndCourse(@Param("userId") Long userId, @Param("courseId") Long courseId);

    @Query("SELECT p FROM Progress p WHERE p.user.id = :userId AND p.lesson.module.id = :moduleId")
    List<Progress> findByUserIdAndModuleId(@Param("userId") Long userId, @Param("moduleId") Long moduleId);
}
