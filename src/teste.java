
import DAO.ConexaoDB;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aluno tds
 */
public class teste {
    public static void main(String[] args) {
        ConexaoDB conecta = new ConexaoDB();
        conecta.getConnection();
    }
}
