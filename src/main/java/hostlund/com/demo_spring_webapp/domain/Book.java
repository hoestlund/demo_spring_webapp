package hostlund.com.demo_spring_webapp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import java.util.Set;

@Entity
public class Book {

  @Id
  @GeneratedValue
  private int id;
  private String title;

  @ManyToMany
  @JoinTable(name="author_book", joinColumns = @JoinColumn(name="author_id"), inverseJoinColumns =
  @JoinColumn(name="book_id"))
  private Set<Author> authors;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Set<Author> getAuthors() {
    return authors;
  }

  public void setAuthors(Set<Author> authors) {
    this.authors = authors;
  }
}
