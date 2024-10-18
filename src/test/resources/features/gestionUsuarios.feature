Feature: Gestión de usuarios de la API
  La API debe permitir registrar, listar, editar, eliminar y recuperar usuarios de manera segura usando JWT.

  Scenario: Crear un nuevo usuario exitosamente
    Given que el cliente tiene un payload válido con nombre, apellido, cédula, email, contraseña, teléfono, fecha de nacimiento y dirección
    When el cliente envía una solicitud POST a "http://localhost:80/api/auth/registrarse"
    Then el sistema debe devolver un código de estado 200
    And la respuesta debe contener el mensaje "Usuario {userId} registrado correctamente"


