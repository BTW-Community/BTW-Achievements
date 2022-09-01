package net.minecraft.src;

import net.minecraft.src.Achievement;
import net.minecraft.src.EventDispatcher;
import net.minecraft.src.AchievementTab;
import net.minecraft.src.FCAddOn;
import net.minecraft.src.Block;
import net.minecraft.src.FCAddOnHandler;
import net.minecraft.src.FCBetterThanWolves;
import net.minecraft.src.Item;

/**
 * An example addon showcasing how to use the Achievements Core Addon.
 */
public class BetterAchievementsMod extends FCAddOn
{
	private static BetterAchievementsMod instance;

	public BetterAchievementsMod() {
		super("Better Achievements Mod", "1.0.0", "BAM");
	}

	public static BetterAchievementsMod getInstance() {
		if (instance == null) {
			instance = new BetterAchievementsMod();
		}
		return instance;
	}
	
	@Override
	public void Initialize() {
		FCAddOnHandler.LogMessage(this.getName() + " Version " + this.getVersionString() + " Initializing...");
		
		BAMAchievements.initialize();

		EventDispatcher.register(new BAMEventHandler());

		FCAddOnHandler.LogMessage(this.getName() + " Initialized");
	}

	public String GetLanguageFilePrefix() {
		return "BAM";
	}
}