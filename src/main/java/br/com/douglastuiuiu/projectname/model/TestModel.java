package br.com.douglastuiuiu.projectname.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

/**
 * Created by douglastuiuiu on 9/13/16.
 */
@Document(collection = "test")
public class TestModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    @Field
    private String field;

    public TestModel() {
    }

    public TestModel(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    @Override
    public String toString() {
        return "Test{id='" + id + '\'' + ", field='" + field + '\'' + '}';
    }
}
