package com.tutozone.checknetworkconnectivity;


import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	String msg;
	TextView msgTxtView;
	Button btnCheck;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//Initialization
		
		msgTxtView=(TextView)findViewById(R.id.txtMsg);
		btnCheck=(Button)findViewById(R.id.btnCheck);
		btnCheck.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				isConnected();
			}
		});
		
	}
	
	public void checkConnectivity(){
		ConnectivityManager cm = (ConnectivityManager) getApplicationContext()
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
		//test
		if (null != activeNetwork) {
			if(activeNetwork.getType() == ConnectivityManager.TYPE_WIFI)
				msg="You are connected to a WiFi Network";
			if(activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE)
				msg="You are connected to a Mobile Network";
		} 		
		else
			msg = "No internet Connectivity";
		
			msgTxtView.setText(msg);
	}

	
	public  boolean isConnected() {
		ConnectivityManager cm = (ConnectivityManager) getApplicationContext()
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		 // test
		 if (cm.getActiveNetworkInfo() != null
		   && cm.getActiveNetworkInfo().isAvailable()
		   && cm.getActiveNetworkInfo().isConnected()) {
			 
			msg="You are connected to a Network";
			msgTxtView.setText(msg);
			return true;
		 } else {
			 
			 msg = "No internet Connectivity";
			 msgTxtView.setText(msg);
			 return false;
		 }
		}
	
}
