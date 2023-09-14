package com.example.time.domain.dto.times;

import com.example.time.domain.Enum.ETipoTime;

public class TimeRequestDTO {
    private Long id;
    private String descricao;
    private ETipoTime tipo;
    private String nome;
    private String cidade;
    private double numTorcedores;
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }


    public double getNumTorcedores() {
        return numTorcedores;
    }
    public void setNumTorcedores(double numTorcedores) {
        this.numTorcedores = numTorcedores;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public ETipoTime getTipo() {
        return tipo;
    }
    public void setTipo(ETipoTime tipo) {
        this.tipo = tipo;
    }
    
}
