package axivIT.entites;

import java.util.ArrayList;

import axivIT.tondeuseException;
import axivIT.traiter.Donnees;

public class tondeuse {
	private Coordonnees coordonnestondeuse = new Coordonnees();
	private Orientation orientationtondeuse = new Orientation();
	private Instruction instructiontondeuse = new Instruction();
	private Pelouse pelouse;
	
	public tondeuse() {}
	
	public void initialisertondeuse(ArrayList<String> donneesList, Pelouse pelouse) throws tondeuseException {
		for(int nombretondeuse = 0; nombretondeuse < (donneesList.size() / 4); nombretondeuse++) {
			if(Donnees.verifierFormatCoordonneestondeuse(donneesList)) {
				tondeuse instance = new tondeuse();
				instance.pelouse = pelouse;
				instance.coordonnestondeuse.setX(Integer.parseInt(donneesList.get(nombretondeuse * 4 + 0)));
				instance.coordonnestondeuse.setY(Integer.parseInt(donneesList.get(nombretondeuse * 4 + 1)));
				instance.orientationtondeuse.setOrientation(donneesList.get(nombretondeuse * 4 + 2));
				instance.instructiontondeuse.setInstruction(donneesList.get(nombretondeuse * 4 + 3));
				System.out.println(instance.toString());
				instance.executer(instance);
				Donnees.resultat(instance);
			}			
		}
	}
	
	public void executer(tondeuse instance) {
		String instructions = instance.instructiontondeuse.getInstruction();
		char instruction;
		for(int i = 0; i < instructions.length(); i++) {
			instruction = instructions.charAt(i);
			switch(instruction) {
				case 'G':
					instance.tournerGauche(instance);
					break;
				case 'D':
					instance.tournerDroit(instance);
					break;
				case 'A':
					instance.avencer(instance);
					break;
			}
		}
	}
	
	public void tournerGauche(tondeuse instance) {
		switch (instance.orientationtondeuse.getOrientation()) {
			case "N":
				instance.orientationtondeuse.setOrientation("W");
				break;
			case "W":
				instance.orientationtondeuse.setOrientation("S");
				break;
			case "S":
				instance.orientationtondeuse.setOrientation("E");
				break;
			case "E":
				instance.orientationtondeuse.setOrientation("N");
				break;
		}
	}
	public void tournerDroit(tondeuse instance) {
		switch (instance.orientationtondeuse.getOrientation()) {
			case "N":
				instance.orientationtondeuse.setOrientation("E");
				break;
			case "W":
				instance.orientationtondeuse.setOrientation("N");
				break;
			case "S":
				instance.orientationtondeuse.setOrientation("W");
				break;
			case "E":
				instance.orientationtondeuse.setOrientation("S");
				break;
		}
	}
	public void avencer(tondeuse instance) {
		int x = instance.coordonnestondeuse.getX();
		int y = instance.coordonnestondeuse.getY();
		
		switch (instance.orientationtondeuse.getOrientation()) {
			case "N":
				if(dansLimite(x, y + 1)) {
					instance.coordonnestondeuse.setX(x);
					instance.coordonnestondeuse.setY(y + 1);
				}
				break;
			case "W":
				if(dansLimite(x - 1, y)) {
					instance.coordonnestondeuse.setX(x - 1);
					instance.coordonnestondeuse.setY(y);
				}
				break;
			case "S":
				if(dansLimite(x, y - 1)) {
					instance.coordonnestondeuse.setX(x);
					instance.coordonnestondeuse.setY(y - 1);
				}
				break;
			case "E":
				if(dansLimite(x + 1, y)) {
					instance.coordonnestondeuse.setX(x + 1);
					instance.coordonnestondeuse.setY(y);
				}
				break;
		}
	}
	
	public boolean dansLimite(int x, int y) {
		return 0 <= x && x <= this.pelouse.getCoordonneesPelouse().getX() 
				&& 0 <= y && y <= this.pelouse.getCoordonneesPelouse().getY();
	}

	
	
	public Coordonnees getCoordonnestondeuse() {
		return coordonnestondeuse;
	}
	public Orientation getOrientationtondeuse() {
		return orientationtondeuse;
	}
	public Instruction getInstructiontondeuse() {
		return instructiontondeuse;
	}

	@Override
	public String toString() {
		return "[ Touleuse: Coordonnees est: ["+ this.coordonnestondeuse.getX()+
				", "+this.coordonnestondeuse.getX() +
				"], l'orientation est: "+ this.orientationtondeuse.getOrientation() +
				" et l'instruction est: "+ this.instructiontondeuse.getInstruction() +
				" ]";
	}
}
