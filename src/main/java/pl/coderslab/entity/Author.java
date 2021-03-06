package pl.coderslab.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import pl.coderslab.DTO.AuthorDTO;

@Entity
@Table(name = "author")
public class Author {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "first_name")
    private String firstName;
    
    @Column(name = "last_name")
    private String lastName;

    public Author(String firstName, String lastName) {
	this.firstName = firstName;
	this.lastName = lastName;
    }

    public Author() {
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
	return "Author [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
    }
    
    public AuthorDTO toDto() {
	
	return new AuthorDTO(getId(), getFirstName(), getLastName());
	
    }

}
