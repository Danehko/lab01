package ex3;

import ex3.entities.Aluno;
import ex3.entities.AlunoDAO;

import java.util.List;

public class Exercicio3 {

    public static void main(String[] args) {
        Aluno a = new Aluno(12, "juca",65,168,"emaildojuca@d.com");

        // AlunoDAO.inserir(a);

        List<Aluno> alunos = AlunoDAO.listarTodos();

        alunos.forEach(aluno -> {
            System.out.println(aluno); // invocará método toString()
        });

        /*for(Aluno aluno : alunos){
            System.out.println(aluno);
        }*/
    }

}
