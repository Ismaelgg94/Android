package es.iessaladillo.ismaelgg.pr003estaciones;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup rgrEstacion;
    ImageView imgEstacion;
    Button btnMeGusta;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    public void initViews(){
        rgrEstacion = (RadioGroup) findViewById(R.id.radioGroup);
        imgEstacion = (ImageView) findViewById(R.id.imgEstacion);
        btnMeGusta = (Button) findViewById(R.id.btnMegusta);
        rgrEstacion.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(group.getCheckedRadioButtonId()){
                    case R.id.rbtnVerano:
                        imgEstacion.setImageResource(R.drawable.verano);
                        break;
                    case R.id.rbtnPrimavera:
                        imgEstacion.setImageResource(R.drawable.primavera);
                        break;
                    case R.id.rbtnOtono:
                        imgEstacion.setImageResource(R.drawable.otono);
                        break;
                    case R.id.rbtnInvierno:
                        imgEstacion.setImageResource(R.drawable.invierno);
                        break;
                }
            }
        });
        btnMeGusta.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                switch(rgrEstacion.getCheckedRadioButtonId()){
                    case R.id.rbtnVerano:
                        Toast.makeText(MainActivity.this,R.string.verano,Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbtnPrimavera:
                        Toast.makeText(MainActivity.this, R.string.primavera, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbtnOtono:
                        Toast.makeText(MainActivity.this, R.string.otono, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbtnInvierno:
                        Toast.makeText(MainActivity.this, R.string.invierno, Toast.LENGTH_SHORT).show();
                        break;
                }

            }
        });
    }




}
