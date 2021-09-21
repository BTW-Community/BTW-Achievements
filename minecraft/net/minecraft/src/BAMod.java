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
public class BAMod extends FCAddOn {
	private static BAMod instance;

	public BAMod() {
		super("BTW Achievements", "1.0.0", "BA");
	}

	public static BAMod getInstance() {
		if (instance == null) {
			instance = new BAMod();
		}
		return instance;
	}

	/* List of custom achievements */
	
	//BTW Tabs
	public static Achievement installedBTW;

	public static Achievement findShaft;

	public static Achievement findReeds;
	public static Achievement craftWicker;
	public static Achievement craftBasket;

	public static Achievement craftFire;
	public static Achievement craftCampfire;
	public static Achievement cookOnCampfire;

	public static Achievement craftClub;
	public static Achievement craftBigBone;
	public static Achievement findBone;

	public static Achievement boneHook;
	public static Achievement baitedRod;

	public static Achievement chiselWood;
	public static Achievement knitWool;
	public static Achievement craftClothes;

	public static Achievement chiselStone;
	public static Achievement findCoal;
	public static Achievement craftTorch;
	public static Achievement mineIron;

	public static Achievement findString;
	public static Achievement advancedFire;
	public static Achievement craftAxe;
	public static Achievement getLog;

	public static Achievement craftShovel;
	public static Achievement findClay;
	public static Achievement dryClay;
	public static Achievement craftFurnace;

	public static Achievement smeltIron;
	public static Achievement craftChisel;
	public static Achievement mineBricks;

	public static Achievement workStump;
	public static Achievement craftPick;
	public static Achievement craftBow;
	
	public static Achievement ironIngot;
	
	public static Achievement ironPick;
	public static Achievement findDiamonds;
	public static Achievement diamondIngot;
	public static Achievement diamondPick;
	public static Achievement mineObsidian;
	
	public static Achievement ironAxe;
	public static Achievement cauldron;	
	
	public static Achievement craftShears;
	public static Achievement craftHoe;
	public static Achievement ironSword;
	
	public static Achievement netherPortal;
	public static Achievement blazeRod;
	public static Achievement witherSkull;
	public static Achievement dormantForge;
	
	public static Achievement endPortal;
	public static Achievement findBark;
	public static Achievement findDust;

