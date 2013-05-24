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
	Button btnHave;
	Button btnDeliv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_menu);
		btnExitMain = (Button) findViewById(R.id.btnExitMain);
	    btnExitMain.setOnClickListener(this);
	    btnKitchen = (Button) findViewById(R.id.btnKitchen);
	    btnKitchen.setOnClickListener(this);
	    btnHave = (Button) findViewById(R.id.btnHave);
	    btnHave.setOnClickListener(this);
	    btnDeliv = (Button) findViewById(R.id.btnDeliv);
	    btnDeliv.setOnClickListener(this);
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
	    case R.id.btnHave:
	    	Intent intent2 = new Intent(this, HaveActivity.class);
	        startActivity(intent2);
	      // TODO Call second activity
	      break;
	    case R.id.btnDeliv:
	    	Intent intent3 = new Intent(this, DelivActivity.class);
	        startActivity(intent3);
	      // TODO Call second activity
	      break;
	    default:
	      break;
	    }
	
	}
}
