package model.data.govern;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import model.data.being.Adult;
import model.data.being.Being;
import model.data.being.ControlBeing;

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
	private ControlBeing controlBeing;

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
		controlBeing = new ControlBeing();
		raisePopulation();
	}

	private void raisePopulation() {
		for (int i = 0; i < initialPopulation; i++) {
			youngs.add(controlBeing.createBeing());
		}
	}

	private void raisePopulation(int lifeExpenctancy) {
		for (int i = 0; i < initialPopulation; i++) {
			youngs.add(controlBeing.createBeing(lifeExpenctancy));
		}
	}

	public void developLand(int years) {
		for (int i = 0; i < years; i++) {
			feed();
			becomeOlder();
			bury();
		}
	}

	private void becomeOlder() {
		becomeOlder(youngs, adults, Adult.class);
		becomeOlder(adults, ancients, Being.class);

	}

	public void becomeOlder(List<Being> source, List<Being> destination, Class type) {
		  Iterator<Being> iterator = source.iterator();
		    while (iterator.hasNext()) {
		        Being being = iterator.next();
		        Being olderBeing = controlBeing.controlAges(being);
		        if (type.isInstance(olderBeing)) {
		            iterator.remove();  // Elimina de forma segura el elemento de 'source'
		            destination.add(olderBeing);  // Agrega el elemento a 'destination'
		        }
		    }
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
