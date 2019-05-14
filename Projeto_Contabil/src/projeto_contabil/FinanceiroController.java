/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_contabil;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import static projeto_contabil.Auxiliar.ler_arquivo_binario;

/**
 * FXML Controller class
 *
 * @author danie
 */
public class FinanceiroController implements Initializable {

    @FXML
    PieChart grafpizza;

    @FXML
    Button gerar;

    @FXML
    private ComboBox<Cliente> client_box1;
    private ObservableList<Cliente> cliente_box = FXCollections.observableArrayList();

    public void action_gerar(ActionEvent e) {
        if (client_box1.getSelectionModel().getSelectedItem() == null) {
            Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
            dialogoErro.setTitle("ERROR!");
            dialogoErro.setHeaderText("Erro na seleção do cliente...");
            dialogoErro.setContentText("Favor selecionar um cliente para continuar!");
            dialogoErro.showAndWait();
        } else {
            
            Cliente cli = client_box1.getSelectionModel().getSelectedItem();
            ArrayList<Saida> saidas = ler_arquivo_binario("saidas.bin");

            grafpizza.setTitle(cli.getNome());
            grafpizza.getData().add(new PieChart.Data("Saldo R$" + cli.saldo, Double.parseDouble(cli.getSaldo())));
            for (Saida saida : saidas) {
                if (saida.getCliente().equals(cli)) {
                    grafpizza.getData().add(new PieChart.Data(saida.getTipo() + " R$" + saida.getValor(), saida.getValor()));
                }

            }
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        
        ArrayList<String> linhas = Auxiliar.ler_arquivo("Cliente.txt");
        for (String linha : linhas) {
            String[] v = linha.split(";");

            Cliente c = new Cliente(v[0], v[1], v[2], v[3], v[4]);

            cliente_box.add(c);

        }
        client_box1.setItems(cliente_box);

    }
}
