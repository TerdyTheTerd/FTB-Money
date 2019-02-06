package com.feed_the_beast.mods.money;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * @author LatvianModder
 */
@Mod.EventBusSubscriber(modid = FTBMoney.MOD_ID)
@Config(modid = FTBMoneyConfig.ID, category = "", name = FTBMoney.MOD_ID)
public class FTBMoneyConfig
{
	public static final String ID = FTBMoney.MOD_ID + "_common";
	public static final General general = new General();

	public static class General
	{
		@Config.RequiresMcRestart
		@Config.Comment({"true - use config/ftbmoneyshop.nbt file;", "false - use world/data/ftbmoneyshop.nbt file."})
		public boolean use_config_store = false;
	}

	@SubscribeEvent
	public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event)
	{
		if (event.getModID().equals(ID))
		{
			ConfigManager.sync(ID, Config.Type.INSTANCE);
		}
	}
}