package net.minecraft.src;

import java.util.Random;

import org.lwjgl.opengl.GL11;

import net.minecraft.src.AchievementTab;
import net.minecraft.src.Block;
import net.minecraft.src.Icon;

/**
 * A custom tab that overrides the background generation to create a custom background.
 */
public class BATabEnd extends AchievementTab {

	public BATabEnd(String name) {
		super(name);
	}
	
	@Override
	protected Icon genAchievementIcon(int mapX, int mapY, int windowX, int windowY)
    {   
		// Honestly not sure how this works, but it works.
		int xPos = (windowX + 288 >> 4) + mapX;
        int yPos = (windowY + 288 >> 4) + mapY;
        
        //random for ore
        Random random = new Random();
        int y1;
        
        random.setSeed((long)(1234 + xPos + mapX));
        random.nextInt();
        y1 = random.nextInt(1 + yPos + mapY) + (yPos + mapY) / 2;
        
        //icon defs
        Icon icon = Block.whiteStone.getIcon(0, 0);
        return icon;
    }
    
}