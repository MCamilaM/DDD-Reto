package co.com.ventas.ventas.venta.commands;

import co.com.sofka.domain.generic.Command;
import co.com.ventas.ventas.venta.values.*;
import generics.Nombre;

public class AgregarMedicamento extends Command {
    private final VentaId ventaId;
    private final MedicamentoId medicamentoId;
    private final Nombre nombre;
    private final Laboratorio laboratorio;
    private final EfectoFarmacologico efectoFarmacologico;
    private final Precio precio;
    private final Cantidad cantidad;

    public AgregarMedicamento(VentaId ventaId,
                              MedicamentoId medicamentoId,
                              Nombre nombre,
                              Laboratorio laboratorio,
                              EfectoFarmacologico efectoFarmacologico,
                              Precio precio,
                              Cantidad cantidad) {
        this.ventaId = ventaId;
        this.medicamentoId = medicamentoId;
        this.nombre = nombre;
        this.laboratorio = laboratorio;
        this.efectoFarmacologico = efectoFarmacologico;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public VentaId getVentaId() {
        return ventaId;
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


    public Precio getPrecio() {
        return precio;
    }

    public Cantidad getCantidad() {
        return cantidad;
    }
}
