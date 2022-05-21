package co.com.ventas.ventas.venta.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.ventas.ventas.venta.values.*;
import generics.Nombre;

/**
 * evento medicamento creado
 *
 * @author Camila Morales
 * @version 1.0.0
 * @since 1.0.0
 */
public class MedicamentoCreado extends DomainEvent {

    private final MedicamentoId medicamentoId;
    private final Nombre nombre;
    private final Laboratorio laboratorio;
    private final EfectoFarmacologico efectoFarmacologico;
    private final Precio precio;
    private final Cantidad cantidad;

    /**
     * Constructor
     * @param medicamentoId
     * @param nombre
     * @param laboratorio
     * @param efectoFarmacologico
     * @param precio
     * @param cantidad
     */
    public MedicamentoCreado(MedicamentoId medicamentoId,
                             Nombre nombre,
                             Laboratorio laboratorio,
                             EfectoFarmacologico efectoFarmacologico,
                             Precio precio,
                             Cantidad cantidad) {
        super("co.com.ventas.ventas.MedicamentoCreado");
        this.medicamentoId = medicamentoId;
        this.nombre = nombre;
        this.laboratorio = laboratorio;
        this.efectoFarmacologico = efectoFarmacologico;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    /**
     * Getters
     */
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

    public Precio getPrecio() {
        return precio;
    }

    public Cantidad getCantidad() {
        return cantidad;
    }
}
