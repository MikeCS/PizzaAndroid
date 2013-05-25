package com.TTTT.pizzaandroid;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class KitchenActivity extends Activity implements OnClickListener {

Button btnExitK;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.kitchen_layout);
		btnExitK = (Button) findViewById(R.id.btnExitK);
		btnExitK.setOnClickListener(this);
		//>>>>>>>>>>>>><<<<<<<<<<<<<
		ArrayList<Order> orders = new ArrayList<Order>();
		
		Order order1 = new Order();
		order1.Time = "17:45";
		order1.Type = "Avalon";
		order1.Count = 1;
		order1.Address = "Набережная 24, кв 56";
		order1.Status = true;
		
		Order order2 = new Order();
		order2.Time = "18:01";
		order2.Type = "Fire";
		order2.Count = 2;
		order2.Address = "Переверткина 20, кв 37";
		order2.Status = true;
		
		Order order3 = new Order();
		order3.Time = "18:06";
		order3.Type = "Orlean";
		order3.Count = 1;
		order3.Address = "Хользунова 50, кв 57";
		order3.Status = false;
		
		String[] data = {order1.Time + " " + order1.Address, order2.Time + " " + order2.Address, order3.Time + " " + order3.Address};
		//>>>>>>>>>>>>><<<<<<<<<<<<<
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		Spinner spinner = (Spinner) findViewById(R.id.spinner);
		spinner.setAdapter(adapter);
		spinner.setPrompt("Выбериите выполненный заказ");
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
