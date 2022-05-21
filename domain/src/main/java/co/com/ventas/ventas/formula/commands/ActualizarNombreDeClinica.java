package co.com.ventas.ventas.formula.commands;

import co.com.sofka.domain.generic.Command;
import co.com.ventas.ventas.formula.values.ClinicaId;
import co.com.ventas.ventas.formula.values.FormulaId;
import generics.Nombre;
/**
 * comando Actualizar Nombre de Clinica
 *
 * @author Camila Morales
 * @version 1.0.0
 * @since 1.0.0
 */
public class ActualizarNombreDeClinica extends Command {
    private final FormulaId formulaId;
    private final ClinicaId clinicaId;
    private final Nombre nombre;

    /**
     * Constructor
     * @param formulaId
     * @param clinicaId
     * @param nombre
     */
    public ActualizarNombreDeClinica(FormulaId formulaId, ClinicaId clinicaId, Nombre nombre) {
        this.formulaId = formulaId;
        this.clinicaId = clinicaId;
        this.nombre = nombre;
    }

    /**
     * Getters
     */
    public FormulaId getFormulaId() {
        return formulaId;
    }

    public ClinicaId getClinicaId() {
        return clinicaId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
