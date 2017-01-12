
public class Position {

	private boolean ship;
	private boolean grenade;
	private int x;
	private int y;
	private String owner;
	
	public Position(String owner, String coordinate)
	{
		this.owner=owner;
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
	}
	public Position(String owner, int x , int y)
	{
		this.owner=owner;
		this.x=x;
		this.y=y;
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
	public void setGrenade()
	{
		grenade=true;
	}
	public boolean getGrenade()
	{
		return grenade;
	}
	public boolean isWithin(String coordinate)
	{
		return (((int)coordinate.charAt(0))-65)>=0 && (((int)coordinate.charAt(0))-65)<=7 && (((int)coordinate.charAt(1))-49)>=0 && (((int)coordinate.charAt(1))-49)<=7;
	}
	public boolean isWithin(int x, int y)
	{
		return x>=0 && x<=7 && y>=0 && y<=7;
	}
	public String getOwner()
	{
		return owner;
	}
}
