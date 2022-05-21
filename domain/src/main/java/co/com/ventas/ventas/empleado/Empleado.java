package co.com.ventas.ventas.empleado;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.ventas.ventas.empleado.events.*;
import co.com.ventas.ventas.empleado.values.*;
import generics.Direccion;
import generics.Fecha;
import generics.Nombre;
import generics.Telefono;

import java.util.List;
/**
 * Agregado Empleado
 *
 * @author Camila Morales
 * @version 1.0.0
 * @since 1.0.0
 */
public class Empleado extends AggregateEvent<EmpleadoId> {

    /**
     * propiedades
     */
    protected Nombre nombre;
    protected Contrato contrato;
    protected Rol rol;
    protected Local local;

    /**
     * Constructor
     * @param entityId
     * @param nombre
     * @param contrato
     */
    public Empleado(EmpleadoId entityId, Nombre nombre, Contrato contrato) {
        super(entityId);
        appendChange(new EmpleadoCreado(nombre,contrato)).apply();
        subscribe(new EmpleadoEventChange(this));
    }

    /**
     * Constructor
     * @param entityId
     */
    private Empleado(EmpleadoId entityId){
        super(entityId);
        subscribe(new EmpleadoEventChange(this));
    }

    /**
     * metodo para aplicar eventos
     * @param entityId
     * @param events
     * @return
     */
    public static Empleado from(EmpleadoId entityId, List<DomainEvent> events){
        var empleado = new Empleado(entityId);
        events.forEach(empleado::applyEvent);
        return empleado;
    }


    /**
     * Metodo para agregar rol
     * @param nombre
     */
    public void agregarRol(Nombre nombre){
        var rolId = new RolId("1rol");
        appendChange(new RolAgregado(rolId, nombre)).apply();
    }

    /**
     * Metodo para agregar local
     * @param direccion
     */
    public void agregarLocal(Direccion direccion){
        var localId = new LocalId("local1");
        appendChange(new LocalAgregado(localId, direccion));
    }

    /**
     * Metodo para agregar descripcion a la entidad rol
     * @param rolId
     * @param descripcion
     */
    public void agregarDescripcionDeRol(RolId rolId, Descripcion descripcion){
        appendChange(new DescripcionAgregadaDeRol(rolId, descripcion));
    }

    /**
     * Metodo para modificar la fecha de un contrato
     * @param contratoId
     * @param fecha
     */
    public void modificarFechaDeContrato(ContratoId contratoId, Fecha fecha){
        appendChange(new FechaModificadaDeContrato(contratoId, fecha));
    }

    /**
     * metodo para agregar un telefono a un local
     * @param localId
     * @param telefono
     */
    public void agregarTelefonoDeLocal(LocalId localId, Telefono telefono){
        appendChange(new TelefonoAgregadoDeLocal(localId, telefono));
    }

    /**
     * propiedades
     */
    public Nombre nombre() {
        return nombre;
    }

    public Contrato contrato() {
        return contrato;
    }

    public Rol rol() {
        return rol;
    }

    public Local local() {
        return local;
    }
}
