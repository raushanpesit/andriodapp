package com.pes.training;

import java.io.IOException;

import java.io.InputStream;
import java.io.InputStreamReader;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
			setContentView(R.layout.home);
			
			
			Button notice = (Button) findViewById(R.id.event);
			
			notice.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					
					Intent next = new Intent(MainActivity.this,Placement.class);
					startActivity(next);
				}
				});
Button admin = (Button) findViewById(R.id.button6);
			
			admin.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					
					Intent next = new Intent(MainActivity.this,Signin.class);
					startActivity(next);
				}
				});
			
			
			Button events = (Button) findViewById(R.id.events);
			
			events.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					
					Intent next = new Intent(MainActivity.this,training.class);
					startActivity(next);
				}
				});
			Button feedback = (Button) findViewById(R.id.feedback_button);
			
			feedback.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					
					Intent next = new Intent(MainActivity.this,FeedBack_Home.class);
					startActivity(next);
				}
			});}

			

	
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}


