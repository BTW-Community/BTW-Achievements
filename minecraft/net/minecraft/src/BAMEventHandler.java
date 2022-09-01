package net.minecraft.src;

import net.minecraft.src.EventListener;
import btw.community.sockthing.EventType;
import net.minecraft.src.AchievementList;
import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityCreeper;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPig;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.FCBetterThanWolves;
import net.minecraft.src.Item;
import net.minecraft.src.ItemPotion;
import net.minecraft.src.ItemShears;
import net.minecraft.src.ItemStack;

/**
 * An example event handler.
 * 
 * The names of the functions do not matter, all you need are the annotations
 * and the relevant parameters.
 */
public class BAMEventHandler {
	
	@EventListener(EventType.CRAFTED)
	public void onCrafted(EntityPlayer player, ItemStack itemstack)
	{
		if (itemstack.itemID == FCBetterThanWolves.fcItemWickerPiece.itemID) {
            player.triggerAchievement(BAMAchievements.craftWicker);
            return;
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcBlockBasketWicker.blockID) {
            player.triggerAchievement(BAMAchievements.craftBasket);
            return;
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcItemClubBone.itemID) {
            player.triggerAchievement(BAMAchievements.craftBoneClub);
            return;
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcItemFishHookBone.itemID) {
            player.triggerAchievement(BAMAchievements.craftBoneHook);
            return;
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcItemFishingRodBaited.itemID) {
            player.triggerAchievement(BAMAchievements.baitFishingRod);
            return;
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcItemFireStarterSticks.itemID) {
            player.triggerAchievement(BAMAchievements.craftFirePlow);
            return;
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcBlockCampfireUnlit.blockID) {
            player.triggerAchievement(BAMAchievements.craftCampfire);
            return;
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcItemChiselWood.itemID) {
            player.triggerAchievement(BAMAchievements.craftPointyStick);
            return;
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcItemKnittingNeedles.itemID) {
            player.triggerAchievement(BAMAchievements.craftKnittingNeedles);
            return;
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcItemArmorWoolBoots.itemID ||
				itemstack.itemID == FCBetterThanWolves.fcItemArmorWoolLeggings.itemID ||
				itemstack.itemID == FCBetterThanWolves.fcItemArmorWoolChest.itemID ||
				itemstack.itemID == FCBetterThanWolves.fcItemArmorWoolHelm.itemID) {
            player.triggerAchievement(BAMAchievements.craftWoolArmor);
            return;
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcItemChiselStone.itemID) {
            player.triggerAchievement(BAMAchievements.craftSharpStone);
            return;
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcItemFireStarterBow.itemID) {
            player.triggerAchievement(BAMAchievements.craftBowDrill);
            return;
        }
		else if (itemstack.itemID == Item.axeStone.itemID) {
            player.triggerAchievement(BAMAchievements.craftStoneAxe);
            return;
        }
		else if (itemstack.itemID == Item.shovelStone.itemID) {
            player.triggerAchievement(BAMAchievements.craftStoneShovel);
            return;
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcBlockFurnaceBrickIdle.blockID) {
            player.triggerAchievement(BAMAchievements.craftOven);
            return;
        }
		else if (itemstack.itemID ==  FCBetterThanWolves.fcItemChunkIronOre.itemID) {
            player.triggerAchievement(BAMAchievements.findIronChunk);
            return;
        }
		else if (itemstack.itemID ==  FCBetterThanWolves.fcItemChiselIron.itemID) {
            player.triggerAchievement(BAMAchievements.craftIronChisel);
            return;
        }
		else if (itemstack.itemID ==  Item.pickaxeStone.itemID) {
            player.triggerAchievement(BAMAchievements.craftStonePick);
            return;
        }
		else if (itemstack.itemID ==  Item.ingotIron.itemID) {
            player.triggerAchievement(BAMAchievements.craftIronIngot);
            return;
        }
		else if (itemstack.itemID ==  Item.bootsIron.itemID ||
				itemstack.itemID ==  Item.legsIron.itemID ||
				itemstack.itemID ==  Item.plateIron.itemID ||
				itemstack.itemID ==  Item.helmetIron.itemID) {
            player.triggerAchievement(BAMAchievements.craftIronArmor);
            return;
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcCauldron.blockID) {
            player.triggerAchievement(BAMAchievements.craftCauldron);
            return;
        }
		else if (itemstack.itemID ==  Item.pickaxeIron.itemID) {
            player.triggerAchievement(BAMAchievements.craftIronPick);
            return;
        }
		else if (itemstack.itemID == Item.swordIron.itemID) {
            player.triggerAchievement(BAMAchievements.craftIronSword);
            return;
        }
		else if (itemstack.itemID == Item.axeIron.itemID) {
            player.triggerAchievement(BAMAchievements.craftIronAxe);
            return;
        }
		else if (itemstack.itemID == Item.hoeIron.itemID) {
            player.triggerAchievement(BAMAchievements.craftIronHoe);
            return;
        }
		else if (itemstack.itemID == Item.shears.itemID) {
            player.triggerAchievement(BAMAchievements.craftShears);
            return;
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcItemIngotDiamond.itemID) {
            player.triggerAchievement(BAMAchievements.craftDiamondIngot);
            return;
        }
		else if (itemstack.itemID == Block.planks.blockID) {
            player.triggerAchievement(BAMAchievements.craftPlanks);
            return;
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcBlockHamper.blockID) {
            player.triggerAchievement(BAMAchievements.craftHamper);
            return;
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcItemGear.itemID) {
            player.triggerAchievement(BAMAchievements.craftGear);
            return;
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcMillStone.blockID) {
            player.triggerAchievement(BAMAchievements.craftMillstone);
            return;
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcHandCrank.blockID) {
            player.triggerAchievement(BAMAchievements.craftHandCrank);
            return;
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcSaw.blockID) {
            player.triggerAchievement(BAMAchievements.craftSaw);
            return;
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcBellows.blockID) {
            player.triggerAchievement(BAMAchievements.craftBellows);
            return;
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcTurntable.blockID) {
            player.triggerAchievement(BAMAchievements.craftTurntable);
            return;
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcHopper.blockID) {
            player.triggerAchievement(BAMAchievements.craftHopper);
            return;
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcBlockAxle.blockID) {
            player.triggerAchievement(BAMAchievements.craftAxle);
            return;
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcBlockGearBox.blockID) {
            player.triggerAchievement(BAMAchievements.craftGearBox);
            return;
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcItemHempCloth.itemID) {
            player.triggerAchievement(BAMAchievements.craftFabric);
            return;
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcItemWindMill.itemID) {
            player.triggerAchievement(BAMAchievements.craftWindmill);
            return;
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcItemPadding.itemID) {
            player.triggerAchievement(BAMAchievements.craftPadding);
            return;
        }
		else if (itemstack.itemID ==  Item.bootsDiamond.itemID ||
				itemstack.itemID ==  Item.legsDiamond.itemID ||
				itemstack.itemID ==  Item.plateDiamond.itemID ||
				itemstack.itemID ==  Item.helmetDiamond.itemID) {
            player.triggerAchievement(BAMAchievements.craftDiamondArmor);
            return;
        }
		else if (itemstack.itemID == Item.pickaxeDiamond.itemID) {
            player.triggerAchievement(BAMAchievements.craftDiamondPick);
            return;
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcBBQ.blockID) {
            player.triggerAchievement(BAMAchievements.craftHibachi);
            return;
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcItemWaterWheel.itemID) {
            player.triggerAchievement(BAMAchievements.craftWaterwheel);
            return;
        }
		else if (itemstack.itemID == Item.skull.itemID && itemstack.getItemDamage() == 5)
		{
			player.triggerAchievement(BAMAchievements.craftInfusedSkull);
			return;
		}
		else if (itemstack.itemID == Block.beacon.blockID) {
            player.triggerAchievement(BAMAchievements.craftBeacon);
            return;
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcAnvil.blockID) {
            player.triggerAchievement(BAMAchievements.craftForge);
            return;
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcBlockDispenser.blockID) {
            player.triggerAchievement(BAMAchievements.craftBlockDispenser);
            return;
        }
		else if (itemstack.itemID ==  FCBetterThanWolves.fcItemRefinedPickAxe.itemID ||
				itemstack.itemID ==  FCBetterThanWolves.fcItemRefinedAxe.itemID ||
				itemstack.itemID ==  FCBetterThanWolves.fcItemRefinedHoe.itemID ||
				itemstack.itemID ==  FCBetterThanWolves.fcItemRefinedShovel.itemID) {
            player.triggerAchievement(BAMAchievements.craftSteelArmor);
            return;
        }
		else if (itemstack.itemID ==  FCBetterThanWolves.fcItemPlateBoots.itemID ||
				itemstack.itemID ==  FCBetterThanWolves.fcItemPlateLeggings.itemID ||
				itemstack.itemID ==  FCBetterThanWolves.fcItemPlateBreastPlate.itemID ||
				itemstack.itemID ==  FCBetterThanWolves.fcItemPlateHelm.itemID) {
            player.triggerAchievement(BAMAchievements.craftSteelArmor);
            return;
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcInfernalEnchanter.blockID) {
            player.triggerAchievement(BAMAchievements.craftInfernalEnchater);
            return;
        }
	}
	
