package ex3.entities;

import ex2.db.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public abstract class AlunoDAO {

    public static boolean inserir(Aluno a){
        try(Connection conexao = ConnectionFactory.getConnection()){

            String query = "INSERT INTO Aluno VALUES (?,?,?,?,?)";

            try(PreparedStatement stmt = conexao.prepareStatement(query)){

                stmt.setInt(1,a.getId());
                stmt.setString(2,a.getNome());
                stmt.setDouble(3,a.getPeso());
                stmt.setInt(4,a.getAltura());
                stmt.setString(5,a.getEmail());

                stmt.executeUpdate();

                return true;

            }catch (Exception e){
                e.printStackTrace();
            }

        }catch (Exception e){
            e.printStackTrace();
        }


        return false;
    }

    public static List<Aluno> listarTodos(){

        List<Aluno> lista = new ArrayList<>();

        try(Connection conexao = ConnectionFactory.getConnection()){

            String query = "SELECT * FROM Aluno";

            try(PreparedStatement stmt = conexao.prepareStatement(query)){
                ResultSet linhas = stmt.executeQuery();

                while(linhas.next()){
                    Aluno a = new Aluno(
                            linhas.getInt("idAluno"),
                            linhas.getString("nome"),
                            linhas.getDouble("peso"),
                            linhas.getInt("altura"),
                            linhas.getString("email") );
                    lista.add(a);
                }

                return lista;

            }catch (Exception e){
                e.printStackTrace();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
