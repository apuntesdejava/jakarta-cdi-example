package com.example.jakarta.cdi.impl;

import com.example.jakarta.cdi.GreetingService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped
@Named("Spanish")
public class SpanishGreetingService implements GreetingService {

  @Override
  public String sayHello(String name) {
    return "hola "+name;
  }
}