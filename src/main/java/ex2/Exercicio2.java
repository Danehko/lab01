package ex2;

import ex2.db.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Exercicio2 {

    private Connection conexao;

    public Exercicio2() {
        this.conexao = ConnectionFactory.getConnection();
    }

    // idAluno, nome, peso, altura, peso

    public void inserirAluno(int id, String nome, double peso, int altura, String email){

        PreparedStatement stmt;

        try{

            String query = "INSERT INTO Aluno VALUES (?,?,?,?,?)";

            stmt = conexao.prepareStatement(query);
            stmt.setInt(1,id);
            stmt.setString(2,nome);
            stmt.setDouble(3,peso);
            stmt.setInt(4,altura);
            stmt.setString(5,email);

            stmt.executeUpdate();
            stmt.close();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Exercicio2 e = new Exercicio2();

        e.inserirAluno(10, "mario",65,168,"emaildomario@d.com");

        // DAO -- Direct Acces Object

    }


}
