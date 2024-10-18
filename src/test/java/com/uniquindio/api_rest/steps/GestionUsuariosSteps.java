package com.uniquindio.api_rest.steps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static io.restassured.RestAssured.given;

public class GestionUsuariosSteps {

    private Response response;
    private Map<String, Object> requestBody;

    @Given("que el cliente tiene un payload válido con nombre, apellido, cédula, email, contraseña, teléfono, fecha de nacimiento y dirección")
    public void givenClienteConPayloadValido() {
        requestBody = new HashMap<>();
        requestBody.put("name", "camilo");
        requestBody.put("lastname", "carlos");
        requestBody.put("cedula", "8384779434");
        requestBody.put("email", "juancarlos05@example.com");
        requestBody.put("password", "password123");
        requestBody.put("phone", "+7876543996");
        requestBody.put("birthdate", "1990-01-01T00:00:00.000Z");
        requestBody.put("address", "Calle Falsa 123");
    }

    @When("el cliente envía una solicitud POST a {string}")
    public void whenEnvioSolicitudPOST(String url) {
        response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post(url)
                .then()
                .extract()
                .response();
    }

    @Then("el sistema debe devolver un código de estado {int}")
    public void thenCodigoDeEstado(int statusCode) {
        Assert.assertEquals(statusCode, response.getStatusCode());
    }

    @Then("la respuesta debe contener el mensaje {string}")
    public void thenRespuestaContieneMensaje(String mensajeEsperado) {

        String mensajeReal = response.jsonPath().getString("respuesta");
        // Creamos una expresión regular para capturar el userId del mensaje real
        Pattern pattern = Pattern.compile("Usuario (\\d+) registrado correctamente");
        Matcher matcher = pattern.matcher(mensajeReal);

        if (matcher.find()) {
            String userId = matcher.group(1);
            // Reemplazamos {userId} en el mensaje esperado con el userId capturado
            String mensajeConUserId = mensajeEsperado.replace("{userId}", userId);
            Assert.assertEquals(mensajeConUserId, mensajeReal);
        } else {
            Assert.fail("El formato del mensaje no es el esperado: " + mensajeReal);
        }
    }
}