	@EventListener(EventType.COOKED)
	public void onCooked(EntityPlayer player, ItemStack itemstack)
	{
		if (itemstack.itemID == Item.beefCooked.itemID ||
			itemstack.itemID == Item.porkCooked.itemID ||
			itemstack.itemID == Item.chickenCooked.itemID ||
			itemstack.itemID == FCBetterThanWolves.fcItemMuttonCooked.itemID)
		{
            player.triggerAchievement(BAMAchievements.cookMeat);
            return;
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcItemNuggetIron.itemID) {
            player.triggerAchievement(BAMAchievements.cookIron);
            return;
        }
	}
	
	@EventListener(EventType.BREWED)
	public void onBrewed(EntityPlayer player, ItemStack itemstack) {

	}
	
	@EventListener(EventType.PICKUP)
	public void onPickup(EntityPlayer player, ItemStack itemstack)
	{
		if (itemstack.itemID == Item.reed.itemID) {
            player.triggerAchievement(BAMAchievements.findReeds);
            return;
        }
		else if (itemstack.itemID == Item.bone.itemID) {
            player.triggerAchievement(BAMAchievements.findBones);
            return;
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcItemFishHookBone.itemID) {
            player.triggerAchievement(BAMAchievements.craftBoneHook);
            return;
        }
		else if (itemstack.itemID == Item.stick.itemID) {
            player.triggerAchievement(BAMAchievements.findShaft);
            return;
        }
		else if (itemstack.itemID == Item.silk.itemID) {
            player.triggerAchievement(BAMAchievements.findString);
            return;
        }
		else if (itemstack.itemID == Item.brick.itemID) {
            player.triggerAchievement(BAMAchievements.dryBricks);
            return;
        }
		else if (itemstack.itemID == Block.wood.blockID) {
            player.triggerAchievement(BAMAchievements.findWood);
            return;
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcItemChunkIronOre.itemID) {
            player.triggerAchievement(BAMAchievements.findIronChunk);
            return;
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcItemStoneBrick.itemID) {
            player.triggerAchievement(BAMAchievements.findStoneBrick);
            return;
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcItemHempSeeds.itemID) {
            player.triggerAchievement(BAMAchievements.findHempSeeds);
            return;
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcItemHemp.itemID) {
            player.triggerAchievement(BAMAchievements.harvestHemp);
            return;
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcItemCreeperOysters.itemID) {
            player.triggerAchievement(BAMAchievements.findCreeperOysters);
            return;
        }
		else if (itemstack.itemID == Item.diamond.itemID) {
            player.triggerAchievement(BAMAchievements.findDiamonds);
            return;
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcItemScouredLeather.itemID) {
            player.triggerAchievement(BAMAchievements.craftScouredLeather);
            return;
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcItemDung.itemID) {
            player.triggerAchievement(BAMAchievements.findDung);
            return;
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcItemTannedLeather.itemID) {
            player.triggerAchievement(BAMAchievements.craftTannedLeather);
            return;
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcUnfiredPottery.blockID) {
            player.triggerAchievement(BAMAchievements.craftPottery);
            return;
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcItemHempFibers.itemID) {
            player.triggerAchievement(BAMAchievements.craftHempFibers);
            return;
        }
		else if (itemstack.itemID == Block.obsidian.blockID) {
            player.triggerAchievement(BAMAchievements.findObsidian);
            return;
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcItemGroundNetherrack.itemID) {
            player.triggerAchievement(BAMAchievements.craftGroundNetherrack);
            return;
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcBlockSoulforgeDormant.blockID) {
            player.triggerAchievement(BAMAchievements.findDormantForge);
            return;
        }
		else if (itemstack.itemID == Item.blazeRod.itemID) {
            player.triggerAchievement(BAMAchievements.findBlazeRod);
            return;
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcItemUrn.itemID) {
            player.triggerAchievement(BAMAchievements.cookUrn);
            return;
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcCrucible.blockID) {
            player.triggerAchievement(BAMAchievements.cookCrucible);
            return;
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcItemSoulUrn.itemID) {
            player.triggerAchievement(BAMAchievements.craftSoulUrn);
            return;
        }
		else if (itemstack.itemID == Item.netherStar.itemID) {
            player.triggerAchievement(BAMAchievements.findNetherstar);
            return;
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcItemSteel.itemID) {
            player.triggerAchievement(BAMAchievements.craftSteelIngot);
            return;
        }
	}
	
