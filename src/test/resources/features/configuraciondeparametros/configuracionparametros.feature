# language: es
#HU12
Característica: Configuracion de sorteo en la plataforma GSV

  Como un usuario autorizado
  Quiero poder acceder a la programacion de sorteos desde el menú GSV
  Para crear una nueva programacion sorteo diligenciando toda la información requerida

  Antecedentes:
    Dado que el actor abre la aplicación
    Y diligencia el formulario de login con los siguientes datos:
      | tipoDocumento        | usuario    | contrasenna   |
      | Cédula de ciudadanía | 52202663   | Armenia2025*@ |
    Y hace clic en el botón validar biometrico
    Y hace clic en el botón Iniciar sesión
    Y acepta la primera alerta
    Y acepta la segunda alerta

  Esquema del escenario: Configuracion de parametros exitosa
    Cuando el usuario ingresa al menú lateral "GSV"
    Y selecciona el submenú "Configuración de Parámetros"
    Y el usuario da clic en el botón "Nuevo parámetro"
    #Cuando llena el campo "Empresa" con "GELSA"
    Cuando selecciona la empresa propietaria "<Empresa>"
    Y llena el campo "tipoCampoFiltro" con "BOOLEAN"
    Y llena el campo "tipoParametro" con "SORTEO"
    Y llena el campo Clave del parámetro con "<Clave>"
    Y llena el campo Nombre del parámetro con "<Parametro>"
    Y llena el campo Descripcion con "<Descripcion>"
    Y el usuario da clic en el botón "Guardar"
    Y el usuario hace clic en "Aceptar" en el modal
    Entonces debería aparecer un modal de confirmación "<Mensaje>"


    Ejemplos:
    |Empresa  |Mensaje                                              |Parametro                |Clave              |Descripcion     |
    |GELSA    |Configuración de parámetros creada exitosamente      |autroincremental         |autoincremental    |autoincremental |

  @002
  Esquema del escenario: Consulta de configuracion de parametros exitosa
    Cuando el usuario ingresa al menú lateral "GSV"
    Y selecciona el submenú "Configuración de Parámetros"
    #Y el usuario da clic en el botón "Nuevo parámetro"
    #Cuando el usuario selecciona la empresa "GELSA"
    Cuando selecciona la empresa propietaria "<Empresa>"
    Y el usuario da clic en el botón "Consultar"
    Y el usuario da clic en el icono de editar
    #Y el usuario hace clic en "Aceptar" en el modal
    Y llena el campo Clave del parámetro con "<Clave>"
    Y el usuario da clic en el botón "Guardar"
    Y el usuario hace clic en "Aceptar" en el modal
    Entonces debería aparecer un modal de confirmación "<Mensaje>"


    Ejemplos:
     |Empresa |Mensaje                                              |Clave               |
     |GELSA |Configuración de parámetros creada exitosamente      |autoincremental     |
