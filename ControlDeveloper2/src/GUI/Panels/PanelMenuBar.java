package GUI.Panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import Controller.ControlDevelepor;
import Model.ControlModel;

public class PanelMenuBar extends JMenuBar {
	private static PanelMenuBar instance = null;
	
	
	
	public PanelMenuBar() {
		//******************** Erstellen der Men�eintr�ge ********************
		JMenu mFile = new JMenu("File");
		JMenu mInfo = new JMenu("Info");
		JMenu mBlubb = new JMenu("Blubb");
		
		add(mFile);
		add(mInfo);
		add(mBlubb);
		
		//******************** Erstellen der Untermen�s ********************
		JMenu umManage = new JMenu("FileManagement");
		mFile.add(umManage);
		
		//******************** Erstellen der Eintr�ge ********************
		//* * * * * File-Eintr�ge * * * * *
		JMenuItem iLoad = new JMenuItem("Load List");
		JMenuItem iSave = new JMenuItem("Save List");
		JMenuItem iEmpty = new JMenuItem("Empty actuale List");
		
		umManage.add(iLoad);
		umManage.add(iSave);
		
		mFile.add(iEmpty);
		
		
		//* * * * * Info-Eintr�ge * * * * *
		JMenuItem iAbout = new JMenuItem("About");
		
		mInfo.add(iAbout);
		
		//******************** Erstellen der AktionLisenter ********************
		iLoad.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.out.println("Menueintrag 'Load' ausgew�hlt");
				ControlDevelepor.getInstance().MenuLoadList();
			}
		});
		
		iSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Menueintrag 'Save' ausgew�hlt");
				ControlDevelepor.getInstance().MenuSaveList();
			}
		});
		
		iEmpty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Menueintrag 'Empty' ausgew�hlt");
				ControlDevelepor.getInstance().EmptyList();
			}
		});

		iAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
			}
		});
	
	
	
	
	
	
	}
	
	
	public static PanelMenuBar getInstance() {
		if (instance == null) {
			instance = new PanelMenuBar();
		}
		
		return instance;
	}
}
