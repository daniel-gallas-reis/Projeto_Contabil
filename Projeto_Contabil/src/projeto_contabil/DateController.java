/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_contabil;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author danie
 */
public class DateController implements Initializable {

    @FXML
    DatePicker date;

    @FXML
    Button lembrete;

    @FXML
    private void pick_a_date(ActionEvent e) {
        LocalDate dates = date.getValue();
        System.out.println("Selected date: " + date);
    }

    String lembre;

    @FXML
    private void press_lembrete(ActionEvent e) throws IOException {
    
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml_tableview.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage1 = new Stage();
            stage1.setScene(scene);
            stage1.show();
        } catch (IOException ex) {
            System.err.println("Erro ao abrir janela!");
            ex.printStackTrace();
        }
        
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
