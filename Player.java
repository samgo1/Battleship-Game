import java.util.Scanner;
public class Player {

	private int ships;
	private int grenades;
	private String name;
	public Player() // the default constructor creates the computer player
	{
		ships=6;
		grenades=4;
		name="Computer";
		computerSetShips();
	}
	public Player(String name) // Constructor for the human player
	{
		ships=6;
		grenades=4;
		this.name=name;
		setShips();
	}
	public void removeShips()
	{
		ships--;
	}
	public void removeGrenade()
	{
		grenades--;
		
		
	}
	private void setShips()
	{
		Scanner keyInput = new Scanner(System.in);
		for (int i=0; i<6; i++)
		{
			System.out.println("Enter the coordinate of your ship #" + (i+1) + ": ");
			String coordinate = keyInput.nextLine();
			Position obj = new Position(name, coordinate);
			if (obj.isWithin(coordinate))
			{
				if (Battleship.isAvailable(coordinate))
				{
					Battleship.board[obj.getRow()][obj.getColumn()]=obj;
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
	private void computerSetShips()
	{
		for (int i=0; i<6; i++)
		{
			Position obj = new Position(name, (int)(Math.random()*8), (int)(Math.random()*8));
			if (obj.isWithin(obj.getRow(),obj.getColumn()))
			{
				if (Battleship.isAvailable(obj.getRow(),obj.getColumn()))
				{
					Battleship.board[obj.getRow()][obj.getColumn()]=obj;
				}
				else
				{
					i--;
					continue;
				}
			}
			else
			{
				i--;
				continue;
			}
			
			
		}
	}
	public void callPosition(Player otherPlayer)
	{
		System.out.println("Where do you want to position your rocket?");
		Scanner keyInput = new Scanner(System.in);
		String coordinate = keyInput.nextLine();
		// find the position in the board right here
		Position obj = new Position(name, coordinate);
		if (obj.isWithin(coordinate))
		{
			if (Battleship.isAvailable(coordinate))
			{
				System.out.println("Nothing was hit");
				Battleship.printBoard[obj.getRow()][obj.getRow()]='*';
			}
			else // ca appartient a quelqun cette position la
			{
				if (Battleship.board[obj.getRow()][obj.getColumn()].getOwner().equals(name)) // I called on my position
				{
					if (Battleship.board[obj.getRow()][obj.getColumn()].getShip())
						removeShips();
					else
						removeGrenade();
				}
				else // the other player's position
				{
					if (Battleship.board[obj.getRow()][obj.getColumn()].getShip())
						otherPlayer.removeShips();
					else
						otherPlayer.removeGrenade();
				}
			}
		}
		
		
	}
}
