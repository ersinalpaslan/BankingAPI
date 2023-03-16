package com.bankingapi.bankingapi.dto.response;

import lombok.*;

import java.math.BigDecimal;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountResponseDto {
    private Integer customerId;
    private BigDecimal amount;
}
