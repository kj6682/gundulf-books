package org.kj6682.catalogservice;

import org.kj6682.catalogservice.config.GundulfProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    private final GundulfProperties properties;

    public HomeController(GundulfProperties properties) {
        this.properties = properties;
    }

    @GetMapping("/")
    public String getGreeting() {
      return properties.getGreeting();
    }
}//:)
