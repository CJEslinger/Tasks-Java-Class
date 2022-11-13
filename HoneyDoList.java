
public class HoneyDoList {
	private Task []tasks;
	private int numTasks;
	private int INITIAL_CAPACITY;
	
	public HoneyDoList (int initial) {
		INITIAL_CAPACITY = initial;
		tasks = new Task[initial];
	}
	
	public Task[] getTasks() {
		return tasks;
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
		for(int i = 0; i < tasks.length; i++) {
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
	
	public Task completeTask(int index) {
		Task t = null;
		if (tasks[index] != null) {
			t = new Task(tasks[index].getName(), 
					tasks[index].getPriority(),
					tasks[index].getEstMinsToComplete());
			shiftList(index);
			tasks[index] = null;
		}
		return t;
	}
	
	private void shiftList(int index) {
		Task []storage;
		int storageCapacity = 0;
		int j = 0;
		for (int i = index;i<tasks.length; i++) {
			if (tasks[i] != null) {
				storageCapacity++;
			}
		}
		storage = new Task[storageCapacity];
		for (int i = index+1;i<tasks.length; i++) {
			if (tasks[i] != null) {
				storage[j] = tasks[i];
				j++;
			}
		}
		tasks[index] = null;
		for (int i = 0;i<storage.length; i++) {
			tasks[index] = storage[i];
			index++;
		}
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
