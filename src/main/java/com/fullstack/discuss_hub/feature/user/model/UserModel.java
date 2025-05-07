package com.fullstack.discuss_hub.feature.user.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fullstack.discuss_hub.common.dto.Model;
import com.fullstack.discuss_hub.feature.user.enums.Gender;
import com.fullstack.discuss_hub.feature.user.enums.Role;
import com.fullstack.discuss_hub.validator.ConfirmPasswordValid;
import com.fullstack.discuss_hub.validator.PasswordLengthValid;
import com.fullstack.discuss_hub.validator.UniqueEmailValid;
import com.fullstack.discuss_hub.validator.UniqueUsernameValid;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ConfirmPasswordValid
@JsonInclude(NON_DEFAULT)
public class UserModel extends Model {
    private Long userId;

    @Pattern(regexp = "^[^\\s]+$", message = "Username cannot contain spaces")
    @UniqueUsernameValid
    @NotBlank(message = "{name.required}")
    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @UniqueEmailValid
    @NotBlank(message = "{email.required}")
    @Email(message = "{invalid.email.format}")
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @PasswordLengthValid
    @NotBlank(message = "{password.not.null}")
    private String password;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank(message = "{confirm.password.required}")
    private String confirmPassword;

    private String photoUrl;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private Role role;

}

