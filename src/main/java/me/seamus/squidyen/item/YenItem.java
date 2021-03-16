package me.seamus.squidyen.item;

import me.andante.chord.item.TabbedItemGroupAppendLogic;
import me.seamus.squidyen.SquidYen;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class YenItem extends Item implements TabbedItemGroupAppendLogic {
    public YenItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendStacks(ItemGroup group, DefaultedList<ItemStack> stacks) {
        if (this.isIn(group)) {
            for (int value : new int[]{ 1, 5, 10, 50, 100, 500, 1000, 5000, 10000, 100000, 1000000 }) {
                stacks.add(YenItem.setValue(new ItemStack(this), value));
            }
        }
    }

    @SuppressWarnings("unused")
    public static int getValue(ItemStack stack, @Nullable World world, @Nullable Entity entity) {
        return stack.getOrCreateSubTag(SquidYen.MOD_ID).getInt("Value");
    }
    public static ItemStack setValue(ItemStack stack, int value) {
        stack.getOrCreateSubTag(SquidYen.MOD_ID).putInt("Value", value);
        return stack;
    }

    @Override
    public Text getName(ItemStack stack) {
        return new TranslatableText(this.getTranslationKey(), String.format("%,d", YenItem.getValue(stack, null, null)));
    }
}
