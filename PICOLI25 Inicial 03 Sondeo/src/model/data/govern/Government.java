package model.data.govern;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import model.data.being.Being;

/**
 * En esta version vamos a ver un estado que solo se preocupa
 * de alimentar, con lo necesario, a sus ciudadanos.
 * nosotros debemos aplicar los patrones necesarios para que 
 * el propio Ser pase a Adulto y Anciano sin la necesidad
 * de un control externo
 */
public class Government {
	private ArrayList<ArrayList<Being>> all;
	private ArrayList<Being> youngs = new ArrayList<>();
	private ArrayList<Being> adults = new ArrayList<>();
	private ArrayList<Being> ancients = new ArrayList<>();

	private int initialPopulation = 100;

	public Government(int initialPopulation) {
		this.initialPopulation=initialPopulation;
		preparePeople();
	}
	
	public Government() {
		super();
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

	private void raisePopulation() {
		for (int i = 0; i < initialPopulation; i++) {
			youngs.add(new Being());
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
			transferBeing();
		}
	}

	//Esto es un sondeo porque cada periodo se revisa todo
	private void transferBeing() {
		List<Being> formerAdults= adults.stream().filter(Being::isAncient).collect(Collectors.toList());
		adults.removeAll(formerAdults);
		ancients.addAll(formerAdults);
		List<Being> formerYoungs = youngs.stream().filter(Being::isAdult).collect(Collectors.toList());
		youngs.removeAll(formerYoungs);
		adults.addAll(formerYoungs);
		
	}

	

	private void bury() {
		// sacar a los muertos
		all.forEach(list -> list.removeIf(being -> !being.isAlive()));
	}

	private void feed() {
		// ultimo dia del año
		// alimentar con lo necesario
		all.stream().flatMap(Collection::stream).forEach(being -> being.live(being.getVitalNecesity()));
	}
}
