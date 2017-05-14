package by.news.domain;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "news")
public class News implements Serializable {

    private static final long serialVersionUID = 693011601665176200L;

    @Id
    private String id;
    private String title;
    private String subject;
    private String tags;

    public News(String title, String subject, String tags) {
        this.title = title;
        this.subject = subject;
        this.tags = tags;
    }

    public News() {
        super();
    }

    @Override
    public String toString() {
        return "News{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", subject='" + subject + '\'' +
                ", tags='" + tags + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        News news = (News) o;

        if (id != null ? !id.equals(news.id) : news.id != null) return false;
        if (title != null ? !title.equals(news.title) : news.title != null) return false;
        if (subject != null ? !subject.equals(news.subject) : news.subject != null) return false;
        return tags != null ? tags.equals(news.tags) : news.tags == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (tags != null ? tags.hashCode() : 0);
        return result;
    }
}
