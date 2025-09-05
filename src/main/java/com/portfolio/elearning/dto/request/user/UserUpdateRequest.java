package com.portfolio.elearning.dto.request.user;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "User profile update request")
public class UserUpdateRequest {

    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
    @Schema(description = "First name", example = "John")
    private String firstName;

    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
    @Schema(description = "Last name", example = "Doe")
    private String lastName;

    @Email(message = "Email must be valid")
    @Schema(description = "Email address", example = "john@example.com")
    private String email;

    @Pattern(regexp = "^\\+?[1-9]\\d{1,14}$", message = "Phone number must be valid")
    @Schema(description = "Phone number", example = "+1234567890")
    private String phone;

    @Size(max = 1000, message = "Bio cannot exceed 1000 characters")
    @Schema(description = "User biography", example = "Experienced software developer...")
    private String bio;

    @Schema(description = "Profile picture URL", example = "https://example.com/avatar.jpg")
    private String profilePictureUrl;
}