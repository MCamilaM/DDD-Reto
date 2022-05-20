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
                       Composicion composicion,
                       Precio precio,
                       Cantidad cantidad)
    {
        super(medicamentoId);
        this.nombre = nombre;
        this.laboratorio = laboratorio;
        this.efectoFarmacologico = efectoFarmacologico;
        this.composicion = composicion;
        this.precio = precio;
        this.cantidad = cantidad;
    }
    public void actualizarComposicion(Composicion composicion){
        this.composicion = Objects.requireNonNull(composicion);
    }
}
