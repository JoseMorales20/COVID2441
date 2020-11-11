package cl.inacap.examenespreventivos.dao;

import java.util.ArrayList;
import java.util.List;

import cl.inacap.examenespreventivos.dto.Paciente;

public class PacientesDAOLista implements PacientesDAO {
    private List<Paciente> pacientes = new ArrayList<>();
    private static PacientesDAOLista instancia;
    private PacientesDAOLista(){
        Paciente p = new Paciente();
        p.setRut("20530241-7");
        p.setNombre("Jose");
        p.setApellido("Morales");
        p.setFecha(12-11-2020);
        p.setArea("operador publico");
        p.setTemperatura(37);
        p.setPresion(125);
        pacientes.add(p);
    }

    public static PacientesDAOLista getInstance(){
        if(instancia == null){
            instancia = new PacientesDAOLista();
        }
        return instancia;
    }

    @Override
    public List<Paciente> getAll() {
        return pacientes;
    }

    @Override
    public Paciente save(Paciente p) {
        pacientes.add(p);
        return(p);
    }
}
