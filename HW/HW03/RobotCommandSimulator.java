/*
 * Victoria Condos
 */
import java.util.*;
import java.io.*;
public class RobotCommandSimulator {
	public static final int BOARD_SIZE=10;
	public static final String DELIM="\t";
	
	public static int[][] readBoard(String fileName)
	{
		try
		{
			int[][]board= new int[BOARD_SIZE][BOARD_SIZE];
			Scanner fileScanner=new Scanner(new File(fileName));
			
			for(int i=0;i<BOARD_SIZE;i++)//reads file from top right to bottom left creating board then returns board
			{
				for(int j=0;j<BOARD_SIZE;j++)
				{
					if(!fileScanner.hasNextLine())
						break;
					board[i][j]=Integer.parseInt(fileScanner.nextLine());
				}
			}
			fileScanner.close();
			return board;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}
	public static GenQueue<String> readCom(String fileName)
	{
		try
		{
			Scanner fileScanner= new Scanner(new File(fileName));
			int comCount=0;
			while(fileScanner.hasNextLine())
			{
				fileScanner.nextLine();
				comCount++;
			}
			if(comCount<=0)
				return null;
			//counts number of commands to add to the queue
			GenQueue<String> queue= new GenQueue<String>();
			fileScanner= new Scanner(new File(fileName));//reset scanner
			for(int i=0;i<comCount;i++)// add each command to queue
				queue.enqueue(fileScanner.nextLine());
			fileScanner.close();
			return queue;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}
	
}
