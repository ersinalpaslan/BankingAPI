package com.bankingapi.bankingapi.service;

import com.bankingapi.bankingapi.dto.mapper.TransferMapper;
import com.bankingapi.bankingapi.dto.request.CreateTransferRequestDto;
import com.bankingapi.bankingapi.dto.response.AccountResponseDto;
import com.bankingapi.bankingapi.dto.response.TransferResponseDto;
import com.bankingapi.bankingapi.exception.AccountNotFoundException;
import com.bankingapi.bankingapi.exception.InsufficientAmountException;
import com.bankingapi.bankingapi.model.Account;
import com.bankingapi.bankingapi.model.Transfer;
import com.bankingapi.bankingapi.repository.AccountRepository;
import com.bankingapi.bankingapi.repository.TransferRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class TransferService {
    private final TransferRepository transferRepository;
    private final AccountService accountService;
    private final AccountRepository accountRepository;
    private final TransferMapper transferMapper;

    @Transactional
    public TransferResponseDto createTransfer(CreateTransferRequestDto createTransferRequestDto) {

        Transfer transfer = transferMapper.toTransferFromCreateTransferRequest(createTransferRequestDto);
        Account sender = accountRepository.findById(createTransferRequestDto.getSenderId())
                .orElseThrow(()-> new AccountNotFoundException("Account Not Found"));
        transfer.setSender(sender);

        Account receiver = accountRepository.findById(createTransferRequestDto.getReceiverId())
                .orElseThrow(()-> new AccountNotFoundException("Account Not Found"));
        transfer.setReceiver(receiver);

        if(sender.getAmount().compareTo(createTransferRequestDto.getAmount()) >= 0){
            accountRepository.setAmountForAccount(sender.getAmount().subtract(createTransferRequestDto.getAmount()), sender.getId());
            accountRepository.setAmountForAccount(receiver.getAmount().add(createTransferRequestDto.getAmount()), receiver.getId());
        }
        else{
            throw new InsufficientAmountException("Insufficient Amount");
        }

        transferRepository.save(transfer);

        TransferResponseDto transferResponseDto = new TransferResponseDto();
        transferResponseDto.setAmount(transfer.getAmount());
        transferResponseDto.setSender(transfer.getSender().getId());
        transferResponseDto.setReceiver(transfer.getReceiver().getId());

        return transferResponseDto;
    }

    public List<TransferResponseDto> getAllTransfers() {
        List<Transfer> transferList = transferRepository.findAll();
        return transferList.stream()
                .map(this::toTransferResponseDto)
                .toList();
    }
    public TransferResponseDto toTransferResponseDto(Transfer transfer){
        return TransferResponseDto.builder()
                .amount(transfer.getAmount())
                .sender(transfer.getSender().getId())
                .receiver(transfer.getReceiver().getId())
                .build();
    }
}

