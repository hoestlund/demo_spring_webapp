package hostlund.com.demo_spring_webapp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Author {

  @Id
  @GeneratedValue
  private int id;
  private String name;

  //TODO readup https://www.baeldung.com/hibernate-initialize-proxy-exception
  //®@ManyToMany
  @ManyToMany(fetch= FetchType.EAGER)
  private Set<Book> books = new HashSet<>();

  public Author(){
  }
  public Author(String name) {
    this.name = name;
  }

  public Author(String name, HashSet<Book> books) {
    this.name = name;
    this.books = books;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<Book> getBooks() {
    return books;
  }

  public void setBooks(Set<Book> books) {
    this.books = books;
  }

  @Override
  public String toString() {
    return "Author{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", books=" + books +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Author author = (Author) o;

    return getId() == author.getId();
  }

  @Override
  public int hashCode() {
    return getId();
  }
}
