package Entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Post {

    private int postId, userId, categoryId;
    private String title, content, background, location, dateModify;

    public Post() {
    }

    public Post(int postId, int userId, int categoryId, String title, String content, String background, String location, Date dateModify) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        this.postId = postId;
        this.userId = userId;
        this.categoryId = categoryId;
        this.title = title;
        this.content = content;
        this.background = background;
        this.location = location;
        this.dateModify = sdf.format(dateModify);
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Post{" + "postId=" + postId + ", user=" + userId + ", categoryId=" + categoryId + ", title=" + title + ", location=" + location + '}';
    }

    public String getDateModify() {
        return dateModify;
    }

    public void setDateModify(String dateModify) {
        this.dateModify = dateModify;
    }

}
