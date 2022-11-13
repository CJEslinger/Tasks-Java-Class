import java.time.LocalDateTime;
public class Task {
	
	private String name;
	private int priority;
	private int estMinsToComplete;
	private LocalDateTime whenDue;
	
	public Task (String n, int p, int etc){
		name = n;
		priority = p;
		estMinsToComplete = etc;
	}
	
	public Task (String n, int p, LocalDateTime due, int etc){
		name = n;
		priority = p;
		estMinsToComplete = etc;
		whenDue = due;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public int getEstMinsToComplete() {
		return estMinsToComplete;
	}
	
	public void setName(String newName) {
		name = newName;
	}
	
	public void setEstMinsToComplete(int t) {
		estMinsToComplete = t;
	}
	
	public void increasePriority(int amount) {
		if (amount <= 0) {
			return;
		} else priority += amount;
	}
	
	public void decreasePriority(int amount) {
		if (amount > priority) {
			priority = 0;
		} else priority -= amount;
	}
	
	public String toString() {
		return ("TaskName: "+name+"\nTask Priority: "+priority+"\nEstimated Time: "+estMinsToComplete+"\n\n");
	}
}
