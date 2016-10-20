package com.example.afacia;

import java.util.List;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.widget.ImageButton;

public class verificar_final {
categoria botones_cambiar = new categoria();
int i;
String valor;

final CargarImagenClass imagenboton = new CargarImagenClass();

void verificar_finales(List<categoria> Conjunto_Maximo,List<ImageButton> btn,List<categoria> Conjunto_Aux,List<categoria> Conjunto_Mostrar,int contador,Context MainContext, int botonescontar){
	
	if(!(Conjunto_Mostrar.get(botonescontar).getFinal())){
		String str = Boolean.toString(Conjunto_Mostrar.get(botonescontar).getFinal());  
		botones_cambiar.definir(Conjunto_Maximo,Conjunto_Aux,Conjunto_Mostrar.get(botonescontar).getnombre());
    	 contador=0;
    	 botones_cambiar.mostrar(Conjunto_Aux,Conjunto_Mostrar,contador);
    	 String holasss= Integer.toString(Conjunto_Mostrar.size());
    	 String holasss1= Integer.toString(Conjunto_Maximo.size());
    	 String holasss2= Integer.toString(Conjunto_Aux.size());
    
 		 Log.e("ADENTRO",holasss);
 		Log.e("ADENTRO",holasss1);
 		Log.e("ADENTRO",holasss2);

 		Log.e("ver/fal",str);
    	 for(i=0;i<6;i++){
    	 if(Conjunto_Mostrar.size()>i){
    	 imagenboton.cambiarImagen(Conjunto_Mostrar.get(i).getnombre(), btn.get(i), MainContext);
    	 btn.get(i).setEnabled(true);
    	 }else{
    
        btn.get(i).setImageResource(R.drawable.ic_launcher);
        btn.get(i).setEnabled(false);
    	 }
    	 }
	
}
	else
{	botones_cambiar.definir(Conjunto_Maximo,Conjunto_Aux,"Super");
contador=0;
botones_cambiar.mostrar(Conjunto_Aux,Conjunto_Mostrar,contador);

for(i=0;i<6;i++){
	 if(Conjunto_Mostrar.size()>i){
	 imagenboton.cambiarImagen(Conjunto_Mostrar.get(i).getnombre(), btn.get(i), MainContext);
	 btn.get(i).setEnabled(true);
	 }else{

   btn.get(i).setImageResource(R.drawable.ic_launcher);
   btn.get(i).setEnabled(false);
	 }
	 }}

	btn.get(6).setEnabled(true);
	btn.get(7).setEnabled(true);
}}