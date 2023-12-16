package Model;

import DAO.ContatoBancoDados;
import java.util.ArrayList;

public class ContatoModel {
    
   private int id;
   private String nome;
   private String cpf;
   private String telefone;
   private String cep;
   private String data;
   
   public ContatoModel(){
       
   }

    public ContatoModel(String nome, String cpf, String telefone, String cep, String data) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.cep = cep;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
   public void cadastrarContato(ContatoModel novoCadastro){
       ContatoBancoDados novoRegistro = new ContatoBancoDados();
       novoRegistro.inserirContatoBD(novoCadastro);
       
   }
   
   public ArrayList<ContatoModel> listarContatos(){
       return new ContatoBancoDados().listarTodosContatos();
   }
}
