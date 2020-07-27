package Entity;

import java.util.Date;

public class Comment {

    private int commentId, postId, userId;
    private String content;
    private Date dateModify;

    public Comment() {
    }

    public Comment(int commentId, int postId, int userId, String content, Date dateModify) {
        this.commentId = commentId;
        this.postId = postId;
        this.userId = userId;
        this.content = content;
        this.dateModify = dateModify;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDateModify() {
        return dateModify;
    }

    public void setDateModify(Date dateModify) {
        this.dateModify = dateModify;
    }

    @Override
    public String toString() {
        return "Comment{" + "commentId=" + commentId + ", postId=" + postId + ", userId=" + userId + ", content=" + content + ", dateModify=" + dateModify + '}';
    }

}
