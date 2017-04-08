import java.util.Comparator;

public class Coord implements Comparable<Coord>{

	private double x;
	private double y;
	private Comparator<Coord> sortType;

	public Coord(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {return x;}
	public void setX(double x) {this.x = x;}
	public double getY() {return y;}
	public void setY(double y) {this.y = y;}
	public Comparator<Coord> getSortType() {return sortType;}
	public void setSortType(Comparator<Coord> sortType) {this.sortType = sortType;}


	@Override
	public int compareTo(Coord o) throws NullPointerException
	{
		return sortType.compare(o,this);
	}
	
	public String toString()
	{
		return "("+getX()+","+getY()+")";
	}

	public static class ByNorthToSouth implements Comparator<Coord> 
	{
		@Override
		public int compare(Coord o1, Coord o2) 
		{
			if(o1.getY()<o2.getY())
				return -1;
			if(o1.getY()>o2.getY())
				return 1;
			return 0;
		}
	}
	public static class BySouthToNorth implements Comparator<Coord> 
	{
		@Override
		public int compare(Coord o1, Coord o2) 
		{
			if(o1.getY()<o2.getY())
				return 1;
			if(o1.getY()>o2.getY())
				return -1;
			return 0;
		}
	}
	//TODO change logic totally
	public static class Eastest implements Comparator<Coord> 
	{
		@Override
		public int compare(Coord o1, Coord o2) 
		{
			if(o1.getY()>o2.getY())
				return 1;
			if(o1.getY()>o2.getY())
				return -1;
			return 0;
		}
	}
	//TODO change logic totally
	public static class Westest implements Comparator<Coord> 
	{
		@Override
		public int compare(Coord o1, Coord o2) 
		{
			if(o1.getY()>o2.getY())
				return 1;
			if(o1.getY()>o2.getY())
				return -1;
			return 0;
		}
	}


}
