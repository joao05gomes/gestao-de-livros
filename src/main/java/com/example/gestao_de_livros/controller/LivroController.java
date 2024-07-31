package com.example.gestao_de_livros.controller;

import com.example.gestao_de_livros.model.Livro;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/livros")
public class LivroController {
    private final ArrayList<Livro> listaDeLivros = new ArrayList<>();

    private Long lastID = 0L;
    @GetMapping
    public ArrayList<Livro> listarTodos() {
        return listaDeLivros;
    }

    @PostMapping("/adicionar-livro")
    public String adicionarLivro(@RequestBody Livro livro) {
        lastID ++;
        System.out.println(lastID);
        livro.setId(lastID);
        listaDeLivros.add(livro);
        return "Livro inserido com sucesso";
    }

    @GetMapping("/existe-livro")
    public boolean existeLivro(@RequestParam String titulo) {
        for (Livro livro: listaDeLivros){
            if (livro.getTitulo().equalsIgnoreCase(titulo)){
                return true;
            }
        }
        return false;
    }
}