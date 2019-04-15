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
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

/**
 * FXML Controller class
 *
 * @author danie
 */
public class ClientController implements Initializable {

    @FXML
    Button cadastro, remove;

    @FXML
    private void press_cadastro(ActionEvent e) {
        Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
        dialogoInfo.setTitle("ATENÇÃO");
        dialogoInfo.setHeaderText("Cadastro");
        dialogoInfo.setContentText("Cliente cadastrado com sucesso!");
        dialogoInfo.showAndWait();
    }

    String Exc;

    @FXML
    private void press_remove(ActionEvent e) {
        Alert dialogoExe = new Alert(Alert.AlertType.CONFIRMATION);
        ButtonType btnDelete = new ButtonType("Excluir");
        ButtonType btnCancelar = new ButtonType("Cancelar", ButtonBar.ButtonData.CANCEL_CLOSE);
        dialogoExe.setTitle("ATENÇÃO!");
        dialogoExe.setHeaderText("Remover Cliente");
        dialogoExe.setContentText("Deseja mesmo excluir esse cliente do cadastro?");
        dialogoExe.getButtonTypes().setAll(btnDelete, btnCancelar);
        dialogoExe.showAndWait().ifPresent(b -> {
            if (b == btnDelete) {
                Exc = "Excluindo...";
            } else {
                Exc = "Cancelando operação.";
            }
        });
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
