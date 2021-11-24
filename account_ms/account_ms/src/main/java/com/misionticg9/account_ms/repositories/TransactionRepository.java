package com.misionticg9.account_ms.repositories;

import com.misionticg9.account_ms.models.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface TransactionRepository extends MongoRepository <Transaction,String>{
    List<Transaction> findByUsernameOrigin (String username);
    List<Transaction> findByUsernameDestiny (String username);
}