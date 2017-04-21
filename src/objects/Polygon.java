package objects;
import java.util.*;
import comparators.Coord.*;

public class Polygon implements Comparable<Polygon>
{

	private int id;
	private int maxHeight;
	private int minHeight;
	private List<Coord> coordsList = new ArrayList<>();
	private Comparator<Polygon> sortType;

	protected Polygon(){}

	public Polygon(int id, List<Coord> polygon) 
	{
		this.id = id;
		this.coordsList = polygon;
	}
	public Polygon(int id) 
	{
		this.id = id;
	}

	public Coord getNorthestCoord(){return Collections.max(coordsList, new CoordsByNorthToSouth());}
	public Coord getSouthestCoord(){return Collections.max(coordsList, new CoordsBySouthToNorth());}
	public Coord getEastestCoord(){return Collections.max(coordsList, new CoordsByEastToWest());}
	public Coord getWestestCoord(){return Collections.max(coordsList, new CoordsByWestToEast());}

	public int getVerticesNum(){return coordsList.size();}
	public void addCoord(Coord e){coordsList.add(e);}
	//TODO think about remove an arbitrary coordinate from a polygon
	public void removeCoord(Coord e){coordsList.add(e);}
	public boolean isClosedPolygon()
	{
		if(coordsList.get(coordsList.size())==coordsList.get(1))
			return true;
		return false;
	}
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public List<Coord> getCoordsList() {return coordsList;}
	public void setCoordsList(List<Coord> coordsList) {this.coordsList = coordsList;}
	public Comparator<Polygon> getSortType() {return sortType;}
	public void setSortType(Comparator<Polygon> sortType) {this.sortType = sortType;}
	public int getMaxHeight() {return maxHeight;}
	public void setMaxHeight(int maxHeight) {this.maxHeight = maxHeight;}
	public int getMinHeight() {return minHeight;}
	public void setMinHeight(int minHeight) {this.minHeight = minHeight;}

	@Override
	public int compareTo(Polygon o)
	{
		return sortType.compare(o,this);
	}

	public String toString()
	{
		String str ="";
		str +="[";
		for(int i=0;i<coordsList.size();i++)
		{
			if(i==coordsList.size()-1)
				str+=coordsList.get(i);
			else
				str+=coordsList.get(i)+",";
		}
		str+="]";
		return str;
	}
}