//Christopher Eslinger
//Assignment 9
//11/14/22

public class HoneyDoList {
	private Task []tasks;
	private int numTasks;
	private int INITIAL_CAPACITY = 10;
	
	public HoneyDoList () {
		tasks = new Task[INITIAL_CAPACITY];
		numTasks = 0;
	}
	
	public Task getTask(int index) {
		return tasks[index];
	}
	
	public String toString() {
		String tasksString = "";
		for(Task task: tasks) {
			if (task != null) {
				tasksString += task.toString();
			}
		} return tasksString;
	}
	
	public int find(String name) {
		for(int i = 0; i < numTasks; i++) {
			if(name.equalsIgnoreCase(tasks[i].getName())) {
				return i;
			}
		} return -1;
	}
	
	public int totalTime() {
		int time = 0;
		for (Task task: tasks) {
			if (task!=null) {
				time += task.getEstMinsToComplete();
			}
		} return time;
	}
	
	public int shortestTime() { 
		int shortestTime = -1;
		int index = -1;
		for(int i = 0; i < tasks.length; i++) {
			if (tasks[i] != null) {
				if (i != 0 && tasks[i].getEstMinsToComplete() > shortestTime) {
					shortestTime = tasks[i].getEstMinsToComplete();
					index = i;
				} else index = i; shortestTime = tasks[i].getEstMinsToComplete();

			}
		} return index;
			
	}
	
	public void completeTask(int index) {
		for (int i =index; i < numTasks-1; i++) {
			tasks[i] = tasks[i+1];
		}
		numTasks--;
		tasks[numTasks] = null;
	}
	
	public void addTask(Task t) {
		for (int i = 0; i<tasks.length; i++) {
			if(tasks[i] == null) {
				tasks[i] = t;
				numTasks++;
				return;
			}
		} 
		Task []tasks2 = new Task[numTasks+1];
		for (int i = 0; i < tasks2.length; i++) {
			if(i != tasks2.length - 1) {
				tasks2[i] = tasks[i];
			} else tasks2[i] = t;
		}
		
		tasks = tasks2;
		numTasks++;
	}
}
