package datenInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Vector;

import hsrt.mec.controldeveloper.io.IOType;

public class Console implements IOType {
	// deklaration eines BufferedReaders br f�r read()funktion
		InputStreamReader iSR = new InputStreamReader( System.in );
		BufferedReader bR = new BufferedReader(iSR);
	
	public Console() {
		
	}
	
	@Override
	public boolean close() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean read(Vector<String> arg0) {
		
		
		try {
			arg0.add(this.bR.readLine());
		} catch (IOException e) {
			// wenn beim einlesen des Strings aus der Console etwas schief gelaufen ist, landen wir in catch. ansonsten wird catch �bersprungen.
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean write(Vector<String> arg0) {
		// jedes String element des Vektors arg0 auf Console ausgeben
		for (Iterator<String> iterator = arg0.iterator(); iterator.hasNext();) {			
			System.out.println((String) iterator.next());
		}

		return true;
	}
}
