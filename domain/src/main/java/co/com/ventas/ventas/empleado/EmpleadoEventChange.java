package co.com.ventas.ventas.empleado;

import co.com.sofka.domain.generic.EventChange;
import co.com.ventas.ventas.empleado.events.*;

public class EmpleadoEventChange extends EventChange {
    public EmpleadoEventChange(Empleado empleado) {
        apply((EmpleadoCreado event) -> {
            empleado.nombre = event.getNombre();
            empleado.contrato = event.getContrato();
        });

        apply((RolAgregado event) ->{
            var rol = new Rol(event.getRolId(), event.getNombre());
            empleado.rol = rol;

        });

        apply((LocalAgregado event) ->{
            var local = new Local(event.getLocalId(), event.getDireccion());
            empleado.local = local;

        });

        apply((DescripcionAgregadaDeRol event) ->{
            empleado.rol.agregarDescripcion(event.getDescripcion());
        });

        apply((FechaModificadaAContrato event) ->{
            empleado.contrato.modificarFecha(event.getFecha());
        });

        apply((TelefonoAgregadoDeLocal event) ->{
            empleado.local.agregarTelefono(event.getTelefono());
        });
    }
}
