package com.seamus.squidyen;


import net.minecraft.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(squidYen.MODID)
public class squidYen
{
	// Directly reference a log4j logger.
	private static final Logger LOGGER = LogManager.getLogger();
	public static final String MODID = "squidyen";
	public static final String MODNAME = "Squid Yen";
	public static final String SHORT = "SY";
	public static final String VERSION = "1.0.0";
	
	public squidYen()
	{
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);

		
		MinecraftForge.EVENT_BUS.register(this);
		MinecraftForge.EVENT_BUS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
	
	private void commonSetup(final FMLCommonSetupEvent event)
	{
	}

	
	@SubscribeEvent
	public void onServerStarting(FMLServerStartingEvent event)
	{
	
	}
	
	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents
	{
		@SubscribeEvent
		public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent)
		{
		}
	}
}
