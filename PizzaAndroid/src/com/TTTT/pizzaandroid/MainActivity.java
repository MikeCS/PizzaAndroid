package com.TTTT.pizzaandroid;

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
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.log_layout);
		okButton = (Button) findViewById(R.id.loginButton);
	    okButton.setOnClickListener(this);
	    logView =(EditText) findViewById(R.id.logView);
	    PassView =(EditText) findViewById(R.id.PassView);
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
	    	if ((logView.getText().toString().equals("admin")) && (PassView.getText().toString().equals("1234")))
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
