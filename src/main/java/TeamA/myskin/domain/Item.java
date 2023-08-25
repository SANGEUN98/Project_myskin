package TeamA.myskin.domain;

import lombok.Data;

@Data
public class Item {
    private int pid;
    private String itemName;
    private String skin;
    private String brand;
    private String cate;
    private int price;

    public Item() {
    }

    public Item(int pid, String itemName, String skin, String brand, String cate, int price) {
        this.pid = pid;
        this.itemName = itemName;
        this.skin = skin;
        this.brand = brand;
        this.cate = cate;
        this.price = price;
    }

}
