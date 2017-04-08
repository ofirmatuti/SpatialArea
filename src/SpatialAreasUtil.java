import java.util.Collections;
import java.util.Comparator;

public class SpatialAreasUtil {

	public static void deepSortForSpatialArea(SpatialArea o, Comparator<SpatialArea> comp)
	{
		SpatialArea.setSortType(comp);
		Collections.sort(o.getSons());
		for(SpatialArea a: o.getSons())
			deepSortForSpatialArea(a,comp);
	}
}
