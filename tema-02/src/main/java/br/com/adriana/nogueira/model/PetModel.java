package br.com.adriana.nogueira.model;

public class PetModel {

    private Long id;
    private String name;
    private String race;
    private int age;

    public PetModel(Long id, String name, String race, int age) {
        this.id = id;
        this.name = name;
        this.race = race;
        this.age = age;
    }

    public PetModel() {

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

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public int getAge() {

        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        // Retorne uma representação adequada do objeto PetModel
        return "PetModel[name=" + name + ", age=" + age + ", species=" + race + "]";
    }
}
