package com.example.meditrack;

import android.os.Bundle;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView textRecordatorio = findViewById(R.id.textRecordatorio);

        // PRUEBA
        String medicamento = "Ibuprofeno";
        String horaProgramada = "02:14";

        String horaActual = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());

        if (horaActual.equals(horaProgramada)) {
            textRecordatorio.setText("Recordatorio: Tomar " + medicamento);
        } else {
            textRecordatorio.setText("No hay recordatorios en este momento");
        }

    }
}