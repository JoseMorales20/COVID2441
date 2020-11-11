package cl.inacap.examenespreventivos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import cl.inacap.examenespreventivos.adapters.PacientesArrayAdapter;
import cl.inacap.examenespreventivos.dao.PacientesDAO;
import cl.inacap.examenespreventivos.dao.PacientesDAOLista;
import cl.inacap.examenespreventivos.dto.Paciente;

public class Principal extends AppCompatActivity {
    private ListView pacientesLv;
    private List<Paciente> pacientes;
    private PacientesArrayAdapter adaptador;
    private PacientesDAO pacientesDAO = PacientesDAOLista.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        this.setSupportActionBar((Toolbar)findViewById(R.id.toolbar));
        pacientes = pacientesDAO.getAll();
        adaptador = new PacientesArrayAdapter(this,R.layout.pacientes_list,pacientes);
        pacientesLv = findViewById(R.id.pacientesLv);
        pacientesLv.setAdapter(adaptador);
        pacientesLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> AdapterView, View view, int i, long l) {
                Intent intent = new Intent(Principal.this, VerPacientesActivity.class);
                Paciente pacienteActual = pacientes.get(i);
                intent.putExtra("paciente", pacienteActual);
                startActivity(intent);
            }
        });
    }
}