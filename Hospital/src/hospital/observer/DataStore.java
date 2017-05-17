package hospital.observer;

import java.util.Observable;

public class DataStore extends Observable {
	
	private int state;


	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
		setChanged();
	}

	
	

}
