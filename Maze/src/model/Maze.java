package model;

import java.util.List;

public class Maze {
	private int roomsCurse;
	List<Room> rooms;

	public Maze(int roomsCurse) {
		super();
		this.roomsCurse = roomsCurse;
		Polar polarEntrance = Polar.getRandomPolar();
		for (int i = 0; i < roomsCurse; i++) {
			Room e = new Room(polarEntrance);
			rooms.add(e);
			polarEntrance = Polar.getOppositePolar(e.getPolarExit());
		}
	}

}
