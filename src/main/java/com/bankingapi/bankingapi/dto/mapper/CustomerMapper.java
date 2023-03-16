package com.bankingapi.bankingapi.dto.mapper;

import com.bankingapi.bankingapi.dto.request.CreateCustomerRequestDto;
import com.bankingapi.bankingapi.dto.response.CustomerResponseDto;
import com.bankingapi.bankingapi.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(implementationName = "CustomerMapperImpl",componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface CustomerMapper {
    CustomerResponseDto toCustomerResponseDto (Customer customer);

    Customer toCustomerFromCreateCustomerRequest(CreateCustomerRequestDto createCustomerRequestDto);
}
