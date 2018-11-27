package _04_Thread_Pool;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Worker implements Runnable {

	
	ConcurrentLinkedDeque<Task> taskQueue;
	public Worker() {
		
	}
	public Worker(ConcurrentLinkedDeque<Task> taskQueuee) {
		taskQueue = taskQueuee;
		
	}
	public void run() {
		// TODO Auto-generated method stub
		while(taskQueue.size()>0) {
			Task t = taskQueue.remove();
			t.perform();
		}
	}


}
