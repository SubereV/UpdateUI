
package Entity;


public class Roles {
    private int roleId; 
    private String name, decription; 

    public Roles() {
    }

    public Roles(int roleId, String name, String decription) {
        this.roleId = roleId;
        this.name = name;
        this.decription = decription;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }
    
    
}
