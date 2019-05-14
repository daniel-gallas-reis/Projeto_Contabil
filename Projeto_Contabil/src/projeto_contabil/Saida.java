/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_contabil;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author danie
 */
public class Saida implements Serializable{
    private String tipo, descricao, data;
    private Cliente cliente;
    private double valor;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return " " + "Tipo:" + getTipo() + "\nDescricao:" + getDescricao() + "\nData:" + getData() + "\nValor:" + getValor() + " \n";
    }
    


    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.tipo);
        hash = 83 * hash + Objects.hashCode(this.descricao);
        hash = 83 * hash + Objects.hashCode(this.data);
        hash = 83 * hash + Objects.hashCode(this.cliente);
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.valor) ^ (Double.doubleToLongBits(this.valor) >>> 32));
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
        final Saida other = (Saida) obj;
        if (Double.doubleToLongBits(this.valor) != Double.doubleToLongBits(other.valor)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        return true;
    }

    
    
    public Saida(String tipo, Cliente cliente, String descricao, String data, double valor) {
        this.tipo = tipo;
        this.descricao = descricao;
        this.data = data;
        this.valor = valor;
        this.cliente = cliente;
    }

    public Saida() {
    }
    
    
}
