package model;

import java.util.List;
import java.util.Random;

public class SideManager {
	public Side sideCreator(SideCreator sideCreator) {
		return sideCreator.factoryMethod();
	}

	public Side noDoorCreator() {
		List<SideCreator> of = List.of(new WallCreator(),new WindowCreator());
		return of.get(new Random().nextInt(of.size())).factoryMethod();
	}
}
