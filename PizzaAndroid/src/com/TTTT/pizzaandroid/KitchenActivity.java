package com.TTTT.pizzaandroid;

import com.TTTT.pizzaandroid.CustomAdapter;
import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.androidquery.util.XmlDom;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
import android.widget.Toast;

public class KitchenActivity extends Activity implements OnClickListener {

Button btnExitK;
TextView TimeText;
TextView TypeText;
TextView CountText;
TextView AddressText;
CheckBox Status;
boolean first = true;

AQuery aq = new AQuery(this);
String responseStr = "болт";
static String temp;
    
public void asyncJson(){
        
        //perform a Google search in just a few lines of code
        
        String url = "http://192.168.0.101:8080/com.pizza.jersey/rest/orders";
        
        aq.ajax(url, XmlDom.class, new AjaxCallback<XmlDom>() {

                @Override
                public void callback(String url, XmlDom xmldom, AjaxStatus status) {
                        temp = "!!!!";
                        if(xmldom != null){
                                
                                //successful ajax call, show status code and json content
                        		List<XmlDom> entries = xmldom.tags("order"); 
                        		for(XmlDom entry: entries){
                                    
                                    temp = entry.tag("phone").text();
                        		}
                        		
                        		KitchenActivity.temp = (String) xmldom.tag("phone").text();
                                Toast.makeText(aq.getContext(),  entries.get(1).tag("phone").text(), Toast.LENGTH_LONG).show();
                                temp = "6789";
                               // temp = xmldom.tag("phone").text();
                        		//aq.getContext();
                              //  responseStr = xmldom.tag("cost").text().toString();
                               // Log.d("sdf", "cost");
                                
                        
                        }else{
                                
                                //ajax error, show error code
                                Toast.makeText(aq.getContext(), "Error:" + status.getCode(), Toast.LENGTH_LONG).show();
                                responseStr = "я тут";
                        }
                }
                
        });
        
}
    
    /*String url = "http://192.168.0.101:8080/com.pizza.jersey/rest/auth";
    
    aq.ajax(url, String.class, new AjaxCallback<String>() {

            @Override
            public void callback(String url, String json, AjaxStatus status) {
                    
                    
                    if(json != null){
                            
                            //successful ajax call, show status code and json content
                            Toast.makeText(aq.getContext(), status.getCode() + ":" + json.toString(), Toast.LENGTH_LONG).show();
                    
                    }else{
                            
                            //ajax error, show error code
                            Toast.makeText(aq.getContext(), "Error:" + status.getCode(), Toast.LENGTH_LONG).show();
                    }
            }
    });*/
    

	
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
		asyncJson();
		final ArrayList<Order> orders = new ArrayList<Order>();
		
		
		
		
		
		
		
	/*	
		HttpClient httpClient = new DefaultHttpClient();  
		//String url = "http://localhost:8080/com.pizza.jersey/rest/auth";
		String url = "http://ya.ru/";
		HttpGet httpGet = new HttpGet(url);
		try {
		    HttpResponse response = httpClient.execute(httpGet);
		    StatusLine statusLine = response.getStatusLine();
		   // if (statusLine.getStatusCode() == HttpStatus.SC_OK) 
		    {
		        HttpEntity entity = response.getEntity();
		        ByteArrayOutputStream out = new ByteArrayOutputStream();
		        entity.writeTo(out);
		        out.close();
		        responseStr = out.toString();
		        // do something with response 
		    }
		    /*false {
		    	responseStr = "не проканало вот тута";
		        // handle bad response
		    }
		} catch (ClientProtocolException e) {
			responseStr = "не проканало 1";
		    // handle exception
		} catch (IOException e) {
			responseStr = "не проканало 2";
		    // handle exception
		}
		
		
		HttpGet uri = new HttpGet("http://ya.ru");    

		DefaultHttpClient client = new DefaultHttpClient();
		
		HttpResponse resp;
		try {
			resp = client.execute(uri);
			StatusLine status = resp.getStatusLine();
			responseStr = resp.getEntity().toString();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		
		
		
		

		
		
	
		
		
		
		
		
		
		responseStr = KitchenActivity.temp;
		
		Order order1 = new Order();
		order1.Time = "17:45";
		order1.Type = responseStr;
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
