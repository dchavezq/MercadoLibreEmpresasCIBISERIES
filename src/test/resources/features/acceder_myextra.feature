#language: es
Característica: Aprendiendo a usar MyExtra

  Escenario: Ingresar a My Extra
    Dado Que Marcela desea realizar consultar en iseries, Marcela abre myExtra
    Cuando Ingresa sus credenciales
      | usuario   | contrasena |
      | CDMCHAVEZ | COLOMBIA06 |
    Y y Navega en el menu
    Entonces Verifica que inicio sesion correctamente
