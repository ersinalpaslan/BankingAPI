package com.bankingapi.bankingapi.controller;

import com.bankingapi.bankingapi.dto.request.CreateTransferRequestDto;
import com.bankingapi.bankingapi.dto.response.AccountResponseDto;
import com.bankingapi.bankingapi.dto.response.TransferResponseDto;
import com.bankingapi.bankingapi.service.TransferService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/v1/transfer")
public class TransferController {
    private final TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping()
    public ResponseEntity<TransferResponseDto> createTransfer(@Valid @RequestBody CreateTransferRequestDto createTransferRequestDto){
        return new ResponseEntity(transferService.createTransfer(createTransferRequestDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TransferResponseDto>> getAllTransfers(){
        return ResponseEntity.ok(transferService.getAllTransfers());
    }

}
