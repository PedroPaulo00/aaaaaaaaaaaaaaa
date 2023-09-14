package com.example.time.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.time.domain.dto.times.TimeRequestDTO;
import com.example.time.domain.dto.times.TimeResponseDTO;
import com.example.time.domain.exception.ResourceBadRequestException;
import com.example.time.domain.exception.ResourceNotFoundException;
import com.example.time.domain.model.Dono;
import com.example.time.domain.model.Time;
import com.example.time.domain.repository.TimeRepository;

@Service
public class TimeService implements ICRUDService<TimeRequestDTO, TimeResponseDTO> {
     @Autowired
    private TimeRepository timeRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public List<TimeResponseDTO> obterTodos() {
        Dono dono = (Dono) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Time> times = timeRepository.findByDono(dono);
        return times.stream().map(time -> mapper.map(time, TimeResponseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public TimeResponseDTO obterPorId(Long id) {
        Optional<Time> optTime = timeRepository.findById(id);
        if(optTime.isEmpty()){
            throw new ResourceNotFoundException("Não foi possível encontrar o título com o ID:" + id);
        }
        return mapper.map(optTime.get(), TimeResponseDTO.class);
    }

    @Override
    public TimeResponseDTO cadastrar(TimeRequestDTO dto) {
        validarTime(dto);
        Time time = mapper.map(dto, Time.class);
        Dono dono = (Dono) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        time.setDono(dono);
        time.setId(null);
        time = timeRepository.save(time);
        return mapper.map(time, TimeResponseDTO.class);
    }

    @Override
    public TimeResponseDTO atualizar(Long id, TimeRequestDTO dto) {
        obterPorId(id);
        validarTime(dto);
        Time time = mapper.map(dto, Time.class);
        Dono dono = (Dono) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        time.setDono(dono);
        time.setId(id);
        time = timeRepository.save(time);
        return mapper.map(time, TimeResponseDTO.class);

    }

    @Override
    public void deletar(Long id) {
        obterPorId(id);
        timeRepository.deleteById(id);
    }

    private void validarTime(TimeRequestDTO dto){
        if(dto.getTipo() == null || dto.getNome() == null || dto.getCidade() == null || dto.getDescricao() == null){
            throw new ResourceBadRequestException("Time inválido - Campos Obrigatórios!");
        }
    }
    
    public List<TimeResponseDTO> obterPorDataSoltura(String periodoInicial, String periodoFinal){
        List<Time> times = timeRepository.obterFluxoDeHPPorDataSoltura(periodoInicial, periodoFinal);
        return times.stream()
        .map(time -> mapper.map(time, TimeResponseDTO.class))
        .collect(Collectors.toList());
    }
}
