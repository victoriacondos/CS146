/*
 * Victoria Condos
 */
import java.util.Random;
public class MatrixAvg {
	public static final int quadrantsI=4;
	public static final int quadrantsF=quadrantsI/2;//final matrix if half the length in each dimension
	public static final int valueRange=9;
	
	public static void main(String[] args) {
		Random r=new Random();//create random number generator
		int [][] matrix= new int [quadrantsI][quadrantsI];//create initial matrix
		for(int i=0;i<quadrantsI;i++)//populate initial matrix
		{
			for(int j=0;j<quadrantsI;j++)
			{
				matrix[i][j]=r.nextInt(valueRange);
			}
		}
		System.out.println("Initial Matrix:");
		for(int i=0;i<quadrantsI;i++)//print initial matrix
		{
			for(int j=0;j<quadrantsI;j++)
			{
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		
		double [] [] finalMat= new double [quadrantsF][quadrantsF];//create final matrix
		double spotOne=0.0;//create varaible that will be used to store each average
		double spotTwo=0.0;
		double spotThree=0.0;
		double spotFour=0.0;
		for(int i=0;i<quadrantsI;i++)//take averages and store in variables for new spots
		{
			for(int j=0;j<quadrantsI;j++)
			{
				if(i<(quadrantsI/2))//checks if values are in top two quads
				{
					if(j<(quadrantsI/2))//add to spotOne variable to calculate sum of top left values
					{
						spotOne+=matrix[i][j];
						if(i==((quadrantsI/2)-1) && j==((quadrantsI/2)-1)) //if bottom right of sector then divide by total quadrants to find average
						{
							spotOne/=quadrantsI;
							finalMat[0][0]=spotOne;//put value in corresponding spot of final matrix
						}
					}
					else if(j>=(quadrantsI/2))
					{
						spotTwo+=matrix[i][j];//add to spotTwo variable to calculate sum of top right values
						if(i==((quadrantsI/2)-1)&&j==(quadrantsI-1))//if bottom right of sector then divide by total quadrants to find average
						{
							spotTwo/=quadrantsI;
							finalMat[0][1]=spotTwo;//put value in corresponding spot of final matrix
						}
					}
				}
				else if(i>=(quadrantsI/2))//checks if values are in bottom two quads
				{
					
					if(j<(quadrantsI/2))// add to spotThree variable to calculate sum for bottom left values
					{
						spotThree+=matrix[i][j];
						if(i==(quadrantsI-1)&& j==(quadrantsI/2)-1)//if bottom right of sector then divide by total quadrants to find average
						{
							spotThree/=quadrantsI;
							finalMat[1][0]=spotThree;//put value in corresponding spot of final matrix
						}
					}
					else if(j>=(quadrantsI/2))
					{
						spotFour+=matrix[i][j];
						if(i==(quadrantsI-1)&& j==(quadrantsI-1))
						{
							spotFour/=quadrantsI;
							finalMat[1][1]=spotFour;//put value in corresponding spot of final matrix
						}
					}
				}

				}
			}
			System.out.println("Final Matrix: ");
			for(int i=0;i<quadrantsF;i++)//print final matrix
			{
				for(int j=0;j<quadrantsF;j++)
				{
					System.out.print(finalMat[i][j] +" ");
				}
				System.out.println();
			}
		}
	}


