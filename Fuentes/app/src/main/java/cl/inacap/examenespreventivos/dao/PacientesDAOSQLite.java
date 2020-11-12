package cl.inacap.examenespreventivos.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import cl.inacap.examenespreventivos.dto.Paciente;
import cl.inacap.examenespreventivos.helpers.PacientesSQLiteHelper;

public class PacientesDAOSQLite implements PacientesDAO {
    private PacientesSQLiteHelper pacientesHelper;
    public PacientesDAOSQLite(Context context){
        this.pacientesHelper = new PacientesSQLiteHelper(context,"DBPacientes", null, 2);
    }
    @Override
    public List<Paciente> getAll() {
        SQLiteDatabase reader = this.pacientesHelper.getReadableDatabase();
        List<Paciente> pacientes = new ArrayList<>();
        try{
            if(reader != null){
                Cursor c = reader.rawQuery("SELECT id,nombre,apellido,run,fecha,area,sintomas,temperatura,tos,presion" +
                                " FROM pacientes",null);
                if(c.moveToFirst()){
                    do{
                        Paciente p = new Paciente();
                        p.setId(c.getInt(0));
                        p.setNombre(c.getString(1));
                        p.setApellido(c.getString(2));
                        p.setRut(c.getString(3));
                        p.setFecha(c.getInt(4));
                        p.setArea(c.getString(5));
                        p.setTemperatura(c.getInt(6));
                        p.setPresion(c.getInt(7));
                        pacientes.add(p);

                    }while(c.moveToNext());
                }
                reader.close();
            }
        }catch (Exception ex){
            pacientes = null;
        }


        return pacientes;
    }

    @Override
    public Paciente save(Paciente p) {
        SQLiteDatabase writer = this.pacientesHelper.getWritableDatabase();
        String sql = String.format("INSERT INTO pacientes(nombre,apellido,run,fecha,area,sintomas,temperatura,tos,presion)" +
                " VALUES('$s','$s','$s','$i','$s','$s','$d','$s','i')",p.getNombre(),p.getApellido(),p.getRut(),p.getFecha()
                         ,p.getArea());
        writer.execSQL(sql);
        writer.close();
        return p;
    }
}
