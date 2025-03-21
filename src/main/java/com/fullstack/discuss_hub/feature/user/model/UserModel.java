package com.fullstack.discuss_hub.feature.user.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fullstack.discuss_hub.common.dto.Model;
import com.fullstack.discuss_hub.feature.user.enums.Gender;
import com.fullstack.discuss_hub.feature.user.enums.Role;
import com.fullstack.discuss_hub.validator.ConfirmPasswordValid;
import com.fullstack.discuss_hub.validator.PasswordLengthValid;
import com.fullstack.discuss_hub.validator.UniqueEmailValid;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ConfirmPasswordValid
@JsonInclude(NON_DEFAULT)
public class UserModel extends Model {
    private Long userId;
    @NotBlank(message = "{name.required}")
    private String name;

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

    @NotNull(message = "{birth.date.required}")
    @JsonFormat(pattern = "yyyy-MM-dd")
//    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;
    private String photoUrl;

    @Enumerated(EnumType.STRING)
    private Gender gender;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Enumerated(EnumType.STRING)
    private Role role;

}

