package com.portfolio.elearning.repository;

import com.portfolio.elearning.entity.Course;
import com.portfolio.elearning.entity.enums.CourseLevel;
import com.portfolio.elearning.entity.enums.CourseStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>, JpaSpecificationExecutor<Course> {

    Page<Course> findByStatus(CourseStatus status, Pageable pageable);

    Page<Course> findByInstructorId(Long instructorId, Pageable pageable);

    Page<Course> findByCategoryId(Long categoryId, Pageable pageable);

    @Query("SELECT c FROM Course c WHERE c.status = 'PUBLISHED' AND c.active = true")
    Page<Course> findPublishedCourses(Pageable pageable);

    @Query("SELECT c FROM Course c WHERE " +
            "c.status = 'PUBLISHED' AND " +
            "(LOWER(c.title) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
            "LOWER(c.description) LIKE LOWER(CONCAT('%', :search, '%')))")
    Page<Course> searchPublishedCourses(@Param("search") String search, Pageable pageable);

    @Query("SELECT c FROM Course c WHERE " +
            "c.status = 'PUBLISHED' AND " +
            "(:categoryId IS NULL OR c.category.id = :categoryId) AND " +
            "(:level IS NULL OR c.level = :level) AND " +
            "(:minPrice IS NULL OR c.price >= :minPrice) AND " +
            "(:maxPrice IS NULL OR c.price <= :maxPrice)")
    Page<Course> findCoursesWithFilters(
            @Param("categoryId") Long categoryId,
            @Param("level") CourseLevel level,
            @Param("minPrice") BigDecimal minPrice,
            @Param("maxPrice") BigDecimal maxPrice,
            Pageable pageable
    );

    @Query("SELECT c FROM Course c LEFT JOIN FETCH c.modules m LEFT JOIN FETCH m.lessons WHERE c.id = :courseId")
    Optional<Course> findByIdWithModulesAndLessons(@Param("courseId") Long courseId);

    @Query("SELECT c FROM Course c WHERE c.instructor.id = :instructorId AND c.status = :status")
    List<Course> findByInstructorIdAndStatus(
            @Param("instructorId") Long instructorId,
            @Param("status") CourseStatus status
    );

    @Query("SELECT COUNT(c) FROM Course c WHERE c.instructor.id = :instructorId")
    long countByInstructorId(@Param("instructorId") Long instructorId);

    @Query("SELECT c FROM Course c ORDER BY c.enrollmentCount DESC")
    Page<Course> findPopularCourses(Pageable pageable);

    @Query("SELECT c FROM Course c WHERE c.averageRating >= :minRating ORDER BY c.averageRating DESC")
    Page<Course> findTopRatedCourses(@Param("minRating") Double minRating, Pageable pageable);

    @Query("SELECT c FROM Course c WHERE c.price = 0 AND c.status = 'PUBLISHED'")
    Page<Course> findFreeCourses(Pageable pageable);
}