package md.utm.fcim.gateway.view;

import org.springframework.hateoas.ResourceSupport;

import java.io.Serializable;
import java.util.Set;

public class AuthorView extends ResourceSupport implements Serializable {

    private static final long serialVersionUID = -4977035781114877769L;

    private Long idAuthor;

    private String firstName;

    private String lastName;

    private Long age;

    private String gender;

    private Set<BookView> books;

    public Long getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(Long idAuthor) {
        this.idAuthor = idAuthor;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Set<BookView> getBooks() {
        return books;
    }

    public void setBooks(Set<BookView> books) {
        this.books = books;
    }
}
