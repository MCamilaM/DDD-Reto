package co.com.ventas.ventas.venta;

import co.com.sofka.domain.generic.Entity;
import co.com.ventas.ventas.venta.values.*;
import generics.Nombre;

import java.util.Objects;

public class Medicamento extends Entity<MedicamentoId> {

    protected Nombre nombre;
    protected Laboratorio laboratorio;
    protected EfectoFarmacologico efectoFarmacologico;
    protected Composicion composicion;
    protected Precio precio;
    protected Cantidad cantidad;

    public Medicamento(MedicamentoId medicamentoId,
                       Nombre nombre,
                       Laboratorio laboratorio,
                       EfectoFarmacologico efectoFarmacologico,
                       Precio precio,
                       Cantidad cantidad)
    {
        super(medicamentoId);
        this.nombre = nombre;
        this.laboratorio = laboratorio;
        this.efectoFarmacologico = efectoFarmacologico;
        this.precio = precio;
        this.cantidad = cantidad;
    }
    public void agregarComposicion(Composicion composicion){
        this.composicion = Objects.requireNonNull(composicion);
    }
}
