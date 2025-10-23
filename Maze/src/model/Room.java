package model;

import java.util.HashMap;
import java.util.HashSet;

public class Room {
	private final int sidesAmount = 4;
	HashMap<Polar, Side> sides=new HashMap<Polar, Side>();
	private HashSet<Polar> drawnPolars=new HashSet<Polar>();
	private Polar polarExit;
	public Polar getPolarExit() {
		return polarExit;
	}

	public Room(Polar polarEntrance) {
		super();
		SideManager sideManager=new SideManager();
		polarExit=createSide(polarEntrance,  sideManager.sideCreator(new DoorCreator()));
		Polar anotherSide=createSide(polarExit,  sideManager.sideCreator(new DoorCreator()));
		anotherSide=createSide(anotherSide, sideManager.noDoorCreator());
		anotherSide=createSide(anotherSide, sideManager.noDoorCreator());
	}
	
	public Polar createSide(Polar polar,Side side) {
		drawnPolars.add(polar);
		sides.put(polar, side);
		return Polar.GetRandomLeftPolar(drawnPolars);
	}
	
}
