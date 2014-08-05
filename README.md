CheckNetworkConnectivity
========================
A tutorial that shows how we check newtork connectivity in our android application.
I'had used two methods:
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
	
