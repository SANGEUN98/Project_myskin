package TeamA.myskin.repository;

import lombok.Data;

@Data
public class ItemSearchCond {


    private String itemName;
//    private boolean to;
//    private boolean dr;
//    private boolean hu;
//    private boolean oil;
//    private boolean dry;
//    private boolean com;


    public ItemSearchCond() {
    }

    public ItemSearchCond(String itemName) {
        this.itemName = itemName;
    }

//    public ItemSearchCond(String itemName, boolean to, boolean dr, boolean hu, boolean oil, boolean dry, boolean com) {
//        this.itemName = itemName;
//        this.to = to;
//        this.dr = dr;
//        this.hu = hu;
//        this.oil = oil;
//        this.dry = dry;
//        this.com = com;
//    }
}
