/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_contabil;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.image.Image;

/**
 * FXML Controller class
 *
 * @author danie
 */
public class DateController implements Initializable {

    @FXML
    DatePicker date;
    
     @FXML
    private void pick_a_date(ActionEvent e) {
        LocalDate dates = date.getValue();
        System.out.println("Selected date: " + date);
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
