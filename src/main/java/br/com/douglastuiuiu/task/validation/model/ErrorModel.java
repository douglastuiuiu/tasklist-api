package br.com.douglastuiuiu.task.validation.model;

/**
 * erro genérico padrão
 *
 * @author douglastuiuiu@gmail.com
 **/
public class ErrorModel {
    private Object message;

    public ErrorModel() {
    }

    public ErrorModel(Object message) {
        this.message = message;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

}
