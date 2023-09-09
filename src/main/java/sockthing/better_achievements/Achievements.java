package sockthing.better_achievements;

import btw.block.BTWBlocks;
import issame.achievements_core.achievements.Achievement;
import issame.achievements_core.achievements.AchievementTab;
import net.minecraft.src.Item;

public class Achievements {
    private static AchievementTab tabBTW = new AchievementTab("btw").setIcon(BTWBlocks.companionCube);

    public static Achievement findReeds;
    public static Achievement craftWicker;
    public static Achievement craftBasket;

    public static Achievement findBones;
    public static Achievement craftBoneClub;
    public static Achievement craftBoneHook;
    public static Achievement baitFishingRod;

    public static Achievement findShaft;
    public static Achievement craftWoodClub;
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

    public static Achievement tradeButcherLvl2;
    public static Achievement tradeButcherLvl3;
    public static Achievement tradeButcherLvl4;
    public static Achievement tradeButcherLvl5;

    public static Achievement tradeBlacksmithLvl2;
    public static Achievement tradeBlacksmithLvl3;
    public static Achievement tradeBlacksmithLvl4;
    public static Achievement tradeBlacksmithLvl5;

    public static Achievement tradePriestLvl2;
    public static Achievement tradePriestLvl3;
    public static Achievement tradePriestLvl4;
    public static Achievement tradePriestLvl5;

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
    public static Achievement craftBeacon;
    public static Achievement craftForge;
    public static Achievement craftBlockDispenser;

    public static Achievement steelBeacon;

    private static AchievementTab tabFun = new AchievementTab("fun").setIcon(Item.cake);
    public static Achievement eatOysters;
    //public static Achievement powerCake;
    public static Achievement cleanFarmer;
    public static Achievement milkBucket;
    public static Achievement eatMysteryMeat;

    public static void setupAchievements() {
        findReeds = new Achievement("findReeds", 0, -3, Item.reed, tabBTW);
    }
}
