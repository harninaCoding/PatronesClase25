package problema00;

public class Poller implements Runnable {
	private Generator generator;
	private int shabbyNumber = 0;
	private long counter=0;
	private int changes=0;

	public Poller(Generator generator) {
		super();
		this.generator = generator;
	}

	@Override
	public void run() {
		do {
			if (shabbyNumber != this.generator.getAwesomeValue()) {
				System.out.println("new number change:"+changes++);
			
				shabbyNumber=this.generator.getAwesomeValue();
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			else {
				counter++;
				if(counter%10000==0)
					System.out.println("esperando new number tried:"+counter);
			}
		} while (true);
	}

}
