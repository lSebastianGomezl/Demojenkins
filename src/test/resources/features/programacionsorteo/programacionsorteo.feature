# language: es
#HU02
Característica: Configuracion de sorteo en la plataforma GSV

  Como un usuario autorizado
  Quiero poder acceder a la programacion de sorteos desde el menú GSV
  Para crear una nueva programacion sorteo diligenciando toda la información requerida

  Antecedentes:
    Dado que el actor abre la aplicación
    Y diligencia el formulario de login con los siguientes datos:
      | tipoDocumento        | usuario    | contrasenna    |
      | Cédula de ciudadanía | 52202663  | Armenia2025*@  |
    Y hace clic en el botón validar biometrico
    Y hace clic en el botón Iniciar sesión
    Y acepta la primera alerta
    Y acepta la segunda alerta

  Esquema del escenario: Programacion de sorteos unica fecha exitosa
    Cuando el usuario ingresa al menú lateral "GSV"
    Y selecciona el submenú "Configuración de sorteos"
    Entonces debería abrirse una nueva ventana con el buscador de sorteos "GSV"

    #Cuando el usuario hace clic en el botón "Crear Sorteo"
    #Entonces debería abrirse una nueva ventana con el formulario de creacion de sorteos y ver el texto "Información del sorteo"
    Cuando ingresa el codigo numero "<codigo>" en el codigo unico de sorteo
    Cuando selecciona la empresa propietaria "<Empresa>"
    Y el usuario da clic en el botón "Consultar"
    Y el usuario da clic en la accion editar del codigo de sorteo "<codigo>"
    Y el usuario ingresa al menú "Programaciones del sorteo"
    Y el usuario da de nuevo clic en el botón "Nueva Programación"
    Y el usuario elige si es una "<tipoFecha>"
    Cuando la fecha de inicio fecha y "<Hora>" de ejecucion del sorteo
    Y el usuario da clic en el botón "Guardar Programación"
    Y el usuario hace clic en "Aceptar" en el modal
    Entonces debería aparecer un modal de confirmación "<Mensaje>"


    Ejemplos:
    |Empresa  |  Hora            |Mensaje                                      | codigo|tipoFecha|
    |GELSA    |  20:00:00        | Configuración registrada exitosamente       |  33   |fechaUnica|
  @002
  Esquema del escenario: Programacion de sorteos multiples fecha exitosa
    Cuando el usuario ingresa al menú lateral "GSV"
    Y selecciona el submenú "Configuración de sorteos"
    Entonces debería abrirse una nueva ventana con el buscador de sorteos "GSV"

    Cuando ingresa el codigo numero "<codigo>" en el codigo unico de sorteo
    Cuando selecciona la empresa propietaria "<Empresa>"
    Y el usuario da clic en el botón "Consultar"
    Y el usuario da clic en la accion editar del codigo de sorteo "<codigo>"
    Y el usuario ingresa al menú "Programaciones del sorteo"
    Y el usuario da de nuevo clic en el botón "Nueva Programación"
    Y el usuario elige si es una "<tipoFecha>"
    Cuando el usuario ingresa la fecha rango inicial y rango final y la "<horaInicial>" y "<horaFinal>"
    Y el usuario selecciona el item mes
    Y el usuario selecciona el mes especifico
    Y el usuario selecciona el item dias
    Y el usuario selecciona el item de horas
    Y el usuario selecciona la "<horaInicial>" y la "<horaFinal>" programadas
    Y el usuario da clic en el botón "Guardar Programación"
    Y el usuario hace clic en "Aceptar" en el modal
    Entonces debería aparecer un modal de confirmación "<Mensaje>"


    Ejemplos:
     |Empresa |  horaInicial | horaFinal    |Mensaje                                      | codigo|tipoFecha      |
     |GELSA   |  17:00:00    | 22:00:00     | Configuración registrada exitosamente       |  33   |multipleFecha  |

