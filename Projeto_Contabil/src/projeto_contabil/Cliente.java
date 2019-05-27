/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_contabil;

import java.io.Serializable;
import java.util.Objects;
import static projeto_contabil.Auxiliar.geraLinha;

/**
 *
 * @author danie
 */
public class Cliente implements Serializable{
    public String nome;
    public String idade;
    public String saldo;
    public String salario;
    public String cpf;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Cliente() {
    }

    public Cliente(String nome, String idade, String saldo, String salario, String cpf) {
        this.nome = nome;
        this.idade = idade;
        this.saldo = saldo;
        this.salario = salario;
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return nome;
    }
    
    public String proArquivo(){
        return getNome() + ";" + getIdade() + ";" + getSaldo()
                + ";" + getSalario() + ";" + getCpf();
    }
    
    public String proInfo(){
        return "Nome: " + this.getNome() + System.lineSeparator() + "Idade: " + this.getIdade() + System.lineSeparator() +
                "Saldo: " + this.getSaldo()
                + System.lineSeparator() + "Salário: " + this.getSalario() + System.lineSeparator() + "CPF: " + this.getCpf() + "\n" + geraLinha(20);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + Objects.hashCode(this.nome);
        hash = 19 * hash + Objects.hashCode(this.cpf);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        return true;
    }

    void atualizaSaldo() {
        this.saldo = String.valueOf(Double.parseDouble(this.saldo) + Double.parseDouble(this.salario));
    }

    
    
}
