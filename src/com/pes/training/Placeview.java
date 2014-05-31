package com.pes.training;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Placeview extends Activity implements OnClickListener{
	Button sqlUpdate,sqlView;
	EditText sqlName,sqlDetail,sqlDate,sqlLocation,sqlYear,sqlCg;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.place);
		sqlUpdate=(Button) findViewById(R.id.bSQLUpdat);
		sqlView=(Button) findViewById(R.id.bSQLopenVie);
		sqlName=(EditText) findViewById(R.id.etSQLNam);
		
		sqlDetail=(EditText) findViewById(R.id.etSQLDetai);
		sqlDate=(EditText) findViewById(R.id.etSQLDat);
		sqlLocation=(EditText) findViewById(R.id.etSQLLocatio);
		sqlYear=(EditText) findViewById(R.id.etSQLYea);
		sqlCg=(EditText) findViewById(R.id.etSQLYea1);
		sqlView.setOnClickListener(this);
		sqlUpdate.setOnClickListener(this);
		
		
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
		
		case R.id.bSQLUpdat:
			boolean did=true;
			try{  
			String name=sqlName.getText().toString();
			String detail=sqlDetail.getText().toString();
			String date=sqlDate.getText().toString();
			String location=sqlLocation.getText().toString();
			String year=sqlYear.getText().toString();
		
			String year1=sqlCg.getText().toString();
			int a=name.length();
			int b=5/a;
			a=detail.length();
			b=5/a;
			a=date.length();
			b=5/a;
			a=location.length();
			b=5/a;
			a=year.length();
			b=5/a;
			a=year1.length();
			b=5/a;
			Placedata entry=new Placedata(Placeview.this);
			entry.open();
			entry.createEntry(name,detail,date,location,year,year1);
			entry.close();
			}catch(Exception e){
				did=false;
			/*	String error=e.toString();
				Dialog d=new Dialog(this);
				d.setTitle("Error");
				TextView tv=new TextView(this);
				tv.setText(error);
				d.setContentView(tv);
				d.show();*/
				
			}finally{if(did){
				
				Dialog d=new Dialog(this);
				d.setTitle("Ok");
				TextView tv=new TextView(this);
				tv.setText("Data Entered Successfully");
				d.setContentView(tv);
				d.show();
			}else{
				Dialog d=new Dialog(this);
				d.setTitle("alert");
				TextView tv=new TextView(this);
				tv.setText("Fill all the fields**");
				d.setContentView(tv);
				d.show();
			}
			}
						
			break;
		case R.id.bSQLopenVie:
			Intent i=new Intent(Placeview.this,Place.class);
			startActivity(i);
			
			break;
		
		}
	}

}
