package com.example.time.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.time.domain.model.Dono;
import com.example.time.domain.model.Time;

public interface TimeRepository extends JpaRepository<Time, Long> {
    
     @Query(nativeQuery = true, value = "SELECT * FROM public.time " +
            "WHERE data_soltura " +
            "BETWEEN TO_TIMESTAMP(:periodoInicial, 'YYYY-MM-DD hh24:MI:SS') AND " +
            "TO_TIMESTAMP(:periodoFinal, 'YYYY-MM-DD hh24:MI:SS')")
    List<Time> obterFluxoDeHPPorDataSoltura(
        @Param("periodoInicial") String periodoInicial,
        @Param("periodoFinal") String periodoFinal);

    List<Time> findByDono(Dono dono);
}
