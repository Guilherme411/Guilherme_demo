package br.edu.ifrn.demo.dto;

import java.time.LocalDate;
public record TaskRequestDTO(
        String titulo,
        String descricao,
        LocalDate prazo
) {}