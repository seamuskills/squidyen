package me.seamus.squidyen;

import me.seamus.squidyen.init.SquidYenItems;
import me.seamus.squidyen.item.YenItem;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class SquidYenClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        SquidYen.log("Initializing client");

        for (Item item : new Item[]{ SquidYenItems.YEN, SquidYenItems.FAKE_YEN }) {
            FabricModelPredicateProviderRegistry.register(item, new Identifier(SquidYen.MOD_ID, "value"), YenItem::getValue);
        }

        SquidYen.log("Initialized client");
    }
}
