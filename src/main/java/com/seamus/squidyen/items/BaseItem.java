package com.seamus.squidyen.items;

import com.seamus.squidyen.registries.squidYenItems;
import net.minecraft.entity.Entity;
import net.minecraft.item.*;
import net.minecraft.world.World;

public class BaseItem extends Item
{
	public BaseItem()
	{
		super(new Properties().maxStackSize(100).group(ItemGroup.MISC));
		squidYenItems.weapons.add(this);
	}
	
	@Override
	public void inventoryTick(ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected)
	{
		super.inventoryTick(stack, world, entity, itemSlot, isSelected);
	}
}
