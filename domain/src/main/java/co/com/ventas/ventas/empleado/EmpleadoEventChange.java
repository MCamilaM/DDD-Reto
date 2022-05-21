package co.com.ventas.ventas.empleado;

import co.com.sofka.domain.generic.EventChange;
import co.com.ventas.ventas.empleado.events.*;

public class EmpleadoEventChange extends EventChange {
    public EmpleadoEventChange(Empleado empleado) {
        /**
         * evento empleado creado
         */
        apply((EmpleadoCreado event) -> {
            empleado.nombre = event.getNombre();
            empleado.contrato = event.getContrato();
        });

        /**
         * evento rol agregado
         */
        apply((RolAgregado event) ->{
            var rol = new Rol(event.getRolId(), event.getNombre());
            empleado.rol = rol;

        });

        /**
         * evento local agregado
         */
        apply((LocalAgregado event) ->{
            var local = new Local(event.getLocalId(), event.getDireccion());
            empleado.local = local;

        });

        /**
         * evento descripcion agregada a rol
         */
        apply((DescripcionAgregadaDeRol event) ->{
            empleado.rol.agregarDescripcion(event.getDescripcion());
        });

        /**
         * evento fecha modificada a la entidad contrato
         */
        apply((FechaModificadaDeContrato event) ->{
            empleado.contrato.modificarFecha(event.getFecha());
        });

        /**
         * evento telefono agregado a local
         */
        apply((TelefonoAgregadoDeLocal event) ->{
            empleado.local.agregarTelefono(event.getTelefono());
        });
    }
}
