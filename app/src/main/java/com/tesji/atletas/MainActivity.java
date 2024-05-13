
package com.tesji.atletas;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;
import Model.MainActivityModel;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText txmUno;
    private TextInputEditText txsUno;
    private TextInputEditText txmDos;
    private TextInputEditText txsDos;
    private Button btcalcular;
    private Button btnuevo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txmUno = findViewById(R.id.metrosUno);
        txsUno = findViewById(R.id.segundosUno);
        txmDos = findViewById(R.id.metrosDos);
        txsDos = findViewById(R.id.segundosDos);
        btcalcular = findViewById(R.id.calcular);
        btnuevo = findViewById(R.id.nuevo);

        btcalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txmUno.getText().toString().trim().length() == 0) {
                    txmUno.setError("INGRESE UN NUMERO");
                    txmUno.requestFocus();
                } else if (txsUno.getText().toString().trim().length() == 0) {
                    txsUno.setError("INGRESE UN NUMERO");
                    txsUno.requestFocus();
                } else if (txmDos.getText().toString().trim().length() == 0) {
                    txmDos.setError("INGRESE UN NUMERO");
                    txmDos.requestFocus();
                } else if (txsDos.getText().toString().trim().length() == 0) {
                    txsDos.setError("INGRESE UN NUMERO");
                    txsDos.requestFocus();
                } else {
                    int sUno = Integer.parseInt(txsUno.getText().toString());
                    int sDos = Integer.parseInt(txsDos.getText().toString());

                    if (sUno >= 60) {
                        txsUno.setError("NO EXISTEN 60 SEGUNDOS. \nNO EXISTEN +60 SEGUNDOS");
                    } else if (sDos >= 60) {
                        txsDos.setError("NO EXISTEN 60 SEGUNDOS. \nNO EXISTEN +60 SEGUNDOS");
                    } else {
                        MainActivityModel objModel = new MainActivityModel("Atleta", Integer.parseInt(txmUno.getText().toString()), Integer.parseInt(txsUno.getText().toString()), Integer.parseInt(txmDos.getText().toString()), Integer.parseInt(txsDos.getText().toString()));
                        Toast.makeText(getApplicationContext(), objModel.calcular(), Toast.LENGTH_LONG).show();

                    }
                }
            }
        });
        btnuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txmUno.setText(null);
                txsUno.setText(null);
                txmDos.setText(null);
                txsDos.setText(null);
            }
        });
    }
}
