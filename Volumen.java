package com.example.afacia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Volumen extends Activity {
boolean activate;
	 Intent intent = new Intent();
	 Bundle parametros = new Bundle();
	//boolean volumen;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 setContentView(R.layout.ayuda);
		 
Button button = (Button) findViewById(R.id.sonido2);
		Log.e("hola","se ejecuto");	

		Bundle parametros2 = this.getIntent().getExtras();
       activate = parametros2.getBoolean("activate");
		
	    
	    String str = Boolean.toString(activate);
		Log.e("boolean",str);
		
		
	 button.setOnClickListener(new View.OnClickListener() {
	         public void onClick(View v) { 
	        	 
	        	 Log.e("hola","se ejecugrt123451234hshto");	
	          	 
	         }  
	         });
	 ToggleButton toggle = (ToggleButton) findViewById(R.id.sonido);
		toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
		    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		        if (isChecked) {
		        	activate = true;
		        	parametros.putBoolean("activate", activate);
					intent.putExtras(parametros);
					 String str = Boolean.toString(activate);
						Log.e("boolean",str);
		        } else {
		        	activate = false;
		        	parametros.putBoolean("activate", activate);
					intent.putExtras(parametros);
					 String str = Boolean.toString(activate);
						Log.e("boolean",str);
		        }
		    }
		});
	
	
		
		
	
	} 
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		CreateMenu(menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item){

		return MenuChoice(item);
	}
	
	private void CreateMenu(Menu menu){
		MenuItem menuAjustes = menu.add(0, 0, 0, "Ayuda");
		MenuItem menuAcercade = menu.add(0, 1, 1, "Volumen");
		MenuItem menuvovler = menu.add(0, 2, 2, "Volver");
	}
	
	private boolean MenuChoice(MenuItem item){
		switch (item.getItemId()) {
			case 0:
					Toast.makeText(this, "-Ajustes- fue seleccionado",Toast.LENGTH_LONG).show();
				  
					
					setContentView(R.layout.volumen);
					
					 return true;
			case 1:
					Toast.makeText(this, "-Acerca de fue- seleccionado",Toast.LENGTH_LONG).show();

					intent.setClass(Volumen.this, Volumen.class);
					
					
					parametros.putBoolean("activate", activate);
					intent.putExtras(parametros);
					startActivity(intent);
					setContentView(R.layout.ayuda);
					return true;
			case 2:
			       intent.setClass(Volumen.this, MainActivity.class);
			       startActivity(intent);
		         finish();
		         
				
				return true;
		}
		return false;
	}
   
	public void onInit(int arg0) {
		// TODO Auto-generated method stub
		
	}


	






}



