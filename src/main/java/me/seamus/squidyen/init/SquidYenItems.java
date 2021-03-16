package me.seamus.squidyen.init;

import me.seamus.squidyen.SquidYen;
import me.seamus.squidyen.item.YenItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

@SuppressWarnings("unused")
public class SquidYenItems {
    public static final Item YEN = register("yen", new YenItem(new FabricItemSettings().maxCount(50).group(SquidYen.ITEM_GROUP)));
    public static final Item FAKE_YEN = register("fake_yen", new YenItem(new FabricItemSettings().maxCount(50).group(SquidYen.ITEM_GROUP)));

    public static Item register(String id, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(SquidYen.MOD_ID, id), item);
    }
}
