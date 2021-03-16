package me.seamus.squidyen.init;

import me.seamus.squidyen.SquidYen;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

@SuppressWarnings("unused")
public class SquidYenBlocks {
    private static Block register(String id, Block block, boolean registerItem) {
        Identifier identifier = new Identifier(SquidYen.MOD_ID, id);

        Block registeredBlock = Registry.register(Registry.BLOCK, identifier, block);
        if (registerItem) {
            Registry.register(Registry.ITEM, identifier, new BlockItem(registeredBlock, new FabricItemSettings().maxCount(64).group(SquidYen.ITEM_GROUP)));
        }

        return registeredBlock;
    }
    private static Block register(String id, Block block) {
        return register(id, block, true);
    }
}
