package net.minecraft.src;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


public class EventDispatcher {
	private static EventDispatcher instance;
	private static List listeners = new ArrayList();
	
	public static void init() {
		getInstance();
	}
	
	public static EventDispatcher getInstance() {
		if (instance == null) {
			instance = new EventDispatcher();
		}
		return instance;
	}
	
	/**
	 * Registers an event handler that will be called when events are called.
	 * 
	 * @param obj is the event handler
	 */
	public static void register(Object obj) {
		if (!listeners.contains(obj)) {
			listeners.add(obj);
		}
	}
	
	private static boolean canHandleEvent(Method method, EventType type) {
		EventListener annotation = method.getAnnotation(EventListener.class);
		if (annotation != null && annotation.value() == type) { 
			return true;
		}
		return false;
	}
	
	private static void handleEvent(EventType type, Object... args) {
		for (Object listener: listeners) {
			Method[] methods = listener.getClass().getMethods();
			for (Method method: methods) {
				if (canHandleEvent(method, type)) {
					try {
						method.invoke(listener, args);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	public static void onCrafted(EntityPlayer player, ItemStack itemstack) {
		handleEvent(EventType.CRAFTED, player, itemstack);
	}
	
	public static void onCooked(EntityPlayer player, ItemStack itemstack) {
		handleEvent(EventType.COOKED, player, itemstack);
	}
	
	public static void onBrewed(EntityPlayer player, ItemStack itemstack) {
		handleEvent(EventType.BREWED, player, itemstack);
	}
	
	public static void onCollideWithPlayer(EntityPlayer player, ItemStack itemstack) {
		handleEvent(EventType.PICKUP, player, itemstack);
	}
	
	public static void onKilled(EntityPlayer player, EntityLiving entity) {
		handleEvent(EventType.KILLED, player, entity);
	}
	
	public static void onTraveledDimension(EntityPlayer player, int dimension) {
		handleEvent(EventType.PORTAL, player, dimension);
	}
	
	public static void onEntityInteraction(EntityPlayer player, Entity entity) {
		handleEvent(EventType.ENTITY_INTERACT, player, entity);
	}
	
	public static void onBlockConverted(EntityPlayer player, Block block) {
		handleEvent(EventType.CONVERTED_BLOCK, player, block);
	}
	
	public static void onDeath(EntityPlayer player, DamageSource damageSource) {
		handleEvent(EventType.DEATH, player, damageSource);
	}
	
	public static void onTraded(EntityPlayer player, MerchantRecipe recipe) {
		handleEvent(EventType.TRADED, player, recipe);
	}
	
	public static void onCured(EntityPlayer player, FCEntityZombie zombieVillager) {
		handleEvent(EventType.CURED, player, zombieVillager);
	}
	
	public static void onEaten(EntityPlayer player, ItemStack foodStack) {
		handleEvent(EventType.CONSUMED, player, foodStack);
	}
	
	//BAM: Added
	public static void onKnitted(EntityPlayer player, ItemStack stack) {
		handleEvent(EventType.PROGRESSIVE_CRAFTING, player, stack);
	}
}
