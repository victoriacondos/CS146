/*
 * Victoria Condos
 * TODO-- Fix program: currently does not run processes
 */
public class ProcessScheduler 
{                                   
	//attributes
	private LinkedListQueue<Process> processes;
	private Process currentProcess;
	public ProcessScheduler()
	{
		this.processes=new LinkedListQueue<Process>();
		this.currentProcess=null;
	}
	//methods
	public Process getCurrentProcess()
	{
		return this.currentProcess;
	}
	public void addProcess(Process aProcess)
	{
		if(currentProcess==null)
			this.currentProcess=aProcess;
		else
			processes.enqueue(aProcess);
	}
	public void runNextProcess()
	{
		currentProcess=processes.dequeue();
		//System.out.println("CURRENT PROCESS "+ currentProcess);
	}
	public void cancelCurrentProcess()
	{	
		processes.dequeue();//remove process after current process has been set.
	}
	public void printProcessQueue()
	{
		processes.print();
	}
}
