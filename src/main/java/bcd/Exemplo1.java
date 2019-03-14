package bcd;

import java.sql.*;
import java.util.Scanner;

public class Exemplo1 {

    private static final String dbPath = "src/main/resources/lab01.sqlite";

    private static void inserir() throws ClassNotFoundException, SQLException {
        String nome, email;
        int matricula,altura, peso;

        Scanner teclado = new Scanner(System.in);
        //ler string
        //String s = teclado.nextLine();
        //teclado.next();//consumir caractere extra do ENTER CR/LF
        //ler int
        //int i = teclado.nextInt();

        System.out.println("Insira Matricula");
        matricula = teclado.nextInt();
        System.out.println("Insira Nome");
        nome = teclado.next();
        System.out.println("Insira Peso");
        peso = teclado.nextInt();
        System.out.println("Insira Altura");
        altura = teclado.nextInt();
        System.out.println("Insira email");
        email = teclado.next();

        String teste = matricula + ", '" + nome + "', " + peso +", " + altura + ", '"+ email + "'";
        Class.forName("org.sqlite.JDBC");
        Connection conexao = DriverManager.getConnection("jdbc:sqlite:"+dbPath);
        Statement stmt = conexao.createStatement();

        String query = "INSERT INTO Aluno VALUES(" + teste +")";
        System.out.println(query);

        stmt.executeUpdate(query);

        stmt.close();
        conexao.close();
    }

    public static void listarRegistros() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        Connection conexao = DriverManager.getConnection("jdbc:sqlite:"+dbPath);
        Statement stmt = conexao.createStatement();

        String query = "SELECT * FROM Aluno";

        ResultSet linhas = stmt.executeQuery(query);
        imprimir(linhas);

        linhas.close();
        stmt.close();
        conexao.close();

    }

    public static void imprimir(ResultSet linhas) throws SQLException {
        System.out.println(String.format("|%-5s|%-25s|%-25s","ID","Nome","Email"));
        while(linhas.next()){
            //System.out.println("Nome: " + linhas.getString("nome"));
            System.out.println(String.format("|%-5d|%-25s|%-25s",linhas.getInt("idAluno"),linhas.getString("nome"),linhas.getString("email")));

        }
    }

    public static void buscar() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        Connection conexao = DriverManager.getConnection("jdbc:sqlite:"+dbPath);
        Statement stmt = conexao.createStatement();

        Scanner teclado = new Scanner(System.in);
        System.out.println("Insira email");
        String email = teclado.next();


        String query = "SELECT * FROM Aluno WHERE email = '"+ email + "'";

        ResultSet linhas = stmt.executeQuery(query);
        imprimir(linhas);

        linhas.close();
        stmt.close();
        conexao.close();

    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        buscar();
    }
}
