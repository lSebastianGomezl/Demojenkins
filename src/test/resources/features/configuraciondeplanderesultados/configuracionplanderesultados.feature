# language: es
#H03
Característica: Configuración de plan de resultados, balotas y baloteras

  Como un usuario autorizado
  Quiero poder acceder a la configuración de sorteos desde el menú GSV
  Para crear un nuevo sorteo diligenciando toda la información requerida

  Antecedentes:
    Dado que el actor abre la aplicación
    Y diligencia el formulario de login con los siguientes datos:
      | tipoDocumento        | usuario   | contrasenna        |
      | Cédula de ciudadanía | 52202663  | Armenia2025*@      |
    Y hace clic en el botón validar biometrico
    Y hace clic en el botón Iniciar sesión
    Y acepta la primera alerta
    Y acepta la segunda alerta

  Esquema del escenario: Configuración de plan de resultados, balotas y baloteras
    Cuando el usuario ingresa al menú lateral "GSV"
    Y selecciona el submenú "Configuración de sorteos"
    Entonces debería abrirse una nueva ventana con el buscador de sorteos "GSV"

    Cuando el usuario hace clic en el botón "Crear Sorteo"
    Entonces debería abrirse una nueva ventana con el formulario de creación de sorteos y ver el texto "Información del sorteo"

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

    Y el usuario ingresa al menú "Programaciones del sorteo"
    Y el usuario da de nuevo clic en el botón "Nueva Programación"
    Y el usuario elige si es una "<tipoFecha>"
    Cuando la fecha de inicio y "<Hora>" de ejecución del sorteo
    Y el usuario da clic en el botón "Guardar Programación"
    Y el usuario hace clic en "Aceptar" en el modal

    Cuando selecciona el item "Plan de resultados"
    Y el usuario da clic en el botón "Nuevo Plan de Resultados"
    Y el usuario llena el formulario de plan de resultados
      | nombre     | descripcion           | cantidad | tipoPlan   | tiempoRetardo | activar |
      | Test Plan  | Prueba de formulario  | 10       | PRINCIPAL  | 5000          | si      |
    Cuando el usuario da clic en el botón "Guardar"
    Y el usuario hace clic en "Aceptar" en el modal

    Cuando el usuario da selecciona "Agregar balotera"
    Y el usuario da clic en el botón "Nueva Balotera"
    Y el usuario llena el formulario de crear balotera
      | nombre          | rangoInicio | rangoFin | tipo                    |
      | Balotera prueba | 1           | 100      | SELECTOR COLOR2 - COPIA |
    Y el usuario hace clic en "Siguiente" en el modal
    Y el usuario hace clic en "Guardar Balotera" en el modal

    Cuando el usuario da clic en el botón "Consultar"
    Y el usuario consulta el nombre de la balotera "<nombrBalotera>"
    Y el usuario da clic en el botón "Consultar"
    Y el usuario selecciona el checkbox de la balotera creada "<nombrBalotera>"
    Y el usuario da clic en el botón "Siguiente"
    Cuando el usuario da clic en el boton guardar del modal

    Entonces debería aparecer un modal de confirmación "<Mensaje>"

    Ejemplos:
      | Empresa | Nombre de sorteo | Codigo unico    | Tipo de sorteo | Descripcion | Fecha de inicio | Fecha de fin | Parametro                | tipoFecha      | Hora     | nombrBalotera     |tipoFecha |Mensaje                                                      |
      | GELSA   | dinamico         | autoincremental | SORTEO         | Prueba      | fechaActual     | fechaActual  | Código único del sorteo  | fechaUnica     | 20:00:00 | nombreBalotera    |fechaUnica|Asociación Balotera - Plan de Resultados creada exitosamente.|
