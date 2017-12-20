package bin;

public class Item {

    private int id;
    private String name;
    private int uniqueKeyItem;

    public Item(){

    }

    public Item(String name, int uniqueKeyItem){
        this.name = name;
        this.uniqueKeyItem = uniqueKeyItem;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUniqueKeyItem() {
        return uniqueKeyItem;
    }

    public void setUniqueKeyItem(int uniqueKeyItem) {
        this.uniqueKeyItem = uniqueKeyItem;
    }
}
