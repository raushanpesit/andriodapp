package com.pes.training;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.TextView;

public class Place extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.placeview);
		TextView tv=(TextView) findViewById(R.id.tvSQLinf);
		Placedata info=new Placedata(this);
		info.open();
		String data1=info.getData();
		info.close();
			tv.setText(data1);}
		
	}
	

