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

import com.example.time.domain.dto.times.TimeRequestDTO;
import com.example.time.domain.dto.times.TimeResponseDTO;
import com.example.time.domain.service.TimeService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/times")
public class TimeController {
    @Autowired
    private TimeService timeService;

    @GetMapping
    public ResponseEntity<List<TimeResponseDTO>> obterTodos(){
        return ResponseEntity.ok(timeService.obterTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TimeResponseDTO>obterPorId(@PathVariable Long id){
        return ResponseEntity.ok(timeService.obterPorId(id));
    }

    @PostMapping
    public ResponseEntity<TimeResponseDTO> cadastrar(@RequestBody TimeRequestDTO dto){
        TimeResponseDTO responseDTO = timeService.cadastrar(dto);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TimeResponseDTO> atualizar(@PathVariable Long id, @RequestBody TimeRequestDTO dto){
        TimeResponseDTO responseDTO = timeService.atualizar(id, dto);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id){
        timeService.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

