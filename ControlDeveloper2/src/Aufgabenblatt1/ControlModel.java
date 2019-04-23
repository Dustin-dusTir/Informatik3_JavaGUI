package Aufgabenblatt1;

import java.io.File;
import java.util.Iterator;
import java.util.Vector;

import datenInterface.TextFile;
import hsrt.mec.controldeveloper.core.com.command.ICommand;

public class ControlModel {
	private ControlModel instance = new ControlModel();
	private CommandType[] commandTypes = new CommandType[4];
	private CommandList controlProzess;
	
	
	private ControlModel() {
		controlProzess = new CommandList();
		commandTypes[0] = new CommandType("Direction");
		commandTypes[1] = new CommandType("Gear");
		commandTypes[2] = new CommandType("Pause");
		commandTypes[3] = new CommandType("Command");
	}
	
	public ControlModel getInstance() {
		return instance;
	}
	
	public void createCommandTypes() {
		// k�nnte / wird zu fehlern f�hren wenn es dem Programmierer �berlassen wird sich um die bef�llung des Arrays zu k�mmern!
		// desshalb:
		System.out.println("Well..... this is stupid, isnt it?");
	}
	
	// l�dt commands Zeilenweise aus file
	public boolean load(File file) {
		
		
		return false;
		
	}
	
	// Speichert die CommandList controlProzess als file ab
	public boolean save(File file) {
		TextFile commandsFile = new TextFile(file, true);
		
		Vector<String> geleseneCommandStrings = new Vector<String>();  // for Testing
		
		int numberOfCommands = controlProzess.getSize();
		Vector<String> commands = new Vector<String>();
		for (int i = 0; i <= numberOfCommands; i++) {
			commands.add(controlProzess.get(i).getName());  // speichert alle namen der ICommands in einem Vector		
		}
		System.out.println("CommandList controlProcess: ");  	// for Testing													
		System.out.println(commands);							// for Testing
		
		commandsFile.write(commands);
		
		System.out.println("In file steht jetzt:");  	// for Testing
		System.out.println();							// for Testing
																											
		geleseneCommandStrings.clear();																		// for Testing
		boolean erfolgreich = commandsFile.read(geleseneCommandStrings);									// for Testing
		for (Iterator<String> iterator = geleseneCommandStrings.iterator(); iterator.hasNext();) {			// for Testing		
			System.out.println((String) iterator.next());													// for Testing
		}																									// for Testing
		geleseneCommandStrings.clear();																		// for Testing

		return erfolgreich;		
	}

	public void commandPerformed(ICommand command) {
		
	}

	public CommandList getControlProcess() {
		return controlProzess;
	}
	
}
