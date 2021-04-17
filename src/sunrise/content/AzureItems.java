package sunrise.content;

import arc.graphics.Color;
import mindustry.content.Items;
import mindustry.ctype.ContentList;
import mindustry.type.Item;

public class AzureItems implements ContentList {
static {
        Items.class.isArray();
    }

        public static Item  mythrylium;

        public void load(){
            mythrylium = new Item("mythrylium") {
                {
                this.localizedName = "Mythrylium";
                this.description = "Little bit radioactive and heavy resource, uses in powerful armor for units and defense.";
                this.hardness = 4;
                this.cost = 1;
                this.radioactivity = 0.2f;
                this.color = Color.valueOf("AA2F2A");
                }
            };

    }

}
