package _04_Thread_Pool;

import java.util.ArrayDeque;
import java.util.concurrent.ConcurrentLinkedDeque;

public class ThreadPool {

	
	int totalThreads;
	Thread[] threads;
	ConcurrentLinkedDeque<Task> taskQueue;
	
	
	ThreadPool(int totalThread){
		totalThreads = totalThread;
		taskQueue = new ConcurrentLinkedDeque<Task>();
		
		threads = new Thread[totalThreads];
		
		for(int i = 0; i < totalThreads; i++) {
			
			Thread t1 = new Thread(()-> new Worker());
			threads[i] = t1;
			
		}
		
	}
	
	public void addTask(Task task) {
		taskQueue.add(task);
	}
	public void start() {
		
		for(int i = 0; i < totalThreads; i++) {
			threads[i].start();
		
		}
		
		for(int i = 0; i < totalThreads; i++) {
			
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
