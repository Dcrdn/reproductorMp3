
public class queueArray {
	
	private int tail,
				head,
				size;

	private String[] q;
	
	//método constructor con tamaño definido
	public queueArray(int tamaño){
		this.q=new String[tamaño];
		this.tail=this.head=-1;
	}
	//esta función regresa mi último elemento ingresado en dado caso de que exista
	//si no, regresa "-1"
	public String rear(){
		if(this.isEmpty()){
			return "-1";
		}
		else{
			return this.q[this.tail];
		}
	}
	//regreso mi primer elemento ingresado en dado caso de que exista
	//si no, regresa "-1"
	public String front(){
		if(this.isEmpty()){
			return "-1";
		}
		else{
			return this.q[this.head];
		}
	}
	/*	
	* 	en dado caso de que mi tail y head tengan el valor -1, es porque no tengo datos,
	*	esto debido a que en mi función dequeue estoy diciéndoles que adquieran ese valor
	*	cuando se haya borrado el último elemento del queue
	*/	
	public boolean isEmpty(){
		if(this.tail==-1 && this.head==-1){
			return true;
		}
		else{
			return false;
		}
	}
	/*	
	 * Mi enqueue se encarga de ingresar datos en la última posición disponible
	 * el momento en que mi tail sea igual a mi head, es porque se está tratando de poner algo en un lugar
	 * que ya está ocupado, es un overflow
	 * Si mi queue está vacío, pongo mis valores en 0 (porque están en -1 al estar vacío) e inserto mi dato
	 * Y en cualquier otro caso, solo inserto mi dato en la última posición disponible
	 * El "%this.q.length" lo utilizo para sacar el mod del tamaño de mi posición contra el tamaño de mi queue
	 * Para poder generar un array circular y siempre estar ocupando los lugares que ya fueron desocupados
	 */
	public void enqueue(String data){
		if((this.tail+1)%this.q.length==this.head){
			System.out.println("overflow");
		}
		else if(this.isEmpty()){
			this.head++;
			this.tail++;
			this.size++;
			this.q[head]=data;
		}
		else{
			tail=(tail+1)%this.q.length;
			this.size++;
			this.q[tail]=data;
		}
	}	
	/*
	 * Si mi queue está vacío, estoy tratando de hacer un underflow, y lo imprimo
	 * Si mi tail es igual a mi head, significa que ya vacié mi lista, y seteo mis valores a -1
	 * Y finalmente, solo queda la opción de que tenga elementos a eliminar, por tanto es lo que hago,
	 * Se elimina el último elemento y la head adquiere el siguiente valor
	 */
	public void dequeue(){
		if(this.isEmpty()){
			System.out.println("underflow");
		}
		else if(this.tail==this.head){
			this.q[this.head]="";
			this.head=-1;
			this.tail=-1;
			this.size--;
		}
		else{
			this.q[this.head]="";
			this.head=(this.head+1)%this.q.length;
			this.size--;
		}
	}
	//Devuelve el tamaño de mi queue
	public int getSize(){
		return this.size;
	}
}
