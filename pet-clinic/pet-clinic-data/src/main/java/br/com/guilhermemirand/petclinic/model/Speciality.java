package br.com.guilhermemirand.petclinic.model;

public class Speciality extends BaseEntity {

    private String description;

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
