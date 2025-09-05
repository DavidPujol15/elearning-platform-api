package com.portfolio.elearning.dto.response.auth;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.portfolio.elearning.dto.response.user.UserResponse;
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
@Schema(description = "Authentication response with tokens")
public class AuthResponse {

    @Schema(description = "JWT access token")
    private String accessToken;

    @Schema(description = "JWT refresh token")
    private String refreshToken;

    @Schema(description = "Token type", example = "Bearer")
    private String tokenType = "Bearer";

    @Schema(description = "Access token expiry time in seconds", example = "3600")
    private Long expiresIn;

    @Schema(description = "Refresh token expiry time in seconds", example = "604800")
    private Long refreshExpiresIn;

    @Schema(description = "Authentication timestamp")
    private LocalDateTime issuedAt;

    @Schema(description = "Authenticated user information")
    private UserResponse user;

    @Schema(description = "Authentication message", example = "Login successful")
    private String message;
}
