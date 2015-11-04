package training.viewGroup.ModalWindows;

import java.awt.GridBagConstraints;

import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import training.viewGroup.FaceOfApp;
import training.viewGroup.listeners.ChangeWinOkButtonListener;
import training.viewGroup.listeners.MyCaretListener;

public class ChangeModalWindow {
	FaceOfApp face;
	

	JDialog changeDialog;
	
	JButton okButton;
	JButton cancelButton;
	
	JLabel nameLabel;
	JLabel lastNameLabel;
	JLabel birthDayLabel;
	JLabel jobLabel;
	JLabel commentLabel;
	
	JLabel status;
	
	JTextField nameTextField;
	JTextField lastNameTextField;
	JTextField birthDayTextField;
	JTextField jobTextField;
	JTextField commentTextField;
	
	String [] selectedPersonTochange;

	public ChangeModalWindow(FaceOfApp face) {
		this.face = face;
		
		selectedPersonTochange=face.getSelectedPerson();
		
		changeDialog = new JDialog(face, "Geben Sie bitte neue Information ein!", true);
		changeDialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		changeDialog.setLayout(new GridBagLayout());
		changeDialog.setSize(450, 250);

		makeLabelsButtonsAndTextFields();
		changeDialog.setVisible(true);
		changeDialog.pack();
	}

	private void makeLabelsButtonsAndTextFields() {
		nameLabel = new JLabel("Name");
		lastNameLabel = new JLabel("Lastname");
		birthDayLabel = new JLabel("Birth Day");
		jobLabel = new JLabel("Job");
		commentLabel = new JLabel("Comment");

		okButton = new JButton("Ok");
		cancelButton = new JButton("Cancel");

		nameTextField = new JTextField(25);
		String name = selectedPersonTochange[1];
		nameTextField.setText(name);
		
		lastNameTextField = new JTextField(10);
		String lastname = selectedPersonTochange[2];
		lastNameTextField.setText(lastname);
		
		birthDayTextField = new JTextField(10);
		String bday = selectedPersonTochange[3];
		birthDayTextField.setText(bday);
		
		jobTextField = new JTextField(10);
		String job = selectedPersonTochange[4];
		jobTextField.setText(job);
		
		commentTextField = new JTextField(20);
		String comment = selectedPersonTochange[5];
		commentTextField.setText(comment);
		
		
		status = new JLabel("Status : clear");
		
		changeDialog.add(nameLabel, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.BOTH, new Insets(3, 3, 3, 3), 0, 0));
		changeDialog.add(nameTextField, new GridBagConstraints(1, 1, 1, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.BOTH, new Insets(3, 3, 3, 3), 0, 0));

		changeDialog.add(lastNameLabel, new GridBagConstraints(0, 2, 1, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.BOTH, new Insets(3, 3, 3, 3), 0, 0));
		changeDialog.add(lastNameTextField, new GridBagConstraints(1, 2, 1, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.BOTH, new Insets(3, 3, 3, 3), 0, 0));

		changeDialog.add(birthDayLabel, new GridBagConstraints(0, 3, 1, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.BOTH, new Insets(3, 3, 3, 3), 0, 0));
		changeDialog.add(birthDayTextField, new GridBagConstraints(1, 3, 1, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.BOTH, new Insets(3, 3, 3, 3), 0, 0));

		changeDialog.add(jobLabel, new GridBagConstraints(0, 4, 1, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.BOTH, new Insets(3, 3, 3, 3), 0, 0));
		changeDialog.add(jobTextField, new GridBagConstraints(1, 4, 1, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.BOTH, new Insets(3, 3, 3, 3), 0, 0));

		changeDialog.add(commentLabel, new GridBagConstraints(0, 5, 1, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.BOTH, new Insets(3, 3, 3, 3), 0, 0));
		changeDialog.add(commentTextField, new GridBagConstraints(1, 5, 1, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.BOTH, new Insets(3, 3, 3, 3), 0, 0));

		changeDialog.add(okButton, new GridBagConstraints(0, 6, 1, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.BOTH, new Insets(3, 3, 3, 3), 0, 0));
		changeDialog.add(cancelButton, new GridBagConstraints(1, 6, 1, 1, 1, 1, GridBagConstraints.NORTH,
				GridBagConstraints.BOTH, new Insets(3, 3, 3, 3), 0, 0));

		changeDialog.add(status, new GridBagConstraints(0, 7, 0, 0, 0, 0, GridBagConstraints.NORTH,
				GridBagConstraints.BOTH, new Insets(3, 3, 3, 3), 0, 0));

		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changeDialog.setVisible(false);
			}
		});
		
		okButton.addActionListener(new ChangeWinOkButtonListener(this));
		birthDayTextField.addCaretListener(new MyCaretListener(birthDayTextField, status));
		
	}
	
	public JDialog getChangeDialog() {
		return changeDialog;
	}

	public JTextField getNameTextField() {
		return nameTextField;
	}

	public JTextField getLastNameTextField() {
		return lastNameTextField;
	}

	public JTextField getBirthDayTextField() {
		return birthDayTextField;
	}

	public JTextField getJobTextField() {
		return jobTextField;
	}

	public JTextField getCommentTextField() {
		return commentTextField;
	}
	
	public FaceOfApp getFace() {
		return face;
	}

	

}
