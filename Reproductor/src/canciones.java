import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class canciones extends JPanel implements ActionListener{

	private JFrame Ventana;
	
	private Image imagen;
	
	private JButton btnBack;
	
	private String[] arrayCanciones,
					nombresCanciones;
	
	public canciones(){
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
		
		this.btnBack = new JButton("Back");
		this.btnBack.setBounds(5, 5, 89, 35);
		this.add(this.btnBack);
		this.btnBack.addActionListener(this);
		this.btnBack.setForeground(Color.WHITE);
	    this.btnBack.setBorderPainted(true);
		this.btnBack.setContentAreaFilled(false);
		this.btnBack.setOpaque(false);
	}
	
	public void setNombres(){
		for(int i=0;i<this.arrayCanciones.length;i++){
			if(this.arrayCanciones[i]=="mb.mp3"){
				this.nombresCanciones[i]="Mr. Brightside";
			}
			else if(this.arrayCanciones[i]=="Crawling.mp3"){
				this.nombresCanciones[i]="Crawling";
			}
			else if(this.arrayCanciones[i]=="oml.mp3"){
				this.nombresCanciones[i]="One More Light";
			}
			else if(this.arrayCanciones[i]=="jag.mp3"){
				this.nombresCanciones[i]="Just another girl";
			}
			else if(this.arrayCanciones[i]=="r.mp3"){
				this.nombresCanciones[i]="Radioactive";
			}
			else if(this.arrayCanciones[i]=="FirstDate.mp3"){
				this.nombresCanciones[i]="First Date";
			}
			else if(this.arrayCanciones[i]=="uita.mp3"){
				this.nombresCanciones[i]="Up in the air";
			}
			else if(this.arrayCanciones[i]=="sweet.mp3"){
				this.nombresCanciones[i]="Sweet child o' mine";
			}
		}
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(this.imagen, 0, 0, this);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Agency FB", Font.BOLD, 30));
		g.drawString("Orden de reproducción:", 20, 100);
		g.drawString(this.nombresCanciones[0], 20, 150);
		g.drawString(this.nombresCanciones[1], 20, 200);
		g.drawString(this.nombresCanciones[2], 20, 250);
		g.drawString(this.nombresCanciones[3], 20, 300);
		g.drawString(this.nombresCanciones[4], 20, 350);
		g.drawString(this.nombresCanciones[5], 20, 400);
		g.drawString(this.nombresCanciones[6], 20, 450);
		g.drawString(this.nombresCanciones[7], 20, 500);
	}
	
	public void setArrayCanciones(String[] array){
		this.arrayCanciones=array;
		this.nombresCanciones=new String[this.arrayCanciones.length];
		this.setNombres();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btnBack){
			this.Ventana.dispose();
			this.setVisible(false);
		}
		
	}
}