	@EventListener(EventType.KILLED)
	public void onKilled(EntityPlayer player, EntityLiving entity)
	{
		if (entity instanceof FCEntityWither)
		{
			player.triggerAchievement(BAMAchievements.killWither);
            return;
		}
		else if (entity instanceof EntityDragon)
		{
			player.triggerAchievement(BAMAchievements.killDragon);
            return;
		}
	}
	
	@EventListener(EventType.PORTAL)
	public void onTravelledDimension(EntityPlayer player, int dimension) {
		if ( dimension == -1)
		{
			player.triggerAchievement(BAMAchievements.travelNether);
            return;
		}
		else if ( dimension == 1)
		{
			player.triggerAchievement(BAMAchievements.travelEnd);
            return;
		}
	}
	
	@EventListener(EventType.ENTITY_INTERACT)
	public void onEntityInteraction(EntityPlayer player, Entity entity) {
		if (player.getCurrentEquippedItem().getItem() instanceof FCItemShears && entity instanceof FCEntityCreeper)
		{
			player.triggerAchievement(BAMAchievements.findCreeperOysters);
		}
	}
	
	@EventListener(EventType.CONVERTED_BLOCK)
	public void onEntityInteraction(EntityPlayer player, Block block) {
		if (block.blockID == Block.wood.blockID) {
            player.triggerAchievement(BAMAchievements.craftWorkbench);
            return;
        }
	}
	
