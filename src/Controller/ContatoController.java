/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.ContatoModel;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author aluno tds
 */
public class ContatoController {
        public void cadastrarContato(String nome, String cpf, String telefone, String cep, String data) {
        if ((nome != null && nome.length() > 0) && (cpf != null && cpf.length() > 0)
                && (telefone != null && telefone.length() > 0) && (cep != null && cep.length() > 0) 
                && (data != null && data.length() > 0)) {
            
            ContatoModel novoContato = new ContatoModel(nome, cpf, telefone, cep, data);
            novoContato.cadastrarContato(novoContato);
        } else {
            JOptionPane.showMessageDialog(null, "Preencha os campos corretamente");
        }
    }
        public ArrayList<ContatoModel> listarContatosController(){
            ContatoModel contato = new ContatoModel();
            return contato.listarContatos();
        }
}

