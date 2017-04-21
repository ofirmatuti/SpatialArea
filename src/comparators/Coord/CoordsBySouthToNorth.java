package comparators.Coord;
import java.util.Comparator;

import objects.Coord;

public class CoordsBySouthToNorth implements Comparator<Coord> 
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