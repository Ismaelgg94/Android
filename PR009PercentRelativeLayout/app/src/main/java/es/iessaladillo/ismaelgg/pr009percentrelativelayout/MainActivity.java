package es.iessaladillo.ismaelgg.pr009percentrelativelayout;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import static es.iessaladillo.ismaelgg.pr009percentrelativelayout.R.color.c6;

public class MainActivity extends AppCompatActivity {

    TextView c1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        c1= (TextView) findViewById(R.id.c1);
        c1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                c1.setBackgroundColor(getResources().getColor(c6));
                crearSnackBar();
            }

            private void crearSnackBar() {
                
            }
        });
    }

}
