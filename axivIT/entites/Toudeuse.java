package axivIT.entites;

import java.util.ArrayList;

import axivIT.ToudeuseException;
import axivIT.traiter.Donnees;

public class Toudeuse {
	private Coordonnees coordonnesToudeuse = new Coordonnees();
	private Orientation orientationToudeuse = new Orientation();
	private Instruction instructionToudeuse = new Instruction();
	
	public Toudeuse() {}
	
	public Toudeuse(ArrayList<String> donneesList) throws ToudeuseException {
		for(int nombreToudeuse = 0; nombreToudeuse < (donneesList.size() / 4); nombreToudeuse++) {
			if(Donnees.verifierFormatCoordonneesToudeuse(donneesList)) {
				Toudeuse instance = new Toudeuse();
				instance.coordonnesToudeuse.setX(Integer.parseInt(donneesList.get(nombreToudeuse * 4 + 0)));
				instance.coordonnesToudeuse.setY(Integer.parseInt(donneesList.get(nombreToudeuse * 4 + 1)));
				instance.orientationToudeuse.setOrientation(donneesList.get(nombreToudeuse * 4 + 2));
				instance.instructionToudeuse.setInstruction(donneesList.get(nombreToudeuse * 4 + 3));
				System.out.println(instance.toString());;
				instance.executer(instance);
			}			
		}
	}
	
	public void executer(Toudeuse instance) {
		
	}
	
	public boolean horsLimite(String x, String y) {
		return false;
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
