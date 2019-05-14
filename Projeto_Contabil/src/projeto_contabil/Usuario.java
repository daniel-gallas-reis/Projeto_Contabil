/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_contabil;

import java.util.Objects;

/**
 *
 * @author 05180176
 */
public class Usuario {
    private String Login, Senha;

    public Usuario() {
    }

    public Usuario(String Login, String Senha) {
        this.Login = Login;
        this.Senha = Senha;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    @Override
    public String toString() {
        return "Usuario{" + "Login=" + Login + ", Senha=" + Senha + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.Login);
        hash = 53 * hash + Objects.hashCode(this.Senha);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.Login, other.Login)) {
            return false;
        }
        return true;
    }
    
    
}
