package com.example.afacia;

import java.util.List;

import android.util.Log;

class categoria {
	
	String nombre;
	String hijode;
	boolean Final;
	int hola;
	
	void setNombre(String string){
		nombre=string;
	}	
	void sethijode(String string){
		hijode = string;
	}
	void setFinal(boolean Boolean){
		Final = Boolean;
		
	}
	String getnombre(){
		return nombre;
	}
	String gethijode(){
		return hijode;
		
	}
	boolean getFinal(){
		
		return Final;
		
		
	}
	void definir(List<categoria> cat_entrada,List<categoria> cat_salida,String etiqueta){
		cat_salida.clear();
		for(int i=0;i<cat_entrada.size();i++){
				/*if((etiqueta.equals(cat_entrada.get(i).getnombre()))&&!(cat_entrada.get(i).getFinal())){
					cat_salida=cat_entrada;
					break;
				}*/
				if(etiqueta.equals(cat_entrada.get(i).gethijode())){ // el == compara punteros x eso hay q usar uno.equals(otro)
				cat_salida.add(cat_entrada.get(i));
			}
		}
	}
	
	void mostrar(List<categoria> cat_entrada,List<categoria> cat_salida,int contador){
	cat_salida.clear();
	
		for(int i=0;i<6;i++){
			
					if(i+6*contador<cat_entrada.size()){
					cat_salida.add(cat_entrada.get(i+6*contador));
					}
		}
		
	}
	
}
