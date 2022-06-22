package net.minecraft.src;

public class BAMAchievements {

	
	/* List of custom achievements */
	public static Achievement findReeds;
	public static Achievement craftWicker;	
	public static Achievement craftBasket;	
	
	public static Achievement findBones;
	public static Achievement craftBoneClub;
	public static Achievement craftBoneHook;
	public static Achievement baitFishingRod;
	
	public static Achievement findShaft;
	public static Achievement craftFirePlow;
	public static Achievement craftCampfire;
	public static Achievement cookMeat;
	
	public static Achievement craftPointyStick;
	public static Achievement craftKnittingNeedles;
	public static Achievement craftWoolArmor;
	
	public static Achievement craftSharpStone;
	public static Achievement findString;
	
	public static Achievement craftBowDrill;
	
	public static Achievement craftStoneAxe;
	public static Achievement findWood;
	
	public static Achievement craftStoneShovel;
	public static Achievement dryBricks;
	
	public static Achievement findIronChunk;
	
	public static Achievement craftOven;
	public static Achievement cookIron;
	
	public static Achievement craftIronChisel;
	public static Achievement findStoneBrick;
	
	public static Achievement craftWorkbench;
	public static Achievement craftStonePick;
	
	public static Achievement craftIronIngot;
	public static Achievement craftIronPick;
	public static Achievement craftIronSword;
	public static Achievement craftIronHoe;
	public static Achievement craftShears;
	public static Achievement craftCauldron;
	public static Achievement craftIronAxe;
	public static Achievement craftIronArmor;
	
	public static Achievement findDung;
	public static Achievement craftScouredLeather;
	public static Achievement craftTannedLeather;
	public static Achievement craftSaw;
	public static Achievement craftBellows;
	public static Achievement craftTurntable;
	public static Achievement craftPottery;
	public static Achievement craftHopper;
	
	public static Achievement craftPlanks;
	public static Achievement craftHamper;
	public static Achievement craftGear;
	public static Achievement craftHandCrank;
	public static Achievement craftMillstone;
	
	public static Achievement findHempSeeds;
	public static Achievement harvestHemp;
	
	public static Achievement craftHempFibers;
	public static Achievement craftAxle;
	public static Achievement craftGearBox;
	public static Achievement craftFabric;
	public static Achievement craftWindmill;
	public static Achievement craftPadding;
	
	public static Achievement findDiamonds;
	public static Achievement craftDiamondIngot;
	public static Achievement findCreeperOysters;
	
	public static Achievement craftDiamondArmor;
	public static Achievement craftDiamondPick;
	
	public static Achievement findObsidian;
	public static Achievement travelNether;
	public static Achievement findDormantForge;
	public static Achievement findBlazeRod;
	public static Achievement craftGroundNetherrack;
	
	public static Achievement craftHibachi;
	public static Achievement cookUrn;
	public static Achievement cookCrucible;
	public static Achievement craftWaterwheel;
	
	public static Achievement craftSoulUrn;
	public static Achievement cureZombieVillager;
	
	public static Achievement tradeFarmerLvl2;
	public static Achievement tradeFarmerLvl3;
	public static Achievement tradeFarmerLvl4;
	public static Achievement tradeFarmerLvl5;
	
	public static Achievement tradeClericLvl2;
	public static Achievement tradeClericLvl3;
	public static Achievement tradeClericLvl4;
	public static Achievement tradeClericLvl5;
	
	public static Achievement tradeButcherLvl2;
	public static Achievement tradeButcherLvl3;
	public static Achievement tradeButcherLvl4;
	public static Achievement tradeButcherLvl5;
	
	public static Achievement tradeLibrarianLvl2;
	public static Achievement tradeLibrarianLvl3;
	public static Achievement tradeLibrarianLvl4;
	public static Achievement tradeLibrarianLvl5;

