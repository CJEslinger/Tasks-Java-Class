
public class HoneyDoList {
	private Task []tasks;
	private int numTasks;
	private int INITIAL_CAPACITY;
	
	public HoneyDoList (Task []t, int initial) {
		INITIAL_CAPACITY = initial;
		tasks = new Task[initial];
	}
	
	public String toString() {
		String tasksString = "";
		for(Task task: tasks) {
			tasksString += task.toString() + "\n";
		} return tasksString;
	}
	
	public int find(String name) {
		for(int i = 0; i < tasks.length; i++) {
			if(name.equals(tasks[i].getName())) {
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
	
	public void addTask(Task t) {
		for (Task task: tasks) {
			if(task == null) {
				task.setName(t.getName());
				task.setEstMinsToComplete(t.getEstMinsToComplete());
				task.increasePriority(t.getPriority());
				return;
			}
		} 
		tasks = new Task[INITIAL_CAPACITY +1 ];
	}
}
