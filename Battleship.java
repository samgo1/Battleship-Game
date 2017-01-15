import java.util.Scanner;

public class Battleship {
	
	// Instance variables
	
	private Scanner scan = new Scanner (System.in);
	private Player p1 = new Player("Human"); // H player
	private Player p2 = new Player(); // computer player
	private Position[][] grid;
	private char[][] printGrid;
	
	/////////////////////////////////////////////////////////////////
	
	// Constructors
	
	public Battleship() // Default constructor
	{
		grid = new Position[8][8];
		printGrid = new char[8][8];
		
	}
	
	/////////////////////////////////////////////////////////////////
	
	// My isAvailable methods
	
	public boolean isAvailable(int x, int y) // if row and column is known
	{
		return grid[x][y]==null;
	}
	public boolean isAvailable(String coordinate) // if the position entered is a coordinate this one only works for 8x8 grid or < 
	{
		int x=0,y=0;
		
		switch(coordinate.charAt(0))
		{
		case 'A' : y=0;break;
		case 'B' : y=1;break;
		case 'C' : y=2;break;
		case 'D' : y=3;break;
		case 'E' : y=4;break;
		case 'F' : y=5;break;
		case 'G' : y=6;break;
		case 'H' : y=7;break;
		}
		switch(coordinate.charAt(1))
		{
		case '1' : x=0;break;
		case '2' : x=1;break;
		case '3' : x=2;break;
		case '4' : x=3;break;
		case '5' : x=4;break;
		case '6' : x=5;break;
		case '7' : x=6;break;
		case '8' : x=7;break;
		}
		return grid[x][y]==null;
		
	}
	/////////////////////////////////////////////////////////////////
	
	// My isWithin methods
	
	public boolean isWithin(String coordinate) // only for 8x8 grid or <
	{
		int x=0,y=0;
		
		switch(coordinate.charAt(0))
		{
		case 'A' : y=0;break;
		case 'B' : y=1;break;
		case 'C' : y=2;break;
		case 'D' : y=3;break;
		case 'E' : y=4;break;
		case 'F' : y=5;break;
		case 'G' : y=6;break;
		case 'H' : y=7;break;
		default : y=99;
		}
		switch(coordinate.charAt(1))
		{
		case '1' : x=0;break;
		case '2' : x=1;break;
		case '3' : x=2;break;
		case '4' : x=3;break;
		case '5' : x=4;break;
		case '6' : x=5;break;
		case '7' : x=6;break;
		case '8' : x=7;break;
		default :x=99;
		}
		
		return x>=0 && x<=7 && y>=0 && y<=7;
	}
	public boolean isWithin(int x, int y) // only for 8x8 grid or <
	{
		return x>=0 && x<=7 && y>=0 && y<=7;
	}
	/////////////////////////////////////////////////////////////////
	
	// My getters and setters
	
	public Position[][] getGrid()
	{
		return grid;
	}
	
	
	
	
	
	
	
	/////////////////////////////////////////////////////////////////
	
	// Running the game 
	
	public void run() // not done
	{
		
		System.out.println("\tWelcome to ||BATTLESHIP||\n\n");
		setShips(p1, scan);
		setGrenades(p1, scan);
		setShips(p2, scan);
		setGrenades(p2,scan);
		System.out.println("The Computer placed all his ships, let's play");
		fillGrid();
		while (p1.getShips()!=0 && p2.getShips()!=0)
		{
			System.out.println("Your turn");
			placeRocket(p1, scan);
			display();
			System.out.println("Computer's turn");
			placeRocket(p2, scan);
			display();
		}
		if (p1.getShips()==0)
			System.out.println("The winner is "+ p2.getName());
		else
			System.out.println("The winner is " + p1.getName());
		System.out.println("Number of missed turns for " + p1.getName() + " = " + p1.getMissedTurns());
		System.out.println("Number of missed turns for " + p2.getName() + " = " + p2.getMissedTurns());
		display();
		
		
		
		
	}
	/////////////////////////////////////////////////////////////////
	
	// Game methods
	
	public void setShips(Player p, Scanner sc) // for the H player and computer
	{
		if (p.getName().equals("Computer"))
		{
			for (int i=0; i<6; i++)
			{
				Position x = new Position(p.getName(), (int)(Math.random()*8), (int)(Math.random()*8));
				if (isAvailable(x.getRow(),x.getColumn()))
				{
					x.setShip();
					grid[x.getRow()][x.getColumn()]=x;
				}
				else
				{
					i--;
					continue;
				}
			}
		}
		else
		{
			
			for (int i=0; i<6; i++)
			{
				System.out.println("Enter the coordinate of your ship #" + (i+1) + ": ");
				String coordinate = sc.nextLine();
				if (isWithin(coordinate))
				{
					if (isAvailable(coordinate))
					{
						Position x = new Position(p.getName(), coordinate);
						x.setShip();
						grid[x.getRow()][x.getColumn()]=x;
					}
					else
					{
						System.out.println("Position not available, try another one.");
						i--;
						continue;
					}
				}
				else
				{
					System.out.println("The coordinate you entered is invalid, try again");
					i--;
					continue;
				}
				
			}
			
		}
		
	}
	
