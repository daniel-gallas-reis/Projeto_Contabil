/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_contabil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author danie
 */
public class ClientController implements Initializable {

    Cliente cliente1;

    @FXML
    Button cadastro, remove, find;

    @FXML
    TextArea area;

    @FXML
    TextField client_nome, client_idade, client_saldo, client_salario,
            client_cpf, edit_name, edit_age, edit_money, edit_salary;

    @FXML
    private ComboBox<Cliente> client_box, client_box1, box_cliente_edit;
    private ObservableList<Cliente> cliente_box = FXCollections.observableArrayList();
    private ArrayList<Saida> saidas;

    @FXML
    private void press_cadastro(ActionEvent e) throws FileNotFoundException, IOException {
        try {
            Path Cliente_caminho = new File("Cliente.txt").toPath();
        } catch (Exception exception) {
            File Cliente = new File("Cliente.txt");
        }

        cliente1 = new Cliente();

        cliente1.setNome(client_nome.getText());
        cliente1.setIdade(client_idade.getText());
        cliente1.setSaldo(client_saldo.getText());
        cliente1.setSalario(client_salario.getText());
        cliente1.setCpf(client_cpf.getText());

        String texto = cliente1.proArquivo();

        if (Auxiliar.escrever_arquivo(texto, "Cliente.txt", true)) {
            cliente_box.add(cliente1);
            Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
            dialogoInfo.setTitle("ATENÇÃO");
            dialogoInfo.setHeaderText("Cadastro");
            dialogoInfo.setContentText("Cliente cadastrado com sucesso!");
            dialogoInfo.showAndWait();
            client_nome.setText("");
            client_idade.setText("");
            client_saldo.setText("");
            client_salario.setText("");
            client_cpf.setText("");
        } else {
            Alert dialogoInfo = new Alert(Alert.AlertType.ERROR);
            dialogoInfo.setTitle("ATENÇÃO");
            dialogoInfo.setHeaderText("Cadastro");
            dialogoInfo.setContentText("Cliente não cadastrado com sucesso!");
            dialogoInfo.showAndWait();
            client_nome.setText("");
            client_idade.setText("");
            client_saldo.setText("");
            client_salario.setText("");
            client_cpf.setText("");
        }

    }

    String Exc;

    @FXML
    private void press_remove(ActionEvent e) {
        Cliente cliente_a_ser_removido = client_box.getSelectionModel().getSelectedItem();

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
                cliente_box.remove(client_box1.getSelectionModel().getSelectedItem());
                for (Cliente cliente : cliente_box) {
                    Auxiliar.escrever_arquivo(cliente.proArquivo(), "Cliente.txt", false);
                }
                for (Iterator<Saida> iterator = saidas.iterator(); iterator.hasNext();) {
                    Saida s = iterator.next();

                    if (s.getCliente().getNome().equals(cliente_a_ser_removido.getNome())) {
                        iterator.remove();
                    }
                }
                Auxiliar.escrever_arquivo_binario(saidas, "saidas.bin", false);
            } else {
                Exc = "Cancelando operação.";
            }
        });
    }

    @FXML
    private void find_client(ActionEvent e) {
        area.setText(client_box.getSelectionModel().getSelectedItem().proInfo() + System.lineSeparator());
        for (Saida s : saidas) {
            if (s.getCliente().getNome().equals(client_box.getSelectionModel().getSelectedItem().getNome())) {
                area.appendText(s.toString());
            }
        }

    }

    @FXML
    private void altsave(ActionEvent e) throws IOException {

        if (box_cliente_edit.getSelectionModel().getSelectedItem() == null) {
            Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
            dialogoErro.setTitle("ERROR!");
            dialogoErro.setHeaderText("Erro na seleção do cliente...");
            dialogoErro.setContentText("Favor selecionar um cliente para continuar!");
            dialogoErro.showAndWait();
        } else {
            String name = edit_name.getText();
            String age = edit_age.getText();
            String money = edit_money.getText();
            String salary = edit_salary.getText();

            boolean erro_atualizacao_patrimonio = true;

            File f = new File("Cliente.txt");

            f.delete();
            f.createNewFile();
            for (Cliente cliente : cliente_box) {
                if (cliente.equals(box_cliente_edit.getSelectionModel().getSelectedItem())) {
                    if(!name.isEmpty()){
                    cliente.setNome(name);
                    }
                    if(!age.isEmpty()){
                    cliente.setIdade(age);
                    }
                    if(!money.isEmpty()){
                    cliente.setSaldo(money);
                    }
                    if(!salary.isEmpty()){
                    cliente.setSalario(salary);
                    }
                }
                String texto = cliente.proArquivo();

                boolean x = Auxiliar.escrever_arquivo(texto, "Cliente.txt", true);

                if (x == false) {
                    erro_atualizacao_patrimonio = false;
                }
                for (Saida saida : saidas) {
                    if (saida.getCliente().equals(cliente)) {
                        saida.setCliente(cliente);
                    }
                }
            }
            Auxiliar.escrever_arquivo_binario(saidas, "saidas.bin", false);

            if (!erro_atualizacao_patrimonio) {
                Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
                dialogoInfo.setTitle("ATENÇÃO");
                dialogoInfo.setHeaderText("Alteração em Clientes");
                dialogoInfo.setContentText("Cliente não atualizado com sucesso!");
                dialogoInfo.showAndWait();
                edit_name.setText("");
                edit_age.setText("");
                edit_money.setText("");
                edit_salary.setText("");

            } else {
                Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
                dialogoInfo.setTitle("ATENÇÃO");
                dialogoInfo.setHeaderText("Alteração em Clientes");
                dialogoInfo.setContentText("Cliente atualizado com sucesso!");
                dialogoInfo.showAndWait();
                edit_name.setText("");
                edit_age.setText("");
                edit_money.setText("");
                edit_salary.setText("");
            }
        }

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        saidas = Auxiliar.ler_arquivo_binario("saidas.bin");
        ArrayList<String> linhas = Auxiliar.ler_arquivo("Cliente.txt");

        for (String linha : linhas) {
            String[] v = linha.split(";");

            Cliente c = new Cliente(v[0], v[1], v[2], v[3], v[4]);

            cliente_box.add(c);
        }

        client_box.setItems(cliente_box);
        client_box1.setItems(cliente_box);
        box_cliente_edit.setItems(cliente_box);
    }

}
