package com.portfolio.elearning.repository;

import com.portfolio.elearning.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    Optional<Review> findByStudentIdAndCourseId(Long studentId, Long courseId);

    boolean existsByStudentIdAndCourseId(Long studentId, Long courseId);

    Page<Review> findByCourseId(Long courseId, Pageable pageable);

    Page<Review> findByStudentId(Long studentId, Pageable pageable);

    @Query("SELECT r FROM Review r WHERE r.course.id = :courseId AND r.rating >= :minRating")
    Page<Review> findByCourseIdAndMinRating(
            @Param("courseId") Long courseId,
            @Param("minRating") Integer minRating,
            Pageable pageable
    );

    @Query("SELECT AVG(r.rating) FROM Review r WHERE r.course.id = :courseId")
    Double calculateAverageRatingByCourseId(@Param("courseId") Long courseId);

    @Query("SELECT COUNT(r) FROM Review r WHERE r.course.id = :courseId AND r.rating = :rating")
    long countByCourseIdAndRating(@Param("courseId") Long courseId, @Param("rating") Integer rating);

    @Query("SELECT r FROM Review r WHERE r.course.instructor.id = :instructorId ORDER BY r.createdAt DESC")
    Page<Review> findByInstructorId(@Param("instructorId") Long instructorId, Pageable pageable);

    Page<Review> findByReportedTrue(Pageable pageable);
}