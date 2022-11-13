
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
	
	public Task completeTask(int index) {
		Task t = null;
		if (tasks[index] != null) {
			t.setEstMinsToComplete(tasks[index].getEstMinsToComplete()); 
			t.setName(tasks[index].getName());
			t.increasePriority(tasks[index].getPriority());
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
		for (Task task: tasks) {
			if(task == null) {
				task.setName(t.getName());
				task.setEstMinsToComplete(t.getEstMinsToComplete());
				task.increasePriority(t.getPriority());
				return;
			}
		} 
		tasks = new Task[tasks.length+1];
		tasks[tasks.length-1] = t;
	}
}
