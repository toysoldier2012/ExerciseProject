package axivIT;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import axivIT.commune.*;
import axivIT.entites.Pelouse;
import axivIT.entites.Tondeuse;
import axivIT.traiter.*;

/**
 * Le programme principal
 * 1. Lire le fichier fourni
 * 2. Analyser le fichier, et formater les donn¨¦es
 * 3. Initialiser la pelouse et le tondeuse
 * 4. Executer le tondeuse
 * 5. Retourner le r¨¦sultat
 * @author toysoldier
 *
 */
public class Main {

	public static void main(String[] args) throws TondeuseException, IOException {
		File file = new File(Commune.CHEMIN_FICHIER);
		Fichier instance = new Fichier(file);
		ArrayList<String> infoPelouse = instance.InfoPelouse();
		ArrayList<String> infoTondeuse = instance.InfoTondeuse();
		Pelouse pelouse = new Pelouse(infoPelouse);
		System.out.println(pelouse.toString());
		Tondeuse tondeuse = new Tondeuse();
		tondeuse.initialiserTondeuse(infoTondeuse, pelouse);
	}

}