	@EventListener(EventType.DEATH)
	public void onDeath(EntityPlayer player, DamageSource damageSource) {
		
	}
	
	@EventListener(EventType.TRADED)
	public void onTraded(EntityPlayer player, MerchantRecipe recipe) {
		
		if (recipe.getItemToBuy().itemID == FCBetterThanWolves.fcItemSoap.itemID)
		{
			player.triggerAchievement(BAMAchievements.cleanFarmer);
			return;
		}
		else if (recipe.getItemToBuy().itemID == Item.hoeIron.itemID )
		{
			player.triggerAchievement(BAMAchievements.tradeFarmerLvl2);
			return;
		}
		else if (recipe.getItemToBuy().itemID == FCBetterThanWolves.fcMillStone.blockID )
		{
			player.triggerAchievement(BAMAchievements.tradeFarmerLvl3);
			return;
		}
		else if (recipe.getItemToBuy().itemID == FCBetterThanWolves.fcItemWaterWheel.itemID )
		{
			player.triggerAchievement(BAMAchievements.tradeFarmerLvl4);
			return;
		}
		else if (recipe.getItemToBuy().itemID == FCBetterThanWolves.fcBlockPlanterSoil.blockID )
		{
			player.triggerAchievement(BAMAchievements.tradeFarmerLvl5);
			return;
		}
		else if (recipe.getItemToBuy().itemID == FCBetterThanWolves.fcCauldron.blockID )
		{
			player.triggerAchievement(BAMAchievements.tradeButcherLvl2);
			return;
		}
		else if (recipe.getItemToBuy().itemID == FCBetterThanWolves.fcSaw.blockID )
		{
			player.triggerAchievement(BAMAchievements.tradeButcherLvl3);
			return;
		}
		else if (recipe.getItemToBuy().itemID == FCBetterThanWolves.fcItemBreedingHarness.itemID )
		{
			player.triggerAchievement(BAMAchievements.tradeButcherLvl4);
			return;
		}
		else if (recipe.getItemToBuy().itemID == FCBetterThanWolves.fcAestheticOpaque.blockID &&
				recipe.getItemToBuy().getItemDamage() ==  FCBlockAestheticOpaque.m_iSubtypeChoppingBlockDirty)
		{
			player.triggerAchievement(BAMAchievements.tradeButcherLvl5);
			return;
		}
		else if (recipe.getItemToSell().itemID == Item.skull.itemID &&
				recipe.getItemToSell().getItemDamage() == 5)
		{
			player.triggerAchievement(BAMAchievements.craftInfusedSkull);
			return;
		}
		else if (recipe.getItemToSell().itemID == Item.eyeOfEnder.itemID )
		{
			player.triggerAchievement(BAMAchievements.craftEye);
			return;
		}
	}
	
