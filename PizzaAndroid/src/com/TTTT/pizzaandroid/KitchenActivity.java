package com.TTTT.pizzaandroid;

import com.TTTT.pizzaandroid.CustomAdapter;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

public class KitchenActivity extends Activity implements OnClickListener {

Button btnExitK;
TextView TimeText;
TextView TypeText;
TextView CountText;
TextView AddressText;
CheckBox Status;
boolean first = true;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.kitchen_layout);
		btnExitK = (Button) findViewById(R.id.btnExitK);
		btnExitK.setOnClickListener(this);
		TimeText = (TextView) findViewById(R.id.TimeText);
		TypeText = (TextView) findViewById(R.id.TypeText);
		CountText = (TextView) findViewById(R.id.countText1);
		AddressText = (TextView) findViewById(R.id.AddressText);
		Status = (CheckBox) findViewById(R.id.checkBox);
		//>>>>>>>>>>>>><<<<<<<<<<<<<
		final ArrayList<Order> orders = new ArrayList<Order>();
		
		Order order1 = new Order();
		order1.Time = "17:45";
		order1.Type = "Avalon";
		order1.Count = "1";
		order1.Address = "Набережная 24, кв 56";
		order1.Status = true;
		
		Order order2 = new Order();
		order2.Time = "18:01";
		order2.Type = "Fire";
		order2.Count = "2";
		order2.Address = "Переверткина 20, кв 37";
		order2.Status = true;
		
		Order order3 = new Order();
		order3.Time = "18:06";
		order3.Type = "Orlean";
		order3.Count = "1";
		order3.Address = "Хользунова 50, кв 57";
		order3.Status = false;
		
		orders.add(order1);
		orders.add(order2);
		orders.add(order3);
		
		String[] data = {order1.Time + " " + order1.Address, order2.Time + " " + order2.Address, order3.Time + " " + order3.Address};
		//>>>>>>>>>>>>><<<<<<<<<<<<<
		
		CustomAdapter adapter = new CustomAdapter(this, android.R.layout.simple_spinner_item, data);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		Spinner spinner = (Spinner) findViewById(R.id.spinner);
		spinner.setAdapter(adapter);
		spinner.setPrompt("Выбериите заказ, чтобы получить инфо");

        
        
        
        
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
	        @Override
	        public void onNothingSelected(AdapterView<?> parent) {
	        	 
	        }
	        @Override
	        public void onItemSelected(AdapterView<?> parent, View view,
	                int pos, long id) {
				// Set adapter flag that something has been chosen	
	            CustomAdapter.flag = true;  
	          
	           /* if (first)
	            {
	            	TimeText.setText("");
	                TypeText.setText("");
	                CountText.setText("");
	                AddressText.setText("");
	                Status.setChecked(false);
	                first = false;
	            }*/
	            //else
	            {
	            	TimeText.setText(orders.get(pos).Time);
		            TypeText.setText(orders.get(pos).Type);
		            CountText.setText(orders.get(pos).Count);
		            AddressText.setText(orders.get(pos).Address);
		            Status.setChecked(orders.get(pos).Status);
		            Status.setVisibility(1);
	            }
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
	    case R.id.btnExitK:
	    	Intent intent = new Intent(this, MainMenuActivity.class);
	        startActivity(intent);
	      // TODO Call second activity
	      break;
	    default:
	      break;
	    }
	}	
	
}
