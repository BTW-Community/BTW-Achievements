package net.minecraft.src;

import java.util.Random;
import org.lwjgl.opengl.GL11;
import net.minecraft.src.AchievementTab;
import net.minecraft.src.Block;
import net.minecraft.src.Icon;

/**
 * A custom tab that overrides the background generation to create a custom background.
 */
public class BAMAchievementTabFun extends AchievementTab {

	public BAMAchievementTabFun(String name) {
		super(name);
	}
	
	@Override
	protected Icon genAchievementIcon(int mapX, int mapY, int windowX, int windowY)
    {   
		int var10 = windowX + 288 >> 4;
        int var11 = windowY + 288 >> 4;
        Random random = new Random();
        int y1;
        
        float brightness = 0.6F - (float)(var11 + mapY) / 25.0F * 0.3F;
        //GL11.glColor4f(brightness, brightness, brightness, 1.0F);
    	
    	random.setSeed((long)(1234 + var10 + mapX));
        random.nextInt();
        y1 = random.nextInt(1 + var11 + mapY) + (var11 + mapY) / 2;
        Icon icon = Block.blockNetherQuartz.getIcon(0, 0);


//        if (y1 <= 37 && var11 + mapY != 35)
//        {
//            if (y1 == 22)
//            {
//                if (random.nextInt(2) == 0)
//                {
//                    icon = Block.lavaStill.getIcon(0, 0);
//                }
//            }
//            else if (y1 == 10)
//            {
//                icon = Block.oreNetherQuartz.getIcon(0, 0);
//            }
//            else if (y1 == 8)
//            {
//                icon = Block.netherrack.getIcon(0, 0);
//            }
//            else if (y1 > 4)
//            {
//                icon = Block.netherrack.getIcon(0, 0);
//            }
//            else if (y1 > 0)
//            {
//                icon = Block.netherrack.getIcon(0, 0);
//            }
//        }
//        else
//        {
//            icon = Block.bedrock.getIcon(0, 0);
//        }
        
//        if ((var11 + mapY + 1) % 4 == 0 && (var10 + mapX - 3) % 5 == 0)
//        {
//        	icon = Block.blockDiamond.getIcon(0,0);
//        }
        
        return icon;
    }
    
}