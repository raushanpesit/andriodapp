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

public class training extends Activity implements OnClickListener {
	//public static long l;
	EditText sqlRow,sqlRow2,sqlRow3;
	String lat1,lat2,lat3,lat4,s;
	int value;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.training);
		 sqlRow=(EditText) findViewById(R.id.etSQLrowInfo);
		 sqlRow2=(EditText)findViewById(R.id.etSQLrowInfo2);
		 sqlRow3=(EditText)findViewById(R.id.etSQLrowInfo3);
		 Button ta=(Button)findViewById(R.id.bgetInfo2);
		 Button de=(Button) findViewById(R.id.bgetInfo);
		de.setOnClickListener(this);

		ta.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		//first
		case R.id.bgetInfo:
			String s=sqlRow.getText().toString();
			//long l=Long.parseLong(s);
				int a =s.length();
				if(a==0)
				{
					Dialog d=new Dialog(this);
					d.setTitle("Alert");
					TextView tv=new TextView(this);
					tv.setText("Fill sem  field first**");
					d.setContentView(tv);
					d.show();
				}else{
				lat1=s;
				 value = Integer.valueOf(sqlRow.getText().toString());  
				if (value ==0) {  
					Dialog d=new Dialog(this);
					d.setTitle("Error");
					TextView tv=new TextView(this);
					tv.setText("Invalid sem input");
					d.setContentView(tv);
					d.show(); 
				}
				else if (value>8) {  
					Dialog d=new Dialog(this);
					d.setTitle("Error");
					TextView tv=new TextView(this);
					tv.setText("Invalid sem input ");
					d.setContentView(tv);
					d.show(); 
				}
				
				else{
				
			Intent i=new Intent(training.this,Trainview1.class);
			i.putExtra("lat1", s);
			startActivity(i);}}
			break;
		//second
		
		
		case R.id.bgetInfo2:
			 String s2=sqlRow2.getText().toString();
			String s3=sqlRow3.getText().toString();
			
			int b =s2.length();
			int c =s3.length();
			if(b==0 || c==0)
			{
				Dialog d=new Dialog(this);
				d.setTitle("Alert");
				TextView tv=new TextView(this);
				tv.setText("Fill sem and cgpa  field first**");
				d.setContentView(tv);
				d.show();
			}else{
			
			//long l=Long.parseLong(s);
				lat3=s2;
				lat4=s3;
		
		
			//long l=Long.parseLong(s);
			value = Integer.valueOf(sqlRow2.getText().toString()); 
		double value1 = Double.parseDouble(sqlRow3.getText().toString());
			if (value >8) {  
				Dialog d=new Dialog(this);
				d.setTitle("Error");
				TextView tv=new TextView(this);
				tv.setText("Invalid sem input");
				d.setContentView(tv);
				d.show();
			}
			
				else if (value1>10.0) {  
					Dialog d=new Dialog(this);
					d.setTitle("Error");
					TextView tv=new TextView(this);
					tv.setText("Invalid CGPA input ");
					d.setContentView(tv);
					d.show();}
				else{
				Intent i2=new Intent(training.this,Trainview.class);
			i2.putExtra("lat3", s2);
			i2.putExtra("lat4", s3);
			startActivity(i2);}}
				break;
	}

}}
