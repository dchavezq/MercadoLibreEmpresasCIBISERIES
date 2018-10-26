package co.proyectobase.myextra.userinterface;

import co.proyectobase.myextra.model.Target;

public class CambiarEstadoCuentaPage {
	
	public static final Target ESTADO_DE_CUENTA = Target.the("Cambiar Estado Activo").locatedBy(14, 24);
	public static final Target CONFIRMAR_CAMBIO_DE_ESTADO = Target.the("Confirmar cambio de estado").locatedBy(18, 55);
	public static final Target ESTADO_DE_CUENTA1 = Target.the("Estado de la cuenta").locatedBy(14, 24, 1);
	public static final Target MENSAJE_CAMBIAR_ESTADO_CUENTA = Target
			.the("Mensaje cambiar estado de rechazado a pendiente verificacion ").locatedBy(24, 2, 65);
}
