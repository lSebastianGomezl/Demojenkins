# language: es
#HU20
Característica: Crear un tipo balota en la plataforma GSV

  Como un usuario autorizado
  Quiero poder acceder al menu de tipo balotas
  Para crear un nuevo sorteo diligenciando toda la información requerida

  Antecedentes:
    Dado que el actor abre la aplicación
    Y diligencia el formulario de login con los siguientes datos:
      | tipoDocumento        | usuario    | contrasenna   |
      | Cédula de ciudadanía | 52202663   | Armenia2025*@  |
    Y hace clic en el botón validar biometrico
    Y hace clic en el botón Iniciar sesión
    Y acepta la primera alerta
    Y acepta la segunda alerta

  Esquema del escenario: Crear tipo de balota en la plataforma GSV exitosa
    Cuando el usuario ingresa al menú lateral "GSV"
    Y selecciona el submenú "Tipo de balotas"
    Cuando el usuario hace clic en el botón "Nuevo tipo de balota"
    Cuando selecciona la empresa propietaria "<Empresa>"
    Y ingresa el nombre del tipo de balota "<Nombre de balota>"
    Y selecciona el tipo de balota "<Tipo de balota>"
    Y selecciona opcion de homologacion "<Homologa>"
    Cuando el usuario da clic en el botón "Guardar"
    Y el usuario hace clic en "Aceptar" en el modal
    #Entonces debería aparecer un modal de confirmación "<Mensaje>"
    Y el usuario da clic en la opcion agregar parametro
    Y selecciona el parametro
    Cuando el usuario da clic en el botón "Siguiente"
    Y el usuario ingresa el color "#cf5454"
    Cuando el usuario da clic en el botón guardar
    Y el usuario hace clic en "Aceptar" en el modal
    Entonces debería aparecer un modal de confirmación "<Mensaje>"




    Ejemplos:
     |Empresa | Nombre de balota | Tipo de balota | Homologa |  Mensaje                                     |
     |GELSA   | dinamico         | NUMERICO       | SI       | Tipo de balota parametro creado exitosamente.|

