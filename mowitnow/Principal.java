package mowitnow;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import mowitnow.entites.Params;
import mowitnow.parser.ParserTondeuse;
import mowitnow.traitement.FormaterLigne;
import mowitnow.traitement.TraitementTondeuse;

public class Principal {

	protected static List<String> listResultats;

	public static void main(String... args) throws ExceptionTondeuse, IOException {
			File file = new File("src/mowitnow/fichier_xebia.txt");
			Principal instance = new Principal();
			instance.lancerTraitementsTondeuses(file);
	}

	/**
	 * lecture/validation du fichier et lancement des tondeuses
	 * 
	 * @param fichier
	 * @throws ExceptionTondeuse
	 * @throws IOException
	 * @return List<String> : position des tondeuses
	 */
	private void lancerTraitementsTondeuses(File fichier)
			throws ExceptionTondeuse, IOException {
		if (!fichier.isFile()) {
			throw new ExceptionTondeuse(Params.ERREUR_FICHIER_INEXISTANT);
		} else {
			ParserTondeuse parser = new ParserTondeuse();
			Scanner scanner = new Scanner(fichier);
			try {
				traiterPremiereLigne(parser, scanner);
				traiterLignesSuivantes(parser, scanner);
			} finally {
				if (scanner != null) {
					scanner.close();
				}
			}
		}
	}

	/**
	 * traiter la premiere ligne du fichier
	 * @param parser
	 * @param scanner
	 * @throws ExceptionTondeuse : erreur si le fichier contients moins de 2 lignes
	 */
	protected void traiterPremiereLigne(ParserTondeuse parser, Scanner scanner)
			throws ExceptionTondeuse {
		if (scanner.hasNext()) {
			parser.setPelouse(scanner.nextLine());
		}
		if (!scanner.hasNext()) {
			throw new ExceptionTondeuse(
					Params.ERREUR_DONNEES_INCORRECTES);
		}
	}

	/**
	 * 
	 * @param parser
	 * @param scanner
	 * @return la position des tondeuses
	 * @throws ExceptionTondeuse
	 */
	private void traiterLignesSuivantes(ParserTondeuse parser,
			Scanner scanner) throws ExceptionTondeuse {
		List<String> listePositions = new ArrayList<String>();
		while (scanner.hasNext()) {
			// lecture de la positon initiale de la tondeuse
			parser.setTondeuse(scanner.nextLine());

			if (scanner.hasNext()) {
				parser.setInstructions(scanner.nextLine());
				parserEtLancerTraitement(parser);
			} else {
				throw new ExceptionTondeuse(Params.ERREUR_DONNEES_INCORRECTES);
			}
		}
	}

	/**
	 * Parser et executer le traitement de la tondeuse
	 * @param parser : l'objet contenant les informations de la tondeuse
	 * @throws ExceptionTondeuse
	 */
	private void parserEtLancerTraitement(ParserTondeuse parser)
			throws ExceptionTondeuse {
		if (!parser.executeParse()) {
			throw new ExceptionTondeuse(Params.ERREUR_DONNEES_INCORRECTES);
		} else {
			TraitementTondeuse traitement = new TraitementTondeuse();
			traitement.setPelouse(FormaterLigne
					.formaterLignePelouse(parser.getPelouse()));
			traitement.setPositionTondeuse(FormaterLigne
					.formaterLigneTondeuse(parser.getTondeuse()));
			traitement.setListeInstruction(FormaterLigne
					.formaterLigneInstruction(parser.getInstructions()));
			traitement.executerInstructions();
			System.out.println(traitement);
		}
	}
}