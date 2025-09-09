# language: es
#H01
Característica: Crear un sorteo en la plataforma GSV

  Como un usuario autorizado
  Quiero poder acceder a la configuración de sorteos desde el menú GSV
  Para crear un nuevo sorteo diligenciando toda la información requerida

  Antecedentes:
    Dado que el actor abre la aplicación
    Y diligencia el formulario de login con los siguientes datos:
      | tipoDocumento        | usuario    | contrasenna |
      | Cédula de ciudadanía | 52202663   | Francisco*2024  |
    Y hace clic en el botón validar biometrico
    Y hace clic en el botón Iniciar sesión
    Y acepta la primera alerta
    Y acepta la segunda alerta

  Esquema del escenario: Crear un sorteo en la plataforma GSV exitosa y validaciones
    Cuando el usuario ingresa al menú lateral "GSV"
    Y selecciona el submenú "Configuración de sorteos"
    Entonces debería abrirse una nueva ventana con el buscador de sorteos "GSV"

    Cuando el usuario hace clic en el botón "Crear Sorteo"
    Entonces debería abrirse una nueva ventana con el formulario de creacion de sorteos y ver el texto "Información del sorteo"

    Cuando selecciona la empresa propietaria "<Empresa>"
    Y ingresa el nombre del sorteo "<Nombre de sorteo>"
    Y ingresa el código único del sorteo "<Codigo unico>"
    Y selecciona el tipo de sorteo "<Tipo de sorteo>"
    Y escribe la descripción "<Descripcion>"
    Y selecciona la fecha de inicio "<Fecha de inicio>"
    Y selecciona la fecha de fin "<Fecha de fin>"
    Y configura el parámetro de formato de sorteo "<Parametro>"

    Cuando el usuario da clic en el botón "Guardar"
    Y el usuario hace clic en "Aceptar" en el modal
    Entonces debería aparecer un modal de confirmación "<Mensaje>"




    Ejemplos:
      | Empresa | Nombre de sorteo | Codigo unico     | Tipo de sorteo | Descripcion | Fecha de inicio | Fecha de fin | Parametro                   |Mensaje                                                                                                  |
      | GELSA   | dinamico         | autoincremental  | SORTEO         | Prueba      | fechaActual     | fechaActual  |  Código único del sorteo    | Configuración de sorteo creado exitosamente.                                                            |
      | GELSA   | dinamico         | COD1753300361435 | SORTEO         | Prueba      | fechaActual     | fechaActual  |  Código único del sorteo    | Error al guardar la configuración del sorteo. El código del sorteo ya existe para la compañía asociada. |

  Esquema del escenario: Crear un sorteo con fecha final menor a la fecha incial
    Cuando el usuario ingresa al menú lateral "GSV"
    Y selecciona el submenú "Configuración de sorteos"
    Entonces debería abrirse una nueva ventana con el buscador de sorteos "GSV"

    Cuando el usuario hace clic en el botón "Crear Sorteo"
    Entonces debería abrirse una nueva ventana con el formulario de creacion de sorteos y ver el texto "Información del sorteo"

    Cuando selecciona la empresa propietaria "<Empresa>"
    Y ingresa el nombre del sorteo "<Nombre de sorteo>"
    Y ingresa el código único del sorteo "<Codigo unico>"
    Y selecciona el tipo de sorteo "<Tipo de sorteo>"
    Y escribe la descripción "<Descripcion>"
    Y selecciona la fecha de inicio "<Fecha de inicio>"
    Y selecciona la fecha de fin "<Fecha de fin>"
    Entonces debería aparecer un modal de confirmación "<Mensaje>"

    Ejemplos:
      | Empresa | Nombre de sorteo | Codigo unico     | Tipo de sorteo | Descripcion | Fecha de inicio | Fecha de fin | Mensaje                                                 |
      | GELSA   | dinamico         | autoincremental  | SORTEO         | Prueba      | fechaActual     | fechaInvalida| La fecha final no puede ser menor que la fecha de inicio|


