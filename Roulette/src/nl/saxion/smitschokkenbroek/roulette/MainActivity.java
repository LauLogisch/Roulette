package nl.saxion.smitschokkenbroek.roulette;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	EditText txtGebruikersnaam, txtWachtwoord;	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //Variablen declareren
        txtGebruikersnaam = (EditText) findViewById(R.id.txtGebruikersnaam);
        txtWachtwoord = (EditText) findViewById(R.id.txtWachtwoord);
        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        Button btnAanmelden = (Button) findViewById(R.id.btnAanmelden);
        
        btnLogin.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				//TODO: als er op de button wordt geklikt moet je kunnen inloggen.
				//Intent i = new Intent(TipTopTweetActivity.this, UserProfileActivity.class);
				//startActivity(i);
				
				HttpGet httpGet = new HttpGet("http://10.0.2.2:8080/webservice/rest/account/laurasmit");
				ResponseHandler<String> handler = new BasicResponseHandler();			
				HttpClient client = new DefaultHttpClient();	
				try {
					String response = client.execute(httpGet, handler);	
					JSONObject jsonObj = new JSONObject(response); 		
					
					if (jsonObj.has("name")){
						String name = jsonObj.getString("name");	
					}
					
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		});
        
        btnAanmelden.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO: als er op de button wordt geklikt moet je kunnen aanmelden.
				
			}
		});
    }

}
