package objects;

public class Main {

	public static void main(String args[]) throws WrongSubAreaException
	{
		CreateSpatialAreas();
	}
	
	
	private static void CreateSpatialAreas() throws WrongSubAreaException
	{
		Polygon isrPol = new Polygon(1);
		Polygon nrthPol = new Polygon(2);
		Polygon midPol = new Polygon(2);
		Polygon sothPol = new Polygon(2);
		for(int i=0;i<12;i++)
			isrPol.addCoord(new Coord(i, i));
		for(int i=8;i<11;i++)
			nrthPol.addCoord(new Coord(i, i));
		for(int i=4;i<8;i++)
			midPol.addCoord(new Coord(i, i));
		for(int i=0;i<4;i++)
			sothPol.addCoord(new Coord(i, i));

		SpatialArea israel = new SpatialArea(1,"israel",5,isrPol);//has no father
		SpatialArea north = new SpatialArea(2,"north",5,nrthPol,israel);
		SpatialArea middle = new SpatialArea(3,"middle",5,midPol,israel);
		SpatialArea south = new SpatialArea(4,"south",5,sothPol,israel);
//		List<SpatialArea> list = Arrays.asList(israel,middle,south,north);
//		SpatialArea.setSortType( new SpatialArea.BySouthToNorth());
//		System.out.println("list\n" + list);
//		Collections.sort(list);
//		System.out.println("\nsorted list\n" + list);
		
//		SpatialArea tberias  = new SpatialArea(5,"tberias",150,300,5,north);
//		SpatialArea zfat = new SpatialArea(6,"zfat",150,300,5,north);
//		SpatialArea haifa = new SpatialArea(7,"haifa",150,300,5,north);
//		
//		SpatialArea holon = new SpatialArea(8,"holon",150,300,5,middle);
//		SpatialArea telAviv = new SpatialArea(9,"telAviv",150,300,5,middle);
//		SpatialArea ramatGan = new SpatialArea(10,"ramatGan",150,300,5,middle);
//		
//		SpatialArea BeerSheva = new SpatialArea(11,"Beer Sheva",150,300,5,south);
//		SpatialArea Eilat = new SpatialArea(12,"Eilat",150,300,5,south);
//		SpatialArea arad  = new SpatialArea(13,"arad",150,300,5,south);
//		north.add(tberias);
//		north.add(zfat);
//		north.add(haifa);
//		
//		middle.add(telAviv);
//		middle.add(holon);
//		middle.add(ramatGan);
//		
//		south.add(Eilat);
//		south.add(BeerSheva);
//		south.add(arad);
//		
		israel.add(middle);
		israel.add(north);
		israel.add(south);
		System.out.println(israel);
		
	}
}
