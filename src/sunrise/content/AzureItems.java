package sunrise.content;

import arc.graphics.Color;
import mindustry.content.Items;
import mindustry.ctype.ContentList;
import mindustry.type.Item;

public class AzureItems implements ContentList {
static {
        Items.class.isArray();
    }

        public static Item  azurite;

        public void load(){
            azurite = new Item("azurite") {
                {
                this.localizedName = "Azurite";
                this.description = "Shiny and heavy resource.";
                this.hardness = 4;
                this.cost = 1;
                this.radioactivity = 0.0f;
                this.color = Color.valueOf("AA2F2A");
                }
            };

    }

}
