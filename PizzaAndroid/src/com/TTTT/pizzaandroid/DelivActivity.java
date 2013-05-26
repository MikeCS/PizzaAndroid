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
	int selected = -2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.deliv_layout);
		btnExitD = (Button) findViewById(R.id.btnExitD);
		btnExitD.setOnClickListener(this);
		btnDone = (Button) findViewById(R.id.btnDone);
		btnDone.setOnClickListener(this);
		
		final ArrayList<Order> orders = new ArrayList<Order>();
		
		Order order1 = new Order();
		order1.Time = "18:12";
		order1.Type = "Avalon";
		order1.Count = "1";
		order1.Address = "Ленина 25, кв. 48";
		order1.Status = true;
		
		Order order2 = new Order();
		order2.Time = "17:52";
		order2.Type = "Orlean";
		order2.Count = "1";
		order2.Address = "25 января 67, кв 98";
		order2.Status = true;
		
		
		orders.add(order1);
		orders.add(order2);
		
		String[] data = {order1.Time + " " + order1.Address, order2.Time + " " + order2.Address};
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
	          
	         selected++;
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

	        if (selected == -1)
	        	Toast.makeText(this, "Выберите заказ", Toast.LENGTH_LONG).show();
	        else
	        {
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

