package model;

public class WallCreator extends SideCreator {

	@Override
	public Side factoryMethod() {
		return new Wall();
	}

}
