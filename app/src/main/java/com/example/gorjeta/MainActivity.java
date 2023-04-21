package com.example.gorjeta;

import androidx.appcompat.app.AppCompatActivity;
import java.text.NumberFormat;

import android.os.Build;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SeekBar barra;
    TextView textoValor;
    TextView textoGorjeta;
    TextView textGorjeta;
    TextView textConta;
    double total =400.80;
    double gorjeta = 0;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        barra = findViewById(R.id.barra);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            barra.setMin(15);
            barra.setMax(40);
            textoValor = findViewById(R.id.progresso);
            textoValor.setText(barra.getMin() +"%");
        }
        textoValor.setText("Total de consumação: " + NumberFormat.getCurrencyInstance().format(total) );

        textoGorjeta = findViewById(R.id.textoGorgeta);
        textGorjeta = findViewById(R.id.textGorjeta);
        textConta = findViewById(R.id.textConta);


        barra.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                        textoGorjeta.setText(+i +"% ");
                        gorjeta = (total/100) * i;
                        textGorjeta.setText("Total da gorjeta: " + NumberFormat.getCurrencyInstance().format(gorjeta) );




                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        double temp =0;
                        temp = total +gorjeta;
                        textConta.setText("Total da conta: " + NumberFormat.getCurrencyInstance().format(temp) );
                        temp=total;
                    }
                }
        );
    }
}