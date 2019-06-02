package Model;

import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

//import hsrt.mec.controldeveloper.io.TextFile;
import hsrt.mec.controldeveloper.core.com.command.ICommand;
import zzzDatenInterface.TextFile;

/**
 * Klasse des ControlModels Enth�lt M�gliche Commands und eine Liste des
 * bestehenden Prozesses
 * 
 *
 */
public class ControlModel {
	private static ControlModel instance = new ControlModel();
	private CommandType[] commandTypes = new CommandType[4];
	private CommandList controlProzess = new CommandList();

	/**
	 * Konstruktor der CommandType Array mit den M�glichen CommandTypes bef�llt
	 */
	private ControlModel() {
		controlProzess = new CommandList();
		commandTypes[0] = new CommandType("Direction");
		commandTypes[1] = new CommandType("Gear");
		commandTypes[2] = new CommandType("Pause");
		commandTypes[3] = new CommandType("Command");
	}

	/**
	 * Methode die die Instance des ControlModels liefert singleton
	 * 
	 * @return Instanz des ControlModels
	 */
	public static ControlModel getInstance() {
		return instance;
	}

	/**
	 * Funktion, die commandTypes mit den Command Types bef�llen sollte. Dies ist
	 * aber doof da es schon in dem Constructor gemacht wurde k�nnte / wird zu
	 * fehlern f�hren wenn es dem Programmierer �berlassen wird sich um die
	 * bef�llung des Arrays zu k�mmern!
	 */
	public void createCommandTypes() {
		// k�nnte / wird zu fehlern f�hren wenn es dem Programmierer �berlassen wird
		// sich um die bef�llung des Arrays zu k�mmern!
		// desshalb:
		System.out.println("Well..... this is stupid, isnt it?");
	}

	/**
	 * l�dt commands Zeilenweise aus file commands werden �berschrieben
	 * 
	 * @param file Das file aus dem controlProzess erstellt werden soll
	 * @return true
	 */
	public boolean load(File file) {
		TextFile commandsFile = new TextFile(file, true);
		Vector<String> geleseneCommandStrings = new Vector<String>();
		commandsFile.read(geleseneCommandStrings);
		controlProzess.VectorToList(geleseneCommandStrings);

		return true;
	}

	/**
	 * Speichert die CommandList controlProzess als file ab. file wird �berschrieben
	 * 
	 * @param file
	 * @return
	 */
	public boolean save(File file) {
		TextFile textFile = new TextFile(file, false);

		Vector<String> geleseneCommandStrings = new Vector<String>(); // for Testing

		System.out.println();// for Testing
		System.out.println("CommandList controlProcess: "); // for Testing
		System.out.println(controlProzess.ListToVector());// for Testing

		boolean erfolgreich = textFile.write(controlProzess.ListToVector());
		textFile.close();

		System.out.println();// for Testing
		System.out.println("In file steht jetzt:"); // for Testing

		geleseneCommandStrings.clear(); // for Testing
		textFile.read(geleseneCommandStrings); // for Testing

		textFile.close();

		System.out.println(geleseneCommandStrings);// for Testing

		return erfolgreich;
	}

	/**
	 * macht nichts bis jetzt
	 * 
	 * @param command
	 */
	public void commandPerformed(ICommand command) {

	}

	/**
	 * Getter f�r controlProzess
	 * 
	 * @return
	 */
	public CommandList getControlProcess() {
		return controlProzess;
	}

	public Vector<String> getCommandTypes() {
		Vector<String> temp = new Vector<String>();
		for (int i = 0; i < commandTypes.length; i++) {
			temp.add(commandTypes[i].getName());
		}
		return temp;
	}
	
	
}