	public static Achievement craftEye;
	public static Achievement travelEnd;
	public static Achievement killDragon;
	public static Achievement craftSteelIngot;
	public static Achievement craftSteelTools;
	public static Achievement craftSteelArmor;	
	public static Achievement craftInfernalEnchater;
	
	public static Achievement craftInfusedSkull;
	public static Achievement killWither;
	public static Achievement findNetherstar;
	public static Achievement craftForge;
	public static Achievement craftBlockDispenser;
	
	
	public static void initialize() {
		
		/*
		 * DO NOT set any achievement to independent (i.e. don't call .setIndependent())
		 * as this may cause issues for some achievement triggers. Setting the parent
		 * achievement to null works completely fine so there shouldn't be a reason to
		 * use it anyway.
		 */

		AchievementTab tabBTW = new AchievementTab("btw").setIcon(FCBetterThanWolves.fcCompanionCube);
		
		/* Reed branch */

		findReeds = (new Achievement("findReeds", 0, -3, Item.reed,  null, null))
				.registerAchievement(tabBTW);
		
		craftWicker = (new Achievement("craftWicker", 1, -3, FCBetterThanWolves.fcItemWickerWeaving,  findReeds))
				.registerAchievement(tabBTW);
		
		craftBasket = (new Achievement("craftBasket", 2, -3, FCBetterThanWolves.fcBlockBasketWicker,  craftWicker))
				.registerAchievement(tabBTW);
		
		/* Bone Branch */
		
		findBones = (new Achievement("findBones", 0, 2, Item.bone, null, null))
				.registerAchievement(tabBTW);
		
		craftBoneClub = (new Achievement("craftBoneClub", 1, 2, FCBetterThanWolves.fcItemClubBone, findBones))
				.registerAchievement(tabBTW); 
		
		craftBoneHook = (new Achievement("craftBoneHook", 1, 3, FCBetterThanWolves.fcItemFishHookBone, findBones))
				.registerAchievement(tabBTW); 
				
		baitFishingRod = (new Achievement("baitFishingRod", 2, 3, FCBetterThanWolves.fcItemFishingRodBaited, craftBoneHook))
				.registerAchievement(tabBTW); 
		
		/* Main Branch */
		
		findShaft = (new Achievement("findShaft", 0, 0, Item.stick,  null, null))
				.registerAchievement(tabBTW);
		
		craftFirePlow = (new Achievement("craftFirePlow", 1, -1, FCBetterThanWolves.fcItemFireStarterSticks, findShaft))
				.registerAchievement(tabBTW);
		
		craftCampfire = (new Achievement("craftCampfire", 2, -1, FCBetterThanWolves.fcBlockCampfireUnlit, craftFirePlow))
				.registerAchievement(tabBTW);
		
		cookMeat = (new Achievement("cookMeat", 3, -1, Item.beefCooked, craftCampfire))
				.registerAchievement(tabBTW);
		
		craftPointyStick = (new Achievement("craftPointyStick", 4, 0, FCBetterThanWolves.fcItemChiselWood, findShaft))
				.registerAchievement(tabBTW);
		
		craftKnittingNeedles = (new Achievement("craftKnittingNeedles", 5, -1, FCBetterThanWolves.fcItemKnittingNeedles, craftPointyStick))
				.registerAchievement(tabBTW);
		
		craftWoolArmor = (new Achievement("craftWoolArmor", 6, -1, FCBetterThanWolves.fcItemArmorWoolBoots, craftKnittingNeedles))
				.registerAchievement(tabBTW);
		
		craftSharpStone = (new Achievement("craftSharpStone", 6, 0, FCBetterThanWolves.fcItemChiselStone, craftPointyStick))
				.registerAchievement(tabBTW);
		
		findString = (new Achievement("findString", 7, 0, Item.silk, craftSharpStone))
				.registerAchievement(tabBTW);
		
		craftBowDrill = (new Achievement("craftBowDrill", 8, -2, FCBetterThanWolves.fcItemFireStarterBow, findString))
				.registerAchievement(tabBTW);
		
		craftStoneAxe = (new Achievement("craftStoneAxe", 8, -1, Item.axeStone, findString))
				.registerAchievement(tabBTW);
		
		findWood = (new Achievement("findWood", 9, -1, Block.wood, craftStoneAxe))
				.registerAchievement(tabBTW);
		
		craftStoneShovel = (new Achievement("craftStoneShovel", 8, 0, Item.shovelStone, findString))
				.registerAchievement(tabBTW);
		
		dryBricks = (new Achievement("dryBricks", 9, 0, Item.brick, craftStoneShovel))
				.registerAchievement(tabBTW);
		
		craftOven = (new Achievement("craftOven", 10, 0, FCBetterThanWolves.fcBlockFurnaceBrickIdle, dryBricks))
				.registerAchievement(tabBTW);
		
		findIronChunk = (new Achievement("findIronChunk", 11, 1, FCBetterThanWolves.fcItemChunkIronOre, craftSharpStone))
				.registerAchievement(tabBTW);
		
		cookIron = (new Achievement("cookIron", 11, 0, FCBetterThanWolves.fcItemNuggetIron, craftOven, findIronChunk))
				.registerAchievement(tabBTW);
		
		craftIronChisel = (new Achievement("craftIronChisel", 12, 0, FCBetterThanWolves.fcItemChiselIron, cookIron))
				.registerAchievement(tabBTW);
		
		findStoneBrick = (new Achievement("findStoneBrick", 12, -1, FCBetterThanWolves.fcItemStoneBrick, craftIronChisel))
				.registerAchievement(tabBTW);
		
		craftWorkbench = (new Achievement("craftWorkbench", 13, 0, FCBetterThanWolves.fcBlockWorkStump, craftIronChisel))
				.registerAchievement(tabBTW);
		
		craftStonePick = (new Achievement("craftStonePick", 13, 1, Item.pickaxeStone, craftWorkbench))
				.registerAchievement(tabBTW);
		
		craftIronIngot = (new Achievement("craftIronIngot", 14, 0, Item.ingotIron, craftWorkbench))
				.registerAchievement(tabBTW);
		
		craftIronArmor = (new Achievement("craftIronArmor", 15, -4, Item.plateIron, craftIronIngot))
				.registerAchievement(tabBTW);
		
		craftCauldron = (new Achievement("craftCauldron", 15, -3, FCBetterThanWolves.fcCauldron, craftIronIngot))
				.registerAchievement(tabBTW);
		
		craftIronPick = (new Achievement("craftIronPick", 15, -2, Item.pickaxeIron, craftIronIngot))
				.registerAchievement(tabBTW);
		
		craftIronSword = (new Achievement("craftIronSword", 15, -1, Item.swordIron, craftIronIngot))
				.registerAchievement(tabBTW);
		
		craftIronAxe = (new Achievement("craftIronAxe", 15, 0, Item.axeIron, craftIronIngot))
				.registerAchievement(tabBTW);
		
		craftIronHoe = (new Achievement("craftIronHoe", 15, 1, Item.hoeIron, craftIronIngot))
				.registerAchievement(tabBTW);
		
		craftShears = (new Achievement("craftShears", 15, 2, Item.shears, craftIronIngot))
				.registerAchievement(tabBTW);
		
		findHempSeeds = (new Achievement("findHempSeeds", 16, 1, FCBetterThanWolves.fcItemHempSeeds, craftIronHoe))
				.registerAchievement(tabBTW);
		
		harvestHemp = (new Achievement("harvestHemp", 16, 2, FCBetterThanWolves.fcItemHemp, craftShears))
				.registerAchievement(tabBTW);
		
		findCreeperOysters = (new Achievement("findCreeperOysters", 15, 4, FCBetterThanWolves.fcItemCreeperOysters, craftShears))
				.registerAchievement(tabBTW);
		
		findDiamonds = (new Achievement("findDiamonds", 13, 5, Item.diamond, null, null))
				.registerAchievement(tabBTW);
		
		craftDiamondIngot = (new Achievement("craftDiamondIngot", 15, 5, FCBetterThanWolves.fcItemIngotDiamond, craftIronIngot, findCreeperOysters, findDiamonds))
				.registerAchievement(tabBTW);
		
		craftPlanks = (new Achievement("craftPlanks", 16, 0, Block.planks, craftIronAxe))
				.registerAchievement(tabBTW);
		
		craftHamper = (new Achievement("craftHamper", 17, -1, FCBetterThanWolves.fcBlockHamper, craftPlanks))
				.registerAchievement(tabBTW);
		
		craftGear = (new Achievement("craftGear", 18, 0, FCBetterThanWolves.fcItemGear, craftPlanks))
				.registerAchievement(tabBTW);
		
		craftMillstone = (new Achievement("craftMillstone", 20, 0, FCBetterThanWolves.fcMillStone, craftGear))
				.registerAchievement(tabBTW);
		
		craftHandCrank = (new Achievement("craftHandCrank", 19, -1, FCBetterThanWolves.fcHandCrank, craftGear))
				.registerAchievement(tabBTW);
		
		craftScouredLeather = (new Achievement("craftScouredLeather", 20, -1, FCBetterThanWolves.fcItemScouredLeather, craftMillstone))
				.registerAchievement(tabBTW);
		
		findDung = (new Achievement("findDung", 20, -4, FCBetterThanWolves.fcItemDung, null, null))
				.registerAchievement(tabBTW);
		
		craftTannedLeather = (new Achievement("craftTannedLeather", 20, -3, FCBetterThanWolves.fcItemTannedLeather, craftCauldron, findDung, craftScouredLeather))
				.registerAchievement(tabBTW);
		
		craftSaw = (new Achievement("craftSaw", 21, -3, FCBetterThanWolves.fcSaw, craftTannedLeather))
				.registerAchievement(tabBTW);
		
		craftBellows = (new Achievement("craftBellows", 22, -3, FCBetterThanWolves.fcBellows, craftSaw))
				.registerAchievement(tabBTW);
		
		craftTurntable = (new Achievement("craftTurntable", 22, -2, FCBetterThanWolves.fcTurntable, craftSaw))
				.registerAchievement(tabBTW);
		
		craftHopper = (new Achievement("craftHopper", 26, -1, FCBetterThanWolves.fcHopper, craftSaw))
				.registerAchievement(tabBTW);
		
		craftPottery = (new Achievement("craftPottery", 23, -2, FCBetterThanWolves.fcUnfiredPottery, craftTurntable))
				.registerAchievement(tabBTW); 
		
		craftHempFibers = (new Achievement("craftHempFibers", 19, 2, FCBetterThanWolves.fcItemHempFibers, harvestHemp))
				.registerAchievement(tabBTW); 
		
		craftAxle = (new Achievement("craftAxle", 20, 2, FCBetterThanWolves.fcBlockAxle, craftHempFibers))
				.registerAchievement(tabBTW); 
		
		craftGearBox = (new Achievement("craftGearBox", 21, 2, FCBetterThanWolves.fcBlockGearBox, craftAxle))
				.registerAchievement(tabBTW); 
		
		craftFabric = (new Achievement("craftFabric", 20, 3, FCBetterThanWolves.fcItemHempCloth, craftHempFibers))
				.registerAchievement(tabBTW);
		
		craftWindmill = (new Achievement("craftWindmill", 21, 3, FCBetterThanWolves.fcItemWindMill, craftFabric))
				.registerAchievement(tabBTW);
		
		craftPadding = (new Achievement("craftPadding", 20, 4, FCBetterThanWolves.fcItemPadding, craftHempFibers))
				.registerAchievement(tabBTW);
		
		craftDiamondArmor = (new Achievement("craftDiamondArmor", 20, 5, Item.plateDiamond, craftPadding, craftDiamondIngot))
				.registerAchievement(tabBTW);
		
		craftDiamondPick = (new Achievement("craftDiamondPick", 20, 6, Item.pickaxeDiamond, craftDiamondIngot))
				.registerAchievement(tabBTW);
		
		findObsidian = (new Achievement("findObsidian", 21, 6, Block.obsidian, craftDiamondPick))
				.registerAchievement(tabBTW);
		
		travelNether = (new Achievement("travelNether", 23, 6, Block.portal, findObsidian))
				.registerAchievement(tabBTW);
		
		craftGroundNetherrack = (new Achievement("craftGroundNetherrack", 23, 1, FCBetterThanWolves.fcItemGroundNetherrack, travelNether, craftMillstone))
				.registerAchievement(tabBTW);
		
		findDormantForge = (new Achievement("findDormantForge", 24, 6, FCBetterThanWolves.fcBlockSoulforgeDormant, travelNether))
				.registerAchievement(tabBTW);
		
		findBlazeRod = (new Achievement("findBlazeRod", 24, 4, Item.blazeRod, travelNether))
				.registerAchievement(tabBTW);
		
		craftHibachi = (new Achievement("craftHibachi", 25, 4, FCBetterThanWolves.fcBBQ, findBlazeRod))
				.registerAchievement(tabBTW);
		
		cookUrn = (new Achievement("cookUrn", 26, 3, FCBetterThanWolves.fcItemUrn, craftHibachi))
				.registerAchievement(tabBTW);
		
		cookCrucible = (new Achievement("cookCrucible", 26, 4, FCBetterThanWolves.fcCrucible, craftHibachi))
				.registerAchievement(tabBTW);
		
		craftWaterwheel = (new Achievement("craftWaterwheel", 26, 5, FCBetterThanWolves.fcItemWaterWheel, craftHibachi))
				.registerAchievement(tabBTW);
		
		//need to replace the displayed item, but enchanted items break the gui
		craftSoulUrn = (new Achievement("craftSoulUrn", 26, 1, FCBetterThanWolves.fcItemUrn, cookUrn, craftGroundNetherrack, craftHopper))
				.registerAchievement(tabBTW);
		
		cureZombieVillager = (new Achievement("cureZombieVillager", 27, 1, Item.emerald, craftSoulUrn))
				.registerAchievement(tabBTW);
		
		/* Trades */
		
		tradeFarmerLvl2 = (new Achievement("tradeFarmerLvl2", 28, -1, Item.hoeIron, cureZombieVillager))
				.registerAchievement(tabBTW);
		
		tradeFarmerLvl3 = (new Achievement("tradeFarmerLvl3", 29, -1, FCBetterThanWolves.fcMillStone, tradeFarmerLvl2))
				.registerAchievement(tabBTW);
		
		tradeFarmerLvl4 = (new Achievement("tradeFarmerLvl4", 30, -1, FCBetterThanWolves.fcItemWaterWheel, tradeFarmerLvl3))
				.registerAchievement(tabBTW);
		
		tradeFarmerLvl5 = (new Achievement("tradeFarmerLvl5", 31, -1, FCBetterThanWolves.fcBlockPlanterSoil, tradeFarmerLvl4))
				.registerAchievement(tabBTW);
		
		
		tradeClericLvl2 = (new Achievement("tradeClericLvl2", 28, 0, Item.book, cureZombieVillager))
				.registerAchievement(tabBTW);
		
		tradeClericLvl3 = (new Achievement("tradeClericLvl3", 29, 0, Item.brewingStand, tradeClericLvl2))
				.registerAchievement(tabBTW);
		
		tradeClericLvl4 = (new Achievement("tradeClericLvl4", 30, 0, FCBetterThanWolves.fcBlockDispenser, tradeClericLvl3))
				.registerAchievement(tabBTW);
		
		tradeClericLvl5 = (new Achievement("tradeClericLvl5", 31, 0, FCBetterThanWolves.fcItemEnderSpectacles, tradeClericLvl4))
				.registerAchievement(tabBTW);
		
		
		tradeButcherLvl2 = (new Achievement("tradeButcherLvl2", 28, 1, FCBetterThanWolves.fcCauldron, cureZombieVillager))
				.registerAchievement(tabBTW);
		
		tradeButcherLvl3 = (new Achievement("tradeButcherLvl3", 29, 1, FCBetterThanWolves.fcSaw, tradeButcherLvl2))
				.registerAchievement(tabBTW);
		
		tradeButcherLvl4 = (new Achievement("tradeButcherLvl4", 30, 1, FCBetterThanWolves.fcItemBreedingHarness, tradeButcherLvl3))
				.registerAchievement(tabBTW);
		
		//TODO: fix display block
		tradeButcherLvl5 = (new Achievement("tradeButcherLvl5", 31, 1, FCBetterThanWolves.fcBlockStoneBrickLoose, tradeButcherLvl4))
				.registerAchievement(tabBTW);
		
		
		tradeLibrarianLvl2 = (new Achievement("tradeLibrarianLvl2", 28, 2, Block.enchantmentTable, cureZombieVillager))
				.registerAchievement(tabBTW);
		
		tradeLibrarianLvl3 = (new Achievement("tradeLibrarianLvl3", 29, 2, FCBetterThanWolves.fcBlockArcaneVessel, tradeLibrarianLvl2))
				.registerAchievement(tabBTW);
		
		tradeLibrarianLvl4 = (new Achievement("tradeLibrarianLvl4", 30, 2, Block.skull, tradeLibrarianLvl3))
				.registerAchievement(tabBTW);
		
		tradeLibrarianLvl5 = (new Achievement("tradeLibrarianLvl5", 31, 2, FCBetterThanWolves.fcInfernalEnchanter, tradeLibrarianLvl4))
				.registerAchievement(tabBTW);
		
		craftInfusedSkull = (new Achievement("craftInfusedSkull", 30, 3, Block.skull, tradeLibrarianLvl4))
				.registerAchievement(tabBTW);
		
		killWither = (new Achievement("killWither", 31, 3, Block.skull, craftInfusedSkull))
				.registerAchievement(tabBTW);
		
		findNetherstar = (new Achievement("findNetherstar", 31, 4, Item.netherStar, killWither))
				.registerAchievement(tabBTW);
		
		craftForge = (new Achievement("craftForge", 31, 6, FCBetterThanWolves.fcAnvil, findNetherstar, findDormantForge))
				.registerAchievement(tabBTW);
		
		craftEye = (new Achievement("craftEye", 32, 0, Item.eyeOfEnder, tradeClericLvl5))
				.registerAchievement(tabBTW);
		
		travelEnd = (new Achievement("travelEnd", 33, 0, Block.endPortalFrame, craftEye))
				.registerAchievement(tabBTW);
		
		killDragon = (new Achievement("killDragon", 34, 0, Block.dragonEgg, travelEnd))
				.registerAchievement(tabBTW);
		
		craftSteelIngot = (new Achievement("craftSteelIngot", 35, 0, FCBetterThanWolves.fcItemSteel, killDragon))
				.registerAchievement(tabBTW);
		
		craftSteelTools = (new Achievement("craftSteelTools", 36, 0, FCBetterThanWolves.fcItemBattleAxe, craftSteelIngot))
				.registerAchievement(tabBTW);
		
		craftSteelArmor = (new Achievement("craftSteelArmor", 36, 1, FCBetterThanWolves.fcItemPlateBreastPlate, craftSteelIngot))
				.registerAchievement(tabBTW);
		
		craftInfernalEnchater = (new Achievement("craftInfernalEnchater", 36, -1, FCBetterThanWolves.fcInfernalEnchanter, craftSteelIngot))
				.registerAchievement(tabBTW);
		
		System.out.println("BTW Tab: " + tabBTW.size() + " achievements");

	}


	private static int vPos(int vPos)
	{
		return vPos * 2;
	}


	private static int hPos(int hPos)
	{
		return hPos * 2;
	}
	

}
