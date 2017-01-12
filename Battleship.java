
public class Battleship {
	
	
	public void run() // not done
	{
		Player player1 = new Player("Samuel");
		Player computer = new Player();
		
	}
	
	public static Position[][] board = new Position[8][8];
	public static char[][] printBoard = new char[8][8];
	
	
	// Overloading here
	public static boolean isAvailable(int x, int y)
	{
		return board[x][y]==null;
	}
	public static boolean isAvailable(String coordinate)
	{
		int x=0,y=0;
		
		switch(coordinate.charAt(0))
		{
		case 'A' : x=0;break;
		case 'B' : x=1;break;
		case 'C' : x=2;break;
		case 'D' : x=3;break;
		case 'E' : x=4;break;
		case 'F' : x=5;break;
		case 'G' : x=6;break;
		case 'H' : x=7;break;
		}
		switch(coordinate.charAt(1))
		{
		case '1' : y=0;break;
		case '2' : y=1;break;
		case '3' : y=2;break;
		case '4' : y=3;break;
		case '5' : y=4;break;
		case '6' : y=5;break;
		case '7' : y=6;break;
		case '8' : y=7;break;
		}
		return board[x][y]==null;
		
	}
	
}
