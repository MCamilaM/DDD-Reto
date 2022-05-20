package co.com.ventas.ventas.empleado;

import co.com.sofka.domain.generic.Entity;
import co.com.ventas.ventas.empleado.values.ContratoId;
import co.com.ventas.ventas.empleado.values.Descripcion;
import co.com.ventas.ventas.empleado.values.Fecha;

import java.util.Objects;

public class Contrato extends Entity<ContratoId> {

    protected Fecha fecha;
    protected Descripcion descripcion;

    public Contrato(ContratoId entityId, Fecha fecha, Descripcion descripcion) {
        super(entityId);
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public void modificarFecha(Fecha fecha){
        this.fecha = Objects.requireNonNull(fecha);
    }
}
