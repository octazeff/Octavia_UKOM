package com.example.presdanwapres;

import com.example.presdanwapres.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Periode1_11 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.periode1_11);
		
		Button x =(Button) findViewById(R.id.button1);

    	x.setOnClickListener(new OnClickListener() {
    	public void onClick(View v) {
    	startActivity(new Intent(Periode1_11.this, Listperiode1.class));
    			}
    	});
		
    	Button y =(Button) findViewById(R.id.button2);

    	y.setOnClickListener(new OnClickListener() {
    	public void onClick(View v) {
    	startActivity(new Intent(Periode1_11.this, Listperiode2_8.class));
    			}
    	});
    	
    	Button z =(Button) findViewById(R.id.button3);

    	z.setOnClickListener(new OnClickListener() {
    	public void onClick(View v) {
    	startActivity(new Intent(Periode1_11.this, Listperiode9.class));
    			}
    	});
    	Button w = (Button) findViewById(R.id.button4);
    	
    	w.setOnClickListener(new OnClickListener() {
        public void onClick(View v) {
        startActivity(new Intent(Periode1_11.this, Listperiode10_11.class));
        } 
    	});
    	
    	}
}
    	
    	
