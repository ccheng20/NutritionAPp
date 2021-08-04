import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import org.json.simple.parser.ParseException;

public class VegeComboBox extends JComboBox<String>{
	private JComboBox comboBoxVege;
	private ReadVegesData vegeData;
	private JPanel AddFoodpanel;

	public VegeComboBox(JPanel AddFoodpanel) {
		this.AddFoodpanel = AddFoodpanel;
//		comboBoxVege = new JComboBox();
//		try {
//			vegeData = new ReadVegesData();
//		} catch (IOException | ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		comboBoxVege.setModel(new DefaultComboBoxModel(vegeData.getNames()));
	}
	
	public void VegeCombo() {
		comboBoxVege = new JComboBox();
		try {
			vegeData = new ReadVegesData();
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		comboBoxVege.setModel(new DefaultComboBoxModel(vegeData.getNames()));
		comboBoxVege.setBounds(53, 56, 102, 27);
		AddFoodpanel.add(comboBoxVege);
	}

	public JComboBox getComboBoxVege() {
		return comboBoxVege;
	}

	
}
