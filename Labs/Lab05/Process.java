/*
 * Victoria Condos
 */
public class Process
{
	private String name="none";
	private double completionTime=1.0;
	public Process()
	{
	}
	public Process(String aName, double aCompletionTime)
	{
		this.setName(aName);
		this.setCompletionTime(aCompletionTime);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getCompletionTime() {
		return completionTime;
	}
	public void setCompletionTime(double completionTime) {//must be positive
		if(completionTime>0)	
			this.completionTime = completionTime;
		if(completionTime<0)
			this.completionTime=0;
	}
	//other methods
	public String toString()
	{
		return "Process Name: "+ this.name + " Completion Time: "+this.completionTime;
	}
	
}
