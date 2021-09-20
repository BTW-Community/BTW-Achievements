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
public class BAEventHandler {

	@EventListener(EventType.CRAFTED)
	public void onCrafted(EntityPlayer player, ItemStack itemstack) {
		if (itemstack.itemID == FCBetterThanWolves.fcItemChiselWood.itemID) {
            player.triggerAchievement(BAMod.chiselWood);
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcItemChiselStone.itemID) {
            player.triggerAchievement(BAMod.chiselStone);
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcItemChunkIronOre.itemID) {
            player.triggerAchievement(BAMod.mineIron);
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcItemFireStarterSticks.itemID) {
            player.triggerAchievement(BAMod.craftFire);
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcBlockCampfireUnlit.blockID) {
            player.triggerAchievement(BAMod.craftCampfire);
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcItemClubWood.itemID) {
            player.triggerAchievement(BAMod.craftClub);
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcItemClubBone.itemID) {
            player.triggerAchievement(BAMod.craftBigBone);
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcItemFishHookBone.itemID) {
            player.triggerAchievement(BAMod.boneHook);
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcItemFishingRodBaited.itemID) {
            player.triggerAchievement(BAMod.baitedRod);
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcItemWickerWeaving.itemID) {
            player.triggerAchievement(BAMod.craftWicker);
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcBlockBasketWicker.blockID) {
            player.triggerAchievement(BAMod.craftBasket);
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcItemWoolKnit.itemID) {
            player.triggerAchievement(BAMod.knitWool);
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcItemArmorWoolChest.itemID
				|| itemstack.itemID == FCBetterThanWolves.fcItemArmorWoolHelm.itemID
				|| itemstack.itemID == FCBetterThanWolves.fcItemArmorWoolLeggings.itemID) {
            player.triggerAchievement(BAMod.craftClothes);
        }
		else if (itemstack.itemID == Item.coal.itemID) {
            player.triggerAchievement(BAMod.findCoal);
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcBlockTorchFiniteUnlit.blockID) {
            player.triggerAchievement(BAMod.craftTorch);
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcItemFireStarterBow.itemID) {
            player.triggerAchievement(BAMod.advancedFire);
        }
		else if (itemstack.itemID == Item.axeStone.itemID) {
            player.triggerAchievement(BAMod.craftAxe);
        }
		else if (itemstack.itemID == Item.shovelStone.itemID) {
            player.triggerAchievement(BAMod.craftShovel);
        }
		else if (itemstack.itemID == Item.clay.itemID) {
            player.triggerAchievement(BAMod.findClay);
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcBlockFurnaceBrickIdle.blockID) {
            player.triggerAchievement(BAMod.craftFurnace);
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcItemChiselIron.itemID) {
            player.triggerAchievement(BAMod.craftChisel);
        }
	}
	
	@EventListener(EventType.COOKED)
	public void onCooked(EntityPlayer player, ItemStack itemstack) {
		if (itemstack.itemID == Item.porkCooked.itemID 
			|| itemstack.itemID == Item.beefCooked.itemID
			|| itemstack.itemID == Item.chickenCooked.itemID
			|| itemstack.itemID == FCBetterThanWolves.fcItemMuttonCooked.itemID) {
            	player.triggerAchievement(BAMod.cookOnCampfire);
		}
		else if (itemstack.itemID == FCBetterThanWolves.fcItemNuggetIron.itemID) {
	            	player.triggerAchievement(BAMod.smeltIron);
			}
	}
	
	@EventListener(EventType.PICKUP)
	public void onPickup(EntityPlayer player, ItemStack itemstack) {
		if (itemstack.itemID == Item.stick.itemID) {
            player.triggerAchievement(BAMod.findShaft);
            player.addChatMessage(player.username + " has made the achievement: " + BAMod.findShaft.getName());
        }
		else if (itemstack.itemID == Item.reed.itemID) {
            player.triggerAchievement(BAMod.findReeds);
        }
		else if (itemstack.itemID == Item.coal.itemID) {
            player.triggerAchievement(BAMod.findCoal);
        }
		else if (itemstack.itemID == Item.silk.itemID) {
            player.triggerAchievement(BAMod.findString);
        }
		else if (itemstack.itemID == Block.wood.blockID) {
            player.triggerAchievement(BAMod.getLog);
        }
		else if (itemstack.itemID == Item.clay.itemID) {
            player.triggerAchievement(BAMod.findClay);
        }
		else if (itemstack.itemID == Item.brick.itemID) {
            player.triggerAchievement(BAMod.dryClay);
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcItemChunkIronOre.itemID) {
            player.triggerAchievement(BAMod.mineIron);
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcItemStoneBrick.itemID) {
            player.triggerAchievement(BAMod.mineBricks);
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcItemBark.itemID) {
            player.triggerAchievement(BAMod.findBark);
        }
		else if (itemstack.itemID == FCBetterThanWolves.fcItemSawDust.itemID) {
            player.triggerAchievement(BAMod.findDust);
        }
	}
	
	@EventListener(EventType.PORTAL)
	public void onTravelledDimension(EntityPlayer player, int dimension) {
		if (dimension == -1) {
            player.triggerAchievement(BAMod.netherPortal);
        }
	}
}