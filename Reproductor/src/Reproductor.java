import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JFileChooser;


import javazoom.jl.player.Player;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;

public class Reproductor{
	
	private BasicPlayer intento;
	
	private String cancion,
					nombre;
	
	private ArrayList<String> arrayList;
	
	private queueArray queue;
	
	private String[] arraycanciones;
	
	//Aquí estoy haciendo un array agregando todas las canciones con las que cuenta mi librería
	//además, creo un nuevo queue con el tamaño de mi array List, y también un arrayString de canciones,
	//este arrayCanciones se mandará a otra clase para que ponga los nombres de las canciones en pantalla
	//y finalmente agrego mis elementos a mi queue después de haberlos revuelto
	public Reproductor() throws Exception{

		this.arrayList = new ArrayList<String>();
		this.arrayList.add("mb.mp3");
		this.arrayList.add("Crawling.mp3");
		this.arrayList.add("oml.mp3");
		this.arrayList.add("jag.mp3");
		this.arrayList.add("r.mp3");
		this.arrayList.add("FirstDate.mp3");
		this.arrayList.add("uita.mp3");
		this.arrayList.add("sweet.mp3");
		
		this.arraycanciones=new String[this.arrayList.size()];
		
		this.queue=new queueArray(this.arrayList.size());
		
		Collections.shuffle(this.arrayList);
		
		for(int i=0;i<this.arrayList.size();i++){
			this.queue.enqueue(this.arrayList.get(i));
			this.arraycanciones[i]=this.arrayList.get(i);
		}
	}
	//para reproducir una canción, obtengo el primer elemento del queue, lo asigno a
	//la variable que tendrá mi canción
	// y hago un dequeue para finalmente reproducir mi canción
	public void nuevaLista() throws Exception{
		this.nombre=this.queue.front();
		this.cancion=this.nombre;
		this.queue.dequeue();
		intento=new BasicPlayer();
		this.AbrirFichero(this.cancion);
		this.Play();	
	}
	//regresa 0 si la canción se está reproduciendo, 1 si está en pausa
	//y 2 si la canción finalizó, gracias a la librería que importé
	public int getStatus(){
		return intento.getStatus();
	}
	//setea el valor del volumen de 0 a 1
	public void setGain(double volume) throws BasicPlayerException{
		intento.setGain(volume);
	}
	//reproduce la canción
	public void Play() throws Exception {
	  intento.play();
	}
	//abre mi canción 
	public void AbrirFichero(String ruta) throws Exception {
	  intento.open(new File(ruta));
	}
	//pausa la canción
	public void Pausa() throws Exception {
	  intento.pause();
	}
	//si está pausada, continúa la canción
	public void Continuar() throws Exception {
	  intento.resume();
	}
	//detiene la reproducción del la canción
	public void Stop() throws Exception {
	  intento.stop();
	}
	//otra clase obtiene este array para poner los nombres de las canciones
	public String[] getLista(){
		return this.arraycanciones;
	}
	//regresa mi canción actual
	public String getCancion(){
		return this.nombre;
	}
	
	
}