	@Override
	public void Initialize() {
		FCAddOnHandler.LogMessage(this.getName() + " Version " + this.getVersionString() + " Initializing...");
		int shift = -4;
		/*
		 * DO NOT set any achievement to independent (i.e. don't call .setIndependent())
		 * as this may cause issues for some achievement triggers. Setting the parent
		 * achievement to null works completely fine so there shouldn't be a reason to
		 * use it anyway.
		 */

		AchievementTab tabBTW = new AchievementTab("btw").setIcon(FCBetterThanWolves.fcCompanionCube);

		// installedBTW = (new Achievement ("openInventory", -2, 0, Item.book,
		// null)).registerAchievement(tabTest).setSpecial();
		
		findBark = (new Achievement("findBark", shift + 0, -1, FCBetterThanWolves.fcItemBark, null)).registerAchievement(tabBTW);
		findDust = (new Achievement("findDust", shift + 0, 1, FCBetterThanWolves.fcItemSawDust, null)).registerAchievement(tabBTW);
		
		findShaft = (new Achievement("findShaft", shift + 2, 0, Item.stick, findBark, findDust)).registerAchievement(tabBTW).setSpecial();
		craftFire = (new Achievement("craftFire", shift + 3, -2, FCBetterThanWolves.fcItemFireStarterSticks, findShaft)).registerAchievement(tabBTW);
		craftCampfire = (new Achievement("craftCampfire", shift + 3, -1, FCBetterThanWolves.fcBlockCampfireMedium,findShaft)).registerAchievement(tabBTW);
		cookOnCampfire = (new Achievement("cookOnCampfire", shift + 4, -1, Item.beefCooked, craftCampfire)).registerAchievement(tabBTW);

		craftClub = (new Achievement("craftClub", shift + 3, 1, FCBetterThanWolves.fcItemClubWood, findShaft)).registerAchievement(tabBTW);
		findBone = (new Achievement("findBone", shift + 4, 1, Item.bone, craftClub)).registerAchievement(tabBTW);
		craftBigBone = (new Achievement("craftBigBone", shift + 5, 1, FCBetterThanWolves.fcItemClubBone, findBone)).registerAchievement(tabBTW);

		boneHook = (new Achievement("boneHook", shift + 5, 2, FCBetterThanWolves.fcItemFishHookBone, findBone)).registerAchievement(tabBTW);
		baitedRod = (new Achievement("baitedRod", shift + 6, 2, FCBetterThanWolves.fcItemFishingRodBaited, boneHook)).registerAchievement(tabBTW);

		findReeds = (new Achievement("findReeds", shift + 2, -3, Item.reed, null)).registerAchievement(tabBTW);
		craftWicker = (new Achievement("craftWicker", shift + 3, -3, FCBetterThanWolves.fcItemWickerWeaving, findReeds)).registerAchievement(tabBTW);
		craftBasket = (new Achievement("craftBasket", shift + 4, -3, FCBetterThanWolves.fcBlockBasketWicker, craftWicker)).registerAchievement(tabBTW).setSpecial();

		chiselWood = (new Achievement("chiselWood", shift + 5, 0, FCBetterThanWolves.fcItemChiselWood, findShaft)).registerAchievement(tabBTW);
		knitWool = (new Achievement("knitWool", shift + 6, -2, FCBetterThanWolves.fcItemKnitting, chiselWood)).registerAchievement(tabBTW);
		craftClothes = (new Achievement("craftClothes", shift + 7, -2, FCBetterThanWolves.fcItemArmorWoolBoots,knitWool)).registerAchievement(tabBTW);

		chiselStone = (new Achievement("chiselStone", shift + 6, 0, FCBetterThanWolves.fcItemChiselStone, chiselWood)).registerAchievement(tabBTW);
		findCoal = (new Achievement("findCoal", shift + 7, 1, Item.coal, chiselStone)).registerAchievement(tabBTW);
		craftTorch = (new Achievement("craftTorch", shift + 8, 1, Block.torchWood, findCoal)).registerAchievement(tabBTW);
		mineIron = (new Achievement("mineIron", shift + 7, -1, FCBetterThanWolves.fcItemChunkIronOre, chiselStone)).registerAchievement(tabBTW);

		findString = (new Achievement("findString", shift + 9, 0, Item.silk, chiselStone)).registerAchievement(tabBTW).setSpecial();
		advancedFire = (new Achievement("advancedFire", shift + 10, -1, FCBetterThanWolves.fcItemFireStarterBow,findString)).registerAchievement(tabBTW);

		craftAxe = (new Achievement("craftAxe", shift + 10, 1, Item.axeStone, findString)).registerAchievement(tabBTW);
		getLog = (new Achievement("getLog", shift + 11, 1, Block.wood, craftAxe)).registerAchievement(tabBTW);

		craftShovel = (new Achievement("craftShovel", shift + 10, 0, Item.shovelStone, findString)).registerAchievement(tabBTW);
		findClay = (new Achievement("findClay", shift + 11, 0, Item.clay, craftShovel)).registerAchievement(tabBTW);
		dryClay = (new Achievement("dryClay", shift + 12, 0, Item.brick, findClay)).registerAchievement(tabBTW);
		
		craftFurnace = (new Achievement("craftFurnace", shift + 13, 0, FCBetterThanWolves.fcBlockFurnaceBrickIdle,dryClay)).setSpecial().registerAchievement(tabBTW);
		
		smeltIron = (new Achievement("smeltIron", shift + 14, 0, FCBetterThanWolves.fcItemNuggetIron, craftFurnace)).registerAchievement(tabBTW);
		craftChisel = (new Achievement("craftChisel", shift + 15, 0, FCBetterThanWolves.fcItemChiselIron, smeltIron)).registerAchievement(tabBTW);
		mineBricks = (new Achievement("mineBricks", shift + 16, -1, FCBetterThanWolves.fcItemStoneBrick, craftChisel)).registerAchievement(tabBTW);
		
		workStump = (new Achievement("workStump", shift + 17, 0, FCBetterThanWolves.fcBlockWorkStump, null)).registerAchievement(tabBTW);
		
		ironSword = (new Achievement("ironSword", shift + 18, 1, Item.swordIron, null)).registerAchievement(tabBTW);
		
		
		System.out.println("BTW Tab: " + tabBTW.size() + " achievements");

		// NetherTab
		AchievementTab tabBTWNether = new BATabNether("btwNether").setIcon(Block.netherrack);

		netherPortal = (new Achievement("netherPortal", 0, 0, Block.portal, null)).registerAchievement(tabBTWNether);

		System.out.println("Nether Tab: " + tabBTWNether.size() + " achievements");
		
		// NetherTab
		AchievementTab tabBTWEnd = new BATabEnd("btwEnd").setIcon(Block.whiteStone);

		endPortal = (new Achievement("endPortal", 0, 0, Block.endPortalFrame, null)).registerAchievement(tabBTWEnd);
		
		System.out.println("End Tab: " + tabBTWEnd.size() + " achievements");

		EventDispatcher.register(new BAEventHandler());

		FCAddOnHandler.LogMessage(this.getName() + " Initialized");
	}

	public String GetLanguageFilePrefix() {
		return "BA";
	}
}