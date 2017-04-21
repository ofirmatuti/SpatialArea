package comparators.SpatialArea;
import java.util.Comparator;
import objects.SpatialArea;

public class AreaBySouthToNorth implements Comparator<SpatialArea> 
	{
		@Override
		public int compare(SpatialArea o1, SpatialArea o2) 
		{
			o1.getPolygon().getSouthestCoord().setSortType(new comparators.Coord.CoordsBySouthToNorth());
			return o1.getPolygon().getSouthestCoord().compareTo(o2.getPolygon().getSouthestCoord());
		}
	}