#language: es
Característica: Realizar cambios de estado de las cuentas inscritas

  Antecedentes: 
    Dado Que Marcela desea realizar consultar en iseries, Marcela abre myExtra
    Cuando Ingresa sus credenciales
      | usuario   | contrasena |
      | CDMCHAVEZ | COLOMBIA06 |
    Y y Navega en el menu

    @ActivarCuenta
  Escenario: Como usuario requiero consultar y realizar cambios de estado de pendiente verificacion a activa
    Dado Realizar el cambio de estado de pendiente verificacion a activa
      | programa                 | documento  | cuenta                            | opciones | estado |
      | CALL CIBLIBRP.CIBOMTOSIT | 1061714027 | GB1895580112369074951659678723102 |        2 | A      |
    Cuando Consultar  las cuentas inscritas por la sucursal virtual empresas
      | documento  | cuenta                            | opciones |
      | 1061714027 | GB1895580112369074951659678723102 |        5 |
    Entonces Verifica que la cuenta quede en estado activa

  @RechazarCuenta
  Escenario: Como usuario requiero consultar y realizar cambios de estado de pendiente verificacion a rechazada
    Dado Realizar el cambio de estado de pendiente verificacion a rechazada
      | programa                 | documento  | cuenta                            | opciones | estado |
      | CALL CIBLIBRP.CIBOMTOSIT | 1061714027 | 941416153585696775309448626933756 |        2 | Z      |
    Cuando Consultar  las cuentas inscritas por la sucursal virtual empresas
      | documento  | cuenta                            | opciones |
      | 1061714027 | 941416153585696775309448626933756 |        5 |
    Entonces Verifica que la cuenta quede en estado rechazada

  @FraudeCuenta
  Escenario: Como usuario requiero consultar y realizar cambios de estado de pendiente verificacion a fraude
    Dado Realizar el cambio de estado de pendiente verificacion a fraude
      | programa                 | documento  | cuenta                            | opciones | estado |
      | CALL CIBLIBRP.CIBOMTOSIT | 1061714027 | 941416153585696775309448626933756 |        2 | V      |
    Cuando Consultar  las cuentas inscritas por la sucursal virtual empresas
      | documento  | cuenta                            | opciones |
      | 1061714027 | 941416153585696775309448626933756 |        5 |
    Entonces Verifica que la cuenta quede en estado fraude

  #Escenarios no exitosos
  @CuentaRechazadoAverificacion
  Escenario: Como usuario requiero consultar y realizar cambios de estado de rechazada a pendiente verificacion
    Dado Realizar el cambio de estado  rechazada a pendiente verificacion
      | programa                 | documento | cuenta  | opciones | estado |
      | CALL CIBLIBRP.CIBOMTOSIT | 809654267 | 9999992 |        2 | V      |
    Cuando Consultar  las cuentas inscritas por la sucursal virtual empresas
      | documento | cuenta  | opciones |
      | 809654267 | 9999992 |        5 |
    Entonces Verifica que la cuenta no se pueda cambiar a estado pendiente verificacion

  @CasoPruebaEstadodeCuentasActivas
  Escenario: Como usuario requiero consultar y realizar cambios de estado de cuenta activa a pendiente de verificacion, 
  verificar que el sistema no permita realizar cambio a estado verificacion
    Dado Realizar el cambio de estado  rechazada a pendiente verificacion
      | programa                 | documento | cuenta  | opciones | estado |
      | CALL CIBLIBRP.CIBOMTOSIT | 809654267 | 9999992 |        2 | V      |
    Cuando Consultar  las cuentas inscritas por la sucursal virtual empresas
      | documento | cuenta  | opciones |
      | 809654267 | 9999992 |        5 |
    Entonces Verifica que la cuenta no se pueda cambiar de estado activa  a estado pendiente verificacion