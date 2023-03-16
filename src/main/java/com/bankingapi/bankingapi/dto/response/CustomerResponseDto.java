package com.bankingapi.bankingapi.dto.response;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponseDto {
    private Integer id;
    private String name;
    private String lastName;
}
