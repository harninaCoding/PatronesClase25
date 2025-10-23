package model;

public class DoorCreator extends SideCreator {

	@Override
	public Side factoryMethod() {
		return new Door();
	}

}
