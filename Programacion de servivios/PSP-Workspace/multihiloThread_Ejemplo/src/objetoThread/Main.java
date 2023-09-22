package objetoThread;

public class Main {

	public static void main(String[] args) {
		
		new Thread() {
			
			@Override
			public void run() {
				while(true) {
					System.out.println("+");
				}
			}
		}.start();

	}

}
