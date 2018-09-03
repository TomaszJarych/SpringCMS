package pl.coderslab.DTO;


import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class CategoryDTO {

    private Long id;

    @NotBlank
    @Size(min=5)
    private String name;

    private String description;

    public CategoryDTO() {
    }

    public CategoryDTO(Long id, String name, String description) {
	this.id = id;
	this.name = name;
	this.description = description;
    }

    public CategoryDTO(String name, String description) {
	this.name = name;
	this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
	return "CategoryDTO [id=" + id + ", name=" + name + ", description=" + description + "]";
    }

}
