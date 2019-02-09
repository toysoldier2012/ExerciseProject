package axivIT;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import axivIT.commune.*;
import axivIT.entites.Pelouse;
import axivIT.entites.tondeuse;
import axivIT.traiter.*;

/**
 * Le programme principal, lire le fichier fourni, analyser et formater les donn¨¦es.
 * Ensuite, initialiser le pelouse et le tondeuse.
 * En derni¨¨rement ex¨¦cuter le tondeuse, et retourner le r¨¦sultat.
 * @author toysoldier
 *
 */
public class Main {

	public static void main(String[] args) throws TondeuseException, IOException {
		File file = new File(Commune.CHEMIN_FICHIER);
		Fichier instance = new Fichier(file);
		
		ArrayList<String> infoPelouse = instance.InfoPelouse();
		ArrayList<String> infotondeuse = instance.Infotondeuse();
		
		Pelouse pelouse = new Pelouse(infoPelouse);
		System.out.println(pelouse.toString());
<<<<<<< HEAD

		tondeuse tondeuse = new tondeuse();
		
		tondeuse.initialisertondeuse(infoTondeuse, pelouse);

=======
		Toudeuse toudeuse = new Toudeuse(infoToudeuse);
>>>>>>> parent of b6e1b03... Finish!
	}

}
