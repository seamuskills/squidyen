package com.seamus.squidyen.registries;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class squidYenItems
{
	public static final List<Item> weapons = new ArrayList<>();
	
	public static final Item oneYen = new Item(new Item.Properties().maxStackSize(50).group(ItemGroup.MISC)).setRegistryName("1_yen");
	public static final Item fiveYen = new Item(new Item.Properties().maxStackSize(50).group(ItemGroup.MISC)).setRegistryName("5_yen");
	public static final Item tenYen = new Item(new Item.Properties().maxStackSize(50).group(ItemGroup.MISC)).setRegistryName("10_yen");
	public static final Item fiftyYen = new Item(new Item.Properties().maxStackSize(50).group(ItemGroup.MISC)).setRegistryName("50_yen");
	public static final Item oneCYen = new Item(new Item.Properties().maxStackSize(50).group(ItemGroup.MISC)).setRegistryName("100_yen");
	public static final Item fiveCYen = new Item(new Item.Properties().maxStackSize(50).group(ItemGroup.MISC)).setRegistryName("500_yen");
	public static final Item oneKYen = new Item(new Item.Properties().maxStackSize(50).group(ItemGroup.MISC)).setRegistryName("1k_yen");
	public static final Item fiveKYen = new Item(new Item.Properties().maxStackSize(50).group(ItemGroup.MISC)).setRegistryName("5k_yen");
	public static final Item tenKYen = new Item(new Item.Properties().maxStackSize(50).group(ItemGroup.MISC)).setRegistryName("10k_yen");
	public static final Item fakeYen = new Item(new Item.Properties().maxStackSize(50).group(ItemGroup.MISC)).setRegistryName("fake_yen");
	public static final Item oneCKYen = new Item(new Item.Properties().maxStackSize(50).group(ItemGroup.MISC)).setRegistryName("100k_yen");
	public static final Item oneCKfakeYen = new Item(new Item.Properties().maxStackSize(50).group(ItemGroup.MISC)).setRegistryName("100kfake_yen");
	public static final Item oneMilYen = new Item(new Item.Properties().maxStackSize(50).group(ItemGroup.MISC)).setRegistryName("1_million_yen");
	public static final Item oneMilFakeYen = new Item(new Item.Properties().maxStackSize(50).group(ItemGroup.MISC)).setRegistryName("1_million_yen_fake");

	@SubscribeEvent
	public static void itemInit(final RegistryEvent.Register<Item> event)
	{
		IForgeRegistry<Item> registry = event.getRegistry();
		
		for(Item item : weapons)
			registry.register(item);

		registry.register(oneYen);
		registry.register(fiveYen);
		registry.register(tenYen);
		registry.register(fiftyYen);
		registry.register(oneKYen);
		registry.register(fiveKYen);
		registry.register(tenKYen);
		registry.register(fiveCYen);
		registry.register(oneCYen);
		registry.register(fakeYen);
		registry.register(oneCKYen);
		registry.register(oneCKfakeYen);
		registry.register(oneMilYen);
		registry.register(oneMilFakeYen);
	}
}
