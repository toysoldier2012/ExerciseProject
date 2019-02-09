package axivIT.traiter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import axivIT.ToudeuseException;
import axivIT.commune.Commune;
import axivIT.commune.Erreur;
import axivIT.entites.Toudeuse;

import java.util.ArrayList;

public class Donnees {

	public static boolean verifierFormatCoordonneesPelouse(ArrayList<String> donneesList) throws ToudeuseException {
		Pattern patternCoordonnees = Pattern.compile(Commune.REGEX_COORDONNEES_PELOUSE);
		
		for(String donnee : donneesList) {
			Matcher matcher = patternCoordonnees.matcher(donnee);
			if(!matcher.matches())
				throw new ToudeuseException(Erreur.PELOUSE_COORDONNEES_INCORRECT);
		}
			
		return true;
	}
	
	public static boolean verifierFormatCoordonneesToudeuse(ArrayList<String> donneesList) throws ToudeuseException {
		Matcher matcher;
		Pattern patternCoordonneesToudeuse = Pattern.compile(Commune.REGEX_COORDONNEES_TOUDEUSE);
		Pattern patternOrientationToudeuse = Pattern.compile(Commune.REGEX_ORIENTATION_TOUDEUSE);
		Pattern patternInstructionToudeuse = Pattern.compile(Commune.REGEX_INSTRUCTION_TOUDEUSE);
		
		for(int i = 0; i < 2; i++) {
			matcher = patternCoordonneesToudeuse.matcher(donneesList.get(i));
			if(!matcher.matches())
				throw new ToudeuseException(Erreur.TOUDEUSE_COORDONNEES_INCORRECT);
		}
		matcher = patternOrientationToudeuse.matcher(donneesList.get(2));
		if(!matcher.matches())
			throw new ToudeuseException(Erreur.TOUDEUSE_ORIENTATION_INCORRECT);
		matcher = patternInstructionToudeuse.matcher(donneesList.get(3));
		if(!matcher.matches())
			throw new ToudeuseException(Erreur.TOUDEUSE_INSTRUCTION_INCORRECT);	
		
		return true;
	}

	public static void resultat(Toudeuse instance) {
		System.out.println("[ Touleuse: Coordonnees est: ["+ instance.getCoordonnesToudeuse().toString() +
				"], l'orientation est: "+ instance.getOrientationToudeuse().toString() +"]");
	}
}
