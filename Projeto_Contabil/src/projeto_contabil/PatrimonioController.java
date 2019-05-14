/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_contabil;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author danie
 */
public class PatrimonioController implements Initializable {

    @FXML
    Button add_pat, add_sal1;

    @FXML
    TextField text_pat;

    @FXML
    private ComboBox<Cliente> client_box, client_box1;
    private ObservableList<Cliente> cliente_box = FXCollections.observableArrayList();

    @FXML
    private void button_add_pat(ActionEvent e) throws IOException {

        if (client_box1.getSelectionModel().getSelectedItem() == null) {
            Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
            dialogoErro.setTitle("ERROR!");
            dialogoErro.setHeaderText("Erro na seleção do cliente...");
            dialogoErro.setContentText("Favor selecionar um cliente para continuar!");
            dialogoErro.showAndWait();
        } else {

            String pat = text_pat.getText();

            boolean erro_atualizacao_patrimonio = true;

            File f = new File("Cliente.txt");

            f.delete();
            f.createNewFile();
            for (Cliente cliente : cliente_box) {
                if (cliente.equals(client_box1.getSelectionModel().getSelectedItem())) {
                    cliente.setSaldo(String.valueOf(Float.parseFloat(cliente.getSaldo()) + Float.parseFloat(pat)));
                }
                String texto = cliente.proArquivo();

                boolean x = Auxiliar.escrever_arquivo(texto, "Cliente.txt", true);

                if (x == false) {
                    erro_atualizacao_patrimonio = false;
                }
            }

            if (!erro_atualizacao_patrimonio) {
                Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
                dialogoInfo.setTitle("ATENÇÃO");
                dialogoInfo.setHeaderText("Patrimônio");
                dialogoInfo.setContentText("Patrimônio não atualizado com sucesso!");
                dialogoInfo.showAndWait();
                text_pat.setText("");

            } else {
                Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
                dialogoInfo.setTitle("ATENÇÃO");
                dialogoInfo.setHeaderText("Patrimônio");
                dialogoInfo.setContentText("Patrimônio atualizado com sucesso!");
                dialogoInfo.showAndWait();
            }
        }

    }
    
    @FXML
    private void button_add_sal (ActionEvent e) throws IOException{
        if (client_box1.getSelectionModel().getSelectedItem() == null) {
            Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
            dialogoErro.setTitle("ERROR!");
            dialogoErro.setHeaderText("Erro na seleção do cliente...");
            dialogoErro.setContentText("Favor selecionar um cliente para continuar!");
            dialogoErro.showAndWait();
        } else {

            String pat = text_pat.getText();

            boolean erro_atualizacao_patrimonio = true;

            File f = new File("Cliente.txt");

            f.delete();
            f.createNewFile();
            for (Cliente cliente : cliente_box) {
                if (cliente.equals(client_box1.getSelectionModel().getSelectedItem())) {
                    cliente.setSalario(String.valueOf( Float.parseFloat(pat)));
                }
                String texto = cliente.proArquivo();

                boolean x = Auxiliar.escrever_arquivo(texto, "Cliente.txt", true);

                if (x == false) {
                    erro_atualizacao_patrimonio = false;
                }
            }

            if (!erro_atualizacao_patrimonio) {
                Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
                dialogoInfo.setTitle("ATENÇÃO");
                dialogoInfo.setHeaderText("Patrimônio");
                dialogoInfo.setContentText("Salário não atualizado com sucesso!");
                dialogoInfo.showAndWait();
                text_pat.setText("");

            } else {
                Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
                dialogoInfo.setTitle("ATENÇÃO");
                dialogoInfo.setHeaderText("Patrimônio");
                dialogoInfo.setContentText("Salário atualizado com sucesso!");
                dialogoInfo.showAndWait();
                text_pat.setText("");
            }
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ArrayList<String> linhas = Auxiliar.ler_arquivo("Cliente.txt");

        for (String linha : linhas) {
            String[] v = linha.split(";");

            Cliente c = new Cliente(v[0], v[1], v[2], v[3], v[4]);

            cliente_box.add(c);
        }

        client_box1.setItems(cliente_box);

    }

}
