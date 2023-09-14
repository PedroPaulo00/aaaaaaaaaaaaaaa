package com.example.time.domain.Enum;

public enum ETipoTime {
    MASCULINO("Masculino"),
    FEMININO("Feminino"),
    SUB20("Sub20");
    
    private String valor;

    private ETipoTime(String valor){
        this.valor = valor;
    }

    public String getvalor() {
        return valor;
    }
}
