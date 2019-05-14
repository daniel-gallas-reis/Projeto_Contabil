/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_contabil;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 05180176
 */
public class FXMLRegisterInController implements Initializable {

    @FXML
    TextField NewUser;
    @FXML
    PasswordField NewPassword, Confirm;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void FuncaoCreateUser(ActionEvent e) {
        if ((NewPassword.getText().length() >= 10)
                && (NewUser.getText().length() >= 8)) {
            if (NewUser.getText().isEmpty()) {
                Alert dialogo = new Alert(Alert.AlertType.WARNING, "O campo de Usuário deve ser Preenchido!");
                dialogo.showAndWait();
            } else if (NewPassword.getText().isEmpty() || Confirm.getText().isEmpty()) {
                Alert dialogo = new Alert(Alert.AlertType.WARNING, "Os campos de Senhas devem ser Preenchidos!");
                dialogo.showAndWait();
            } else if (!Confirm.getText().equals(NewPassword.getText())) {
                Alert dialogo = new Alert(Alert.AlertType.WARNING, "As Senhas devem ser Iguais!");
                dialogo.showAndWait();
            } else {
                // String senha = hash(NewPassword.getText());
                Stage stage1 = (Stage) ((Node) e.getSource()).getScene().getWindow();
                stage1.close();
                try {
                    Auxiliar.gravar_usuario(new File("usuarios.txt"), new Usuario(NewUser.getText(), Auxiliar.hash(Confirm.getText())));
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML_Login.fxml"));
                    Parent root = loader.load();
                    FXML_LoginController controladorLogin = loader.getController();

                    controladorLogin.setUsuario(NewUser.getText(), Auxiliar.hash(NewPassword.getText()));
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();

                    stage.setOnCloseRequest(ee -> {
                        stage.hide();
                    });
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } else {
            Alert dialogo = new Alert(Alert.AlertType.WARNING, "Requisitos de Segurança não Atingidos!");
            dialogo.showAndWait();
        }
    }

    @FXML
    private void FuncaoVoltar(ActionEvent e) {
        Stage stage1 = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage1.hide();
        try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("FXML_Login.fxml"));

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setOnCloseRequest(ee -> {
                stage.hide();
            });
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
