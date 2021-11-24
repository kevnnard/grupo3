package com.misionticg9.account_ms.repositories;

import com.misionticg9.account_ms.models.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository <Account,String>{ }
