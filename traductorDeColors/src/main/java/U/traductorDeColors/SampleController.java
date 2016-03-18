package U.traductorDeColors;

import javafx.fxml.FXML;

import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.control.ComboBox;

public class SampleController {
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
	@FXML
	private ComboBox comoIdioma;

	// Event Listener on Button.onAction
	@FXML
	public void cercar(ActionEvent event) {
Connection conect = null;
    	
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conect = DriverManager.getConnection("jdbc:mysql://192.168.4.1/traductor", "foot", "ball");
			
			comoIdioma.getItems().addAll("Català","Castellà","Francés","Angles");
			
			
			String demanat = color.getText();
			String idioma = "";
			
			switch(comoIdioma.getValue().toString()){
			case "Català":
				idioma = "nom";
				break;
			case "Castellà":
				idioma = "castella";
				break;
			case "Francés":
				idioma = "frances";
				break;
			case "Angles":
				idioma = "angles";
				break;
			}
			
			
			String consulta = "SELECT angles, castella, nom, frances FROM colors WHERE"+idioma+"="+demanat+";";
			
			//Descartar el color del idioma introducido, poner idiomas en los labels y color de ese idioma en
			//los textFields
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
