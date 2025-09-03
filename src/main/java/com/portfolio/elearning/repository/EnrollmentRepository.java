package com.portfolio.elearning.repository;

import com.portfolio.elearning.entity.Enrollment;
import com.portfolio.elearning.entity.enums.EnrollmentStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

    Optional<Enrollment> findByStudentIdAndCourseId(Long studentId, Long courseId);

    boolean existsByStudentIdAndCourseId(Long studentId, Long courseId);

    Page<Enrollment> findByStudentId(Long studentId, Pageable pageable);

    Page<Enrollment> findByCourseId(Long courseId, Pageable pageable);

    Page<Enrollment> findByStudentIdAndStatus(Long studentId, EnrollmentStatus status, Pageable pageable);

    @Query("SELECT e FROM Enrollment e WHERE e.student.id = :studentId AND e.status = 'ACTIVE' ORDER BY e.lastAccessedAt DESC")
    List<Enrollment> findActiveEnrollmentsByStudent(@Param("studentId") Long studentId);

    @Query("SELECT e FROM Enrollment e WHERE e.course.instructor.id = :instructorId AND e.status = :status")
    Page<Enrollment> findByInstructorIdAndStatus(
            @Param("instructorId") Long instructorId,
            @Param("status") EnrollmentStatus status,
            Pageable pageable
    );

    @Query("SELECT COUNT(e) FROM Enrollment e WHERE e.course.id = :courseId AND e.status = 'ACTIVE'")
    long countActiveByCourseId(@Param("courseId") Long courseId);

    @Query("SELECT COUNT(e) FROM Enrollment e WHERE e.student.id = :studentId AND e.status = 'ACTIVE'")
    long countActiveByStudentId(@Param("studentId") Long studentId);

    @Query("SELECT e FROM Enrollment e WHERE e.expiryDate IS NOT NULL AND e.expiryDate < :now AND e.status = 'ACTIVE'")
    List<Enrollment> findExpiredEnrollments(@Param("now") LocalDateTime now);

    @Query("SELECT e FROM Enrollment e JOIN FETCH e.course c JOIN FETCH c.modules WHERE e.id = :enrollmentId")
    Optional<Enrollment> findByIdWithCourseAndModules(@Param("enrollmentId") Long enrollmentId);
}