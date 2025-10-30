package problema00HilosObserverSolucion;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

class PollerTest {

	@Test
	void test() throws InterruptedException {
		ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
		Generator task = new Generator();
		Poller poller = new Poller();
		task.addObserver(poller);
		newCachedThreadPool.execute(task);
		newCachedThreadPool.execute(poller);
		newCachedThreadPool.awaitTermination(100, TimeUnit.SECONDS);
		newCachedThreadPool.shutdown();
	}

}
