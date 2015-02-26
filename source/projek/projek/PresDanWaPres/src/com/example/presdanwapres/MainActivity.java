package com.example.presdanwapres;

import com.example.presdanwapres.MainActivity;
import com.example.presdanwapres.R;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
		Button a =(Button) findViewById(R.id.button1);
    	a.setOnClickListener(new OnClickListener() {
    	public void onClick(View v) {
    	startActivity(new Intent(MainActivity.this, Pres_dan_Wapres.class));}
    	});
    	Button b =(Button) findViewById(R.id.button2);
    	b.setOnClickListener(new OnClickListener() {
    	public void onClick(View v) {
    	startActivity(new Intent(MainActivity.this, Periode1_11.class));}
    	});
    	Button c =(Button) findViewById(R.id.button3);
    	c.setOnClickListener(new OnClickListener() {
    	public void onClick(View v) {
    	startActivity(new Intent(MainActivity.this, About.class));}
    	});
    	Button d = (Button) findViewById(R.id.button4);
    	d.setOnClickListener(new OnClickListener(){
    		public void onClick(View arg0){
    			AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this); 
    			builder.setMessage("Yakin mau keluar ?").setCancelable(false)
    			.setNegativeButton("Ya", new DialogInterface.OnClickListener() {
    		
    				public void onClick(DialogInterface dialog,int id) { 
    	    			moveTaskToBack(true);
    	    			MainActivity.this.finish();
    		 
    		}
    		}).setPositiveButton("Tidak", new DialogInterface.OnClickListener() { 
    			public void onClick(DialogInterface dialog,int id) {
        			dialog.cancel();
    		 
    		}
    	}) .show();
    		}
    	});
	}
    	@Override
        public boolean onKeyDown(int keyCode, KeyEvent event) {
        	if (keyCode == KeyEvent.KEYCODE_BACK ) {
        	return true;
        	}
        	return super.onKeyDown(keyCode, event);
	}}
