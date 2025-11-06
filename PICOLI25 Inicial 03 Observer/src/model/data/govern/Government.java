package model.data.govern;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import model.data.being.Being;

/**
 * En esta version vamos a ver un estado que solo se preocupa de alimentar, con
 * lo necesario, a sus ciudadanos. nosotros debemos aplicar los patrones
 * necesarios para que el propio Ser pase a Adulto y Anciano sin la necesidad de
 * un control externo
 */
public class Government {
	private ArrayList<ArrayList<Being>> all;
	private ArrayList<Being> youngs = new ArrayList<>();
	private ArrayList<Being> adults = new ArrayList<>();
	private ArrayList<Being> ancients = new ArrayList<>();

	private int initialPopulation = 100;

	// patron observer
	private PropertyChangeListener adultChangeListener, ancientChangeListener;
	// patron observer

	public Government(int initialPopulation) {
		this.initialPopulation = initialPopulation;
		preparePeople();
		createListeners();
	}

	public Government() {
		super();
		createListeners();
		preparePeople();
	}

	private void preparePeople() {
		youngs = new ArrayList<>();
		adults = new ArrayList<>();
		ancients = new ArrayList<>();
		all = new ArrayList();
		all.add(youngs);
		all.add(adults);
		all.add(ancients);
		raisePopulation();

	}

	private void moveBeing(PropertyChangeEvent event, List<Being> source, List<Being> destination) {
		Being remove = source.remove(source.indexOf(event.getNewValue()));
		destination.add(remove);
	}

	private void createListeners() {
		adultChangeListener = (event) -> {
			moveBeing(event, youngs, adults);
		};
		ancientChangeListener = (event) -> {
			moveBeing(event, adults, ancients);
		};
	}

	private void raisePopulation() {
		for (int i = 0; i < initialPopulation; i++) {
			Being being = new Being();
			youngs.add(being);
			// patron observer
			being.addAdultPropertyChangeListener(adultChangeListener);
			being.addAncientPropertyChangeListener(ancientChangeListener);
		}
	}

	private void raisePopulation(int lifeExpenctancy) {
		for (int i = 0; i < initialPopulation; i++) {
			youngs.add(new Being(lifeExpenctancy));
		}
	}

	public void developLand(int years) {
		for (int i = 0; i < years; i++) {
			feed();
			bury();
		}
	}

	private void bury() {
		// sacar a los muertos
		all.forEach(list -> list.removeIf(being -> {
			boolean beingFlag = being.isAlive();
			if (!beingFlag) {
				being.removeAdultPropertyChangeListener(adultChangeListener);
				being.removeAncientPropertyChangeListener(ancientChangeListener);
			}
			return !beingFlag;
		}));
	}

	private void feed() {
		// ultimo dia del año
		// alimentar con lo necesario
		all.stream().flatMap(Collection::stream).forEach(being -> being.live(being.getVitalNecesity()));
	}
}
