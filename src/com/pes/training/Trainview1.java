package com.pes.training;
import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.TextView;

public class Trainview1 extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.train1);
		TextView tv=(TextView) findViewById(R.id.tvSQLinf1);
		Bundle bundle=getIntent().getExtras();
		String s=bundle.getString("lat1");
		
		
		Data inf=new Data(this);
		inf.open();
		String data1=inf.getData1(s);
		
		inf.close();
		  
		
		if(data1.length()==0){
			Dialog d=new Dialog(this);
			d.setTitle("Alert");
			TextView tv1=new TextView(this);
			tv1.setText("Data Not found");
			d.setContentView(tv1);
			d.show(); 
			
		}else{
			tv.setText(data1);}
		}
		 }		
		
		
	


