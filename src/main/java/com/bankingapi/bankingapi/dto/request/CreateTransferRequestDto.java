package com.bankingapi.bankingapi.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.math.BigDecimal;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateTransferRequestDto {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal amount;

    private Integer senderId;

    private Integer receiverId;


}
