package com.spring.springsecurity.controller;

import com.spring.springsecurity.model.Customer;
import com.spring.springsecurity.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

@RestController
public class LoginController {

  @Autowired
  private CustomerRepository customerRepository;

  @RequestMapping("/user")
  public Customer getUserDetailsAfterLogin(Authentication authentication) {
    List<Customer> customers = customerRepository.findByEmail(authentication.getName());
    if (!customers.isEmpty()) {
      return customers.getFirst();
    } else {
      return null;
    }
  }

}
