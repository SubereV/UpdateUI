
package Entity;


public class Contact {
    private int contactId; 
    private String name, email, phoneNumber, content; 

    public Contact() {
    }

    public Contact(int contactId, String name, String email, String phoneNumber, String content) {
        this.contactId = contactId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.content = content;
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }   
}
