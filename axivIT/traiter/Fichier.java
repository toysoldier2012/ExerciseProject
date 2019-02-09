package axivIT.traiter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import axivIT.ToudeuseException;
import axivIT.commune.Commune;
import axivIT.commune.Erreur;

public class Fichier {

	Scanner scanner;
	
	public Fichier() {}
	public Fichier(File file) {
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> InfoPelouse() throws ToudeuseException {
		ArrayList<String> donneesPelouse = new ArrayList<String>();
		
		if(scanner.hasNext()) {
			for(String donne : scanner.nextLine().split(Commune.CHAIN_ESPACE)) 
					donneesPelouse.add(donne);
			return donneesPelouse;
		}
		else throw new ToudeuseException(Erreur.PELOUSE_COORDONNEES_MANQUANTES);
	}
	
	public ArrayList<String> InfoToudeuse() throws ToudeuseException {
		ArrayList<String> donneesToudeuse = new ArrayList<String>();
		
		if(scanner.hasNext()) {
			do {
				for(String donnee : scanner.nextLine().split(Commune.CHAIN_ESPACE))
					donneesToudeuse.add(donnee);
				if(!scanner.hasNext())
					throw new ToudeuseException(Erreur.TOUDEUSE_INSTRUCTIONS_MANQUANTES);
				donneesToudeuse.add(scanner.nextLine());
			}while(scanner.hasNext());
			return donneesToudeuse;
		}
		else 			
			throw new ToudeuseException(Erreur.TOUDEUSE_COORDONNEES_MANQUANTES);
	}
}
