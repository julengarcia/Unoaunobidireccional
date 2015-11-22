package org.julengarcia.hibernate.airlines;

import org.julengarcia.hibernate.airlines.dao.AircraftDAO;
import org.julengarcia.hibernate.airlines.dao.PilotDAO;
import org.julengarcia.hibernate.airlines.models.Aircraft;
import org.julengarcia.hibernate.airlines.models.Pilot;

public class Main {

	public static void main(String[] args) {
		Aircraft aircraft1 = new Aircraft("Modelo1",0);
		Aircraft aircraft2 = new Aircraft("Modelo2",0);

		Pilot pilot1 = new Pilot("Piloto 1",3);
		Pilot pilot2 = new Pilot("Piloto 3",2);
		aircraft1.setPilot(pilot1);
		aircraft2.setPilot(pilot2);
	
		AircraftDAO aircraftDAO = new AircraftDAO();
		
		aircraftDAO.insert(aircraft1);
		aircraftDAO.insert(aircraft2);

		for (Aircraft aircraft: aircraftDAO.selectAll()) {
	        System.out.println(aircraft.toString()); 
	    }
		
	}

}
