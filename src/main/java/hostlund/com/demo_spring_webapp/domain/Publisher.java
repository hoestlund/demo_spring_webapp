package hostlund.com.demo_spring_webapp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Publisher {

  @Id
  @GeneratedValue
  private Long id;
  private String name;
  private String hqLocation;

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "publisher")
  private Set<Book> publishedTitles = new HashSet<>();

  public Publisher() {
  }

  public Publisher(String name, String hqLocation) {
    this.name = name;
    this.hqLocation = hqLocation;
  }

  @Override
  public String toString() {
    return "Publisher{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", hqLocation='" + hqLocation + '\'' +
        ", publishedTitle=" + publishedTitles +
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

    Publisher publisher = (Publisher) o;

    return getId().equals(publisher.getId());
  }

  @Override
  public int hashCode() {
    return getId().hashCode();
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

  public String getHqLocation() {
    return hqLocation;
  }

  public void setHqLocation(String hqLocation) {
    this.hqLocation = hqLocation;
  }

  public Set<Book> getPublishedTitles() {
    return publishedTitles;
  }
}
