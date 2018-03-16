package br.com.douglastuiuiu.projectname.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class SampleModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    private Long id;

    @NotBlank
    private String name;

    @NotNull
    @Valid
    private Person person;

    public SampleModel() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

}
