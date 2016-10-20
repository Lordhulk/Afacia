package com.example.afacia;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.Toast;



public class MainActivity<Adios> extends Activity implements TextToSpeech.OnInitListener{

	int contador;
	int botonescontar;
	boolean activate;
	 Intent intent = new Intent();
	 Bundle parametros = new Bundle();
	 
	private TextToSpeech textToSpeech;
	List<categoria> Conjunto_Maximo = new ArrayList<categoria>();
	List<categoria> Conjunto_Aux = new ArrayList<categoria>();
	List<categoria> Conjunto_Mostrar = new ArrayList<categoria>();
	List<ImageButton> btn = new ArrayList<ImageButton>();
	categoria botones_cambiar = new categoria();
	verificar_final botones = new verificar_final();
	final CargarImagenClass imagenboton = new CargarImagenClass();
	Volumen Volumen = new Volumen();
	Context MainContext;
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_main);
		
		
		
		contador=0;
		
		
	
		
		MainContext=getApplicationContext();
		 
		 btn.add((ImageButton) findViewById( R.id.boton_1));//0
		 btn.add((ImageButton) findViewById( R.id.boton_2));//1
		 btn.add((ImageButton) findViewById( R.id.boton_3));//2
		 btn.add((ImageButton) findViewById( R.id.boton_4));//3
		 btn.add((ImageButton) findViewById( R.id.boton_5));//4
		 btn.add((ImageButton) findViewById( R.id.boton_6));//5
		 btn.add((ImageButton) findViewById( R.id.boton_atras));//6
		 btn.add((ImageButton) findViewById( R.id.boton_adelante));//7
		
		 
		textToSpeech = new TextToSpeech( this, this );
		 
		 textToSpeech.setLanguage( new Locale( "spa", "ESP" ) );
		 
		Cortito_cr crear = new Cortito_cr();
		
		crear.isExternalStorageWritable();	
		
		crear.isExternalStorageReadable();
		
		crear.getAlbumStorageDir();	
		

		
		final XML documento_base = new XML();
			
  		Conjunto_Maximo = documento_base.parse();
  		
  		botones_cambiar.definir(Conjunto_Maximo,Conjunto_Aux,"Super");
  		botones_cambiar.mostrar(Conjunto_Aux,Conjunto_Mostrar,contador);
  		btn.get(6).setEnabled(false);
  		 for(int i=0;i<6;i++){
  	    	 if(Conjunto_Mostrar.size()>i){
  	    	 imagenboton.cambiarImagen(Conjunto_Mostrar.get(i).getnombre(), btn.get(i), MainContext);
  	    	btn.get(i).setEnabled(true);
  	    	
  	    	 }else{
  	    
  	        btn.get(i).setImageResource(R.drawable.ic_launcher);
  	        btn.get(i).setEnabled(false);
  	    	 }
  	    	 }

		 btn.get(0).setOnClickListener(new View.OnClickListener() {
	         public void onClick(View v) {
	        	 speak(Conjunto_Mostrar.get(0).getnombre(),activate);
	        	 botones.verificar_finales(Conjunto_Maximo, btn, Conjunto_Aux, Conjunto_Mostrar, contador,MainContext,0);

	        	 String str = Boolean.toString(activate);
					Log.e("boolean",str);
	  	         }

		 		}
	        	 );
	        	 
		 btn.get(1).setOnClickListener(new View.OnClickListener() {
	         public void onClick(View v) {
	   
	        	 speak(Conjunto_Mostrar.get(1).getnombre(),activate);
	        	 botones.verificar_finales(Conjunto_Maximo, btn, Conjunto_Aux, Conjunto_Mostrar, contador,MainContext,1);
	        	
	        	 
	         }  
	         });
		 btn.get(2).setOnClickListener(new View.OnClickListener() {
	         public void onClick(View v) {
	   
	        	 speak(Conjunto_Mostrar.get(2).getnombre(),activate);
	        	 botones.verificar_finales(Conjunto_Maximo, btn, Conjunto_Aux, Conjunto_Mostrar, contador,MainContext,2);
	        	 
	        	 
	         }  
	         });
		   btn.get(3).setOnClickListener(new View.OnClickListener() {
		         public void onClick(View v) {
		        	 
		        speak(Conjunto_Mostrar.get(3).getnombre(),activate); 
		        botones.verificar_finales(Conjunto_Maximo, btn, Conjunto_Aux, Conjunto_Mostrar, contador,MainContext,3);
		         		     }
		     });
		   btn.get(4).setOnClickListener(new View.OnClickListener() {
		         public void onClick(View v) {
		   
		        speak(Conjunto_Mostrar.get(4).getnombre(),activate); 
		        botones.verificar_finales(Conjunto_Maximo, btn, Conjunto_Aux, Conjunto_Mostrar, contador,MainContext,4);
		         	 
		        	 
		         } 
		         });
		   btn.get(5).setOnClickListener(new View.OnClickListener() {
		         public void onClick(View v) { 
		        	 
		        speak(Conjunto_Mostrar.get(5).getnombre(),activate);
		        botones.verificar_finales(Conjunto_Maximo, btn, Conjunto_Aux, Conjunto_Mostrar, contador,MainContext,5);
		          	 
		         }  
		         });
		  
		   btn.get(6).setOnClickListener(new View.OnClickListener() {
		         public void onClick(View v) {
		        	
		        	 if(contador*6>0){
		        		String holasss= Integer.toString(contador);
		        	 btn.get(7).setEnabled(true);
		        	Log.e("Ficheros",holasss);
		        	contador=contador-1;
		        	 botones_cambiar.mostrar(Conjunto_Aux,Conjunto_Mostrar,contador);
		        	
		        	 for(int i=0;i<6;i++){	
		            	 if(Conjunto_Mostrar.size()>i){
		            	 imagenboton.cambiarImagen(Conjunto_Mostrar.get(i).getnombre(), btn.get(i), MainContext);
		            	 btn.get(i).setEnabled(true);
		            	 }else{
		            		    
		            	        btn.get(i).setImageResource(R.drawable.ic_launcher);
		            	        btn.get(i).setEnabled(false);
		            	    	 }
		        	 }
		  	         }else{
		  	        	btn.get(6).setEnabled(false);
		  	         }}}
		        	 );
		   
		   btn.get(7).setOnClickListener(new View.OnClickListener() {
		         public void onClick(View v) {
		        	 
		        	if(6+contador*6<Conjunto_Aux.size()){
		        		btn.get(6).setEnabled(true);	
		        	contador++;
		        	botones_cambiar.mostrar(Conjunto_Aux,Conjunto_Mostrar,contador);
		        	 for(int i=0;i<6;i++){
		            	 if(Conjunto_Mostrar.size()>i){
		            	 imagenboton.cambiarImagen(Conjunto_Mostrar.get(i).getnombre(), btn.get(i), MainContext);
		            	 btn.get(i).setEnabled(true);
		            	 }else{
		            		    
		            	        btn.get(i).setImageResource(R.drawable.ic_launcher);
		            	        btn.get(i).setEnabled(false);
		            	    	 }
		        	 }
		        	 
		        	}else{
		        		btn.get(7).setEnabled(false);	
		        	}
		        	 
		  	         }}
		        	 );	  


		   
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

						intent.setClass(MainActivity.this, Volumen.class);
						
						
						parametros.putBoolean("activate", activate);
						intent.putExtras(parametros);
						startActivity(intent);
						setContentView(R.layout.ayuda);
						return true;
				case 2:

				       intent.setClass(null, MainActivity.class);
				       startActivity(intent);
			         finish();
			         
					
					return true;
			}
			return false;
		}


	public void onInit(int status) {

		
	
	
	if ( status == TextToSpeech.LANG_MISSING_DATA | status == TextToSpeech.LANG_NOT_SUPPORTED )
	{
		Toast.makeText( this, "ERROR LANG_MISSING_DATA | LANG_NOT_SUPPORTED", Toast.LENGTH_SHORT ).show();
	}
	
}

	private void speak( String str ,boolean activate){
		if(activate){textToSpeech.speak(str, TextToSpeech.QUEUE_FLUSH, null );
		textToSpeech.setSpeechRate( 0.0f );
		textToSpeech.setPitch( 0.0f );}
	}
	public void onCreateContextMenu(ContextMenu menu, View view,
			ContextMenuInfo menuInfo)
			{
			super.onCreateContextMenu(menu, view, menuInfo);
			CreateMenu(menu);
			}

}
	