package com.pes.training;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Signin extends Activity implements OnClickListener {
	//public static long l;
	EditText sqlRow,sqlRow1;
	String lat1,lat2,s;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		 sqlRow=(EditText) findViewById(R.id.editText1);
		sqlRow1=(EditText) findViewById(R.id.editText2);
		 Button de=(Button) findViewById(R.id.button1);
		 Button te=(Button) findViewById(R.id.button2);
		de.setOnClickListener(this);
		te.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		//first
		case R.id.button1:
			//try{
			s=sqlRow.getText().toString();
			String l = sqlRow1.getText().toString();
		//long l=Long.parseLong(s);
			int a =s.length();
			int b=l.length();
			if(a==0 || b==0)
			{
				Dialog d=new Dialog(this);
				d.setTitle("alert");
				TextView tv=new TextView(this);
				tv.setText("Fill Username and password");
				d.setContentView(tv);
				d.show();
			}
			else
			{lat1=s;
			lat2=l;
			
		Intent i=new Intent(Signin.this,Sign.class);
		i.putExtra("lat1", s);
		i.putExtra("lat2",l);
		startActivity(i);}
		break;
		//second
		
		
		case R.id.button2:
			 
				Intent i2=new Intent(Signin.this,Login.class);
			
			startActivity(i2);
				break;
	}

}}
