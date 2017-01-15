
public class Player {

	private int missedTurns;
	private int ships;
	private int grenades;
	private String name;
		
		public void addMissedTurn()
		{
			missedTurns++;
		}
		public int getMissedTurns()
		{
			return missedTurns;
		}
		public Player() // the default constructor creates the computer player
		{
			ships=6;
			grenades=4;
			name="Computer";
			
		}
		public Player(String name) // Constructor for the human player
		{
			ships=6;
			grenades=4;
			this.name=name;
			
		}
		public String getName()
		{
			return name;
		}
		public void removeShips() 
		{
			ships--;
		}
		public void removeGrenade() 
		{
			grenades--;	
		}
		public int getShips()
		{
			return ships;
		}
		public int getGrenades()
		{
			return grenades;
		}
	
	}
