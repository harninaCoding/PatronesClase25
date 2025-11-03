package model.data.being;

public class Adult extends Being {
	private long savings;
	private boolean active;

	public Adult(Being being) {
		super(being);
		savings=0;
		active=false;
	}

	public long getSavings() {
		return savings;
	}

	public void setSavings(long savings) {
		this.savings = savings;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	

}
