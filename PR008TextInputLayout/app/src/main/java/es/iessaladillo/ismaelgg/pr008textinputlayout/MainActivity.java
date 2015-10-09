package es.iessaladillo.ismaelgg.pr008textinputlayout;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    TextInputLayout tilNombre;
    TextInputLayout tilTelefono;
    TextInputLayout tilEmail;
    EditText etxNombre;
    EditText etxTelefono;
    EditText etxEmail;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        tilNombre = (TextInputLayout) findViewById(R.id.tilNombre);
        tilTelefono = (TextInputLayout) findViewById(R.id.tilTelefono);
        tilEmail = (TextInputLayout) findViewById(R.id.tilEmail);
        etxNombre = (EditText) findViewById(R.id.etxNombre);
        etxTelefono = (EditText) findViewById(R.id.etxTelefono);
        etxEmail = (EditText) findViewById(R.id.etxEmail);

        etxTelefono.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            public void afterTextChanged(Editable s) {
                    if(!etxTelefono.getText().toString().startsWith("6") || etxTelefono.getText().toString().length()!=9){
                        tilTelefono.setError("Telefono no valido");
                    }else{
                        tilTelefono.setErrorEnabled(false);
                    }

            }
        });

        etxEmail.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            public void afterTextChanged(Editable s) {
                if (!TextUtils.isEmpty(etxEmail.getText().toString())) {
                    if (!Patterns.EMAIL_ADDRESS.matcher(etxEmail.getText().toString()).matches()) {
                        tilEmail.setError("Correo no valido");
                    } else {
                        tilEmail.setErrorEnabled(false);
                    }
                } else {
                    tilEmail.setErrorEnabled(false);
                }
            }
        });
    }


}
