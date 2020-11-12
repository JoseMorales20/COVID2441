package cl.inacap.examenespreventivos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toolbar;

import java.util.Calendar;

import cl.inacap.examenespreventivos.dao.PacientesDAO;
import cl.inacap.examenespreventivos.dao.PacientesDAOSQLite;
import cl.inacap.examenespreventivos.dto.Paciente;

public class IngresarPacienteActivity extends AppCompatActivity {
    private PacientesDAO pacientesDAO = new PacientesDAOSQLite(this);
    private EditText nombreTxt_pc;
    private EditText apellidoTxt_pc;
    private EditText rutTxt_pc;
    private TextView fechaTxt_pc;
    private Spinner areaTxt_pc;
    private Switch sintomasTxt_pc;
    private EditText temperaturaTxt_pc;
    private Switch tosTxt_pc;
    private EditText presionTxt_pc;
    private Button ingresarBtn_pc;
    private Toolbar toolbar;
    DatePickerDialog.OnDateSetListener setListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar_paciente);
        this.nombreTxt_pc = findViewById(R.id.nombreTxt_pc);
        this.apellidoTxt_pc = findViewById(R.id.apellidoTxt_pc);
        this.rutTxt_pc = findViewById(R.id.rutTxt_pc);
        this.sintomasTxt_pc = findViewById(R.id.sintomasTxt_pc);
        this.temperaturaTxt_pc = findViewById(R.id.temperaturaTxt_pc);
        this.tosTxt_pc = findViewById(R.id.tosTxt_pc);
        this.presionTxt_pc = findViewById(R.id.presionTxt_pc);
        this.ingresarBtn_pc = findViewById(R.id.ingresarBtn_pc);
        this.areaTxt_pc = findViewById(R.id.areaTxt_pc);
        this.fechaTxt_pc = findViewById(R.id.fechaTxt_pc);
        this.toolbar = findViewById(R.id.toolbar);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setDisplayShowHomeEnabled(true);
        this.setSupportActionBar(this.toolbar);


        String[] opciones = {"sector publico","salud","gastronomica","turismo"};
        final String[] opcines2 = {"1","2","3","4","5"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,opciones);
        areaTxt_pc.setAdapter(adapter);

        final Calendar calendar = Calendar.getInstance();
        final int dia = calendar.get(Calendar.DAY_OF_MONTH);
        final int mes = calendar.get(Calendar.MONTH);
        final int anio = calendar.get(Calendar.YEAR);



        fechaTxt_pc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        IngresarPacienteActivity.this,android.R.style.Theme_Holo_Light_Dialog_MinWidth
                        ,setListener,dia,mes,anio);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });
        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker View, int dia, int mes, int anio) {
                mes = mes+1;
                String fecha = dia+"/"+ mes+"/"+anio;
                fechaTxt_pc.setText(fecha);

            }
        };

        this.ingresarBtn_pc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Paciente p = new Paciente();
                p.setNombre(nombreTxt_pc.getText().toString());
                p.setApellido(apellidoTxt_pc.getText().toString());
                p.setFecha(Integer.parseInt(fechaTxt_pc.toString()));
                p.setRut(rutTxt_pc.getText().toString());
                p.setTemperatura(Integer.parseInt(temperaturaTxt_pc.toString()));
                p.setPresion(Integer.parseInt(presionTxt_pc.toString()));
                pacientesDAO.save(p);
                startActivity(new Intent(IngresarPacienteActivity.this,Principal.class));


            }
        });

    }


}