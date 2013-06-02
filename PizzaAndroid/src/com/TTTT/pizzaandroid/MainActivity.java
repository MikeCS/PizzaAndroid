package com.TTTT.pizzaandroid;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	Button okButton;
	EditText logView;
	EditText PassView;
	static int count = 0;
	//>>>>>>>>>>>>>>>>>>>>>
	final static ArrayList<Order> ordersStat = new ArrayList<Order>();
	static int selected = -2;
	//>>>>>>>>>>>>>>>>>>>>>
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.log_layout);
		okButton = (Button) findViewById(R.id.loginButton);
	    okButton.setOnClickListener(this);
	    logView =(EditText) findViewById(R.id.logView);
	    PassView =(EditText) findViewById(R.id.PassView);
	    
	    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>
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
		
		
		ordersStat.add(order1);
		ordersStat.add(order2);
	    //>>>>>>>>>>>>>>>>>>>>>>>>>>
	    
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
	    case R.id.loginButton:
	    	Intent intent = new Intent(this, MainMenuActivity.class);
	    	//>>>>>>>>>
	    //	okButton.setBackgroundResource();
	    	if ((logView.getText().toString().equals("")) && (PassView.getText().toString().equals("")))
	    	{	
	    		logView.setText("");
	    		PassView.setText("");
	    		startActivity(intent);
	    	}
	    	else
	    		Toast.makeText(this, "Неверное имя или пароль", Toast.LENGTH_LONG).show();
	    			
	    		
	    	//>>>>>>>>>
	    	
	        
	      // TODO Call second activity
	      break;
	    default:
	      break;
	    }
	}	
}
