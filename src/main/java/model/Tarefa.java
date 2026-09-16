package br.edu.ifrn.labtarefas.model;

public class Tarefa {
    private Long id;
    private String titulo;
    private String descrição;
    private localDate prazo;
    private boolean concluida;

    public Tarefa(Long id, String titulo, boolean concluida) {
        this.id = id;
        this.titulo = titulo;
        this.descricao;
        this.prazo;
        this.concluida = concluida;
        System.out.println("Criando Tarefa...");
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }
}