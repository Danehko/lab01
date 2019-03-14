package bcd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Exemplo1 {

    private static final String dbPath = "src/main/resources/lab01.sqlite";


    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner teclado = new Scanner(System.in);
        //ler string
        String s = teclado.nextLine();
        teclado.next();//consumir caractere extra do ENTER CR/LF
        //ler int
        int i = teclado.nextInt();


        System.out.println("Ola mundo!");

        Class.forName("org.sqlite.JDBC");

        Connection conexao = DriverManager.getConnection("jdbc:sqlite:"+dbPath);

        Statement stmt = conexao.createStatement();

        String query = "INSERT INTO Aluno VALUES (2,'Juca',80,180,'email@do.com')";

        stmt.executeUpdate(query);

        stmt.close();
        conexao.close();
    }

}
