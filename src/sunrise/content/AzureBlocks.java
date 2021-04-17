package sunrise.content;

import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.ctype.ContentList;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.production.GenericSmelter;

public class AzureBlocks implements ContentList {

    public static Block

    mythryliumKiln;

    public void load() {

        mythryliumKiln = new GenericSmelter("mythrylium-kiln") {
            {
                this.localizedName = "Mythrylium Kiln";
                this.description = "Make Mythrylium from Titanium and Thorium.";
                this.health = 220;
                this.liquidCapacity = 0;
                this.size = 3;
                this.hasPower = true;
                this.hasLiquids = false;
                this.hasItems = true;
                this.craftTime = 90;
                this.updateEffect = Fx.plasticburn;
                this.consumes.power(2.5f);
                this.consumes.items(ItemStack.with(Items.thorium, 2, Items.titanium, 1));
                this.requirements(Category.crafting, ItemStack.with(Items.plastanium, 80, Items.titanium, 100, Items.metaglass, 120, Items.silicon, 200, Items.graphite, 200));
                this.outputItem = new ItemStack(AzureItems.mythrylium, 1);
            }
        };

    }

}
