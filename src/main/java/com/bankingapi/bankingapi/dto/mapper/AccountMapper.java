package com.bankingapi.bankingapi.dto.mapper;

import com.bankingapi.bankingapi.dto.request.CreateAccountRequestDto;
import com.bankingapi.bankingapi.dto.response.AccountResponseDto;
import com.bankingapi.bankingapi.model.Account;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(implementationName = "AccountMapperImpl",componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface AccountMapper {
    AccountResponseDto toAccountResponseDto(Account account);

    Account toAccountFromCreateAccountRequest(CreateAccountRequestDto createAccountRequestDto);
}
