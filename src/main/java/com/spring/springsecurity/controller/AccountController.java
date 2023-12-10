package com.spring.springsecurity.controller;

import com.spring.springsecurity.model.Accounts;
import com.spring.springsecurity.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

  @Autowired
  private AccountsRepository accountsRepository;

  @GetMapping("/myAccount")
  public Accounts getAccountDetails(@RequestParam int id) {
    Accounts accounts = accountsRepository.findByCustomerId(id);
    if (accounts != null ) {
      return accounts;
    } else {
      return null;
    }
  }

}