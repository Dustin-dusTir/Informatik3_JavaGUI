package GUI.Bedienelemente.Tabelle;

import javax.swing.table.AbstractTableModel;

import Controller.ControlDevelepor;
import Controller.Updater;
import GUI.iUpdater;
import Model.CommandList;
import Model.CommandType;
import Model.ControlModel;
import Model.Direction;
import Model.Gear;

public class TableCommandsModel extends AbstractTableModel implements iUpdater{
	private ControlDevelepor cD;
	private CommandList listCommands;
	private final String[] arrCOLUMNNAMES = { "Nr.", "Command", "Configuration" };

	public TableCommandsModel(ControlDevelepor cD) {
		Updater.add(this);
		this.cD = cD;
		listCommands = ControlModel.getInstance().getControlProcess(); 
		listCommands.add(new Direction(30));
		listCommands.add(new Gear(5, 5.0));
		listCommands.add(new Direction(30));
		listCommands.add(new Gear(5, 5.0));
		listCommands.add(new Direction(30));
		listCommands.add(new Gear(5, 5.0));

	}

	public void addCommand(String strCommand) {
		listCommands.add(new CommandType(strCommand).createInstance());

		listCommands.printList();

		System.out.println(strCommand + " - Command wurde angelegt!");

		// fireTableRowsInserted(listCommands.getSize(), listCommands.getSize());
		fireTableDataChanged();
	}

	public void removeCommand(int row) {
		listCommands.printList();
		System.out.println("DesiredPosition" + row);
		System.out.println("List:" + listCommands.getSize());
		System.out.println("DesiredPosition" + row);
//		if (listCommands.getSize() == 1) {
//			if(ControlDevelepor.getInstance().EmptyList()) {
//				listCommands.remove(row);
//			}
//			else {}
//		}
//		listCommands.remove(row);
		fireTableDataChanged();

	}

	public void upCommand(int row) {
		listCommands.printList();
		System.out.println("DesiredPosition" + row);
		System.out.println("List:" + listCommands.getSize());
		listCommands.moveUp(row);
		listCommands.printList();
		fireTableDataChanged();

	}

	public void downCommand(int row) {
		System.out.println("DesiredPosition" + row);
		listCommands.moveDown(row);
		fireTableDataChanged();

	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public int getRowCount() {
		return listCommands.getSize();
	}

	@Override
	public String getColumnName(int column) {
		return arrCOLUMNNAMES[column];
	}

	@Override
	public Object getValueAt(int row, int col) {
		Object o = "";

		String[] comContent = CommandType.showInstance(listCommands.get(row));
		switch (col) {
		case 0:
			o = "" + (row + 1);
			break;
		case 1:
			o = comContent[0];
			break;
		case 2:
			o = comContent[1];
			break;
		default:
			System.err.println("ERROR - INVALID ICOMMAND");
			break;
		}
		return o;
	}

	public void test() {
	}

	@Override
	public void updateView() {
		
		//fireTableDataChanged();
	}

	public void emptyList() {
		listCommands.clear();
		fireTableDataChanged();
		Updater.updateAll();
		
	}

}