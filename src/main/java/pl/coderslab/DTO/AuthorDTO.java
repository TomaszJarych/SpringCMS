package pl.coderslab.DTO;

import org.hibernate.validator.constraints.NotBlank;

public class AuthorDTO {
    
    private Long id;
    
    @NotBlank
    private String firstName;
    
    @NotBlank
    private String lastName;

    public AuthorDTO(Long id, String firstName, String lastName) {
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
    }

    public AuthorDTO(String firstName, String lastName) {
	this.firstName = firstName;
	this.lastName = lastName;
    }

    public AuthorDTO() {
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
	return "AuthorDTO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
    }
    
    public String getFullName() {
	return firstName+" "+lastName;
    }

    
    
}
