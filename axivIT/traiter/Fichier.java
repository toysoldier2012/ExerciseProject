package axivIT.traiter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import axivIT.TondeuseException;
import axivIT.commune.Commune;
import axivIT.commune.Erreur;

public class Fichier {

	Scanner scanner;
	
	public Fichier() {}
	
	/**
	 * Cr¨¦er le courant d'entr¨¦e scanner
	 * @param file
	 */
	public Fichier(File file) {
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Obtenir les informations de pelouse
	 * @return ArrayList des informations de pelouse
	 * @throws TondeuseException
	 */
	public ArrayList<String> InfoPelouse() throws TondeuseException {
		ArrayList<String> donneesPelouse = new ArrayList<String>();
		
		if(scanner.hasNext()) {
			for(String donne : scanner.nextLine().split(Commune.CHAIN_ESPACE)) 
					donneesPelouse.add(donne);
			return donneesPelouse;
		}
		else throw new TondeuseException(Erreur.PELOUSE_COORDONNEES_MANQUANTES);
	}
	
	/**
	 * Obtenir les informations de tondeuse
	 * @return ArrayList des informations de tondeuse
	 * @throws TondeuseException
	 */
	public ArrayList<String> InfoTondeuse() throws TondeuseException {
		ArrayList<String> donneesTondeuse = new ArrayList<String>();
		
		if(scanner.hasNext()) {
			do {
				for(String donnee : scanner.nextLine().split(Commune.CHAIN_ESPACE))
					donneesTondeuse.add(donnee);
				if(!scanner.hasNext())
					throw new TondeuseException(Erreur.TONDEUSE_INSTRUCTIONS_MANQUANTES);
				donneesTondeuse.add(scanner.nextLine());
			}while(scanner.hasNext());
			return donneesTondeuse;
		}
		else 			
			throw new TondeuseException(Erreur.TONDEUSE_COORDONNEES_MANQUANTES);
	}
}
