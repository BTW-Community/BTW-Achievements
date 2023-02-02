package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.server.MinecraftServer;

public class BAMCommand extends CommandBase {

	private String[] commands = new String[] {
			"only",
			"upto",
	};

	private String[] achievementNames = new String[] {
			"findReeds",
			"craftWicker",	
			"craftBasket",	
			"findBones",
			"craftBoneClub",
			"craftBoneHook",
			"baitFishingRod",
			"findShaft",
			"craftWoodClub",
			"craftFirePlow",
			"craftCampfire",
			"cookMeat",
			"craftPointyStick",
			"craftKnittingNeedles",
			"craftWoolArmor",
			"craftSharpStone",
			"findString",
			"craftBowDrill",
			"craftStoneAxe",
			"findWood",
			"craftStoneShovel",
			"dryBricks",
			"findIronChunk",
			"craftOven",
			"cookIron",
			"craftIronChisel",
			"findStoneBrick",
			"craftWorkbench",
			"craftStonePick",
			"craftIronIngot",
			"craftIronPick",
			"craftIronSword",
			"craftIronHoe",
			"craftShears",
			"craftCauldron",
			"craftIronAxe",
			"craftIronArmor",
			"findDung",
			"craftScouredLeather",
			"craftTannedLeather",
			"craftSaw",
			"craftBellows",
			"craftTurntable",
			"craftPottery",
			"craftHopper",
			"craftPlanks",
			"craftHamper",
			"craftGear",
			"craftHandCrank",
			"craftMillstone",
			"findHempSeeds",
			"harvestHemp",
			"craftHempFibers",
			"craftAxle",
			"craftGearBox",
			"craftFabric",
			"craftWindmill",
			"craftPadding",
			"findDiamonds",
			"craftDiamondIngot",
			"findCreeperOysters",
			"craftDiamondArmor",
			"craftDiamondPick",
			"findObsidian",
			"travelNether",
			"findDormantForge",
			"findBlazeRod",
			"craftGroundNetherrack",
			"craftHibachi",
			"cookUrn",
			"cookCrucible",
			"craftWaterwheel",
			"craftSoulUrn",
			"cureZombieVillager",
			"tradeFarmerLvl2",
			"tradeFarmerLvl3",
			"tradeFarmerLvl4",
			"tradeFarmerLvl5",
			"tradeButcherLvl2",
			"tradeButcherLvl3",
			"tradeButcherLvl4",
			"tradeButcherLvl5",
			"tradeBlacksmithLvl2",
			"tradeBlacksmithLvl3",
			"tradeBlacksmithLvl4",
			"tradeBlacksmithLvl5",
			"tradePriestLvl2",
			"tradePriestLvl3",
			"tradePriestLvl4",
			"tradePriestLvl5",
			"tradeLibrarianLvl2",
			"tradeLibrarianLvl3",
			"tradeLibrarianLvl4",
			"tradeLibrarianLvl5",
			"craftEye",
			"travelEnd",
			"killDragon",
			"craftSteelIngot",
			"craftSteelTools",
			"craftSteelArmor",	
			"craftInfernalEnchater",
			"craftInfusedSkull",
			"killWither",
			"findNetherstar",
			"craftBeacon",
			"craftForge",
			"craftBlockDispenser",
			"steelBeacon",
			"eatOysters",
			"cleanFarmer",
			"milkBucket",
			"eatMysteryMeat",
	};

	@Override
	public String getCommandName() {
		return "achievements";
	}

	@Override
	public int getRequiredPermissionLevel()
	{
		return 2;
	}

	@Override
	public void processCommand(ICommandSender commandSender, String[] commandTokens) {

		if (commandTokens.length > 0)
		{	
			Achievement achievement = null;
			EntityPlayer player = func_82359_c(commandSender, commandTokens[0]); //getPlayer
			
			if (commandTokens.length > 1) { 

				for (String name : achievementNames) {
					if (commandTokens[2].equalsIgnoreCase(name))
					{
						achievement = BAMAchievements.getAchievement(name);
					}
				}

				if (achievement != null && achievement.isAchievement() && commandTokens.length > 2)
				{

					AchievementsCore ac = AchievementsCore.getInstance();

					
					if (commandTokens[1].equalsIgnoreCase("only"))
					{
						if (!ac.hasUnlocked(player, achievement))
						{
							if (ac.canUnlock(player, achievement))
							{
								player.triggerAchievement(achievement);
							}
							else
							{
								commandSender.sendChatToPlayer(EnumChatFormatting.RED + "Achievement can't be unlocked");
							}
						}
						else
						{
							commandSender.sendChatToPlayer(EnumChatFormatting.RED + "Achievement has already been unlocked");
						}
					}
					else if (commandTokens[1].equalsIgnoreCase("upto"))
					{
						checkPreviousAchievement(player, ac, achievement);			
						player.triggerAchievement(achievement);
						achievementsToUnlock.clear();
					}
				}
				else
				{
					commandSender.sendChatToPlayer(EnumChatFormatting.RED + "No Achievement found with that name");
				}

			}
			else
			{
				printUsageError(commandSender);
			}
		}
		else
		{
			printUsageError(commandSender);
		}
	}
	
	private void printUsageError(ICommandSender commandSender)
	{
		commandSender.sendChatToPlayer(EnumChatFormatting.RED + "Usage: /achievements <playerName> <only/upto> <achievementName>");
	}
	
	
	private ArrayList<Achievement> achievementsToUnlock = new ArrayList<Achievement>();
	
	private void checkPreviousAchievement(EntityPlayer player, AchievementsCore ac, Achievement achievement)
	{

		if (achievement != null && !ac.hasUnlocked(player, achievement) && ac.canUnlock(player, achievement))
		{
			triggerAchievements(player);
		}

		Achievement[] prequisites = null;

		if (achievement != null)
		{
			prequisites = achievement.parentAchievements;
		}

		if (prequisites != null)
		{
			for( Achievement p : prequisites)
			{ 
				achievementsToUnlock.add(0, p); 	
				
				if(prequisites.length > 0 && !ac.hasUnlocked(player, p))
				{
					checkPreviousAchievement(player, ac, p);
				}
			}
		}
	}

	private void triggerAchievements(EntityPlayer player)
	{
		for (Achievement a : achievementsToUnlock) {
			//System.out.println(a);
			player.triggerAchievement(a);
		}
	}

	/**
	 * Adds the strings available in this command to the given list of tab completion options.
	 */
	public List addTabCompletionOptions(ICommandSender commandSender, String[] commandTokens)
	{
		return commandTokens.length == 1 ?
				getListOfStringsMatchingLastWord(commandTokens, this.getPlayers()) : commandTokens.length == 2 ?
						getListOfStringsMatchingLastWord(commandTokens, commands) : commandTokens.length == 3 ?
								getListOfStringsMatchingLastWord(commandTokens, achievementNames) : null;
	}

	protected String[] getPlayers()
	{
		return MinecraftServer.getServer().getAllUsernames();
	}

}
