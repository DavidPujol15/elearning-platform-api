package com.portfolio.elearning.dto.request.enrollment;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Enrollment creation request")
public class EnrollmentCreateRequest {

    @NotNull(message = "Course ID is required")
    @Schema(description = "Course ID to enroll in", example = "1")
    private Long courseId;

    @Schema(description = "Payment amount", example = "49.99")
    private BigDecimal paymentAmount;

    @Schema(description = "Payment method", example = "CREDIT_CARD")
    private String paymentMethod;

    @Schema(description = "Transaction ID from payment processor")
    private String transactionId;

    @Schema(description = "Apply coupon code")
    private String couponCode;
}