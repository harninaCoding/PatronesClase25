package model;

import java.util.List;

public class Maze {
	private int roomsCount;
	List<Room> rooms;

	public Maze(int roomsCurse) {
		super();
		this.roomsCount = roomsCount;
		Polar polarEntrance = Polar.getRandomPolar();
		for (int i = 0; i < roomsCurse; i++) {
			Room e = new Room(polarEntrance);
			rooms.add(e);
			polarEntrance = Polar.getOppositePolar(e.getPolarExit());
		}
	}

}
