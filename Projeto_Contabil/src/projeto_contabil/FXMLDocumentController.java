/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_contabil;

import static com.sun.deploy.util.ReflectionUtil.getClass;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import static jdk.nashorn.internal.objects.NativeDebug.getClass;
import static sun.security.x509.OIDMap.getClass;

/**
 *
 * @author danie
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    AnchorPane painel0, painel1, painel2;
    
    @FXML
    ScrollPane painel3;
    
    @FXML
    Label label;
    
    @FXML
    Button financeiro, cliente, saidas, entradas; 
    
    @FXML
    ComboBox<ferramenta> ferramentas;
    
    private ObservableList<ferramenta> mytoolsData;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @FXML
    private void finance_button(ActionEvent e){
        System.out.println("you clicked me");
    }
    
    @FXML
    private void client_button(ActionEvent e){
        System.out.println("you clicked me");
    }
    
    @FXML
    private void in_button(ActionEvent e){
        System.out.println("you clicked me");
    }
    
    @FXML
    private void out_button(ActionEvent e){
        System.out.println("you clicked me");
    }
    
    
    @FXML
    private void ferramentas_menu(ActionEvent e){
        ferramenta selecionada = ferramentas.getSelectionModel().getSelectedItem();
        
        System.out.println(selecionada.getTool());
        if (selecionada.getTool().equals("Calculadora")) {
            try{
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Vista.fxml"));
                Parent root = loader.load();
                
                Scene scene = new Scene(root);
                Stage stage1 = new Stage();
                stage1.setScene(scene);
                stage1.show();
            }
            catch(IOException ex){
                System.err.println("Erro ao abrir janela!");
                ex.printStackTrace();
            }
        }
         if (selecionada.getTool().equals("Calendário")) {
            try{
                FXMLLoader loader = new FXMLLoader(getClass().getResource("date.fxml"));
                Parent root = loader.load();
                
                Scene scene = new Scene(root);
                Stage stage1 = new Stage();
                stage1.setScene(scene);
                stage1.show();
            }
            catch(IOException ex){
                System.err.println("Erro ao abrir janela!");
                ex.printStackTrace();
            }
        }
    }
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mytoolsData = FXCollections.observableArrayList();
        mytoolsData.add(new ferramenta ("Calculadora"));
        mytoolsData.add(new ferramenta ("Calendário"));
        
        ferramentas.setItems(mytoolsData);
    }    
    
}
