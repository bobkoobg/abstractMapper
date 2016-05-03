package entity;

public abstract class AbstractEntity extends Object{

    protected Integer id; //izpolzvam v kolasovete vk oito nasledqvam

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Entity{" + "id=" + id + '}';
    }

}
