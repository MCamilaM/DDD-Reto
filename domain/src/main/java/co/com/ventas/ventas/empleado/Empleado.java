package co.com.ventas.ventas.empleado;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.ventas.ventas.empleado.events.*;
import co.com.ventas.ventas.empleado.values.*;
import generics.Direccion;
import generics.Nombre;
import generics.Telefono;

import java.util.List;

public class Empleado extends AggregateEvent<EmpleadoId> {

    protected Nombre nombre;
    protected Contrato contrato;
    protected Rol rol;
    protected Local local;

    public Empleado(EmpleadoId entityId, Nombre nombre, Contrato contrato) {
        super(entityId);
        appendChange(new EmpleadoCreado(nombre,contrato)).apply();
        subscribe(new EmpleadoEventChange(this));
    }

    private Empleado(EmpleadoId entityId){
        super(entityId);
        subscribe(new EmpleadoEventChange(this));
    }

    public static Empleado from(EmpleadoId entityId, List<DomainEvent> events){
        var empleado = new Empleado(entityId);
        events.forEach(empleado::applyEvent);
        return empleado;
    }


    public void agregarRol(Nombre nombre){
        var rolId = new RolId("1rol");
        appendChange(new RolAgregado(rolId, nombre)).apply();
    }

    public void agregarLocal(Direccion direccion){
        var localId = new LocalId("local1");
        appendChange(new LocalAgregado(localId, direccion));
    }

    public void agregarDescripcionDeRol(RolId rolId, Descripcion descripcion){
        appendChange(new DescripcionAgregadaDeRol(rolId, descripcion));
    }

    public void modificarFechaDeContrato(ContratoId contratoId, Fecha fecha){
        appendChange(new FechaModificadaDeContrato(contratoId, fecha));
    }

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
