/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_contabil;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 05180176
 */
public class FXML_LoginController implements Initializable {

    @FXML
    TextField User;

    @FXML
    PasswordField Password;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {


        Password.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                faz_login();
            }
        });

        User.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                faz_login();
            }
        });

        Platform.runLater(() -> User.requestFocus());

    }

    String b;

    @FXML
    public void FuncaoCheck(ActionEvent e) {
        faz_login();
    }

    void setUsuario(String login, String senha) {
        User.setText(login);
        Password.setText(senha);
    }

    private void faz_login() {
        if (User.getText().isEmpty() || Password.getText().isEmpty()) {
            Alert dialogo = new Alert(Alert.AlertType.WARNING, "Campos Importantes estão em Branco!");
            dialogo.showAndWait();
        } else {
            try {
                Usuario user = new Usuario(User.getText(), Auxiliar.hash(Password.getText()));
                ArrayList<Usuario> users = Auxiliar.ler_usuarios(new File("usuarios.txt"));
                if (!users.contains(user)) {
                    Alert dialogo = new Alert(Alert.AlertType.WARNING, "Usuário Inexistente!");
                    dialogo.showAndWait();
                    Parent root;

                    root = FXMLLoader.load(getClass().getResource("FXML_Login.fxml"));

                    Scene scene = new Scene(root);
                    Stage stage = new Stage();

                    stage.setOnCloseRequest(ee -> {
                        stage.hide();
                    });
                    stage.setScene(scene);
                    stage.setTitle("Register In");
                    stage.show();
                }
                Stage stage1 = (Stage) ((Node) Password).getScene().getWindow();
                stage1.close();
                if (users.contains(user)) {
                    b = User.getText();
                    Parent root;

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
                    root = loader.load();

                    Scene scene = new Scene(root);
                    Stage stage = new Stage();

                    stage.setOnCloseRequest(ee -> {
                        stage.hide();
                    });
                    stage.setScene(scene);
                    //stage.setFullScreen(true);
                    stage.setResizable(true);
                    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                    stage.setHeight(screenSize.getHeight() - 30);
                    stage.setWidth(screenSize.getWidth() - 30);
                    FXMLDocumentController control = loader.getController();

                    control.setUser(b);

                    scene.widthProperty().addListener((ObservableValue<? extends Number> observableValue, Number oldSceneWidth, Number newSceneWidth) -> {
                        control.painel0.setPrefWidth(newSceneWidth.doubleValue());
                        control.painel1.setPrefWidth(newSceneWidth.doubleValue());
                        control.painel2.setPrefWidth(newSceneWidth.doubleValue());
                        control.painel3.setPrefWidth(newSceneWidth.doubleValue());
                        System.out.println("Width: " + newSceneWidth);
                    });
                    scene.heightProperty().addListener((ObservableValue<? extends Number> observableValue, Number oldSceneHeight, Number newSceneHeight) -> {
                        System.out.println("Height: " + newSceneHeight);
                        control.painel0.setPrefHeight(newSceneHeight.doubleValue());
                        control.painel1.setPrefHeight(newSceneHeight.doubleValue());
                        control.painel2.setPrefHeight(newSceneHeight.doubleValue());
                        control.painel3.setPrefHeight(newSceneHeight.doubleValue());

                    });
                    stage.setTitle("Engenharia Contábil");
                    stage.show();
                }
            } catch (IOException ex) {
                ex.printStackTrace();

            }
        }
    }

}
