package com.bankingapi.bankingapi.dto.response;

import com.bankingapi.bankingapi.model.Account;
import lombok.*;

import java.math.BigDecimal;
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransferResponseDto {

    private BigDecimal amount;
    private Integer sender;
    private Integer receiver;

}
