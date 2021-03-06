package training.viewGroup.listeners;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class MyCaretListener implements CaretListener {
	JTextField textField;
	JLabel status;

	public MyCaretListener(JTextField textField, JLabel label) {
		this.textField = textField;
		this.status = label;
	}

	@Override
	public void caretUpdate(CaretEvent e) {

		String date = textField.getText();
		if (DialogButtonsListener.checkDateFormat(date) || date.length() == 0) {
			status.setForeground(Color.black);
			status.setText("Status : clear");
		} else {
			status.setForeground(Color.red);
			status.setText("Status : the date format should be \"yyyy-mm-dd\"");

		}
	}

}
