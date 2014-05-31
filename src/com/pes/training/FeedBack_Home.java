package com.pes.training;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FeedBack_Home extends Activity {
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.feedback);
		
		
		
		TextView text = (TextView) findViewById(R.id.fbform);
		final String feedback = text.getText().toString();
		
		Button btn = (Button) findViewById(R.id.feedback);
		btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				/*setContentView(R.layout.test);
				TextView tv = (TextView) findViewById(R.id.testText);
				tv.setText(feedback);*/
				
				Intent next = new Intent(FeedBack_Home.this,FeedBack_send.class);
		    	next.putExtra("feedback",feedback);
		    	startActivity(next);
				
			}
		});
		
		
		
	}

}

