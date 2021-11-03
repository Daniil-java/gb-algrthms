package homeworks.eighth;

public class Item {
    private int data;

    public Item(int data){
        this.data = data;
    }

    public int getKey(){
        return this.data;
    }

    @Override
    public String toString() {
        return data + " ";
    }
}
