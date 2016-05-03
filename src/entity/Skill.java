
package entity;

public class Skill extends AbstractEntity{
    
    private String name;

    public Skill(int skillID, String name) {
        this.id = skillID;
        this.name = name;
    }

    public Skill() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
