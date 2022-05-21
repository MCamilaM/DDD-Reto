package co.com.ventas.ventas.formula;

import co.com.sofka.domain.generic.Entity;
import generics.Direccion;
import generics.Telefono;
import co.com.ventas.ventas.formula.values.ClinicaId;
import generics.Nombre;

import java.util.Objects;
/**
 * Entidad Clinica
 *
 * @author Camila Morales
 * @version 1.0.0
 * @since 1.0.0
 */
public class Clinica extends Entity<ClinicaId> {

    protected Nombre nombre;
    protected Telefono telefono;
    protected Direccion direccion;

    /**
     * Constructor
     * @param clinicaId
     * @param nombre
     * @param telefono
     * @param direccion
     */
    public Clinica(ClinicaId clinicaId, Nombre nombre, Telefono telefono, Direccion direccion) {
        super(clinicaId);
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    /**
     * Metodo para actualizar nombre
     * @param nombre
     */
    public void ActualizarNombre(Nombre nombre){
        this.nombre = Objects.requireNonNull(nombre);
    }
}
