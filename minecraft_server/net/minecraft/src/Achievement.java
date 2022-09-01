package net.minecraft.src;

import net.minecraft.src.AchievementsCore;

public class Achievement extends StatBase
{
	static {
		AchievementsCore.getInstance();
		BetterAchievementsMod.getInstance();
	}
	
    /**
     * Is the column (related to center of achievement gui, in 24 pixels unit) that the achievement will be displayed.
     */
    public final int displayColumn;

    /**
     * Is the row (related to center of achievement gui, in 24 pixels unit) that the achievement will be displayed.
     */
    public final int displayRow;

    /**
     * Holds the parent achievements, that must be taken before this achievement is avaiable.
     */
    public final Achievement parentAchievement;
    public final Achievement[] parentAchievements;
    
    /**
     * Holds the tab this achievement is in.
     */
    public AchievementTab tab;
    
    /**
     * Determines if this achievement should be shown to the player when locked.
     */
    public boolean isHidden = false;
    
    /**
     * The format code to be used when the achievement is announce to chat.
     * See https://minecraft.fandom.com/wiki/Formatting_codes
     */
    public String formatCode = "§a";
    
    /**
     * The name of the file containing the achievement's frame.
     */
    public String frameSet = "default";
    
    /**
     * The left coordinate of the frame in frameSet.
     */
    public int u = 0;
    
    /**
     * The top coordinate of the frame in frameSet.
     */
    public int v = 0;

    /**
     * Holds the description of the achievement, ready to be formatted and/or displayed.
     */
    private final String achievementDescription;

    /**
     * Holds the ItemStack that will be used to draw the achievement into the GUI.
     */
    public final ItemStack theItemStack;

    /**
     * Special achievements have a 'spiked' (on normal texture pack) frame, special achievements are the hardest ones to
     * achieve.
     */
    private boolean isSpecial;
    
    public Achievement(String name, int displayColumn, int displayRow, Item item, Achievement... parentAchievements)
    {
        this(0, name, displayColumn, displayRow, new ItemStack(item), parentAchievements);
    }

    public Achievement(String name, int displayColumn, int displayRow, Block block, Achievement... parentAchievements)
    {
        this(0, name, displayColumn, displayRow, new ItemStack(block), parentAchievements);
    }

    public Achievement(int par1, String par2Str, int par3, int par4, Item par5Item, Achievement... parentAchievements)
    {
        this(par1, par2Str, par3, par4, new ItemStack(par5Item), parentAchievements);
    }

    public Achievement(int par1, String par2Str, int par3, int par4, Block par5Block, Achievement... parentAchievements)
    {
        this(par1, par2Str, par3, par4, new ItemStack(par5Block), parentAchievements);
    }

    public Achievement(int id, String name, int displayColumn, int displayRow, ItemStack theItemStack, Achievement... parentAchievements)
    {
        super(AchievementTabList.counter++, "achievement." + name);
        this.theItemStack = theItemStack;
        this.achievementDescription = "achievement." + name + ".desc";
        this.displayColumn = displayColumn;
        this.displayRow = displayRow;

        this.parentAchievements = parentAchievements;
        this.parentAchievement = parentAchievements[0];
    }

    /**
     * Indicates whether or not the given achievement or statistic is independent (i.e., lacks prerequisites for being
     * update).
     */
    public Achievement setIndependent()
    {
        this.isIndependent = true;
        return this;
    }

    /**
     * Special achievements have a 'spiked' (on normal texture pack) frame,
     * as well as having a dark purple announcement color.
     * Special achievements are the hardest ones to achieve.
     */
    public Achievement setSpecial()
    {
        this.isSpecial = true;
        this.formatCode = "§5";
        this.u = 26;
        return this;
    }
    
    /**
     * Hidden achievements are not revealed until unlocked.
     */
    public Achievement setHidden()
    {
        this.isHidden = true;
        return this;
    }
    
    /**
     * The format code to be used when the achievement is announce to chat.
     * This is set to §a (green) by default, and $5 (dark_purple) for special achievements.
     * See https://minecraft.fandom.com/wiki/Formatting_codes
     */
    public Achievement setFormatCode(String formatCode)
    {
        this.formatCode = formatCode;
        return this;
    }
    
    /**
     * The name of the file containing the achievement's frame.
     */
    public Achievement setFrameSet(String frameSetName)
    {
        this.frameSet = frameSetName;
        return this;
    }
    
    /**
     * The coordinate of the achievement's frame.
     */
    public Achievement setFrame(int x, int y)
    {
        this.u = x * 26;
        this.v = y * 26;
        return this;
    }
    
    /**
     * Adds the achievement on the internal list of registered achievements, also, it's check for duplicated id's.
     */
    public Achievement registerAchievement()
    {
        super.registerStat();
        AchievementList.achievementList.add(this);
        return this;
    }
    
    /**
     * Registers an achievement to a custom tab.
     * 
     * @param achievementtab is the custom tab to register to
     * @return this
     */
    public Achievement registerAchievement(AchievementTab achievementtab)
    {
        super.registerStat();
        achievementtab.add(this);
        tab = achievementtab;
        
        if (this.displayColumn < achievementtab.minDisplayColumn)
        {
        	achievementtab.minDisplayColumn = this.displayColumn;
        }

        if (this.displayRow < achievementtab.minDisplayRow)
        {
        	achievementtab.minDisplayRow = this.displayRow;
        }

        if (this.displayColumn > achievementtab.maxDisplayColumn)
        {
        	achievementtab.maxDisplayColumn = this.displayColumn;
        }

        if (this.displayRow > achievementtab.maxDisplayRow)
        {
        	achievementtab.maxDisplayRow = this.displayRow;
        }
        return this;
    }

    /**
     * Register the stat into StatList.
     */
    public StatBase registerStat()
    {
        return this.registerAchievement();
    }
    
    /**
     * Register the stat into StatList.
     */
    public StatBase registerStat(AchievementTab tab)
    {
        return this.registerAchievement(tab);
    }

    /**
     * Initializes the current stat as independent (i.e., lacking prerequisites for being updated) and returns the
     * current instance.
     */
    public StatBase initIndependentStat()
    {
        return this.setIndependent();
    }
}
