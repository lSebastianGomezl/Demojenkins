# language: es
#H01
Característica: Aprobar programacion de sorteo GSV

  Como un usuario autorizado
  Quiero poder acceder a la APROBACION de sorteos desde el menú GSV
  Para aprobar un sorteo diligenciando toda la información requerida

  Antecedentes:
    Dado que el actor abre la aplicación
    Y diligencia el formulario de login con los siguientes datos:
      | tipoDocumento        | usuario    | contrasenna    |
      | Cédula de ciudadanía | 52202663   | Armenia2025*@  |
    Y hace clic en el botón validar biometrico
    Y hace clic en el botón Iniciar sesión
    Y acepta la primera alerta
    Y acepta la segunda alerta

  Esquema del escenario: Aprobar programacion de sorteo en la plataforma GSV exitosa
    Cuando el usuario ingresa al menú lateral "GSV"
    Y selecciona el submenú "Aprobar programación de sorteos"
    Entonces debería abrirse una nueva ventana con el buscador de sorteos "GSV"

    Cuando selecciona la empresa propietaria "<Empresa>"
    Cuando el usuario da clic en el botón "Consultar"
    Y da clic en el apartado de acciones
    Y ingresa a la vigencia de la programacion dando clic en la flecha de Detalle
    Cuando el usuario da clic en el botón "No aprobar programación"
    Y el usuario hace clic en "No aprobar" en el modal
    Y el usuario ingresa el motivo de no aprobacion "<Descripcion>"
    Y el usuario hace clic en "No aprobar" en el modal

    Entonces debería aparecer un modal de confirmación "<Mensaje>"


    Ejemplos:
      | Empresa | Descripcion | Mensaje                                                                                                  |
      | GELSA   |  Prueba      |Programación de sorteo no aprobada correctamente                                                            |