	public void setGrenades(Player p, Scanner sc)
	{
		if (p.getName().equals("Computer"))
		{
			for (int i=0; i<4; i++)
			{
				Position x = new Position(p.getName(), (int)(Math.random()*8), (int)(Math.random()*8));
				if (isAvailable(x.getRow(),x.getColumn()))
				{
					x.setGrenade();
					grid[x.getRow()][x.getColumn()]=x;
				}
				else
				{
					i--;
					continue;
				}
			}
		}
		else
		{
			
			for (int i=0; i<4; i++)
			{
				System.out.println("Enter the coordinate of your grenade #" + (i+1) + ": ");
				String coordinate = sc.nextLine();
				if (isWithin(coordinate))
				{
					if (isAvailable(coordinate)) 
					{
						Position x = new Position(p.getName(), coordinate);
						x.setGrenade();
						grid[x.getRow()][x.getColumn()]=x;
					}
					else
					{
						System.out.println("Position not available, try another one.");
						i--;
						continue;
					}
				}
				else
				{
					System.out.println("The coordinate you entered is invalid, try again");
					i--;
					continue;
				}
				
			}
		}
	}
	public void display()
	{
		for (int i=0; i<8; i++)
		{
			System.out.println("");
			if (i==0)
			{
				System.out.print(" ");
				for (int k=0; k<8;k++)
				{
					System.out.print((char)(k+65)+ " ");
				}
				System.out.println("");
			}
			System.out.print(i+1);
			for (int j=0; j<8; j++)
			{
				if (grid[i][j].isCalled()) // if the position is called
				{
					if (grid[i][j].getOwner().equals("Computer"))
					{
						if (grid[i][j].getShip())
						{
							printGrid[i][j]='S';
		
						}
						else
						{
							printGrid[i][j]='G';
						}
					}
					else if (grid[i][j].getOwner().equals("Nobody")) // position on the grid belongs to nobody
					{
						printGrid[i][j]='*';
					}
					else // if it is human player
					{
						if (grid[i][j].getShip())
						{
							printGrid[i][j]='s';
						}
						else
						{
							printGrid[i][j]='g';
						}
					}
			
				}
				else // position not called
				{
					printGrid[i][j]='_';
				}
				System.out.print(printGrid[i][j]+" ");
			}
		}
		System.out.println("");
	}
	
	public void placeRocket(Player p, Scanner sc)
	{
		if (p.getName().equals("Computer")) //the computer part
		{
			int x,y;
			do
			{
				x=(int)(Math.random()*8);
				y=(int)(Math.random()*8);
			}
			while (grid[x][y].getOwner().equals("Computer")); // loops until he finds a position that is not his
			System.out.println("The computer chose position: "+ (char)(y+65)+""+(char)(x+49));
			if (grid[x][y].getShip()) // then it belongs to the other player
			{
				if (!grid[x][y].isCalled())
				{
					p1.removeShips();
					grid[x][y].setCalled();
				}
				
			}
			else if(grid[x][y].getGrenade()) // then it still belongs to the other player
			{
				if (!grid[x][y].isCalled())
				{
					System.out.println("Computer hit a grenade!");
					p1.removeGrenade();
					grid[x][y].setCalled();
					p.addMissedTurn();
					display();
					placeRocket(p1,scan);
				}
				
			}
			else // nobody owns this position
			{
				grid[x][y].setCalled();
			}
			
			
			
		}
		else // human player place his rocket
		{
			System.out.println("Where do you want to position your rocket?:");
			String coordinate = sc.nextLine();
			if (isWithin(coordinate))
			{
				Position temp = new Position(p1.getName(), coordinate); // temporary created object just to get row and column for the coordinate entered
				if (grid[temp.getRow()][temp.getColumn()].getOwner().equals(p2.getName())) // the position belongs to the computer
				{
					if (grid[temp.getRow()][temp.getColumn()].getShip())
					{
						if (!grid[temp.getRow()][temp.getColumn()].isCalled())
						{
							System.out.println("Ship hit!");
							p2.removeShips();
							grid[temp.getRow()][temp.getColumn()].setCalled();
						}
						
					}
					else 
					{
						if (!grid[temp.getRow()][temp.getColumn()].isCalled())
						{
							System.out.println("You hit a grenade.");
							p2.removeGrenade();
							p.addMissedTurn();
							grid[temp.getRow()][temp.getColumn()].setCalled();
							display();
							placeRocket(p2,scan);
						}
						
						
					}
					
				}
				else if (grid[temp.getRow()][temp.getColumn()].getOwner().equals(p.getName())) // the position belongs to the argument player
				{
					System.out.println("This is your position!");
					placeRocket(p1, scan);
				}
				else // belongs to nobody, must initialize all the position that are not used
				{
					System.out.println("Nothing was hit");
					grid[temp.getRow()][temp.getColumn()].setCalled();
				}
			}
			else
			{
				System.out.println("The coordinate you entered is invalid");
				placeRocket(p1,scan);
			}
		}
	}
	public void fillGrid() // To fill positions that are not owned by either the computer or the human player
	{
		for (int i=0; i<8; i++)
		{
			for (int j=0; j<8;j++)
			{
				if (grid[i][j]==null)
				{
					grid[i][j] = new Position("Nobody", i, j);
				}
			}
		}
	}
	
	
}
