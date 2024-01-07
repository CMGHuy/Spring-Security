package com.spring.springsecurity.controller;

import com.spring.springsecurity.model.AccountTransactions;
import com.spring.springsecurity.model.Customer;
import com.spring.springsecurity.repository.AccountTransactionsRepository;
import com.spring.springsecurity.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BalanceController {

  @Autowired
  private AccountTransactionsRepository accountTransactionsRepository;

  @Autowired
  private CustomerRepository customerRepository;

  @GetMapping("/myBalance")
  public List<AccountTransactions> getBalanceDetails(@RequestParam String email) {
    List<Customer> customers = customerRepository.findByEmail(email);
    if (customers != null && !customers.isEmpty()) {
      List<AccountTransactions> accountTransactions = accountTransactionsRepository.findByCustomerIdOrderByTransactionDtDesc(customers.get(0).getId());
        return accountTransactions;
    }

    return null;
  }
}
