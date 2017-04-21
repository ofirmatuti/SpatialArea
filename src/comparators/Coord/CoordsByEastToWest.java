package comparators.Coord;
import java.util.Comparator;

import objects.Coord;
//TODO check logic
public class CoordsByEastToWest implements Comparator<Coord> 
	{
		@Override
		public int compare(Coord o1, Coord o2) 
		{
			if(o1.getX()<o2.getX())
				return 1;
			if(o1.getX()>o2.getX())
				return -1;
			return 0;
		}
	}