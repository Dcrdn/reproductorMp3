import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.FileReader;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class Panel extends JPanel implements ActionListener, Runnable{
	
	private JButton btnPlay,
					btnPrev,
					btnNext,
					btnBack,
					btnLista;
	
	private JSlider sliderVolumen;
	
	private String cancionActual;

	private Reproductor player;
	
	private boolean reproducir,
					seguirReproduciendo,
					correr,
					playing, //cancion reproduciendo
					paused;//cancion pausada
	
	private Thread hilo;
	
	private Image imagen,
					album;
	
	private JFrame Ventana;
	
	private canciones lista;
	
	public Panel() throws Exception{
			super();
			Ventana=new JFrame();
			setFocusable(true);
			this.Ventana= new JFrame("Queues");
			this.Ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setPreferredSize(new Dimension(400,600));
			this.Ventana.setLocation(475, 45);
			this.Ventana.add(this);
			this.Ventana.pack();
			this.Ventana.setVisible(true);
			this.setLayout(null);
			
			this.imagen = new ImageIcon("nirvana.jpeg").getImage();

			this.player=new Reproductor();
			this.player.nuevaLista();
			
			this.reproducir=false;
			this.playing=true;
			this.paused=false;		
			this.correr=true;
			this.seguirReproduciendo=true;
			
			this.btnPlay = new JButton("Play/Pause");
			this.btnPlay.setBounds(150, 423, 100, 70);
			this.add(this.btnPlay);
			this.btnPlay.addActionListener(this);
			this.btnPlay.setForeground(Color.WHITE);
		    this.btnPlay.setBorderPainted(true);
			this.btnPlay.setContentAreaFilled(false);
			this.btnPlay.setOpaque(false);
			
			this.btnNext = new JButton("Next");
			this.btnNext.setBounds(250, 433, 89, 60);
			this.add(this.btnNext);
			this.btnNext.addActionListener(this);
			this.btnNext.setForeground(Color.WHITE);
		    this.btnNext.setBorderPainted(true);
			this.btnNext.setContentAreaFilled(false);
			this.btnNext.setOpaque(false);
			
			this.btnBack = new JButton("Back");
			this.btnBack.setBounds(5, 5, 89, 35);
			this.add(this.btnBack);
			this.btnBack.addActionListener(this);
			this.btnBack.setForeground(Color.WHITE);
		    this.btnBack.setBorderPainted(true);
			this.btnBack.setContentAreaFilled(false);
			this.btnBack.setOpaque(false);

			this.sliderVolumen = new JSlider();
			this.sliderVolumen.setBounds(15, 500, 365, 46);
			this.add(this.sliderVolumen);
			this.sliderVolumen.setForeground(Color.WHITE);
			this.sliderVolumen.setOpaque(false);
		
			this.btnLista = new JButton(" *  *  *");
			this.btnLista.setBounds(285, 553, 89, 35);
			this.add(this.btnLista);
			this.btnLista.addActionListener(this);
			this.btnLista.setForeground(Color.WHITE);
		    this.btnLista.setBorderPainted(true);
			this.btnLista.setContentAreaFilled(false);
			this.btnLista.setOpaque(false);
				
			hilo=new Thread(this);
			hilo.start();
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(this.imagen, 0, 0, this);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Monospaced", Font.BOLD, 30));
		g.drawString(this.cancionActual, 85, 70);
		//g.drawImage(this.album, 50, 100, this);
		g.drawImage(this.album, 50, 100, 300, 300, this);
		
	}

	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btnPlay){
			//tengo valores booleanos para decidir cuando reproducir mis canciones
			//si quiero que se reproduzca, no está pausada, y quiero que siga reproduciendo
			//empieza a reproducir la canción
			if(this.reproducir && !this.paused && this.seguirReproduciendo){
				try {
					this.player.Play();
					this.playing=true;
					this.reproducir=false;
				} catch (Exception e1) {
				}
			}
			//si se encuentra reproduciendo, no está pasada, y quiero que mi panel siga corriendo
			//entonces pauso mi canción
			else if(this.playing && !this.paused && this.seguirReproduciendo){
				try {
					this.player.Pausa();
					this.playing=false;
					this.paused=true;
					this.reproducir=false;	
				} catch (Exception e1) {
				}
			}
			//si mi canción está pausada, no está tocando y quiero que mi panel siga corriendo
			//entonces continúo la canción
			else if(this.paused && !this.playing && this.seguirReproduciendo){
				try{
					this.player.Continuar();
					this.paused=false;
					this.playing=true;
				}
				catch(Exception ex){			
				}
			}
		}
		//si quiero ir atrás, cierro mis ventanas y le digo que no quiero seguir
		//ejecutando mi panel
		else if(e.getSource()==this.btnBack){
			try {
				this.player.Stop();
				this.Ventana.dispose();
				this.setVisible(false);
				this.seguirReproduciendo=false;
			} catch (Exception e1) {
			}
		}
		//mi boton next para la canción actual y carga una nueva
		//nuevaLista() se encarga del dequeue y reproducir la nueva canción
		else if(e.getSource()==this.btnNext){
			try {
				this.player.Stop();
				this.player.nuevaLista();
				this.reproducir=false;
				this.playing=true;
				this.paused=false;
			} catch (Exception e1) {
			}
		}
		//mi lista abre mi nueva ventana con la información
		//del orden de reproducción generado
		else if(e.getSource()==this.btnLista){
			this.lista=new canciones();
			this.lista.setArrayCanciones(this.player.getLista());
		}
	}
	
	
	public void setName(){
		if(this.player.getCancion()=="mb.mp3"){
			this.cancionActual="Mr. Brightside";
			this.album = new ImageIcon("thekillers.jpeg").getImage();
		}
		else if(this.player.getCancion()=="Crawling.mp3"){
			this.cancionActual="Crawling";
			this.album = new ImageIcon("crawling.jpeg").getImage();
		}
		else if(this.player.getCancion()=="oml.mp3"){
			this.cancionActual="One More Light";
			this.album = new ImageIcon("oml.jpeg").getImage();
		}
		else if(this.player.getCancion()=="jag.mp3"){
			this.cancionActual="Just another girl";
			this.album = new ImageIcon("thekillers.jpeg").getImage();
		}
		else if(this.player.getCancion()=="r.mp3"){
			this.cancionActual="Radioactive";
			this.album = new ImageIcon("r.jpeg").getImage();
		}
		else if(this.player.getCancion()=="FirstDate.mp3"){
			this.cancionActual="First Date";
			this.album = new ImageIcon("blink.jpeg").getImage();
		}
		else if(this.player.getCancion()=="uita.mp3"){
			this.cancionActual="Up in the air";
			this.album = new ImageIcon("uita.jpeg").getImage();
		}
		else if(this.player.getCancion()=="sweet.mp3"){
			this.cancionActual="Sweet child o' mine";
			this.album = new ImageIcon("sweet.jpeg").getImage();
		}
		
		
	}

	@Override
	public void run() {
		try{
			while(this.correr){
				if(this.player.getStatus()==2 && this.seguirReproduciendo){
					this.player.Stop();
					this.player.nuevaLista();
					this.reproducir=false;
					this.playing=true;
					this.paused=false;					
				}
				double temp=this.sliderVolumen.getValue();
				this.player.setGain(temp/100);
				this.setName();
				this.repaint();
				hilo.sleep(1000);
			}
		}
		catch(Exception error){
			
		}
		
	}
}
