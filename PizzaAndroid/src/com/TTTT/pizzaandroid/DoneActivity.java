package com.TTTT.pizzaandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class DoneActivity extends Activity implements OnClickListener {

Button btnOKDone;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.done_layout);
		btnOKDone = (Button) findViewById(R.id.btnOKDone);
		btnOKDone.setOnClickListener(this);
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
	    case R.id.btnOKDone:
	    	Intent intent = new Intent(this, MainMenuActivity.class);
	        startActivity(intent);
	      // TODO Call second activity
	      break;
	    default:
	      break;
	    }
	}	
	
}
