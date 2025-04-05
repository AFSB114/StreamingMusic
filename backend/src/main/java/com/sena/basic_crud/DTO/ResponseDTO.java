package com.sena.basic_crud.DTO;

import org.springframework.http.HttpStatus;
import java.util.ArrayList;
import java.util.List;

public class ResponseDTO {
    private HttpStatus status;
    private String message;
    private boolean ok;
    private List<String> errors;
    private List<Object> data;

    // Constructor vacío
    public ResponseDTO() {
        this.errors = new ArrayList<>();
    }

    // Constructor básico
    public ResponseDTO(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
        this.ok = status.is2xxSuccessful();
        this.errors = new ArrayList<>();
    }

    // Constructor para respuestas exitosas con datos
    public ResponseDTO(HttpStatus status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.ok = status.is2xxSuccessful();
        this.errors = new ArrayList<>();
        this.data = new ArrayList<>();  // Inicializa la lista

        // Verifica si el objeto data es una List
        if (data instanceof List) {
            // Si es una lista, asigna directamente
            this.data = (List<Object>) data;
        } else {
            // Si es un objeto único, agrégalo a la lista
            this.data.add(data);
        }
    }

    // Constructor para respuestas con errores
    public ResponseDTO(HttpStatus status, String message, List<String> errors) {
        this.status = status;
        this.message = message;
        this.ok = status.is2xxSuccessful();
        this.errors = errors != null ? errors : new ArrayList<>();
    }

    // Métodos estáticos para crear respuestas comunes
    public static ResponseDTO ok(String message) {
        return new ResponseDTO(HttpStatus.OK, message);
    }

    public static ResponseDTO ok(String message, Object data) {
        return new ResponseDTO(HttpStatus.OK, message, data);
    }

    public static ResponseDTO error(String message) {
        return new ResponseDTO(HttpStatus.BAD_REQUEST, message);
    }

    public static ResponseDTO error(String message, List<String> errors) {
        return new ResponseDTO(HttpStatus.BAD_REQUEST, message, errors);
    }

    // Getters y setters
    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
        this.ok = status.is2xxSuccessful();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isOk() {
        return ok;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors != null ? errors : new ArrayList<>();
    }

    public void addError(String error) {
        if (this.errors == null) {
            this.errors = new ArrayList<>();
        }
        this.errors.add(error);
    }

    public List<Object> getData() {
        return data;
    }

    public void setData(Object data) {
        if (this.data == null) {
            this.data = new ArrayList<>();
        }
        this.data.add(data);
    }
}