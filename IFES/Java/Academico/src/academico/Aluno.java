/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academico;

/**
 *
 * @author 20181tiimi0197
 */
public class Aluno {

    private String codigo;
    private String nome;
    private double nota;

    public Aluno(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }
    
    public Aluno(String codigo, String nome, double nota) {
        this.codigo = codigo;
        this.nome = nome;
        this.nota = nota;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}

