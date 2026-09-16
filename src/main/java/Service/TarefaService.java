package br.edu.ifrn.demo.service;

import br.edu.ifrn.labtarefas.model.Tarefa;
import br.edu.ifrn.labtarefas.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {
    private final TarefaRepository repository;
    public TarefaService(TarefaRepository repository) {
        this.repository = repository;
    }
    public Tarefa criar(String titulo) {
        System.out.println("[SERVICE] Validando regra de negócio para: " +
                titulo);
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("O título da tarefa não pode ser vazio.");
        }
        return repository.salvar(titulo.trim());
    }
    public List<Tarefa> listar() {
        System.out.println("[SERVICE] Solicitando lista de tarefas ao repository");
        return repository.listarTodas();
    }
    public Tarefa buscarPorId(Long id) {
        System.out.println("[SERVICE] Processando busca por id: " + id);
        return repository.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Tarefa não encontrada: " + id));
    }

    public List<Tarefa> listarConcluidos(){
        System.out.println("[SERVICE] Solicitando lista de tarefas concluidas");
        List<Tarefa> tarefas = listar();
        List<Tarefa> tarefasConcluidas=new ArrayList<Tarefa>();

        for(Tarefa tarefa: tarefas){
            if(tarefa.isConcluida()){
                tarefasConcluidas.add(tarefa);
            }
        }
        return tarefasConcluidas;

    }
}