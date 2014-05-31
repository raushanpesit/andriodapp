package com.pes.training;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Admin extends Activity implements OnClickListener
{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.admin1);
		Button de=(Button)findViewById(R.id.button1);
		Button dt=(Button)findViewById(R.id.button2);
		Button di=(Button)findViewById(R.id.register);
		di.setOnClickListener(this);
		de.setOnClickListener(this);
		dt.setOnClickListener(this);
		
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.button1:
			Intent i=new Intent(Admin.this,SQLexample.class);
			startActivity(i);
			break;
		case R.id.button2:
			Intent t=new Intent(Admin.this,Placeview.class);
			startActivity(t);
			break;
		
		case R.id.register:
			Intent j=new Intent(Admin.this,MainActivity.class);
			startActivity(j);
			break;
			
	}

}}
