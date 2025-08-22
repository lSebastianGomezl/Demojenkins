# language: es
Característica: Login en la aplicación BackOffice

  Como usuario del canal digital
  Quiero ingresar a la plataforma
  Para poder acceder a mis funcionalidades

 Esquema del escenario: Login exitoso desde la aplicación
    Dado que el actor abre la aplicación
    Y diligencia el formulario de login con los siguientes datos:
      | tipoDocumento        | usuario      | contrasenna   |
      | Cédula de ciudadanía | 1136885329   | Diana1993.    |
    Y hace clic en el botón validar biometrico
    Y hace clic en el botón Iniciar sesión
    Y acepta la primera alerta
    Y acepta la segunda alerta
    Entonces debería ver la página de "<mensaje>"

   Ejemplos:
     | mensaje   |
     | Dashboard |

