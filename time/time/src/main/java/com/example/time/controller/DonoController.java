package com.example.time.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.time.domain.dto.donos.DonoRequestDTO;
import com.example.time.domain.dto.donos.DonoResponseDTO;
import com.example.time.domain.service.DonoService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/dono")
public class DonoController {
    @Autowired
    private DonoService donoService;

    @GetMapping
    public ResponseEntity<List<DonoResponseDTO>> 
    obterTodos(){
        return ResponseEntity.ok(donoService.obterTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DonoResponseDTO> 
    obterPorId(@PathVariable Long id){
        return ResponseEntity.ok(donoService.obterPorId(id));
    }

    @PostMapping
    public ResponseEntity<DonoResponseDTO>
    cadastrar(@RequestBody DonoRequestDTO dto){
        DonoResponseDTO dono = donoService.cadastrar(dto);
        return new ResponseEntity<DonoResponseDTO>(dono, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DonoResponseDTO>
    atualizar(@PathVariable Long id, @RequestBody DonoRequestDTO dto){
        DonoResponseDTO dono = donoService.atualizar(id, dto);
        return new ResponseEntity<DonoResponseDTO>(dono, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> 
    deletar(@PathVariable Long id){
        donoService.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
   
}

