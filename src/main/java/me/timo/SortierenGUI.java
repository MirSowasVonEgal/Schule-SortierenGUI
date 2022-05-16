package me.timo;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class SortierenGUI extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblZuweisungen;
	private JLabel lblSortiertenZahlen_1_1;
	private JLabel lblSortiertenZahlen_1_2;
	private JLabel lblSortiertenZahlen_1_3;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public SortierenGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setToolTipText("Welche Zahlen willst du sortieren?");
		textField.setBounds(10, 82, 564, 35);
		contentPane.add(textField);
		textField.setColumns(10);

		textField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				update();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				update();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				update();
			}

		});

		JLabel lblNewLabel = new JLabel("Welche Zahlen willst du sortieren? (Zahlen durch ein Leerzeichen trennen)");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 57, 564, 24);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Sortieren");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(10, 11, 564, 35);
		contentPane.add(lblNewLabel_1);

		JLabel lblWelchen = new JLabel("Welchen Sortieralgorithmus willst du benutzten?");
		lblWelchen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblWelchen.setBounds(10, 128, 564, 24);
		contentPane.add(lblWelchen);

		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Straight Selection", "Straight Insertion", "Bubble Sort", "Quick Sort", "Gnom Sort", "Shaker Sort"}));
		comboBox.setBounds(10, 155, 564, 40);
		contentPane.add(comboBox);

		JLabel lblSortiertenZahlen = new JLabel("Sortiertenzahlen");
		lblSortiertenZahlen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSortiertenZahlen.setBounds(10, 206, 564, 24);
		contentPane.add(lblSortiertenZahlen);

		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(10, 241, 564, 35);
		contentPane.add(textField_1);

		lblZuweisungen = new JLabel("Zuweisungen: 0");
		lblZuweisungen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblZuweisungen.setBounds(10, 287, 282, 24);
		contentPane.add(lblZuweisungen);

		lblSortiertenZahlen_1_1 = new JLabel("Tausche: 0");
		lblSortiertenZahlen_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSortiertenZahlen_1_1.setBounds(10, 311, 282, 24);
		contentPane.add(lblSortiertenZahlen_1_1);

		lblSortiertenZahlen_1_2 = new JLabel("Vergleiche: 0");
		lblSortiertenZahlen_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSortiertenZahlen_1_2.setBounds(292, 287, 282, 24);
		contentPane.add(lblSortiertenZahlen_1_2);

		lblSortiertenZahlen_1_3 = new JLabel("Gesamtzuweisungen: 0");
		lblSortiertenZahlen_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSortiertenZahlen_1_3.setBounds(292, 311, 282, 24);
		contentPane.add(lblSortiertenZahlen_1_3);
	}

	private void update() {
		int[] feld = changeArrayType(textField.getText().replace("  "," ").split(" "));

		if(feld == null) {
			textField_1.setText("Es dürfen nur Zahlen eingegeben werden!");
			return;
		}

		Sortieren sortieren = new Sortieren(feld);

		switch(comboBox.getSelectedItem().toString()) {
			case "Straight Selection":
				sortieren.straightSelection();
				break;
			case "Straight Insertion":
				sortieren.straightInsertion();
				break;
			case "Bubble Sort":
				sortieren.bubbleSort();
				break;
			case "Quick Sort":
				sortieren.quickSort(1, feld.length-1);
				break;
			case "Gnom Sort":
				sortieren.gnomSort();
				break;
			case "Shaker Sort":
				sortieren.shakerSort();
				break;
		}

		lblZuweisungen.setText("Zuweisungen: " + sortieren.getZ());
		lblSortiertenZahlen_1_1.setText("Tausche: " + sortieren.getT());
		lblSortiertenZahlen_1_2.setText("Vergleiche: " + sortieren.getV());
		lblSortiertenZahlen_1_3.setText("Gesamtzuweisungen: " + (sortieren.getZ() + 3 * sortieren.getT()));

		textField_1.setText(arrayToString(feld));

		String[] ee = "sdd".split(" ");
	}

	private int[] changeArrayType(String[] value) {
		int[] result = new int[value.length+1];
		try {
			for (int i = 0; i < value.length; i++) {
				result[i+1] = Integer.parseInt(value[i]);
			}
		} catch (NumberFormatException exception) {
			return null;
		}
		return result;
	}

	private String arrayToString(int[] value) {
		StringBuilder output = new StringBuilder();
		for (int i = 1; i < value.length; i++) {
			output.append(value[i]).append(" ");
		}
		return output.toString();
	}
}
