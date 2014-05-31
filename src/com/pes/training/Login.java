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


public class Login extends Activity implements OnClickListener{
	Button a,b;
	EditText du,de,ta;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.signup);
		a=(Button) findViewById(R.id.button4);
		du=(EditText) findViewById(R.id.editText1);
		de=(EditText) findViewById(R.id.editText2);
		ta=(EditText) findViewById(R.id.editText3);
		a.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
		
		case R.id.button4:
			boolean did=true;
			try{
				String x=du.getText().toString();
				String y=de.getText().toString();
				String m=ta.getText().toString();
				
				int k=x.length();
				int l=5/k;
				k=y.length();
				l=5/k;
				k=m.length();
				l=5/k;
				if(y.contentEquals(m)){
				
				
				LoginData entr=new LoginData(Login.this);
			entr.open();
			entr.createuser(x,y);
			entr.close();}else{
				did=false;
				Dialog d=new Dialog(this);
				d.setTitle("alert");
				TextView tv=new TextView(this);
				tv.setText("Password not match");
				d.setContentView(tv);
				d.show();}
			}
			catch(Exception e){
				did=false;
				/*String error=e.toString();
				Dialog d=new Dialog(this);
				d.setTitle("Error");
				TextView tv=new TextView(this);
				tv.setText(error);
				d.setContentView(tv);
				d.show();*/
				
			}finally{
				if(did){
				Dialog d=new Dialog(this);
				d.setTitle("ok");
				TextView tv=new TextView(this);
				tv.setText("U are registered Successfully");
				d.setContentView(tv);
				d.show();}
			else{
				Dialog d=new Dialog(this);
				d.setTitle("alert");
				TextView tv=new TextView(this);
				tv.setText("Fill  correct info **");
				d.setContentView(tv);
				d.show();
				}
			}
		
			
	
		
		}
	}

}
