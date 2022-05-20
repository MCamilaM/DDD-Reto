package co.com.ventas.ventas.venta.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.ventas.ventas.venta.values.*;
import generics.Nombre;

public class MedicamentoCreado extends DomainEvent {

    private final MedicamentoId medicamentoId;
    private final Nombre nombre;
    private final Laboratorio laboratorio;
    private final EfectoFarmacologico efectoFarmacologico;
    private final Composicion composicion;
    private final Precio precio;
    private final Cantidad cantidad;

    public MedicamentoCreado(MedicamentoId medicamentoId,
                             Nombre nombre,
                             Laboratorio laboratorio,
                             EfectoFarmacologico efectoFarmacologico,
                             Composicion composicion,
                             Precio precio,
                             Cantidad cantidad) {
        super("co.com.ventas.ventas.MedicamentoCreado");
        this.medicamentoId = medicamentoId;
        this.nombre = nombre;
        this.laboratorio = laboratorio;
        this.efectoFarmacologico = efectoFarmacologico;
        this.composicion = composicion;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public MedicamentoId getMedicamentoId() {
        return medicamentoId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public EfectoFarmacologico getEfectoFarmacologico() {
        return efectoFarmacologico;
    }

    public Composicion getComposicion() {
        return composicion;
    }

    public Precio getPrecio() {
        return precio;
    }

    public Cantidad getCantidad() {
        return cantidad;
    }
}
