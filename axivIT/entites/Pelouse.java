package axivIT.entites;

import java.util.ArrayList;

import axivIT.TondeuseException;
import axivIT.traiter.Donnees;


public class Pelouse {
	private Coordonnees coordonneesPelouse = new Coordonnees();

	public Pelouse() {
	}

	public Pelouse(ArrayList<String> donneesList) throws NumberFormatException, TondeuseException {
		if(Donnees.verifierFormatCoordonneesPelouse(donneesList)) {
			coordonneesPelouse.setX(Integer.parseInt(donneesList.get(0)));
			coordonneesPelouse.setY(Integer.parseInt(donneesList.get(1)));			
		}
	}

	public Coordonnees getCoordonneesPelouse() {
		return coordonneesPelouse;
	}

	@Override
	public String toString() {
		return "[ Coordonnee X max est: " + coordonneesPelouse.getX() + " et Coordonne Y max est: "
				+ coordonneesPelouse.getY() + " ]";
	}

}
