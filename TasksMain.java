import java.time.LocalDateTime;
public class TasksMain {

	public static void main(String[] args) {
		Task doMyHW = new Task("finish 1068 homework", 3, 120);
		Task postHW = new Task("post 1068 homework", 1, 180);
		
		Task task1 = new Task("task 1", 3, 180);
		Task task2 = new Task("task 2", 5, 180);
		Task task3 = new Task("task 3", 9, 180);
		
		
		HoneyDoList tasks = new HoneyDoList();
		tasks.addTask(task1);
		tasks.addTask(task2);
		tasks.addTask(task3);
		tasks.addTask(doMyHW);
		

		tasks.completeTask(2);
		
		System.out.println(tasks.toString());
		
		/*
		System.out.println(doMyHW.getName());
		System.out.println(doMyHW.getPriority());
		System.out.println(doMyHW.getEstMinsToComplete());
		*/
		
		doMyHW.setName("Yo");
		doMyHW.setEstMinsToComplete(22);
		doMyHW.increasePriority(4);
		
		/*
		System.out.println("");
		System.out.println(doMyHW.getName());
		System.out.println(doMyHW.getPriority());
		System.out.println(doMyHW.getEstMinsToComplete());
		*/
	}

}
