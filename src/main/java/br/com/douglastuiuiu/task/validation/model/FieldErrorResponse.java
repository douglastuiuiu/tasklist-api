package br.com.douglastuiuiu.task.validation.model;

/**
 * @author douglastuiuiu@gmail.com
 */
public class FieldErrorResponse {
    private String fieldName;
    private String defaultMessage;
    private Object typeRejected;
    private Object valueRejected;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }

    public void setDefaultMessage(String defaultMessage) {
        this.defaultMessage = defaultMessage;
    }

    public Object getTypeRejected() {
        return typeRejected;
    }

    public void setTypeRejected(Object typeRejected) {
        this.typeRejected = typeRejected;
    }

    public Object getValueRejected() {
        return valueRejected;
    }

    public void setValueRejected(Object valueRejected) {
        this.valueRejected = valueRejected;
    }

}
