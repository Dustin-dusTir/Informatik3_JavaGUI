package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JToolBar;

import Controller.ControlDevelepor;
import Controller.Updater;
import GUI.Panels.PanelAttributionsView;
import GUI.Panels.PanelCommandsView;
import GUI.Panels.PanelTypesView;

public class ViewControlDevelepor extends JFrame implements iUpdater {
	private ControlDevelepor cD;

	///////////////////////////////// Panels: \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
	private PanelTypesView pTV;
	private PanelAttributionsView pAV = PanelAttributionsView.getInstance();
	private PanelCommandsView pCV = PanelCommandsView.getInstance();

	// ----------------------------------------------------------

	public ViewControlDevelepor(ControlDevelepor cD, String[] arrList) {
		Updater.add(this); // registrieren beim Observer

		this.cD = cD;
		pTV = PanelTypesView.getTypesView(cD, arrList);

		// Haupteinstellungen
		setLayout(new BorderLayout());
		setVisible(true);
		this.setSize(800, 400);
		// this.getContentPane().setBackground(new Color(33, 33, 33));
		setTitle("Control-Develepor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Fensteraufteilung

		JSplitPane mainPlain1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		JSplitPane mainPlain2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		mainPlain2.setRightComponent(pAV);
		mainPlain2.setLeftComponent(pCV);

		mainPlain1.setLeftComponent(pTV);
		mainPlain1.setRightComponent(mainPlain2);

		JSplitPane rootPanel = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		rootPanel.setBottomComponent(new JLabel("Ausgabefenster"));
		rootPanel.setTopComponent(mainPlain1);

		JToolBar toolBar = new JToolBar();
		toolBar.add(new JButton("List"));
		toolBar.add(new JButton("Aktion"));

		// ERg�nzen der Einzelnen Planes
		add(toolBar, BorderLayout.NORTH);
		add(rootPanel, BorderLayout.CENTER);
		// pack();

	};

	@Override
	public void updateView() {
		// TODO Auto-generated method stub

	}

	// ********************************* Types Befehle ***************************
	public String getSelectedType() {
		return pTV.getSelectedType();

	}

	// ********************************** Table Befehle ****************************

	public void addCommand(String strCommand) {
		pCV.addCommand(strCommand);
	}

	public String getCommandTypeAt(int selectedRow) {
		return pCV.getCommandTypeAt(selectedRow);

	}
	
	public int getSelectedCommandRow() {
		return pCV.getSelectedCOmmandRow();
	}
	
	public void removeCommand(int row) {
		pCV.removeCommand(row);
		
	}

	public void upCommand(int row) {
		pCV.upCommand(row);
		
	}

	public void downCommand(int row) {
		pCV.downCommand(row);
		
	}
	// *********************************** Attributes Befehle *******************
	public void openDirectionPanel() {
		// TODO Auto-generated method stub
		System.out.println("Direction wird ge�ffnet");
	}

	public void openGearPanel() {
		// TODO Auto-generated method stub
		System.out.println("Gear wird ge�ffnet");

	}

	public void openPausePanel() {
		// TODO Auto-generated method stub
		System.out.println("Pause wird ge�ffnet");

	}

	
}
