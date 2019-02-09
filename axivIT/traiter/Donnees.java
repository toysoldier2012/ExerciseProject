package axivIT.traiter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import axivIT.tondeuseException;
import axivIT.commune.Commune;
import axivIT.commune.Erreur;
import axivIT.entites.tondeuse;

import java.util.ArrayList;

public class Donnees {

	public static boolean verifierFormatCoordonneesPelouse(ArrayList<String> donneesList) throws TondeuseException {
		Pattern patternCoordonnees = Pattern.compile(Commune.REGEX_COORDONNEES_PELOUSE);
		
		for(String donnee : donneesList) {
			Matcher matcher = patternCoordonnees.matcher(donnee);
			if(!matcher.matches())
				throw new TondeuseException(Erreur.PELOUSE_COORDONNEES_INCORRECT);
		}
			
		return true;
	}
	
	public static boolean verifierFormatCoordonneestondeuse(ArrayList<String> donneesList) throws TondeuseException {
		Matcher matcher;
		Pattern patternCoordonneestondeuse = Pattern.compile(Commune.REGEX_COORDONNEES_TONDEUSE);
		Pattern patternOrientationtondeuse = Pattern.compile(Commune.REGEX_ORIENTATION_TONDEUSE);
		Pattern patternInstructiontondeuse = Pattern.compile(Commune.REGEX_INSTRUCTION_TONDEUSE);
		
		for(int i = 0; i < 2; i++) {
			matcher = patternCoordonneestondeuse.matcher(donneesList.get(i));
			if(!matcher.matches())
				throw new TondeuseException(Erreur.TONDEUSE_COORDONNEES_INCORRECT);
		}
		matcher = patternOrientationtondeuse.matcher(donneesList.get(2));
		if(!matcher.matches())
			throw new TondeuseException(Erreur.TONDEUSE_ORIENTATION_INCORRECT);
		matcher = patternInstructiontondeuse.matcher(donneesList.get(3));
		if(!matcher.matches())
			throw new TondeuseException(Erreur.TONDEUSE_INSTRUCTION_INCORRECT);	
		
		return true;
	}

	public static void resultat(Tondeuse instance) {
		System.out.println("[ Touleuse: Coordonnees est: ["+ instance.getCoordonnestondeuse().toString() +
				"], l'orientation est: "+ instance.getOrientationtondeuse().toString() +"]");
	}
}
