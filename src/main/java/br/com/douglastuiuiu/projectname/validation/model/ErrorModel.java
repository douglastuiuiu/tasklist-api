package br.com.douglastuiuiu.projectname.validation.model;

/**
 * erro genérico padrão
 *
 * @author diegom
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
