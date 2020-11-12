package cl.inacap.examenespreventivos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.TextView;

import cl.inacap.examenespreventivos.dto.Paciente;

public class VerPacientesActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView nombreTxt;
    private TextView apellidoTxt;
    private TextView rutTxt;
    private TextView fechaTxt;
    private TextView areaTxt;
    private TextView sintomasTxt;
    private TextView temperaturaTxt;
    private TextView tosTxt;
    private TextView presionTxt;

    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_pacientes);
        this.toolbar = findViewById(R.id.toolbar);
        this.nombreTxt = findViewById(R.id.nombreTxt);
        this.apellidoTxt = findViewById(R.id.apellidoTxt);
        this.fechaTxt = findViewById(R.id.fechaTxt);
        this.rutTxt = findViewById(R.id.rutTxt);
        this.areaTxt = findViewById(R.id.areaTxt);
        this.sintomasTxt = findViewById(R.id.sintomasTxt);
        this.temperaturaTxt = findViewById(R.id.temperaturaTxt);
        this.tosTxt = findViewById(R.id.tosTxt);
        this.presionTxt = findViewById(R.id.presionTxt);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setDisplayShowHomeEnabled(true);
        this.setSupportActionBar(this.toolbar);
        if(getIntent() != null){
            Paciente paciente = (Paciente) getIntent().getSerializableExtra("paciente");
            this.nombreTxt.setText(paciente.getNombre());
            this.apellidoTxt.setText(paciente.getApellido());
            this.rutTxt.setText(paciente.getRut());
            this.fechaTxt.setText(paciente.getFecha());
            this.areaTxt.setText(paciente.getArea());
            this.temperaturaTxt.setText(paciente.getTemperatura());
            this.presionTxt.setText(paciente.getPresion());
        }
    }
}