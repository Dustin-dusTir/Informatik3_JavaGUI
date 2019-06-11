package GUI.Bedienelemente.Button;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Controller.ControlDevelepor;
import Model.ControlModel;

public class ButtonStart extends JButton {
	public ButtonStart() {
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("StartButton gedr�ckt");
				ControlModel.getInstance().start();

			}
		});
		setText("Start");
	}
}
