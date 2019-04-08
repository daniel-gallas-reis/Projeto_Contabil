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
class ferramenta {
    public String tool;

    public String getTool() {
        return tool;
    }

    public void setTool(String tool) {
        this.tool = tool;
    }

    public ferramenta(String tool) {
        this.tool = tool;
    }

    @Override
    public String toString() {
        return tool; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
