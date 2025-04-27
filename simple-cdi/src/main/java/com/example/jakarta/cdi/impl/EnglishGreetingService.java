package com.example.jakarta.cdi.impl;

import com.example.jakarta.cdi.GreetingService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped
@Named("English")
public class EnglishGreetingService implements GreetingService {

  @Override
  public String sayHello(String name) {
    return "hello " + name;
  }
}