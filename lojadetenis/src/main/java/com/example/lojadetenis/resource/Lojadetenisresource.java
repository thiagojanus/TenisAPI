package com.example.lojadetenis.resource;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lojadetenis.model.Lojadetenis;
import com.example.lojadetenis.repository.LojadetenisRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/apitenis")
@Api(value="API REST Tênis")
@CrossOrigin(origins="*")
public class LojadetenisResource{
    
    @Autowired
    LojadetenisRepository lojadetenisRepository;
    
    @GetMapping("/lojadetenis")
    @ApiOperation(value="Retorna tênis")
    public List<Lojadetenis> listaLojadetenis(){
        return lojadetenisRepository.findAll();
    }
    
    @GetMapping("/lojadetenis/{id}")
    @ApiOperation(value="Retorna tênis")
    public Lojadetenis listaLojadetenis(@PathVariable(value="id") long id){
        return lojadetenisRepository.findById(id);
    }
    
    @PostMapping("/lojadetenis")
    @ApiOperation(value="Salva tênis")
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Lojadetenis salvaLojadetenis(@RequestBody Lojadetenis lojadetenis) {
        return lojadetenisRepository.save(lojadetenis);
    }
    
    @DeleteMapping("/lojadetenis")
    @ApiOperation(value="Apaga tênis")
    public void deleteLojadetenis(@RequestBody Lojadetenis lojadetenis) {
        lojadetenisRepository.delete(lojadetenis);
    }
    
    @PutMapping("/lojadetenis")
    @ApiOperation(value="Atualiza tênis")
    public Lojadetenis atualizaLojadetenis(@RequestBody Lojadetenis lojadetenis) {
        return lojadetenisRepository.save(lojadetenis);
    }
}