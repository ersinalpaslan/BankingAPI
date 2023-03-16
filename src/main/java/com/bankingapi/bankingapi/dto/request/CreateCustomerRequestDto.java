package com.bankingapi.bankingapi.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CreateCustomerRequestDto {
    @NotBlank(message = "Name cannot blank")
    private String name;
    @NotBlank(message = "Last name cannot blank")
    private String lastName;
}
