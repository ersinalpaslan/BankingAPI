package com.bankingapi.bankingapi.dto.request;

import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CreateAccountRequestDto {
    private BigDecimal amount;
    private Integer customerId;
}
