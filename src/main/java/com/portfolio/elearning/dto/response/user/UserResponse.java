package com.portfolio.elearning.dto.response.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.portfolio.elearning.entity.enums.RoleType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "User information response")
public class UserResponse {

    @Schema(description = "User ID", example = "1")
    private Long id;

    @Schema(description = "Username", example = "john_doe")
    private String username;

    @Schema(description = "Email address", example = "john@example.com")
    private String email;

    @Schema(description = "First name", example = "John")
    private String firstName;

    @Schema(description = "Last name", example = "Doe")
    private String lastName;

    @Schema(description = "Full name", example = "John Doe")
    private String fullName;

    @Schema(description = "Phone number", example = "+1234567890")
    private String phone;

    @Schema(description = "User biography")
    private String bio;

    @Schema(description = "Profile picture URL")
    private String profilePictureUrl;

    @Schema(description = "User role", example = "STUDENT")
    private RoleType role;

    @Schema(description = "Email verification status", example = "true")
    private Boolean emailVerified;

    @Schema(description = "Account active status", example = "true")
    private Boolean active;

    @Schema(description = "Account creation date")
    private LocalDateTime createdAt;

    @Schema(description = "Last login date")
    private LocalDateTime lastLogin;

    // Statistics (for instructors)
    @Schema(description = "Total courses created (for instructors)")
    private Integer totalCourses;

    @Schema(description = "Total students enrolled (for instructors)")
    private Integer totalStudents;

    @Schema(description = "Average rating (for instructors)")
    private Double averageRating;

    // Statistics (for students)
    @Schema(description = "Enrolled courses count (for students)")
    private Integer enrolledCourses;

    @Schema(description = "Completed courses count (for students)")
    private Integer completedCourses;

    @Schema(description = "Certificates earned (for students)")
    private Integer certificatesEarned;
}