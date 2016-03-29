package U.traductorDeColors;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.control.ComboBox;

public class SampleController implements Initializable {
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
	private ComboBox<String> comoIdioma;

	// Event Listener on Button.onAction
	@FXML
	public void cercar(ActionEvent event) {
Connection conect = null;
    	
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conect = DriverManager.getConnection("jdbc:mysql://192.168.4.1/traductor", "foot", "ball");
			
			
			
			
			String demanat = color.getText();
			String idioma = "";
			
			switch(comoIdioma.getValue().toString()){
			case "Català":
				idioma = "nom";
				lidioma1.setText("Castellà");
				lidioma2.setText("Francès");
				lidioma3.setText("Anglès");
				break;
			case "Castellà":
				idioma = "castella";
				lidioma1.setText("Català");
				lidioma2.setText("Francès");
				lidioma3.setText("Anglès");
				break;
			case "Francès":
				idioma = "frances";
				lidioma1.setText("Català");
				lidioma2.setText("Castellà");
				lidioma3.setText("Anglès");
				break;
			case "Anglès":
				idioma = "angles";
				lidioma1.setText("Català");
				lidioma2.setText("Castellà");
				lidioma3.setText("Francès");
				break;
			}
			
			
			String consulta = "SELECT angles, castella, nom, frances FROM colors WHERE"+idioma+"="+demanat+";";
			
			Statement peticio = conect.createStatement();
			
			ResultSet resultat = peticio.executeQuery(consulta);
			
			// Así cojo el color que quiero resultat.getString("angles");
			switch(idioma){
			case "nom":
				
				break;
			case "castella":
				
				break;
			case "frances":
				
				break;
			case "angles":
				
				break;
			}
			
			//Poner el color de los idiomas que tocan en los text field
			
			
			
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		comoIdioma.getItems().addAll("Català","Castellà","Francès","Anglès");
		comoIdioma.setValue("Català");
		
	}
}