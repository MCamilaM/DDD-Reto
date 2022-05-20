package co.com.ventas.ventas.venta.commands;

import co.com.sofka.domain.generic.Command;
import co.com.ventas.ventas.venta.values.*;
import generics.Nombre;

public class AgregarMedicamento extends Command {
    private final VentaId ventaId;
    private final Nombre nombre;
    private final Laboratorio laboratorio;
    private final EfectoFarmacologico efectoFarmacologico;
    private final Composicion composicion;
    private final Precio precio;
    private final Cantidad cantidad;

    public AgregarMedicamento(VentaId ventaId,
                              Nombre nombre,
                              Laboratorio laboratorio,
                              EfectoFarmacologico efectoFarmacologico,
                              Composicion composicion,
                              Precio precio,
                              Cantidad cantidad) {
        this.ventaId = ventaId;
        this.nombre = nombre;
        this.laboratorio = laboratorio;
        this.efectoFarmacologico = efectoFarmacologico;
        this.composicion = composicion;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public VentaId getVentaId() {
        return ventaId;
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
