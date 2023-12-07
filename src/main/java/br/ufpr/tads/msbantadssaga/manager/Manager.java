package br.ufpr.tads.msbantadssaga.manager;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.lang.NonNull;

public record Manager(@NonNull @Positive Long managerId,
                      @NotEmpty String firstName,
                      @NotEmpty String lastName,
                      @NotEmpty @Email String email,
                      @NotEmpty
                      @Length(min = 11, max = 11)
                      @Pattern(regexp = "^\\d{11}$", message = "field must be made of numbers")
                      String cpf,
                      @NotEmpty
                      @Length(min = 11, max = 11)
                      @Pattern(regexp = "^\\d{11}$", message = "field must be made of numbers")
                      String phone) {
}
