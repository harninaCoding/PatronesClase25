package model;

public class WindowCreator extends SideCreator {

	@Override
	public Side factoryMethod() {
		return new Window();
	}

}
