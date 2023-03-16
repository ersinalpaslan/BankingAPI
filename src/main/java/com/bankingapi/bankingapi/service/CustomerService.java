package com.bankingapi.bankingapi.service;

import com.bankingapi.bankingapi.dto.mapper.CustomerMapper;
import com.bankingapi.bankingapi.dto.request.CreateCustomerRequestDto;
import com.bankingapi.bankingapi.dto.response.CustomerResponseDto;
import com.bankingapi.bankingapi.exception.CustomerNotFoundException;
import com.bankingapi.bankingapi.model.Customer;
import com.bankingapi.bankingapi.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public List<CustomerResponseDto> getAllCustomers() {
        List<Customer> customerList = customerRepository.findAll();
        return customerList.stream()
                .map(customerMapper::toCustomerResponseDto)
                .toList();
    }

    public CustomerResponseDto createCustomer(CreateCustomerRequestDto createCustomerRequestDto) {
        Customer customer = customerMapper.toCustomerFromCreateCustomerRequest(createCustomerRequestDto);
        customerRepository.save(customer);
        return customerMapper.toCustomerResponseDto(customer);
    }

    public CustomerResponseDto getCustomerById(Integer id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);

        return customerOptional.map(customerMapper::toCustomerResponseDto)
                .orElseThrow(()-> new CustomerNotFoundException("Customer not found!"));
    }

    public Optional<Customer> findById(Integer id){
        return customerRepository.findById(id);
    }
}
