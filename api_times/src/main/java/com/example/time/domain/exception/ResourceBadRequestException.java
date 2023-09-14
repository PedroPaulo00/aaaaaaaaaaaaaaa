package com.example.time.domain.exception;

public class ResourceBadRequestException extends RuntimeException{
    public ResourceBadRequestException(String mensagem){
        super(mensagem);
    }
    
}
