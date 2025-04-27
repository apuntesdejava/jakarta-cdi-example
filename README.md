# Ejemplos de Jakarta CDI

Aquí mostraré ejemplos de Jakarta Contexts and Dependency Injection

## 1. Implementando _Dependency Inversion Principle_
[![Introducción a Inyección de Dependencias con Jakarta EE - Jakarta CDI](https://img.youtube.com/vi/ynq9_0n79pI/default.jpg)](https://youtu.be/ynq9_0n79pI)

Debemos definir la interfaz que usaremos.

Interfaz [GreetingService](src/main/java/com/example/jakarta/cdi/GreetingService.java)
```java
package com.example.jakarta.cdi;

public interface GreetingService {
  String sayHello(String name);
}
```

Y a partir de ella declaramos nuestras clases especializadas.

Clase [EnglishGreetingService](src/main/java/com/example/jakarta/cdi/impl/EnglishGreetingService.java)
```java
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
```

Clase [SpanishGreetingService](src/main/java/com/example/jakarta/cdi/impl/SpanishGreetingService.java)
```java
package com.example.jakarta.cdi.impl;

import com.example.jakarta.cdi.GreetingService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jdk.jfr.Name;

@ApplicationScoped
@Named("Spanish")
public class SpanishGreetingService implements GreetingService {

  @Override
  public String sayHello(String name) {
    return "hola "+name;
  }
}
```

Y se invoca de la siguiente manera
Clase de prueba [GreetingServiceTest](src/test/java/com/example/jakarta/cdi/GreetingServiceTest.java)
```java
  @Inject
  @Named("English")
  GreetingService englishGreetingService;

  @Inject
  @Named("Spanish")
  GreetingService spanishGreetingService;
```