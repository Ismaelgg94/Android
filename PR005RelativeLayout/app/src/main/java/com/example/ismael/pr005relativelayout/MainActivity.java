package com.example.ismael.pr005relativelayout;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnFocusChangeListener {

    EditText txtUsuario;
    EditText txtClave;
    Button btnAceptar;
    Button btnCancelar;
    TextView txtvUsuario;
    TextView txtvClave;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        txtUsuario = (EditText) findViewById(R.id.txtUsuario);
        txtClave = (EditText) findViewById(R.id.txtClave);
        btnAceptar = (Button) findViewById(R.id.btnAceptar);
        btnCancelar = (Button) findViewById(R.id.btnCancelar);
        txtvClave = (TextView) findViewById(R.id.lblClave);
        txtvUsuario = (TextView) findViewById(R.id.lblUsuario);

        btnAceptar.setOnClickListener(this);
        btnCancelar.setOnClickListener(this);
        txtUsuario.setOnFocusChangeListener(this);
        txtClave.setOnFocusChangeListener(this);

        txtClave.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            public void afterTextChanged(Editable s) {
                visTextView(txtClave, txtvClave);
                btnAceptarVis();
            }
        });

        txtUsuario.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            public void afterTextChanged(Editable s) {
                visTextView(txtUsuario,txtvUsuario);
                btnAceptarVis();
            }
        });

        visTextView(txtClave, txtvClave);
        visTextView(txtUsuario,txtvUsuario);
        btnAceptarVis();

    }

    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAceptar:
                Toast.makeText(this, getString(R.string.msjAceptar) + txtUsuario.getText().toString(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnCancelar:
                txtUsuario.setText("");
                txtClave.setText("");
                break;
        }
    }

    public void onFocusChange(View v, boolean hasFocus) {
        switch (v.getId()){
            case R.id.txtUsuario:
                setColor(txtvUsuario, hasFocus);
                break;
            case R.id.txtClave:
                setColor(txtvClave, hasFocus);
                break;
        }
    }

    public void setColor(TextView text,boolean focus){
        if(focus){
            text.setTextColor(Color.GREEN);
        }else{
            text.setTextColor(Color.GRAY);
        }
    }

    private void visTextView(EditText txt, TextView txtv) {
        if(TextUtils.isEmpty(txt.getText().toString())){
            txtv.setVisibility(View.INVISIBLE);
        }else{
            txtv.setVisibility(View.VISIBLE);
        }
    }

    private void btnAceptarVis(){
        if(!TextUtils.isEmpty(txtUsuario.getText().toString()) && !TextUtils.isEmpty(txtClave.getText().toString())){
            btnAceptar.setEnabled(true);
        }else{
            btnAceptar.setEnabled(false);
        }
    }
}
