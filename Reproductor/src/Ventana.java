import javax.swing.JFrame;

public class Ventana extends JFrame{

	public Ventana() throws Exception{
		
		super("Queues");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Inicio pi=new Inicio();
		this.add(pi);
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
		
	public static void main(String[] args) throws Exception{
		Ventana window = new Ventana();	
	}

}
