package md.utm.fcim.gateway.view;

import org.springframework.hateoas.ResourceSupport;

import java.io.Serializable;

public class BookView extends ResourceSupport implements Serializable  {

    private static final long serialVersionUID = 4022451271475123464L;

    private Long idBook;

    private String title;

    private String genre;

    private Long numberOfPages;

    private String lang;

    public Long getIdBook() {
        return idBook;
    }

    public void setIdBook(Long idBook) {
        this.idBook = idBook;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Long getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Long numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    @Override
    public String toString() {
        return "BookView{" +
                "idBook=" + idBook +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", lang='" + lang + '\'' +
                '}';
    }
}