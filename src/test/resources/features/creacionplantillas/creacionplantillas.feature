# language: es
#H13
Característica: Creación de una nueva plantilla en el visualizador

  Como usuario del sistema
  Quiero crear una nueva plantilla en el visualizador
  Para poder gestionar parámetros personalizados

  Antecedentes:
    Dado que el actor abre la aplicación
    Y diligencia el formulario de login con los siguientes datos:
      | tipoDocumento        | usuario    | contrasenna    |
      | Cédula de ciudadanía | 52202663   | Armenia2025*@  |
    Y hace clic en el botón validar biometrico
    Y hace clic en el botón Iniciar sesión
    Y acepta la primera alerta
    Y acepta la segunda alerta

  Esquema del escenario: Crear plantilla con parámetros
    Cuando el usuario ingresa al menú lateral "GSV"
    Y selecciona el submenú "Plantillas de visualizador"
    Entonces debería abrirse una nueva ventana con el buscador de plantillas "GSV"

    Cuando el usuario hace clic en el botón "Nueva Plantilla"
    Cuando selecciona la empresa propietaria "<Empresa>"
    Y ingresa el nombre del plantilla "<Nombre de plantilla>"
    Y ingresa el código único de plantilla "<Codigo unico>"
    Y escribe la descripción "<Descripcion>"

    Y carga el archivo "<nombreArchivo>"
    Y el usuario da clic en el botón "Guardar Plantilla"
    Y el usuario hace clic en "Aceptar" en el modal
    Y el usuario da clic en la opcion agregar parametro
    Y selecciona el parametro
    Cuando el usuario da clic en el botón "Siguiente"
    Y el usuario ingresa el color "#cf5454"
    Cuando el usuario da clic en el botón guardar
    Y el usuario hace clic en "Aceptar" en el modal
    Entonces debería aparecer un modal de confirmación "<Mensaje>"



    Ejemplos:
      | Empresa | Nombre de plantilla | Codigo unico   | Descripcion |nombreArchivo |  Parametro                |Mensaje                                                                                                  |
      | GELSA   | dinamico         | autoincremental   | Prueba      |imagen.png    |Código único del sorteo    | Tipo de balota parametro creado exitosamente.                                                            |



