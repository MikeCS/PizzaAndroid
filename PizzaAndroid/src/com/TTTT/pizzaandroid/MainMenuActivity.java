package com.TTTT.pizzaandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainMenuActivity extends Activity implements OnClickListener{

	Button btnExitMain;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_menu);
		btnExitMain = (Button) findViewById(R.id.btnExitMain);
	    btnExitMain.setOnClickListener(this);
	}
	
	@Override
	  public void onClick(View v) {
	    switch (v.getId()) {
	    case R.id.btnExitMain:
	    	Intent intent = new Intent(this, MainActivity.class);
	        startActivity(intent);
	      // TODO Call second activity
	      break;
	    default:
	      break;
	    }
	
	}
}
