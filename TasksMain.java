import java.time.LocalDateTime;
public class TasksMain {

	public static void main(String[] args) {
		Task doMyHW = new Task("finish 1068 homework", 3, 120);
		Task postHW = new Task("post 1068 homework", 1, LocalDateTime.of(2019, 3, 23, 13, 0), 180);
		
		
		System.out.println(doMyHW.getName());
		System.out.println(doMyHW.getPriority());
		System.out.println(doMyHW.getEstMinsToComplete());
		
		doMyHW.setName("Yo");
		doMyHW.setEstMinsToComplete(22);
		doMyHW.increasePriority(4);
		
		System.out.println("");
		System.out.println(doMyHW.getName());
		System.out.println(doMyHW.getPriority());
		System.out.println(doMyHW.getEstMinsToComplete());
	}

}
