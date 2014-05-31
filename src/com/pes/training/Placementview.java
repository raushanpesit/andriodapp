package com.pes.training;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.TextView;

public class Placementview extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.place2);
		TextView tv=(TextView) findViewById(R.id.tvSQLin);
		Bundle bundle=getIntent().getExtras();
		
		
		String s2=bundle.getString("lat3");
		String s3=bundle.getString("lat4");
		Placedata inf=new Placedata(this);
		inf.open();
		String data3=inf.getData3(s2,s3);
	    inf.close();
		if(data3.length()==0){
			Dialog d=new Dialog(this);
			d.setTitle("Alert");
			TextView tv1=new TextView(this);
			tv1.setText("Data Not found");
			d.setContentView(tv1);
			d.show(); 
			
		}else{
			tv.setText(data3);
		}
	}


}