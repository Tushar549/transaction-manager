package com.jar.transactionmanager.repository;

import com.jar.transactionmanager.documents.TransactionHistory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author: Tushar Jain
 * @created: 09/01/24 12:20 pm
 * @email: tusharjain549@gmail.com
 * @project: transactionmanager
 */
public interface TransactionHistoryRepo extends MongoRepository<TransactionHistory, String> {
    List<TransactionHistory> findByMobileNumberAndCreatedAtBetween(String mobileNumber, LocalDateTime fromDate, LocalDateTime toDate);

}
