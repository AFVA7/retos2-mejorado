package com.uniquindio.api_rest;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",  // Ruta a los archivos .feature
        glue = "com.uniquindio.api_rest.steps",     // Paquete donde están las definiciones de pasos
        plugin = {"pretty", "html:target/cucumber-reports", "json:target/allure-results/results.json", "junit:target/cucumber.xml", "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"},
        monochrome = true  // Hace que la salida en consola sea más legible

)
public class TestRunner {
}
