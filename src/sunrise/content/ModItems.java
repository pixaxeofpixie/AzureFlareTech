package sunrise.content;

import arc.graphics.Color;
import mindustry.content.Items;
import mindustry.ctype.ContentList;
import mindustry.type.Item;

public class ModItems implements ContentList {
static {
        Items.class.isArray();
    }

        public static Item neptunium;

        public void load(){
            neptunium = new Item("neptunium") {
                {
                this.localizedName = "Neptunium";
                this.description = "Little bit radioactive and heavy resource, uses in powerful armor for units and defense.";
                this.hardness = 4;
                this.cost = 1;
                this.radioactivity = 0.4f;
                this.color = Color.valueOf("AA2F2A");
                }
            };

    }
}
