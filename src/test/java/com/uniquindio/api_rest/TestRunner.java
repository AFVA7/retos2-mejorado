package com.uniquindio.api_rest;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@RunWith(Cucumber.class)
@ContextConfiguration(classes = CucumberSpringConfiguration.class)
@CucumberOptions(
        features = "src/test/resources/features",  // Ruta a los archivos .feature
        glue = "com.uniquindio.api_rest",
        // Paquete donde están las definiciones de pasos
        plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber.json", "junit:target/cucumber.xml"},
        monochrome = true  // Hace que la salida en consola sea más legible

)
public class TestRunner {
    @Test
    void contextLoads() {
    }
}