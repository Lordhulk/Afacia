package com.example.afacia;

import java.io.File;
import android.app.Activity;
import android.os.Environment;
import android.util.Log;

		 public class Cortito_cr extends Activity  {
		 public boolean isExternalStorageWritable() {
		     String state = Environment.getExternalStorageState();
		     
		     if (Environment.MEDIA_MOUNTED.equals(state)) {
		    	 Log.e("Ficheros", "tarjeta SD montada");
		         return true;
		     }
		     return false;
		 }
		 public boolean isExternalStorageReadable() {
		     String state = Environment.getExternalStorageState();
		     if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
		    	 
		    	 Log.e("Ficheros", "Tarjeta SD solo lectura");
		         return true;
		     }
		     return false;
		 }
		 public File getAlbumStorageDir() {
	    // Get the directory for the user's public pictures directory
		Log.e("hol444a","hasta a aca");
	    File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath(), "guardar imagenes");
	    
	    Log.e("hol4445a",Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath());
	    if (!file.mkdir()) {
	        Log.e("LOG_TAG", "Directory not created");

	    }
	    return file;
	}

}
