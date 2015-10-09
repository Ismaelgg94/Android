package com.example.ismael.pr002educado;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtNombre;
    EditText txtMensaje;
    CheckBox chkEducado;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

   public void initView(){
       txtNombre = (EditText)findViewById(R.id.txtNombre);
       txtMensaje = (EditText) findViewById(R.id.txtSaludo);
       chkEducado = (CheckBox) findViewById(R.id.chkEducado);
       chkEducado.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               if(buttonView.isChecked()){
                   Toast.makeText(getApplicationContext(),"El checkbox esta activado",Toast.LENGTH_SHORT).show();
               }else{
                   Toast.makeText(getApplicationContext(),"El checkbox esta desactivado",Toast.LENGTH_SHORT).show();
               }
           }
       });
   }

    public void saludar(View view){
        if(chkEducado.isChecked()){
            txtMensaje.setText(R.string.saludo2+txtNombre.getText().toString());
        }else{
            txtMensaje.setText(R.string.saludo1+txtNombre.getText().toString());
        }


    }


}
