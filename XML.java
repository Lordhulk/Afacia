package com.example.afacia;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

public class XML {
	List<categoria> noticias = new ArrayList<categoria>();
	String escrivir;
	private String texto;
	

	public void prueba(Context MainContext){
		Toast toast1 = Toast.makeText(MainContext, texto, Toast.LENGTH_SHORT);
		toast1.show();
	}


String ruta;
public List<categoria> parse()
{
	ruta = "file://"+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)+"/basico.xml";
    //Instanciamos la fábrica para DOM
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
   try {
        //Creamos un nuevo parser DOM
        DocumentBuilder builder;
		
			builder = factory.newDocumentBuilder();


        //Realizamos lalectura completa del XML
			Document dom = builder.parse(this.getInputStream());
			
        //Nos posicionamos en el nodo principal del árbol (<rss>)
        Element root = dom.getDocumentElement();

        //Localizamos todos los elementos <item>
        NodeList nodo_categorias = root.getElementsByTagName("categoria");
   
        for (int i=0; i<nodo_categorias.getLength(); i++)
        {
            categoria categoria_aux = new categoria();

            //Obtenemos la noticia actual
            Node nodo_categoria_actual = nodo_categorias.item(i);

            //Obtenemos la lista de datos de la noticia actual
            NodeList nodo_hijos = nodo_categoria_actual.getChildNodes();

            //Procesamos cada dato de la noticia
            for (int j=0; j<nodo_hijos.getLength(); j++)
            {
                Node nodo_hijos_actual = nodo_hijos.item(j);
                String etiqueta = nodo_hijos_actual.getNodeName();

                if (etiqueta.equals("nombre"))
                {
                	String texto = nodo_hijos_actual.getFirstChild().getNodeValue();
                    categoria_aux.setNombre(texto);
                }
                else if (etiqueta.equals("hijode"))
                {
                	categoria_aux.sethijode(nodo_hijos_actual.getFirstChild().getNodeValue());
                	
                }
                else if (etiqueta.equals("final"))
                {
                	categoria_aux.setFinal(Boolean.valueOf(nodo_hijos_actual.getFirstChild().getNodeValue()));
                  
                }
                
            }

            noticias.add(categoria_aux);
        
        
   
        }}
		 catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (DOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
return noticias; 

}
private String getInputStream() {
	return ruta;
}



}
