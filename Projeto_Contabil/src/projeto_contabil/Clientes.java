/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_contabil;

/**
 *
 * @author danie
 */
public class Clientes {
    private String nome;
    private int idade;
    private double saldo_bancario;
    private double salario;
    private long documento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getSaldo_bancario() {
        return saldo_bancario;
    }

    public void setSaldo_bancario(double saldo_bancario) {
        this.saldo_bancario = saldo_bancario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public long getDocumento() {
        return documento;
    }

    public void setDocumento(long documento) {
        this.documento = documento;
    }

    public Clientes(String nome, int idade, double saldo_bancario, double salario, long documento) {
        this.nome = nome;
        this.idade = idade;
        this.saldo_bancario = saldo_bancario;
        this.salario = salario;
        this.documento = documento;
    }
    
}
