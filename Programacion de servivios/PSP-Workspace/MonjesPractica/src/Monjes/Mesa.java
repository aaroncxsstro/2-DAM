package Monjes;

public class Mesa {
     
    private boolean[] tenedores;
     
    public Mesa(int numMonjes){
        this.tenedores = new boolean[numMonjes];
    }
    
    public int tenedorIzq(int i){
        return i;
    }
     
    public int tenedorDer(int i){
        return (i + 1) % this.tenedores.length;
    }
    
    public synchronized void cogerTenedores(int monje) throws InterruptedException{
        int tenedorIzq = tenedorIzq(monje);
        int tenedorDer = tenedorDer(monje);
        
        while(tenedores[tenedorIzq] || tenedores[tenedorDer]) { 
            wait();
        }
        
        tenedores[tenedorIzq] = true;
        tenedores[tenedorDer] = true;
    }
     
    public synchronized void soltarTenedores(int monje){
        int tenedorIzq = tenedorIzq(monje);
        int tenedorDer = tenedorDer(monje);
        
        tenedores[tenedorIzq] = false;
        tenedores[tenedorDer] = false;
        notifyAll();
    }
}
