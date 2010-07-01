package mensagem;

public class Semaforo {
	private int cont;
	public Semaforo ( int cont ){
		this.cont = cont;
	}
	public synchronized void p(){
		try{
			while ( cont == 0 ) wait();
			cont--;
			
		}catch ( Exception e ){}
	}
	public synchronized void v(){
		cont ++;
		notify();
	}

}
