
public class Position {

	private boolean ship;
	private boolean grenade;
	private boolean called;
	private int x;
	private int y;
	private String owner;
	
	
	public Position(String owner, String coordinate)
	{
		called=false;
		this.owner=owner;
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
	}
	public Position(String owner, int y , int x)
	{
		this.owner=owner;
		this.x=x;
		this.y=y;
		called=false;
	}
	public int getRow()
	{
		return x;
	}
	public int getColumn()
	{
		return y;
	}
	public void setShip()
	{
		ship=true;
	}
	
	public boolean getShip()
	{
		return ship;
	}
	public void setCalled()
	{
		called=true;
	}
	public boolean isCalled()
	{
		return called;
	}
	public void setGrenade()
	{
		grenade=true;
	}
	public boolean getGrenade()
	{
		return grenade;
	}
	public String getOwner()
	{
		return owner;
	}
}
