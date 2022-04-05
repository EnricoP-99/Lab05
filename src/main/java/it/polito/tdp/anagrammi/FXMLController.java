package it.polito.tdp.anagrammi;

import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.Model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class FXMLController {

	private Model model;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCalcolaAnagrammi;

    @FXML
    private Button btnReset;

    @FXML
    private TextArea txtAnagrammiCorretti;

    @FXML
    private TextArea txtAnagrammiErrati;

    @FXML
    private TextField txtParola;

    @FXML
    void DoAnagrammi(ActionEvent event) {
    	String s = txtParola.getText();
    	for(String p : this.model.anagramma(s))
    	{
    		if(this.model.getTuttiVocaboli().contains(p))
    		{
    			txtAnagrammiCorretti.appendText(p);
    		}
    		else
    		{
    			txtAnagrammiErrati.appendText(p);
    		}
    	}
    	//txtAnagrammiCorretti.setText(this.model.anagramma(s));
    	
    }

    @FXML
    void DoReset(ActionEvent event) {

    }
    
    public void setModel(Model model)
    {
    	this.model = model;
    }

    @FXML
    void initialize() {
        assert btnCalcolaAnagrammi != null : "fx:id=\"btnCalcolaAnagrammi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAnagrammiCorretti != null : "fx:id=\"txtAnagrammiCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAnagrammiErrati != null : "fx:id=\"txtAnagrammiErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";

    }

}
