package com.portfolio.elearning.dto.response.enrollment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.portfolio.elearning.dto.response.course.CourseResponse;
import com.portfolio.elearning.dto.response.user.UserResponse;
import com.portfolio.elearning.entity.enums.EnrollmentStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "Enrollment information response")
public class EnrollmentResponse {

    @Schema(description = "Enrollment ID")
    private Long id;

    @Schema(description = "Student information")
    private UserResponse student;

    @Schema(description = "Course information")
    private CourseResponse course;

    @Schema(description = "Enrollment date")
    private LocalDateTime enrolledAt;

    @Schema(description = "Completion date")
    private LocalDateTime completedAt;

    @Schema(description = "Expiry date")
    private LocalDateTime expiryDate;

    @Schema(description = "Enrollment status")
    private EnrollmentStatus status;

    @Schema(description = "Progress percentage")
    private Integer progressPercentage;

    @Schema(description = "Last accessed date")
    private LocalDateTime lastAccessedAt;

    @Schema(description = "Payment amount")
    private BigDecimal paymentAmount;

    @Schema(description = "Payment method")
    private String paymentMethod;

    @Schema(description = "Certificate issued status")
    private Boolean certificateIssued;

    @Schema(description = "Certificate URL")
    private String certificateUrl;

    @Schema(description = "Certificate issue date")
    private LocalDateTime certificateIssuedAt;

    @Schema(description = "Completed lessons count")
    private Integer completedLessonsCount;

    @Schema(description = "Total lessons count")
    private Integer totalLessonsCount;
}