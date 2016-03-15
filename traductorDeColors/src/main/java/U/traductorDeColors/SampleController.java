package U.traductorDeColors;

import javafx.fxml.FXML;

import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.control.ChoiceBox;

public class SampleController {
	@FXML
	private ChoiceBox choiceIdioma;
	@FXML
	private TextField color;
	@FXML
	private Label lidioma1;
	@FXML
	private Label lidioma2;
	@FXML
	private Label lidioma3;
	@FXML
	private TextField icolor1;
	@FXML
	private TextField icolor2;
	@FXML
	private TextField icolor3;

	// Event Listener on Button.onAction
	@FXML
	public void cercar(ActionEvent event) {
		Connection conect = null;
    	
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conect = DriverManager.getConnection("jdbc:mysql://192.168.4.1/traductor", "foot", "ball");
			
			String demanat = color.getText(); 
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
