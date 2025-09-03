package com.portfolio.elearning.repository;

import com.portfolio.elearning.entity.User;
import com.portfolio.elearning.entity.enums.RoleType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    Page<User> findByRole(RoleType role, Pageable pageable);

    @Query("SELECT u FROM User u WHERE u.role = :role AND u.active = true")
    List<User> findActiveUsersByRole(@Param("role") RoleType role);

    @Query("SELECT u FROM User u WHERE " +
            "LOWER(u.firstName) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
            "LOWER(u.lastName) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
            "LOWER(u.email) LIKE LOWER(CONCAT('%', :search, '%'))")
    Page<User> searchUsers(@Param("search") String search, Pageable pageable);

    @Modifying
    @Query("UPDATE User u SET u.lastLogin = :lastLogin WHERE u.id = :userId")
    void updateLastLogin(@Param("userId") Long userId, @Param("lastLogin") LocalDateTime lastLogin);

    @Query("SELECT COUNT(u) FROM User u WHERE u.role = :role")
    long countByRole(@Param("role") RoleType role);

    @Query("SELECT u FROM User u LEFT JOIN FETCH u.enrollments WHERE u.id = :userId")
    Optional<User> findByIdWithEnrollments(@Param("userId") Long userId);

    @Query("SELECT u FROM User u LEFT JOIN FETCH u.instructorCourses WHERE u.id = :userId")
    Optional<User> findByIdWithCourses(@Param("userId") Long userId);
}