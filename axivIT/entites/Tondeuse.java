package axivIT.entites;

import java.util.ArrayList;

import axivIT.TondeuseException;
import axivIT.traiter.Donnees;

public class Tondeuse {
	private Coordonnees coordonnesTondeuse = new Coordonnees();
	private Orientation orientationTondeuse = new Orientation();
	private Instruction instructionTondeuse = new Instruction();
	private Pelouse pelouse;
	
	public Tondeuse() {}
	
	/**
	 * Initialiser et executer le tondeuse par les informations fournis par les fichier
	 * Affichier le r¨¦sultat de tondeuse, son position et l'orientation finale
	 * @param donneesList: ArrayList des informations de tondeuse
	 * @param pelouse: l'instance de pelouse, fournir la zone limit¨¦e o¨´ le tondeuse ex¨¦cute
	 * @throws TondeuseException
	 */
	public void initialiserTondeuse(ArrayList<String> donneesList, Pelouse pelouse) throws TondeuseException {
		for(int nombreTondeuse = 0; nombreTondeuse < (donneesList.size() / 4); nombreTondeuse++) {
			if(Donnees.verifierFormatCoordonneesTondeuse(donneesList)) {
				Tondeuse instance = new Tondeuse();
				instance.pelouse = pelouse;
				instance.coordonnesTondeuse.setX(Integer.parseInt(donneesList.get(nombreTondeuse * 4 + 0)));
				instance.coordonnesTondeuse.setY(Integer.parseInt(donneesList.get(nombreTondeuse * 4 + 1)));
				instance.orientationTondeuse.setOrientation(donneesList.get(nombreTondeuse * 4 + 2));
				instance.instructionTondeuse.setInstruction(donneesList.get(nombreTondeuse * 4 + 3));
				System.out.println(instance.toString());
				
				instance.executer(instance);
				
				Donnees.resultat(instance);
			}			
		}
	}
	
	/**
	 * D¨¦terminer les instrucion de tondeuse, et choisir l'action correspondante
	 * @param instance
	 */
	public void executer(Tondeuse instance) {
		String instructions = instance.instructionTondeuse.getInstruction();
		char instruction;
		for(int i = 0; i < instructions.length(); i++) {
			instruction = instructions.charAt(i);
			switch(instruction) {
				case 'G':
					instance.tournerGauche(instance);
					break;
				case 'D':
					instance.tournerDroite(instance);
					break;
				case 'A':
					instance.avancer(instance);
					break;
			}
		}
	}
	
	/**
	 * Faire piloter le tondeuse ¨¤ gauche
	 * @param instance: l'instance de tondeuse
	 */
	public void tournerGauche(Tondeuse instance) {
		switch (instance.orientationTondeuse.getOrientation()) {
			case "N":
				instance.orientationTondeuse.setOrientation("W");
				break;
			case "W":
				instance.orientationTondeuse.setOrientation("S");
				break;
			case "S":
				instance.orientationTondeuse.setOrientation("E");
				break;
			case "E":
				instance.orientationTondeuse.setOrientation("N");
				break;
		}
	}
	
	/**
	 * Faire piloter le tondeuse ¨¤ droite
	 * @param instance: l'instance de tondeuse
	 */
	public void tournerDroite(Tondeuse instance) {
		switch (instance.orientationTondeuse.getOrientation()) {
			case "N":
				instance.orientationTondeuse.setOrientation("E");
				break;
			case "W":
				instance.orientationTondeuse.setOrientation("N");
				break;
			case "S":
				instance.orientationTondeuse.setOrientation("W");
				break;
			case "E":
				instance.orientationTondeuse.setOrientation("S");
				break;
		}
	}
	
	/**
	 * Avancer le tondeuse, le m¨¦thode dansLimite() sert ¨¤ v¨¦rifier l'avance suivante si hors la limite
	 * @param instance: l'instance de tondeuse
	 */
	public void avancer(Tondeuse instance) {
		int x = instance.coordonnesTondeuse.getX();
		int y = instance.coordonnesTondeuse.getY();
		
		switch (instance.orientationTondeuse.getOrientation()) {
			case "N":
				if(dansLimite(x, y + 1)) {
					instance.coordonnesTondeuse.setX(x);
					instance.coordonnesTondeuse.setY(y + 1);
				}
				break;
			case "W":
				if(dansLimite(x - 1, y)) {
					instance.coordonnesTondeuse.setX(x - 1);
					instance.coordonnesTondeuse.setY(y);
				}
				break;
			case "S":
				if(dansLimite(x, y - 1)) {
					instance.coordonnesTondeuse.setX(x);
					instance.coordonnesTondeuse.setY(y - 1);
				}
				break;
			case "E":
				if(dansLimite(x + 1, y)) {
					instance.coordonnesTondeuse.setX(x + 1);
					instance.coordonnesTondeuse.setY(y);
				}
				break;
		}
	}
	
	/**
	 * V¨¦rifier l'avance suivante si hors la limite
	 * @param x: Coordonne X d'avance suivante
	 * @param y: Coordonne Y d'avance suivante
	 * @return vrai si l'avance suivante est dans le limite, false sinon
	 */
	public boolean dansLimite(int x, int y) {
		return 0 <= x && x <= this.pelouse.getCoordonneesPelouse().getX() 
				&& 0 <= y && y <= this.pelouse.getCoordonneesPelouse().getY();
	}

	
	/*
	 * Les getter du tondeuse
	 */
	public Coordonnees getCoordonnesTondeuse() {
		return coordonnesTondeuse;
	}
	public Orientation getOrientationTondeuse() {
		return orientationTondeuse;
	}
	public Instruction getInstructionTondeuse() {
		return instructionTondeuse;
	}

	@Override
	public String toString() {
		return "[ Touleuse: Coordonnees est: ["+ this.coordonnesTondeuse.getX()+
				", "+this.coordonnesTondeuse.getX() +
				"], l'orientation est: "+ this.orientationTondeuse.getOrientation() +
				" et l'instruction est: "+ this.instructionTondeuse.getInstruction() +
				" ]";
	}
}
