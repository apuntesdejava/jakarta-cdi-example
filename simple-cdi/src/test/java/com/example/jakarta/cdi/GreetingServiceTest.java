package com.example.jakarta.cdi;

import com.example.jakarta.cdi.impl.EnglishGreetingService;
import com.example.jakarta.cdi.impl.SpanishGreetingService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.jboss.weld.junit5.EnableWeld;
import org.jboss.weld.junit5.WeldInitiator;
import org.jboss.weld.junit5.WeldSetup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@EnableWeld
public class GreetingServiceTest {
  private static final Logger LOGGER = Logger.getLogger(GreetingServiceTest.class.getName());

  @WeldSetup
  WeldInitiator weld = WeldInitiator
          .from(EnglishGreetingService.class, SpanishGreetingService.class, ProducerController.class)
          .activate(ApplicationScoped.class)
          .build();

  @Inject
  @Named("English")
  GreetingService englishGreetingService;

  @Inject
  @Named("Spanish")
  GreetingService spanishGreetingService;

  @Inject
  @Named("German")
  GreetingService germanGreetingService;

  @Test
  @DisplayName("testing englishGreetingService")
  void testSayHello() {
    assertNotNull(englishGreetingService);
    var result = englishGreetingService.sayHello("world");
    LOGGER.info("result: " + result);
    assertEquals("hello world", result);

  }

  @Test
  @DisplayName("testing spanishGreetingService")
  void testSayHelloSpanish() {
    assertNotNull(spanishGreetingService);
    var result = spanishGreetingService.sayHello("world");
    LOGGER.info("result: " + result);
    assertEquals("hola world", result);
  }

  @Test
  void testGermansayHello() {
    assertNotNull(germanGreetingService);
    var result = germanGreetingService.sayHello("world");
    LOGGER.info("result: " + result);
    assertEquals("hallo world", result);
  }
}

class ProducerController {
  @Produces
  @Named("German")
  public GreetingService germanSayHello() {
    return (name) -> "hallo " + name;
  }

}