package comparators.SpatialArea;
import java.util.Comparator;
import comparators.Coord.CoordsByNorthToSouth;
import objects.SpatialArea;

public class AreaByNorthToSouth implements Comparator<SpatialArea> 
{
	@Override
	public int compare(SpatialArea o1, SpatialArea o2) 
	{
		o1.getPolygon().getNorthestCoord().setSortType(new CoordsByNorthToSouth());
		return o1.getPolygon().getNorthestCoord().compareTo(o2.getPolygon().getNorthestCoord());
	}
}