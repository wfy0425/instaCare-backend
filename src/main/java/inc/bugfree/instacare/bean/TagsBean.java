package inc.bugfree.instacare.bean;

import com.google.cloud.firestore.annotation.PropertyName;

public class TagsBean {

    private Integer id;
    private String tagContent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    @PropertyName("tag_content")
    public String getTagContent() {
        return tagContent;
    }

//    @PropertyName("tag_content")
    public void setTagContent(String tagContent) {
        this.tagContent = tagContent;
    }

    @Override
    public String toString() {
        return "Tags{" +
                "id=" + id +
                ", tagContent='" + tagContent + '\'' +
                '}';
    }
}
