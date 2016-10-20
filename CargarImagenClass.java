package com.example.afacia;

import java.io.File;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.Toast;


public class CargarImagenClass {
	
	
	
	public void cambiarImagen(String path_image,ImageButton btn,Context context){
		
		
		File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),"guardar imagenes/"+path_image+".jpg");

	    if (file.exists()){

	        Bitmap image = BitmapFactory.decodeFile(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)+"/guardar imagenes/"+path_image+".jpg");
	        btn.setScaleType(ScaleType.CENTER_INSIDE);
	        btn.setImageBitmap(image);
	        
	    }
	    
	    else{Log.e("hola","El archivo no existe");
	    	Toast toast1 = Toast.makeText(context,"Error: El archivo no existe", Toast.LENGTH_SHORT);
	    	toast1.show();
	    } 
	}

}



