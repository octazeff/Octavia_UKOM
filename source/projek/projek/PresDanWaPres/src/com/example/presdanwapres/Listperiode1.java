package com.example.presdanwapres;
import java.io.IOException;


import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;


public class Listperiode1 extends Activity implements AdapterView.OnItemClickListener{
	private DatabaseHelper myDbHelper;
	private Cursor c;
	private ListView listView1;
	Listheader []listdata;
	int jd=0;
	String[] arrNama;	
	String[] arrIsi;		
	String[] arrGambar;		

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listview);

		myDbHelper = new DatabaseHelper(this);
		try {myDbHelper.createDataBase(); } 
		catch (IOException ioe) {throw new Error("Unable to create database");}
		try {myDbHelper.openDataBase();}
		catch(SQLException sqle) {throw sqle;}

		myDbHelper.getReadableDatabase();
		c=myDbHelper.query("per1", null, null, null, null,null, null);

		c.moveToFirst();
		jd = c.getCount();

		Toast.makeText(Listperiode1.this, "Jumlah data: "+jd+"...", Toast.LENGTH_LONG).show();	

		arrNama=new String[jd];	
		arrIsi=new String[jd];
		arrGambar=new String[jd];	

		for(int i=0;i<jd;i++){
			arrNama[i]=c.getString(0);
			arrIsi[i]=c.getString(1);
			arrGambar[i]=c.getString(2);

			try{c.moveToNext();}
			catch(Exception ee){}
		}
		myDbHelper.close();

		listdata = new Listheader[jd];
		for(int j=0;j<jd;j++){
			listdata[j]=new Listheader(R.drawable.garudasml, "          "+arrNama[j]);
		}
		Listitem adapter = new Listitem(this,R.layout.listitem, listdata);
		listView1 = (ListView)findViewById(R.id.listView1);
		View header = (View)getLayoutInflater().inflate(R.layout.listheader, null);
		listView1.addHeaderView(header);
		listView1.setAdapter(adapter);
		listView1.setOnItemClickListener((OnItemClickListener) this);

		TextView  txtMarquee=(TextView)findViewById(R.id.txtHeader);
		txtMarquee.setSelected(true);
		String kata="PERIODE 1 DIPIMPIN OLEH PEMERINTAHAN SOEKARNO - PERIODE 1 DIPIMPIN OLEH PEMERINTAHAN SOEKARNO ";
		String POLA =getString(R.string.marquee); 
		String kalimat=String.format(POLA,TextUtils.htmlEncode(kata));
		txtMarquee.setText(Html.fromHtml(kalimat));  	        

	}

	@Override
	public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
		Toast.makeText(Listperiode1.this, "Pilihan Anda : "+arrNama[position-1]+"...", Toast.LENGTH_LONG).show();	

		Intent i = new Intent(Listperiode1.this, Isi_Data.class);
		i.putExtra("nama", arrNama[position-1]);
		i.putExtra("isi", arrIsi[position-1]);
		i.putExtra("gambar", arrGambar[position-1]);
		startActivity(i);
	}
}