	@EventListener(EventType.CONSUMED)
	public void onEaten(EntityPlayer player, ItemStack stack)
	{		
		if (stack.itemID == FCBetterThanWolves.fcItemCreeperOysters.itemID)
		{
			player.triggerAchievement(BAMAchievements.eatOysters);
			return;
		}
		else if (stack.itemID == Item.bucketMilk.itemID)
		{
			player.triggerAchievement(BAMAchievements.milkBucket);
			return;
		}
		else if (stack.itemID == FCBetterThanWolves.fcItemCookedMysteryMeat.itemID ||
				stack.itemID == FCBetterThanWolves.fcItemRawMysteryMeat.itemID)
		{
			player.triggerAchievement(BAMAchievements.eatMysteryMeat);
			return;
		}
	}
	
	@EventListener(EventType.CURED)
	public static void onCured(EntityPlayer player, FCEntityZombie zombieVillager) {
		player.triggerAchievement(BAMAchievements.cureZombieVillager);
		return;
	}
	
	@EventListener(EventType.PROGRESSIVE_CRAFTING)
	public void onKnitted(EntityPlayer player, ItemStack stack)
	{
		if (stack.itemID == FCBetterThanWolves.fcItemCarvingBone.itemID)
		{
			player.triggerAchievement(BAMAchievements.craftBoneHook);
		}
		else if (stack.itemID == FCBetterThanWolves.fcItemWickerWeaving.itemID)
		{
			player.triggerAchievement(BAMAchievements.craftWicker);
		}
	}	
}