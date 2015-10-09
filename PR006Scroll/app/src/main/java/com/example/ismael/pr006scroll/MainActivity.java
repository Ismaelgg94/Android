package com.example.ismael.pr006scroll;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView mensajes;
    EditText msjEnviar;
    ImageView btnEnviar;
    ScrollView scvMensajes;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        mensajes= (TextView) findViewById(R.id.lblTexto);
        msjEnviar = (EditText) findViewById(R.id.txtMensaje);
        btnEnviar = (ImageView) findViewById(R.id.imgvEnviar);
        scvMensajes = (ScrollView) findViewById(R.id.sclMensajes);
        msjEnviar.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            public void afterTextChanged(Editable s) {
                desBotonEnviar();
            }
        });

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                envMensaje(msjEnviar.getText().toString());
            }
        });

        desBotonEnviar();

    }



    private void desBotonEnviar() {
        if(TextUtils.isEmpty(msjEnviar.getText().toString())){
            btnEnviar.setEnabled(false);
        }else {
            btnEnviar.setEnabled(true);
        }
    }

    private void envMensaje(String s) {
        SimpleDateFormat formateadorFechas = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
        mensajes.append("("+formateadorFechas.format(new Date())+") "+s+"\n\n");
        msjEnviar.setText("");
        scvMensajes.post(new Runnable() {
            public void run() {
                scvMensajes.fullScroll(View.FOCUS_DOWN);
            }
        });
    }


}
