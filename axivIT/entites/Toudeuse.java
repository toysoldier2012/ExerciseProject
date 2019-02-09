package axivIT.entites;

import java.util.ArrayList;

import axivIT.ToudeuseException;
import axivIT.traiter.Donnees;

public class Toudeuse {
	private Coordonnees coordonnesToudeuse = new Coordonnees();
	private Orientation orientationToudeuse = new Orientation();
	private Instruction instructionToudeuse = new Instruction();
	private Pelouse pelouse;
	
	public Toudeuse() {}
	
	public void initialiserToudeuse(ArrayList<String> donneesList, Pelouse pelouse) throws ToudeuseException {
		for(int nombreToudeuse = 0; nombreToudeuse < (donneesList.size() / 4); nombreToudeuse++) {
			if(Donnees.verifierFormatCoordonneesToudeuse(donneesList)) {
				Toudeuse instance = new Toudeuse();
				instance.pelouse = pelouse;
				instance.coordonnesToudeuse.setX(Integer.parseInt(donneesList.get(nombreToudeuse * 4 + 0)));
				instance.coordonnesToudeuse.setY(Integer.parseInt(donneesList.get(nombreToudeuse * 4 + 1)));
				instance.orientationToudeuse.setOrientation(donneesList.get(nombreToudeuse * 4 + 2));
				instance.instructionToudeuse.setInstruction(donneesList.get(nombreToudeuse * 4 + 3));
				System.out.println(instance.toString());
				instance.executer(instance);
				Donnees.resultat(instance);
			}			
		}
	}
	
	public void executer(Toudeuse instance) {
		String instructions = instance.instructionToudeuse.getInstruction();
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
	
	public void tournerGauche(Toudeuse instance) {
		switch (instance.orientationToudeuse.getOrientation()) {
			case "N":
				instance.orientationToudeuse.setOrientation("W");
				break;
			case "W":
				instance.orientationToudeuse.setOrientation("S");
				break;
			case "S":
				instance.orientationToudeuse.setOrientation("E");
				break;
			case "E":
				instance.orientationToudeuse.setOrientation("N");
				break;
		}
	}
	public void tournerDroit(Toudeuse instance) {
		switch (instance.orientationToudeuse.getOrientation()) {
			case "N":
				instance.orientationToudeuse.setOrientation("E");
				break;
			case "W":
				instance.orientationToudeuse.setOrientation("N");
				break;
			case "S":
				instance.orientationToudeuse.setOrientation("W");
				break;
			case "E":
				instance.orientationToudeuse.setOrientation("S");
				break;
		}
	}
	public void avencer(Toudeuse instance) {
		int x = instance.coordonnesToudeuse.getX();
		int y = instance.coordonnesToudeuse.getY();
		
		switch (instance.orientationToudeuse.getOrientation()) {
			case "N":
				if(dansLimite(x, y + 1)) {
					instance.coordonnesToudeuse.setX(x);
					instance.coordonnesToudeuse.setY(y + 1);
				}
				break;
			case "W":
				if(dansLimite(x - 1, y)) {
					instance.coordonnesToudeuse.setX(x - 1);
					instance.coordonnesToudeuse.setY(y);
				}
				break;
			case "S":
				if(dansLimite(x, y - 1)) {
					instance.coordonnesToudeuse.setX(x);
					instance.coordonnesToudeuse.setY(y - 1);
				}
				break;
			case "E":
				if(dansLimite(x + 1, y)) {
					instance.coordonnesToudeuse.setX(x + 1);
					instance.coordonnesToudeuse.setY(y);
				}
				break;
		}
	}
	
	public boolean dansLimite(int x, int y) {
		return 0 <= x && x <= this.pelouse.getCoordonneesPelouse().getX() 
				&& 0 <= y && y <= this.pelouse.getCoordonneesPelouse().getY();
	}

	
	
	public Coordonnees getCoordonnesToudeuse() {
		return coordonnesToudeuse;
	}
	public Orientation getOrientationToudeuse() {
		return orientationToudeuse;
	}
	public Instruction getInstructionToudeuse() {
		return instructionToudeuse;
	}

	@Override
	public String toString() {
		return "[ Touleuse: Coordonnees est: ["+ this.coordonnesToudeuse.getX()+
				", "+this.coordonnesToudeuse.getX() +
				"], l'orientation est: "+ this.orientationToudeuse.getOrientation() +
				" et l'instruction est: "+ this.instructionToudeuse.getInstruction() +
				" ]";
	}
}
