import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class Inicio extends JPanel implements ActionListener{
	
	private JButton btnCancion1,
					btnCancion2,
					btnCancion3,	
					btnCancion4,
					btnAleatorio;
		
	private Panel pd;
	
	private Image imagen,
					album;
	
	public Inicio() throws Exception{
		this.setPreferredSize(new Dimension(400,600));	
		this.setFocusable(true); 
		setLayout(null);
		this.setBackground(Color.LIGHT_GRAY);
		
		this.imagen = new ImageIcon("banner.jpeg").getImage();
		this.album = new ImageIcon("album.jpg").getImage();
	
		this.btnAleatorio = new JButton("Aleatoriamente");
		this.btnAleatorio.setBounds(20, 450, 170, 50);
		this.btnAleatorio.addActionListener(this);
		this.add(this.btnAleatorio);
		this.btnAleatorio.setForeground(Color.WHITE);
	    this.btnAleatorio.setBorderPainted(true);
		this.btnAleatorio.setContentAreaFilled(false);
		this.btnAleatorio.setOpaque(false);
		this.btnAleatorio.setFont(new Font("Agency FB", Font.BOLD, 25));
	
	}


	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(this.imagen, 0, 0, this);
		g.drawImage(this.album, 30, 30, 335, 335, this);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Agency FB", Font.BOLD, 35));
		g.drawString("Reproducir Playlist:", 20, 420);
	}

	
	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==this.btnCancion1){
			try {

	
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==this.btnCancion2){
			try {
				
			} catch (Exception e1) {
				
		
			}
		}
		else if(e.getSource()==this.btnCancion3){
			try {
				
			} catch (Exception e1) {

				e1.printStackTrace();
			}
		}
		else if(e.getSource()==this.btnCancion4){
			try {
				

			} catch (Exception e1) {

				e1.printStackTrace();
			}
		}
		
		
		else if(e.getSource()==this.btnAleatorio){
			try {
				this.pd=new Panel();
			} catch (Exception e1) {

			}
		}
	}

}
