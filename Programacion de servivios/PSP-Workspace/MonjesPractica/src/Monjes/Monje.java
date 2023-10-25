package Monjes;

public class Monje extends Thread {
     
    private Mesa mesa;
    private int num;
     
    public Monje(Mesa m, int num){
        this.mesa = m;
        this.num = num;
    }
     
    public void run() {
        while (true) {
            try {
            	
                this.orar();
                this.mesa.cogerTenedores(this.num-1); 
                this.comer();
                
                System.out.println("El monje " + num + " deja de comer." );
                System.out.println("Los tenedores que deja libres el monje " +num+ " son el " + (this.mesa.tenedorIzq(this.num-1) + 1) + " y el " + (this.mesa.tenedorDer(this.num-1) + 1));
                
                this.mesa.soltarTenedores(this.num-1);
            } catch (InterruptedException e) {
                System.err.println("Proceso interrumpido");
            }
        }
    }
     
     
    public void comer(){
    	System.out.println("El monje " + this.num + " coge los tenedores "+(this.mesa.tenedorIzq(this.num-1) + 1) + " y el " + (this.mesa.tenedorDer(this.num-1) + 1));
        System.out.println("El monje " + this.num + " está comiendo");
        try {
            sleep((long) (Math.random() * 2000));
        } catch (InterruptedException Excepcion) { 
        	System.err.println("Proceso interrumpido");
        }
    }
    
    public void orar(){
        
        System.out.println("El monje " + this.num + " está orando");
        try {
            sleep((long) (Math.random() * 2000));
        } catch (InterruptedException Excepcion) { 
        	System.err.println("Proceso interrumpido");
        }
         
    }
    
   
     
}