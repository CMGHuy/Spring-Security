package com.spring.springsecurity.controller;

import com.spring.springsecurity.model.Cards;
import com.spring.springsecurity.model.Customer;
import com.spring.springsecurity.repository.CardsRepository;
import java.util.Collections;

import com.spring.springsecurity.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardsController {

  @Autowired
  private CardsRepository cardsRepository;

  @Autowired
  private CustomerRepository customerRepository;

  @GetMapping("/myCards")
  public List<Cards> getCardDetails(String email) {
    List<Customer> customers = customerRepository.findByEmail(email);
    if (customers != null && !customers.isEmpty()) {
      List<Cards> cards = cardsRepository.findByCustomerId(customers.get(0).getId());
      return cards;
    }
    return null;
  }
}