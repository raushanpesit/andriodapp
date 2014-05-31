package com.pes.training;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Sign extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
	
		super.onCreate(savedInstanceState);
		Bundle bundle=getIntent().getExtras();
		
		
		String s2=bundle.getString("lat1");
		String s3=bundle.getString("lat2");
		LoginData inf1=new LoginData(this);
		inf1.open();
		
		
		String data4=inf1.getData4(s2,s3);
	    inf1.close();
		
		
	    if(s3.contentEquals(data4)){
	    	Intent i=new Intent(Sign.this,Admin.class);
			startActivity(i);
			
		}else{
			Dialog d=new Dialog(this);
			d.setTitle("alert");
			TextView tv=new TextView(this);
			tv.setText("wrong company name or password entered**");
			d.setContentView(tv);
			d.show();
		}
	}


}
