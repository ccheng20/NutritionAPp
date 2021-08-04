import javax.swing.JFrame;

public class main {

	public static void main(String[] args) {
		
		NutritionView displayWindow = new NutritionView();
	
        //Set some default values and actions
		displayWindow.setTitle("Generic Tower Defense Game");
		displayWindow.setSize(600, 600);
		displayWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //We have to make the JFrame visible. Why?
		displayWindow.setVisible(true);
	}

}
