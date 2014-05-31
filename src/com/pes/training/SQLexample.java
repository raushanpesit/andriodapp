package com.pes.training;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SQLexample extends Activity implements OnClickListener{
	Button sqlUpdate,sqlView,sqlGetInfo;
	EditText sqlName,sqlDetail,sqlDate,sqlLocation,sqlYear,sqlYear1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sql);
		sqlUpdate=(Button) findViewById(R.id.bSQLUpdate);
		sqlView=(Button) findViewById(R.id.bSQLopenView);
		sqlName=(EditText) findViewById(R.id.etSQLName);
		sqlGetInfo=(Button) findViewById(R.id.bgetInfo);
		sqlDetail=(EditText) findViewById(R.id.etSQLDetail);
		sqlDate=(EditText) findViewById(R.id.etSQLDate);
		sqlLocation=(EditText) findViewById(R.id.etSQLLocation);
		sqlYear1=(EditText)findViewById(R.id.etSQLYear1);
		sqlYear=(EditText) findViewById(R.id.etSQLYear);
		sqlView.setOnClickListener(this);
		sqlUpdate.setOnClickListener(this);
	
		
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		
		case R.id.bSQLUpdate:
			boolean did=true;
			try{
				String name=sqlName.getText().toString();
				String detail=sqlDetail.getText().toString();
				String date=sqlDate.getText().toString();
				String location=sqlLocation.getText().toString();
				String year=sqlYear.getText().toString();
				String year1=sqlYear1.getText().toString();
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
				
				Data entry=new Data(SQLexample.this);
			entry.open();
			entry.createEntry(name,detail,date,location,year,year1);
			entry.close();
			}catch(Exception e){
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
				tv.setText("Data Entered Successfully");
				d.setContentView(tv);
				d.show();}
			else{
				Dialog d=new Dialog(this);
				d.setTitle("alert");
				TextView tv=new TextView(this);
				tv.setText("Fill all the fields**");
				d.setContentView(tv);
				d.show();
				}
			}
		
			
			break;
		case R.id.bSQLopenView:
			Intent i=new Intent(SQLexample.this,SQLView.class);
			startActivity(i);
			
			break;
		
		}
	}

}
