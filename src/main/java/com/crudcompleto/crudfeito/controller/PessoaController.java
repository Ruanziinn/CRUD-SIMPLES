package com.crudcompleto.crudfeito.controller;
import java.util.List;
import com.crudcompleto.crudfeito.model.Pessoa;
import com.crudcompleto.crudfeito.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PessoaController {

    @Autowired
    PessoaRepository pessoaRepository;

    @GetMapping("/")
    public String index() {
        return "Teste API";
    }

    @GetMapping("/pessoa/{id}")
        Pessoa findByPessoa(@PathVariable Integer id) {
        return pessoaRepository.findById(id).get();
    }

    @GetMapping("/pessoa")
    List<Pessoa> all(){
        return pessoaRepository.findAll();
    }

    @PostMapping("/pessoa")
    Pessoa save(@RequestBody Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }

    @DeleteMapping("/pessoa/{id}")
    void delete(@PathVariable Integer id){
        pessoaRepository.deleteById(id);
    }

    @PutMapping("/pessoa/{id}")
    Pessoa update(@RequestBody Pessoa newPessoa, @PathVariable Integer id) {
        return pessoaRepository.findById(id)
                .map(pessoa -> {
                    pessoa.setName(newPessoa.getName());
                    return pessoaRepository.save(pessoa);
                })
                .orElseGet(
                        () -> {
                            newPessoa.setId(id);
                            return pessoaRepository.save(newPessoa);
                        }
                );

    }
}
