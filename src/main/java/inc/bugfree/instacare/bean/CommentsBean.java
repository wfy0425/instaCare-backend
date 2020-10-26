package inc.bugfree.instacare.bean;

public class CommentsBean {
    private Integer id;
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }
}
