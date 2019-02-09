package axivIT;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import axivIT.commune.*;
import axivIT.entites.Pelouse;
import axivIT.entites.Toudeuse;
import axivIT.traiter.*;

public class Main {

	public static void main(String[] args) throws ToudeuseException, IOException {
		File file = new File(Commune.CHEMIN_FICHIER);
		Fichier instance = new Fichier(file);
		ArrayList<String> infoPelouse = instance.InfoPelouse();
		ArrayList<String> infoToudeuse = instance.InfoToudeuse();
		Pelouse pelouse = new Pelouse(infoPelouse);
		System.out.println(pelouse.toString());
		Toudeuse toudeuse = new Toudeuse(infoToudeuse);
	}

}
