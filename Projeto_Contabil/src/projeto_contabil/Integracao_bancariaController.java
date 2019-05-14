/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_contabil;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author danie
 */
public class Integracao_bancariaController implements Initializable {

    
    @FXML
    Button ofx;
    
    @FXML
    public void action_ofx(ActionEvent e){
        Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
            dialogoInfo.setTitle("ATENÇÃO");
            dialogoInfo.setHeaderText("OFX IMPORT");
            dialogoInfo.setContentText("Recurso temporariamente indisponível!");
            dialogoInfo.showAndWait();
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
