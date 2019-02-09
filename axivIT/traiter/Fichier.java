package axivIT.traiter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import axivIT.TondeuseException;
import axivIT.commune.Commune;
import axivIT.commune.Erreur;

/**
 * Le programme Fichier, sert ¨¤ s¨¦parer les donn¨¦es de 
 * @author toysoldier
 *
 */
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
	
	public ArrayList<String> InfoPelouse() throws TondeuseException {
		ArrayList<String> donneesPelouse = new ArrayList<String>();
		
		if(scanner.hasNext()) {
			for(String donne : scanner.nextLine().split(Commune.CHAIN_ESPACE)) 
					donneesPelouse.add(donne);
			return donneesPelouse;
		}
		else throw new TondeuseException(Erreur.PELOUSE_COORDONNEES_MANQUANTES);
	}
	
	public ArrayList<String> Infotondeuse() throws TondeuseException {
		ArrayList<String> donneestondeuse = new ArrayList<String>();
		
		if(scanner.hasNext()) {
			do {
				for(String donnee : scanner.nextLine().split(Commune.CHAIN_ESPACE))
					donneestondeuse.add(donnee);
				if(!scanner.hasNext())
					throw new TondeuseException(Erreur.TONDEUSE_INSTRUCTIONS_MANQUANTES);
				donneestondeuse.add(scanner.nextLine());
			}while(scanner.hasNext());
			return donneestondeuse;
		}
		else 			
			throw new TondeuseException(Erreur.TONDEUSE_COORDONNEES_MANQUANTES);
	}
}
