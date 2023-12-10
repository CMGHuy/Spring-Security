package com.spring.springsecurity.repository;

import java.util.List;

import com.spring.springsecurity.model.AccountTransactions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTransactionsRepository extends CrudRepository<AccountTransactions, Long> {

  List<AccountTransactions> findByCustomerIdOrderByTransactionDtDesc(int customerId);

}
