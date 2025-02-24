package com.example.demo.DTO;

public record ResponseDTO<T> (Integer code, String message, T data){

    public String toString() {
        return "ResponseDTO{code = " + code + ", message = " + message + ", data = " + data + "}";
    }
}
