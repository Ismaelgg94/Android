package es.iessaladillo.ismaelgg.pr007cardview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import javax.xml.datatype.Duration;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etxCuenta;
    private EditText etxPropPorc;
    private EditText etxPropina;
    private EditText etxTotal;
    private EditText etxComensales;
    private EditText etxPorComensal;
    private Button btnCalcular;
    private Button btnCalcular2;
    private Button btnRedondear;
    private Button btnRedondear2;
    private Button btnLimpiar;
    private Button btnLimpiar2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        etxCuenta = (EditText) findViewById(R.id.etxCuenta);
        etxPropPorc = (EditText) findViewById(R.id.etxPropPorc);
        etxPropina = (EditText)findViewById(R.id.etxPropina);
        etxTotal = (EditText) findViewById(R.id.etxTotal);
        etxComensales = (EditText) findViewById(R.id.etxComensales);
        etxPorComensal = (EditText) findViewById(R.id.etxPorComensal);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnCalcular2 = (Button) findViewById(R.id.btnCalcular2);
        btnRedondear = (Button) findViewById(R.id.btnRedondear);
        btnRedondear2 = (Button) findViewById(R.id.btnRedondear2);
        btnLimpiar = (Button) findViewById(R.id.btnLimpiar);
        btnLimpiar2 = (Button) findViewById(R.id.btnLimpiar2);

        btnCalcular.setOnClickListener(this);
        btnCalcular2.setOnClickListener(this);
        btnRedondear.setOnClickListener(this);
        btnRedondear2.setOnClickListener(this);
        btnLimpiar.setOnClickListener(this);
        btnLimpiar2.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnCalcular:
                BigDecimal dec = new BigDecimal(etxCuenta.getText().toString());
                BigDecimal decP = new BigDecimal(etxPropPorc.getText().toString());
                float cuenta=dec.floatValue(),propP=decP.floatValue();
                float propina=(propP*100)/cuenta;
                float total=propina+cuenta;
                etxPropina.setText(String.format(Locale.getDefault(),"%.2f",propina));
                etxTotal.setText(String.format(Locale.getDefault(),"%.2f",total));
                break;
            case R.id.btnCalcular2:
                BigDecimal decT = new BigDecimal(etxTotal.getText().toString());
                BigDecimal decc = new BigDecimal(etxComensales.getText().toString());
                float total2=decT.floatValue();
                float comen=decc.floatValue();
                float porcom=total2/comen;
                etxPorComensal.setText(String.format(Locale.getDefault(),"%.2f",porcom));

                break;
            case R.id.btnRedondear:
                if(!TextUtils.isEmpty(etxCuenta.getText().toString())){
                    BigDecimal dec3 = new BigDecimal(etxCuenta.getText().toString());
                    dec3 = dec3.setScale(0, RoundingMode.UP);
                    etxTotal.setText(String.format(Locale.getDefault(),"%.2f",dec3));
                }

                break;
            case R.id.btnRedondear2:
                if(!TextUtils.isEmpty(etxComensales.getText().toString())){
                    BigDecimal dec4 = new BigDecimal(etxPorComensal.getText().toString());
                    dec4 = dec4.setScale(0, RoundingMode.UP);
                    etxPorComensal.setText(String.format(Locale.getDefault(),"%.2f",dec4));
                }
                break;
            case R.id.btnLimpiar:
                etxCuenta.setText("0.00");
                etxPropPorc.setText("0");
                etxPropina.setText("0.00");
                etxTotal.setText("0.00");
                break;
            case R.id.btnLimpiar2:
                etxComensales.setText("1");
                etxPorComensal.setText("0.00");
                break;
        }

    }
}
