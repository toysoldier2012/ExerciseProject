package axivIT.traiter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import axivIT.TondeuseException;
import axivIT.commune.Commune;
import axivIT.commune.Erreur;
import axivIT.entites.Tondeuse;

import java.util.ArrayList;

public class Donnees {

	/**
	 * V¨¦rifier le format de coordonn¨¦es de pelouse
	 * @param donneesList: ArrayList des coordonn¨¦es de pelouse
	 * @return vrai si le format de coordonn¨¦es fourni par le fichier est juste, sinon jeter l'exception
	 * @throws TondeuseException
	 */
	public static boolean verifierFormatCoordonneesPelouse(ArrayList<String> donneesList) throws TondeuseException {
		Pattern patternCoordonnees = Pattern.compile(Commune.REGEX_COORDONNEES_PELOUSE);
		
		for(String donnee : donneesList) {
			Matcher matcher = patternCoordonnees.matcher(donnee);
			if(!matcher.matches())
				throw new TondeuseException(Erreur.PELOUSE_COORDONNEES_INCORRECT);
		}
			
		return true;
	}
	
	/**
	 * V¨¦rifier le format des information, les coordonn¨¦es, l'orientation original et les instruction, de tondeuse
	 * @param donneesList: ArrayList des information de tondeuse
	 * @return vrai si le format des information fournis par le fichier est juste, sinon jeter l'exception
	 * @throws TondeuseException
	 */
	public static boolean verifierFormatCoordonneesTondeuse(ArrayList<String> donneesList) throws TondeuseException {
		Matcher matcher;
		Pattern patternCoordonneesTondeuse = Pattern.compile(Commune.REGEX_COORDONNEES_TONDEUSE);
		Pattern patternOrientationTondeuse = Pattern.compile(Commune.REGEX_ORIENTATION_TONDEUSE);
		Pattern patternInstructionTondeuse = Pattern.compile(Commune.REGEX_INSTRUCTION_TONDEUSE);
		
		for(int i = 0; i < 2; i++) {
			matcher = patternCoordonneesTondeuse.matcher(donneesList.get(i));
			if(!matcher.matches())
				throw new TondeuseException(Erreur.TONDEUSE_COORDONNEES_INCORRECT);
		}
		matcher = patternOrientationTondeuse.matcher(donneesList.get(2));
		if(!matcher.matches())
			throw new TondeuseException(Erreur.TONDEUSE_ORIENTATION_INCORRECT);
		matcher = patternInstructionTondeuse.matcher(donneesList.get(3));
		if(!matcher.matches())
			throw new TondeuseException(Erreur.TONDEUSE_INSTRUCTION_INCORRECT);	
		
		return true;
	}

	/**
	 * Afficher le r¨¦sultat de tondeuse
	 * @param instance: l'instance de tondeuse execut¨¦
	 */
	public static void resultat(Tondeuse instance) {
		System.out.println("[ Touleuse: Coordonnees est: ["+ instance.getCoordonnesTondeuse().toString() +
				"], l'orientation est: "+ instance.getOrientationTondeuse().toString() +"]");
	}
}
