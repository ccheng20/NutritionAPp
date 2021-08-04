import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.SystemColor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.border.MatteBorder;

import org.json.simple.parser.ParseException;

import java.util.Arrays;
import java.util.List;

import javax.swing.border.BevelBorder;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;
import java.awt.ScrollPane;
import java.awt.Point;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class NutritionView extends JFrame{
	
	private JTextField textField_name;
	private JTextField textField_Age;
	private JTextField textField_Height;
	private JTextField textField_weight;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblShowDate;
	private ReadVegesData vegeData;
	
	public NutritionView() {
		getContentPane().setLayout(null);
		
		JPanel UserInfoPanel = new JPanel();
		UserInfoPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		UserInfoPanel.setBackground(SystemColor.activeCaption);
		UserInfoPanel.setBounds(6, 6, 190, 123);
		getContentPane().add(UserInfoPanel);
		UserInfoPanel.setLayout(null);
		
		JLabel nameLabel = new JLabel("Name:");
		nameLabel.setBounds(6, 11, 61, 16);
		UserInfoPanel.add(nameLabel);
		
		JLabel AgeLabel = new JLabel("Age:");
		AgeLabel.setBounds(6, 39, 61, 16);
		UserInfoPanel.add(AgeLabel);
		
		JLabel HeightLabel = new JLabel("Height:");
		HeightLabel.setBounds(6, 67, 61, 16);
		UserInfoPanel.add(HeightLabel);
		
		textField_Height = new JTextField();
		textField_Height.setBounds(53, 62, 130, 26);
		UserInfoPanel.add(textField_Height);
		textField_Height.setColumns(10);
		
		textField_Age = new JTextField();
		textField_Age.setBounds(53, 34, 130, 26);
		UserInfoPanel.add(textField_Age);
		textField_Age.setColumns(10);
		
		textField_name = new JTextField();
		textField_name.setBounds(53, 6, 130, 26);
		UserInfoPanel.add(textField_name);
		textField_name.setColumns(10);
		
		JLabel lblWeight = new JLabel("Weight:");
		lblWeight.setBounds(6, 95, 61, 16);
		UserInfoPanel.add(lblWeight);
		
		textField_weight = new JTextField();
		textField_weight.setColumns(10);
		textField_weight.setBounds(53, 90, 130, 26);
		UserInfoPanel.add(textField_weight);
		
		JPanel UserInfoPanel_1 = new JPanel();
		UserInfoPanel_1.setLayout(null);
		UserInfoPanel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		UserInfoPanel_1.setBackground(Color.WHITE);
		UserInfoPanel_1.setBounds(456, 6, 190, 123);
		getContentPane().add(UserInfoPanel_1);
		
		JLabel lblDailyCaloryGoal = new JLabel("daily calory goal:");
		lblDailyCaloryGoal.setBounds(6, 11, 116, 16);
		UserInfoPanel_1.add(lblDailyCaloryGoal);
		
		JLabel lblDailyProteinGoal = new JLabel("daily protein goal:");
		lblDailyProteinGoal.setBounds(6, 39, 116, 16);
		UserInfoPanel_1.add(lblDailyProteinGoal);
		
		JLabel lblDailyCarbGoal = new JLabel("daily carb goal:");
		lblDailyCarbGoal.setBounds(6, 67, 116, 16);
		UserInfoPanel_1.add(lblDailyCarbGoal);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(122, 62, 61, 26);
		UserInfoPanel_1.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(122, 34, 61, 26);
		UserInfoPanel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(122, 6, 61, 26);
		UserInfoPanel_1.add(textField_2);
		
		JLabel lblDailyFatGoal = new JLabel("daily fat goal:");
		lblDailyFatGoal.setBounds(6, 95, 116, 16);
		UserInfoPanel_1.add(lblDailyFatGoal);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(122, 90, 61, 26);
		UserInfoPanel_1.add(textField_3);
		
		JPanel NutritionInfo = new JPanel();
		NutritionInfo.setBackground(SystemColor.activeCaption);
		NutritionInfo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		NutritionInfo.setBounds(208, 6, 236, 123);
		getContentPane().add(NutritionInfo);
		NutritionInfo.setLayout(null);
		
		lblShowDate = dateDisplay();
		NutritionInfo.add(lblShowDate);
		
		JLabel lblCalory = new JLabel("Calories : ");
		lblCalory.setBounds(6, 33, 133, 16);
		NutritionInfo.add(lblCalory);
		
		JLabel lblProtein = new JLabel("Protein :");
		lblProtein.setBounds(6, 57, 133, 16);
		NutritionInfo.add(lblProtein);
		
		JLabel lblCarb = new JLabel("Carb :");
		lblCarb.setBounds(6, 78, 133, 16);
		NutritionInfo.add(lblCarb);
		
		JLabel lblFat = new JLabel("fat :");
		lblFat.setBounds(6, 100, 133, 16);
		NutritionInfo.add(lblFat);
		
		JPanel AddFoodpanel = new JPanel();
		AddFoodpanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		AddFoodpanel.setBounds(6, 141, 203, 226);
		getContentPane().add(AddFoodpanel);
		AddFoodpanel.setLayout(null);
		
//		JComboBox comboBoxVege = new JComboBox();
//		comboBoxVege.setModel(new DefaultComboBoxModel(new String[] {"tomato", "potato", "brocolli"}));
//		comboBoxVege.setBounds(53, 56, 102, 27);
		
		JComboBox vb1 = vegeBox(53, 56, 102, 27);
		AddFoodpanel.add(vb1);
		
		JLabel lblSelectVeges = new JLabel("Select your vegetables");
		lblSelectVeges.setBounds(32, 34, 163, 16);
		AddFoodpanel.add(lblSelectVeges);
		
		
		JComboBox vb2 = vegeBox(53, 117, 102, 27);
		AddFoodpanel.add(vb2);
		
		JLabel lblSelectYourMeat = new JLabel("Select your meat");
		lblSelectYourMeat.setBounds(53, 95, 163, 16);
		AddFoodpanel.add(lblSelectYourMeat);
		
		JLabel lblNewLabel = new JLabel("Breakfast");
		lblNewLabel.setBounds(75, 6, 61, 16);
		AddFoodpanel.add(lblNewLabel);
		
		JLabel lblSelectYourMeat_1 = new JLabel("Select your main food");
		lblSelectYourMeat_1.setBounds(32, 156, 163, 16);
		AddFoodpanel.add(lblSelectYourMeat_1);
		
		JComboBox vb3 = vegeBox(53, 180, 102, 27);
		AddFoodpanel.add(vb3);
		
		JPanel AddFoodpanel_1 = new JPanel();
		AddFoodpanel_1.setLayout(null);
		AddFoodpanel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		AddFoodpanel_1.setBounds(224, 141, 203, 226);
		getContentPane().add(AddFoodpanel_1);
		
		JComboBox comboBoxVege_2 = new JComboBox();
		comboBoxVege_2.setBounds(53, 56, 102, 27);
		AddFoodpanel_1.add(comboBoxVege_2);
		
		JLabel lblSelectVeges_1 = new JLabel("Select your vegetables");
		lblSelectVeges_1.setBounds(32, 34, 163, 16);
		AddFoodpanel_1.add(lblSelectVeges_1);
		
		JComboBox comboBoxVege_1_2 = new JComboBox();
		comboBoxVege_1_2.setBounds(53, 117, 102, 27);
		AddFoodpanel_1.add(comboBoxVege_1_2);
		
		JLabel lblSelectYourMeat_2 = new JLabel("Select your meat");
		lblSelectYourMeat_2.setBounds(53, 95, 163, 16);
		AddFoodpanel_1.add(lblSelectYourMeat_2);
		
		JLabel lblNewLabel_1 = new JLabel("Breakfast");
		lblNewLabel_1.setBounds(75, 6, 61, 16);
		AddFoodpanel_1.add(lblNewLabel_1);
		
		JLabel lblSelectYourMeat_1_1 = new JLabel("Select your main food");
		lblSelectYourMeat_1_1.setBounds(32, 156, 163, 16);
		AddFoodpanel_1.add(lblSelectYourMeat_1_1);
		
		JComboBox comboBoxVege_1_1_1 = new JComboBox();
		comboBoxVege_1_1_1.setBounds(53, 180, 102, 27);
		AddFoodpanel_1.add(comboBoxVege_1_1_1);
		
		JPanel AddFoodpanel_2 = new JPanel();
		AddFoodpanel_2.setLayout(null);
		AddFoodpanel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		AddFoodpanel_2.setBounds(443, 141, 203, 226);
		getContentPane().add(AddFoodpanel_2);
		
		JComboBox comboBoxVege_3 = new JComboBox();
		comboBoxVege_3.setBounds(53, 56, 102, 27);
		AddFoodpanel_2.add(comboBoxVege_3);
		
		JLabel lblSelectVeges_2 = new JLabel("Select your vegetables");
		lblSelectVeges_2.setBounds(32, 34, 163, 16);
		AddFoodpanel_2.add(lblSelectVeges_2);
		
		JComboBox comboBoxVege_1_3 = new JComboBox();
		comboBoxVege_1_3.setBounds(53, 117, 102, 27);
		AddFoodpanel_2.add(comboBoxVege_1_3);
		
		JLabel lblSelectYourMeat_3 = new JLabel("Select your meat");
		lblSelectYourMeat_3.setBounds(53, 95, 163, 16);
		AddFoodpanel_2.add(lblSelectYourMeat_3);
		
		JLabel lblNewLabel_2 = new JLabel("Breakfast");
		lblNewLabel_2.setBounds(75, 6, 61, 16);
		AddFoodpanel_2.add(lblNewLabel_2);
		
		JLabel lblSelectYourMeat_1_2 = new JLabel("Select your main food");
		lblSelectYourMeat_1_2.setBounds(32, 156, 163, 16);
		AddFoodpanel_2.add(lblSelectYourMeat_1_2);
		
		JComboBox comboBoxVege_1_1_2 = new JComboBox();
		comboBoxVege_1_1_2.setBounds(53, 180, 102, 27);
		AddFoodpanel_2.add(comboBoxVege_1_1_2);
		

	
		



	}
	
	private JComboBox vegeBox(int a, int b, int c, int d) {
		JComboBox comboBoxVege1 = new JComboBox();
		try {
			vegeData = new ReadVegesData();
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		comboBoxVege1.setModel(new DefaultComboBoxModel(vegeData.getNames()));
		comboBoxVege1.setBounds(a, b, c, d);
		return comboBoxVege1;
	}
	
	private JLabel dateDisplay() {
		String[] days = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
		String[] months = new String[] {"January", "February", "March", "April", "May", "June", "July", "August","September", "October", "November", "December" };
		Calendar cal = new GregorianCalendar();
		String day = days[cal.get(Calendar.DAY_OF_WEEK) - 1];
		int date = cal.get(Calendar.DATE);
		String month = months[cal.get(Calendar.MONTH) - 1];
		int year = cal.get(Calendar.YEAR);
		lblShowDate = new JLabel("Today is: " + day + ", " + month + " " + date + ", " + year);
		lblShowDate.setBounds(6, 6, 224, 16);
		return lblShowDate;
	}
}
