package DAO;

import Model.ContatoModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
import javax.management.remote.JMXConnectorFactory;

public class ContatoBancoDados {
    
    public void inserirContatoBD(ContatoModel novoContato) {

        String sql = "INSERT INTO cliente (nome, cpf, telefone, status, cep) values (?, ?, ?, ?, ?)";
        PreparedStatement stmt = null;
        Connection connection = null;

        try {
            connection = new ConexaoDB().getConnection();
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, novoContato.getNome());
            stmt.setString(2, novoContato.getCpf());
            stmt.setString(3, novoContato.getTelefone());
            stmt.setString(4, novoContato.getCep());
            stmt.setString(5, novoContato.getData());
            
            stmt.execute();
            System.out.println("Registro realizado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao realizar regitro!");
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (Exception e) {
                System.out.println("Erro ao finalizar steatment!");
                e.printStackTrace();
            }

            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                System.out.println("Erro ao finalizar conexao com o banco de dados!");
                e.printStackTrace();
            }
        }
    }

    
    public ArrayList<ContatoModel> listarTodosContatos(){
    
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        
        ContatoModel contato = null;
        ArrayList<ContatoModel> listaContatos = null;
        
        String sql = "SELECT * FROM ROOT.CLIENTE";
        
        try {
            conn = new ConexaoDB().getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            if (rs != null) {
                listaContatos = new ArrayList<>();
                while (rs.next()) {
                    contato = new ContatoModel();
                    contato.setId(rs.getInt("id"));
                    contato.setNome(rs.getString("nome"));
                    contato.setCpf(rs.getString("cpf"));
                    contato.setTelefone(rs.getString("telefone"));
                    contato.setData(rs.getString("status"));
                    contato.setCep(rs.getString("cep"));
                    listaContatos.add(contato);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao realizar regitro!");
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (Exception e) {
                System.out.println("Erro ao finalizar steatment!");
                e.printStackTrace();
            }

            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                System.out.println("Erro ao finalizar conexao com o banco de dados!");
                e.printStackTrace();
            }
        }
        System.out.println("Lista" + listaContatos);
        return listaContatos;
    }
    
    public ArrayList<ContatoModel> buscarContatos(String nome){
    
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        
        ContatoModel contato = null;
        ArrayList<ContatoModel> listaContatos = null;
        
        String sql = "SELECT * FROM ROOT.CONTATOS WHERE nome LIKE '%" + 
                nome + "%' ORDER BY nome";
        
        try {
            conn = new ConexaoDB().getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            if (rs != null) {
                listaContatos = new ArrayList<>();
                while (rs.next()) {
                    contato = new ContatoModel();
                    contato.setId(rs.getInt("id"));
                    contato.setNome(rs.getString("nome"));
                    contato.setCpf(rs.getString("cpf"));
                    contato.setTelefone(rs.getString("telefone"));                    
                    contato.setCep(rs.getString("cep"));                    
                    contato.setCep(rs.getString("data"));                
                    listaContatos.add(contato);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao selecionar contatos!");
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (Exception e) {
                System.out.println("Erro ao finalizar steatment!");
                e.printStackTrace();
            }

            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                System.out.println("Erro ao finalizar conexao com o banco de dados!");
                e.printStackTrace();
            }
        }
        return listaContatos;
    }
    
    
    public void alterarContatoBD(ContatoModel contatoAjuste){

        Connection conn = null;
        PreparedStatement stmt = null;
        
        String sql = "UPDATE ROOT.CONTATOS SET nome=?, cpf=?, telefone=?, cep=?, data=? WHERE id=?";
        
        try {
            conn = new ConexaoDB().getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, contatoAjuste.getNome());
            stmt.setString(2, contatoAjuste.getCpf());
            stmt.setString(3, contatoAjuste.getTelefone());
            stmt.setString(4, contatoAjuste.getCep());
            stmt.setString(5, contatoAjuste.getData());
            stmt.setInt(6, contatoAjuste.getId());
            stmt.execute();
            System.out.println("Alteração do registro realizada com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao realizar a alteração no registro!");
            e.printStackTrace();
        }finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (Exception e) {
                System.out.println("Erro ao finalizar steatment!");
                e.printStackTrace();
            }

            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                System.out.println("Erro ao finalizar conexao com o banco de dados!");
                e.printStackTrace();
            }
        }
    }
    
    public void excluirContatoBD(int id){
    
        Connection conn = null;
        PreparedStatement stmt = null;
        
        String sql = "DELETE FROM ROOT.CONTATOS where id=?";
        
        try {
            conn = new ConexaoDB().getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            System.out.println("Exlusão realizada com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao realizar a exclusão do registro.");
        }finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (Exception e) {
                System.out.println("Erro ao finalizar steatment!");
                e.printStackTrace();
            }

            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                System.out.println("Erro ao finalizar conexao com o banco de dados!");
                e.printStackTrace();
            }
        }
        
    }
    
    
}

    

   


        
    
    
    
    

