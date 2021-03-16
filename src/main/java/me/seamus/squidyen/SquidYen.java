package me.seamus.squidyen;

import com.google.common.collect.ImmutableList;
import me.andante.chord.client.gui.itemgroup.AbstractTabbedItemGroup;
import me.andante.chord.client.gui.itemgroup.ItemGroupTab;
import me.seamus.squidyen.init.*;
import net.fabricmc.api.ModInitializer;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class SquidYen implements ModInitializer {
    public static final String MOD_ID = "squidyen";
    public static final String MOD_NAME = "Squid Yen";

    public static Logger LOGGER = LogManager.getLogger(MOD_ID);

    public static final ItemGroup ITEM_GROUP = new AbstractTabbedItemGroup(SquidYen.MOD_ID) {
        @Override
        protected List<ItemGroupTab> initTabs() {
            return ImmutableList.of(
                createTab(SquidYenItems.YEN, Registry.ITEM.getId(SquidYenItems.YEN).getPath()),
                createTab(SquidYenItems.FAKE_YEN, Registry.ITEM.getId(SquidYenItems.FAKE_YEN).getPath())
            );
        }

        @Override
        public ItemStack createIcon() {
            CompoundTag item = new CompoundTag();
            item.putString("id", Registry.ITEM.getId(SquidYenItems.YEN).toString());
            item.putInt("Count", 1);

            CompoundTag squidyen = new CompoundTag();
            squidyen.putInt("Value", 1000);

            CompoundTag tag = new CompoundTag();
            tag.put(SquidYen.MOD_ID, squidyen);
            item.put("tag", tag);

            return ItemStack.fromTag(item);
        }
    };

    @Override
    public void onInitialize() {
        log("Initializing");

        new SquidYenBlockEntities();
        new SquidYenBlocks();
        new SquidYenItems();

        log("Initialized");
    }

    public static void log(Level level, String message) {
        LOGGER.log(level, "[" + MOD_NAME + "] " + message);
    }
    public static void log(String message) {
        log(Level.INFO, message);
    }

    public static Identifier texture(String path) {
        return new Identifier(MOD_ID, "textures/" + path + ".png");
    }
}
