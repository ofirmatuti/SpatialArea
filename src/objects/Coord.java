package objects;
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

}
