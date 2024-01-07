package com.spring.springsecurity.controller;

import com.spring.springsecurity.model.Accounts;
import com.spring.springsecurity.model.Customer;
import com.spring.springsecurity.repository.AccountsRepository;
import com.spring.springsecurity.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {

  @Autowired
  private AccountsRepository accountsRepository;

  @Autowired
  private CustomerRepository customerRepository;

  @GetMapping("/myAccount")
  public Accounts getAccountDetails(@RequestParam String email) {
    List<Customer> customers = customerRepository.findByEmail(email);
    if (customers != null && !customers.isEmpty()) {
      Accounts accounts = accountsRepository.findByCustomerId(customers.get(0).getId());
      return accounts;
    }
    return null;
  }

}