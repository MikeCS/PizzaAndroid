package com.TTTT.pizzaandroid;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class DelivActivity extends Activity implements OnClickListener {

	Button btnExitD;
	Button btnDone;
	int sel;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.deliv_layout);
		btnExitD = (Button) findViewById(R.id.btnExitD);
		btnExitD.setOnClickListener(this);
		btnDone = (Button) findViewById(R.id.btnDone);
		btnDone.setOnClickListener(this);
		
		String data[] = new String[MainActivity.ordersStat.size()];
		
		for (int i = 0; i<MainActivity.ordersStat.size(); i++)
		{
			data[i] = MainActivity.ordersStat.get(i).Time + " " + MainActivity.ordersStat.get(i).Address;
		}
		
		
		//>>>>>>>>>>>>><<<<<<<<<<<<<
		
		CustomAdapter adapter = new CustomAdapter(this, android.R.layout.simple_spinner_item, data);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		Spinner spinner = (Spinner) findViewById(R.id.spinner_id);
		spinner.setAdapter(adapter);
		spinner.setPrompt("Выбериите выполненный заказ");
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
	        @Override
	        public void onNothingSelected(AdapterView<?> parent) {
	        	 
	        }
	        @Override
	        public void onItemSelected(AdapterView<?> parent, View view,
	                int pos, long id) {
				// Set adapter flag that something has been chosen	
	            CustomAdapter.flag = true;  
	         sel = pos; 
	         MainActivity.selected++;
	       }
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	  public void onClick(View v) {
	    switch (v.getId()) {
	    case R.id.btnExitD:

		    	Intent intent = new Intent(this, MainMenuActivity.class);
		        startActivity(intent);

	      // TODO Call second activity
	      break;
	    case R.id.btnDone:

	        if (MainActivity.selected == -1)
	        	Toast.makeText(this, "Выберите заказ", Toast.LENGTH_LONG).show();
	        else
	        {
	        	MainActivity.ordersStat.remove(sel);
	        	Intent intent2 = new Intent(this, DoneActivity.class);
	        	startActivity(intent2);
	        }
	        
	      // TODO Call second activity
	      break;
	    default:
	      break;
	    }
	}	
	
}

