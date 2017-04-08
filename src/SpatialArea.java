import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SpatialArea implements Comparable<SpatialArea> 
{
	private int id;
	private String name;
	private int maxHeight;
	private int minHeight;
	private int areaType;
	private Polygon polygon;
	private SpatialArea father;
	private List <SpatialArea> sons;
	private static Comparator<SpatialArea> sortType;
	private int level;

	// constructor for spatial area with a father
	public SpatialArea(int id,String name,int maxHeight, int minHeight, 
			int areaType,Polygon polygon,SpatialArea father) 
	{
		this.father = father;	
		this.name = name;
		this.id = id;
		this.minHeight = minHeight;
		this.maxHeight = maxHeight;
		this.setAreaType(areaType);
		this.polygon=polygon;
		level = father.getLevel()+1;
		sons = new ArrayList<SpatialArea>();
	}

	// constructor for spatial area without a father
	public SpatialArea(int id,String name,int maxHeight, int minHeight,
			int areaType,Polygon polygon) 
	{
		this.name = name;
		this.id = id;
		this.minHeight = minHeight;
		this.maxHeight = maxHeight;
		this.setAreaType(areaType);
		this.polygon=polygon;
		level=1;
		sons = new ArrayList<SpatialArea>();
	}

	public void remove(SpatialArea e) {sons.remove(e);}
	public void add(SpatialArea e) throws WrongSubAreaException 
	{
		if(e.getFather().getId()==getId())
			sons.add(e);
		else 
			throw new WrongSubAreaException(e.getName()+" is not a sub Area of " + getName());
	}

	public String toString()
	{
		String str = getName()+ " \n";
		for(int i=0;i<sons.size();i++)
		{
			for(int j=0;j<level;j++)
				str+="     ";
			str+=sons.get(i).toString();
		}
		return str;
	}

	public String helper(String spacer, String pString)
	{
		pString += spacer + getName() + " \n";
		for(SpatialArea o : sons)
		{
			pString+=o.helper(spacer+" ", pString);
		}
		return pString;
	}
	@Override
	public int compareTo(SpatialArea o)
	{
		return sortType.compare(o,this);
	}

	//Getters and Setters
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public int getMaxHeight() {return maxHeight;}
	public void setMaxHeight(int maxHeight) {this.maxHeight = maxHeight;}
	public int getMinHeight() {return minHeight;}
	public void setMinHeight(int minHeight) {this.minHeight = minHeight;}
	public List<SpatialArea> getSons() {return sons;}
	public void setSons(List<SpatialArea> subPlaces) {this.sons = subPlaces;}
	public SpatialArea getFather() 
	{		
		if(father==null)
			return null;
		else return father;
	}
	public void setFather(SpatialArea father) {	this.father = father;}
	public int getLevel() {return level;}
	public void setLevel(int level) {this.level = level;}
	public int getAreaType() {return areaType;}
	public void setAreaType(int areaType) {this.areaType = areaType;}
	public Polygon getPolygon() {return polygon;}
	public void setPolygon(Polygon polygon) {this.polygon = polygon;}
	public static Comparator<SpatialArea> getSortType() {return sortType;}
	public static void setSortType(Comparator<SpatialArea> sortType) {SpatialArea.sortType = sortType;}



	//nested classes
	public static class ByNorthToSouth implements Comparator<SpatialArea> 
	{
		@Override
		public int compare(SpatialArea o1, SpatialArea o2) 
		{
			o1.getPolygon().getNorthestCoord().setSortType(new Coord.ByNorthToSouth());
			return o1.getPolygon().getNorthestCoord().compareTo(o2.getPolygon().getNorthestCoord());
		}
	}

	public static class BySouthToNorth implements Comparator<SpatialArea> 
	{
		@Override
		public int compare(SpatialArea o1, SpatialArea o2) 
		{
			o1.getPolygon().getSouthestCoord().setSortType(new Coord.BySouthToNorth());
			return o1.getPolygon().getSouthestCoord().compareTo(o2.getPolygon().getSouthestCoord());
		}
	}
}
