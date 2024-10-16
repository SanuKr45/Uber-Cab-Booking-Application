package com.coding.project.uber.uberApp.services.impl;

import com.coding.project.uber.uberApp.dto.WalletTransactionDto;
import com.coding.project.uber.uberApp.entities.WalletTransaction;
import com.coding.project.uber.uberApp.repositories.WalletRepository;
import com.coding.project.uber.uberApp.repositories.WalletTransactionRepository;
import com.coding.project.uber.uberApp.services.WalletTransactionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


@Service
@RequiredArgsConstructor
public class WalletTransactionServiceImpl implements WalletTransactionService {

    private final WalletTransactionRepository walletTransactionRepository;
    private final ModelMapper modelMapper;


    @Override
    public void createNewWalletTransaction(WalletTransaction walletTransaction) {
        walletTransactionRepository.save(walletTransaction);
    }

}
