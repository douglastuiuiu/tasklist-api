package br.com.douglastuiuiu.projectname.model;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    private Long id;

    public Person() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
