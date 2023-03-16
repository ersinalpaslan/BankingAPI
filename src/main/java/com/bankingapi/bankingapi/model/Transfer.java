package com.bankingapi.bankingapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "sender")
    private Account sender;

    @ManyToOne
    @JoinColumn(name = "receiver")
    private Account receiver;
}
