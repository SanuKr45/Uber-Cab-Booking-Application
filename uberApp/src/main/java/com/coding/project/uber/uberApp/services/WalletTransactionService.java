package com.coding.project.uber.uberApp.services;

import com.coding.project.uber.uberApp.dto.WalletTransactionDto;
import com.coding.project.uber.uberApp.entities.WalletTransaction;

public interface WalletTransactionService {

    void createNewWalletTransaction(WalletTransaction walletTransaction);

}
