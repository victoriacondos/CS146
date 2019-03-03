/*
 * Victoria Condos
 */
import java.util.Scanner;
public class RCSFrontEnd {
	public static boolean quit=false;
	public static void main(String[]args)
		{
			while(quit!=true){
				Scanner keyboard=new Scanner(System.in);
				output("Welcome to the Robot Simulator");
				output("Enter file for the Board");
				String boardName= keyboard.nextLine();
				int[][] board=RobotCommandSimulator.readBoard(boardName);//reads board file
				printBoard(board);
				output("Enter file for the Robot Commands");//reads robot commands
				keyboard=new Scanner(System.in);
				String rcName=keyboard.nextLine();
				GenQueue<String> queue= new GenQueue<String>();
				queue=RobotCommandSimulator.readCom(rcName);//store commands in queue
				output("Placing robot");
				initRobot(board);
				output("NUM COMMANDS "+ queue.size());
				printBoard(board);
				output("Simulation begin");
				int numTimes=queue.size();
				for(int i=0; i<numTimes;i++)
				{
					output("Command "+i);
					int[][] newBoard=followCom(board, queue);
					for(int k=0;k<board.length;k++)//sync the board up with the changes made by followCom
					{
						for(int j=0;j<board.length;j++)
						{
							board[k][j]= newBoard[k][j];//TODO--null point exception at 10
						}
					}
					printBoard(newBoard);
					queue.dequeue();
				}
				output("Simulation end.");
				runAnother();
			}
	}
	public static int[][] followCom(int[][]board, GenQueue<String> queue)
	{
		int [][] copyBoard= new int[board.length][board.length];
		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board.length;j++)
			{
				copyBoard[i][j]= board[i][j];
			}
		}
		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board.length;j++)
			{
				
					if(copyBoard[i][j]==2)//find current spot of robot and move it based on command, dequeue afterwards
					{
						if(queue.peek().equals("right"))// set increase j by 1
						{
							//System.out.println("I J "+ i+ " "+ (j+1));
							if((j+1)>=board.length)
							{
								output("CRASH!");
								runAnother();
							}
							copyBoard[i][j]=0;
							copyBoard[i][(j+1)]=2;
							//queue.dequeue();
							return copyBoard;
						}
						else if(queue.peek().equals("down"))//increase i by 1
						{
							if((i+1)>=copyBoard.length)
							{
								output("CRASH!");
								runAnother();
							}
							copyBoard[i][j]=0;
							copyBoard[(i+1)][j]=2;
							//queue.dequeue();
							return copyBoard;
						}
						else if(queue.peek().equals("left"))//decrease j by 1
						{
							if((j+1)<0)
							{
								output("CRASH!");
								runAnother();
							}
							copyBoard[i][j]=0;
							copyBoard[i][(j-1)]=2;
							//queue.dequeue();
							return copyBoard;
						}
						else if(queue.peek().equals("up"))// decrease i by 1
						{
							if((i-1)<0)
							{
								output("CRASH!");
								runAnother();
							}
							copyBoard[i][j]=0;
							copyBoard[(i-1)][j]=2;
							//queue.dequeue();
							return copyBoard;
						}
					}
						
				}	
		}
		return null;
	}
	public static void initRobot(int[][] board)
	{
		board[0][0]=2;
	}
	public static void output(String phrase)
	{
		System.out.println(phrase);
	}
	public static void output(int num)
	{
		System.out.println(num);
	}
	public static void printBoard(int [][] board)
	{
		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board.length;j++)
			{
				int space=board[i][j];
				String spaceString;
				switch(space)
				{
					case 0:
						spaceString="_";
						break;
					case 1:
						spaceString="X";
						break;
					case 2:
						spaceString="O";
						break;
					default:
						spaceString="?";
						break;
				}
				System.out.print(spaceString);
			}
			System.out.println();
		}
	}
	public static void runAnother()
	{
		output("Quit? Enter 'true' to quit or hit enter to run another simulation");
		Scanner keyboard=new Scanner(System.in);
		String answer= keyboard.nextLine();
		if(answer.equals("true"))
		{
			quit=true;
			System.exit(0);
		}
		else
		{
			return;
		}
	}
}
