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
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

public class HaveActivity extends Activity implements OnClickListener {

Button btnExitH;
TextView TimeText1;
TextView TypeText1;
TextView CountText1;
TextView AddressText1;
CheckBox Status1;
boolean first = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.have_layout);
		btnExitH = (Button) findViewById(R.id.btnExitH);
		btnExitH.setOnClickListener(this);
		TimeText1 = (TextView) findViewById(R.id.TimeText3);
		TypeText1 = (TextView) findViewById(R.id.TypeText3);
		CountText1 = (TextView) findViewById(R.id.countText3);
		AddressText1 = (TextView) findViewById(R.id.AddressText3);
		Status1 = (CheckBox) findViewById(R.id.checkBox3);
		//>>>>>>>>>>>>><<<<<<<<<<<<<
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
		
		Spinner spinner = (Spinner) findViewById(R.id.spinner3);
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
	            	TimeText1.setText(orders.get(pos).Time);
		            TypeText1.setText(orders.get(pos).Type);
		            CountText1.setText(orders.get(pos).Count);
		            AddressText1.setText(orders.get(pos).Address);
		            Status1.setChecked(orders.get(pos).Status);
		            Status1.setVisibility(1);
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
	    case R.id.btnExitH:
	    	Intent intent = new Intent(this, MainMenuActivity.class);
	        startActivity(intent);
	      // TODO Call second activity
	      break;
	    default:
	      break;
	    }
	}	
	
}
