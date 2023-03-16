package com.bankingapi.bankingapi.controller;

import com.bankingapi.bankingapi.dto.request.CreateCustomerRequestDto;
import com.bankingapi.bankingapi.dto.response.CustomerResponseDto;
import com.bankingapi.bankingapi.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/v1/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponseDto>> getAllCustomers(){
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDto> getCustomerById(@PathVariable Integer id){
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @PostMapping()
    public ResponseEntity<CustomerResponseDto> createCustomer(@Valid @RequestBody CreateCustomerRequestDto createCustomerRequestDto){
        return new ResponseEntity(customerService.createCustomer(createCustomerRequestDto), HttpStatus.CREATED);
    }
}
