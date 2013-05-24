package com.TTTT.pizzaandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainMenuActivity extends Activity implements OnClickListener{

	Button btnExitMain;
	Button btnKitchen;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_menu);
		btnExitMain = (Button) findViewById(R.id.btnExitMain);
	    btnExitMain.setOnClickListener(this);
	    btnKitchen = (Button) findViewById(R.id.btnKitchen);
	    btnKitchen.setOnClickListener(this);
	}
	
	@Override
	  public void onClick(View v) {
	    switch (v.getId()) {
	    case R.id.btnExitMain:
	    	Intent intent = new Intent(this, MainActivity.class);
	        startActivity(intent);
	      // TODO Call second activity
	      break;
	    case R.id.btnKitchen:
	    	Intent intent1 = new Intent(this, KitchenActivity.class);
	        startActivity(intent1);
	      // TODO Call second activity
	      break;
	    default:
	      break;
	    }
	
	}
}
