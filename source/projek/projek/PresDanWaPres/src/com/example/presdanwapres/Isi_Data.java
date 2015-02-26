package com.example.presdanwapres;

import java.io.IOException;
import java.io.InputStream;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Isi_Data extends Activity {
	
	TextView			txtNama, txtIsi;
	private ImageView	Img;
	String 				nama,isi,gambar;
	MediaPlayer  		mp ;
	int suara=R.raw.gusdur; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.isi_data);
		Button a =(Button) findViewById(R.id.btmenu);
    	a.setOnClickListener(new OnClickListener() {
    	public void onClick(View v) {
    	startActivity(new Intent(Isi_Data.this, MainActivity.class));}
    	});
		Intent i = this.getIntent();
		nama=i.getStringExtra("nama");
		isi=i.getStringExtra("isi");
		gambar=i.getStringExtra("gambar");
		
		if(nama.equalsIgnoreCase("Soekarno")){
			suara=R.raw.soekarno;
		}
		else if(nama.equalsIgnoreCase("Mohammad Hatta")){
			suara=R.raw.hatta;
		}
		else if(nama.equalsIgnoreCase("Soeharto")){
			suara=R.raw.soeharto;
		}
		else if(nama.equalsIgnoreCase("Hamengkubuwana IX")){
			suara=R.raw.hameng9;
		}
		else if(nama.equalsIgnoreCase("Adam Malik")){
			suara=R.raw.adammlk;
		}
		else if(nama.equalsIgnoreCase("Umar Wirahadikusumah")){
			suara=R.raw.umar;
		}
		else if(nama.equalsIgnoreCase("Soedharmono")){
			suara=R.raw.sudharmono;
		}
		else if(nama.equalsIgnoreCase("Tri Sutrisno")){
			suara=R.raw.trisutrisno;
		}
		else if(nama.equalsIgnoreCase("Bacharuddin Jusuf Habibie")){
			suara=R.raw.habibie;
		}
		else if(nama.equalsIgnoreCase("Abdurrahman Wahid")){
			suara=R.raw.gusdur;
		}
		else if(nama.equalsIgnoreCase("Megawati Soekarnoputri")){
			suara=R.raw.megawati;
		}
		else if(nama.equalsIgnoreCase("Hamzah Haz")){
			suara=R.raw.hamzahaz;
		}
		else if(nama.equalsIgnoreCase("Susilo Bambang Yudhoyono")){
			suara=R.raw.sby;
		}
		else if(nama.equalsIgnoreCase("Muhammad Jusuf Kalla")){
			suara=R.raw.jk;
		}
		else if(nama.equalsIgnoreCase("Boediono")){
			suara=R.raw.boediono;
		}
		
		Button b =(Button) findViewById(R.id.imgsuara);
		b.setOnClickListener(new OnClickListener() {
		public void onClick(View v) {
			  mp = MediaPlayer.create(Isi_Data.this,suara);
			  if(!mp.isPlaying()){
				  mp.start();
			  		}
			}});  
		Button c =(Button) findViewById(R.id.stop);
		c.setOnClickListener(new OnClickListener() {
		public void onClick(View v) {{
				  mp.stop();
			  		}
			}});  
			
		Img = (ImageView) findViewById(R.id.gambar);
		txtNama = (TextView) findViewById(R.id.nama);txtNama.setText(nama);
		txtIsi = (TextView) findViewById(R.id.isi);txtIsi.setText(isi);
		loadImagesFromAsset();}

	public void loadImagesFromAsset() {
		try {
			InputStream ims =null;
			ims = getAssets().open(gambar);
			Drawable d = Drawable.createFromStream(ims, null);
			Img.setImageDrawable(d);
		} 
		catch (IOException e) {e.printStackTrace();}
	}
	
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			try{mp.stop();}
			catch(Exception ee){}
			finish();
		return true;
		}
		return super.onKeyDown(keyCode, event);
		}    

}