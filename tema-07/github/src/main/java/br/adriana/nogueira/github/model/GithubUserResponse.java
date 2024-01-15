package br.adriana.nogueira.github.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GithubUserResponse {

    @JsonProperty("name")
    private String name;

    @JsonProperty("full_name")
    private String fullName;

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
