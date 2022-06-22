package net.minecraft.src;

import net.minecraft.src.EventListener;
import net.minecraft.src.EventType;
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
		

	}
	
	@EventListener(EventType.COOKED)
	public void onCooked(EntityPlayer player, ItemStack itemstack) {
		if (itemstack.itemID == Item.beefCooked.itemID) {
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

	}
	
	@EventListener(EventType.KILLED)
	public void onKilled(EntityPlayer player, EntityLiving entity) {

	}
	
	@EventListener(EventType.PORTAL)
	public void onTravelledDimension(EntityPlayer player, int dimension) {

	}
	
	@EventListener(EventType.ENTITY_INTERACT)
	public void onEntityInteraction(EntityPlayer player, Entity entity) {

	}
	
	@EventListener(EventType.CONVERTED_BLOCK)
	public void onEntityInteraction(EntityPlayer player, Block block) {
		//TODO doesn't work
		if (block.blockID == FCBetterThanWolves.fcBlockWorkStump.blockID) {
            player.triggerAchievement(BAMAchievements.craftWorkbench);
            return;
        }
	}
	
	@EventListener(EventType.DEATH)
	public void onDeath(EntityPlayer player, DamageSource damageSource) {

	}
	
	@EventListener(EventType.TRADED)
	public void onDeath(EntityPlayer player, MerchantRecipe recipe) {

	}
	
}