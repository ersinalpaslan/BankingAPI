package com.bankingapi.bankingapi.dto.mapper;

import com.bankingapi.bankingapi.dto.request.CreateAccountRequestDto;
import com.bankingapi.bankingapi.dto.request.CreateTransferRequestDto;
import com.bankingapi.bankingapi.dto.response.TransferResponseDto;
import com.bankingapi.bankingapi.model.Account;
import com.bankingapi.bankingapi.model.Transfer;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(implementationName = "TransferMapperImpl",componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TransferMapper {
    Transfer toTransferFromCreateTransferRequest(CreateTransferRequestDto createTransferRequestDto);
}
