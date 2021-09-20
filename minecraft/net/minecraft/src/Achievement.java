package net.minecraft.src;

import net.minecraft.src.AchievementsCore;

public class Achievement extends StatBase
{
	static {
		AchievementsCore.getInstance();
	}
	
	//BA
	static {
		BAMod.getInstance();
	}
	//BA - end
	
    /**
     * Is the column (related to center of achievement gui, in 24 pixels unit) that the achievement will be displayed.
     */
    public final int displayColumn;

    /**
     * Is the row (related to center of achievement gui, in 24 pixels unit) that the achievement will be displayed.
     */
    public final int displayRow;

    /**
     * Holds the parent achievement, that must be taken before this achievement is avaiable.
     */
    public final Achievement parentAchievement;
    
    //BA
    /**
     * Holds the second parent achievement, that must be taken in addition before this achievement is avaiable.
     */
    public final Achievement secondParentAchievement;
    //BA - end

    /**
     * Holds the description of the achievement, ready to be formatted and/or displayed.
     */
    private final String achievementDescription;

    /**
     * Holds a string formatter for the achievement, some of then needs extra dynamic info - like the key used to open
     * the inventory.
     */
    private IStatStringFormat statStringFormatter;

    /**
     * Holds the ItemStack that will be used to draw the achievement into the GUI.
     */
    public final ItemStack theItemStack;

    /**
     * Special achievements have a 'spiked' (on normal texture pack) frame, special achievements are the hardest ones to
     * achieve.
     */
    private boolean isSpecial;
    
    public Achievement(String name, int displayColumn, int displayRow, Item item, Achievement parentAchievement)
    {
        this(0, name, displayColumn, displayRow, new ItemStack(item), parentAchievement, null);
    }

    public Achievement(String name, int displayColumn, int displayRow, Block block, Achievement parentAchievement)
    {
        this(0, name, displayColumn, displayRow, new ItemStack(block), parentAchievement, null);
    }

    public Achievement(int par1, String par2Str, int par3, int par4, Item par5Item, Achievement par6Achievement)
    {
        this(par1, par2Str, par3, par4, new ItemStack(par5Item), par6Achievement, null);
    }

    public Achievement(int par1, String par2Str, int par3, int par4, Block par5Block, Achievement par6Achievement)
    {
        this(par1, par2Str, par3, par4, new ItemStack(par5Block), par6Achievement, null);
    }
    
    //Second Parent
    public Achievement(String name, int displayColumn, int displayRow, Item item, Achievement parentAchievement, Achievement secondParentAchievement)
    {
        this(0, name, displayColumn, displayRow, new ItemStack(item), parentAchievement, secondParentAchievement);
    }

    public Achievement(String name, int displayColumn, int displayRow, Block block, Achievement parentAchievement, Achievement secondParentAchievement)
    {
        this(0, name, displayColumn, displayRow, new ItemStack(block), parentAchievement, secondParentAchievement);
    }

    public Achievement(int par1, String par2Str, int par3, int par4, Item par5Item, Achievement par6Achievement, Achievement secondParentAchievement)
    {
        this(par1, par2Str, par3, par4, new ItemStack(par5Item), par6Achievement, secondParentAchievement);
    }

    public Achievement(int par1, String par2Str, int par3, int par4, Block par5Block, Achievement par6Achievement, Achievement secondParentAchievement)
    {
        this(par1, par2Str, par3, par4, new ItemStack(par5Block), par6Achievement, secondParentAchievement);
    }
    
    
    //BA added second Parent
    public Achievement(int id, String name, int displayColumn, int displayRow, ItemStack theItemStack, Achievement parentAchievement, Achievement secondParentAchievement)
    {
        super(5242880 + AchievementTabList.counter++, "achievement." + name);
        this.theItemStack = theItemStack;
        this.achievementDescription = "achievement." + name + ".desc";
        this.displayColumn = displayColumn;
        this.displayRow = displayRow;

        this.parentAchievement = parentAchievement;
        this.secondParentAchievement = secondParentAchievement; //BA edit
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
     * Special achievements have a 'spiked' (on normal texture pack) frame, special achievements are the hardest ones to
     * achieve.
     */
    public Achievement setSpecial()
    {
        this.isSpecial = true;
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
     * @param tab is the custom tab to register to
     * @return this
     */
    public Achievement registerAchievement(AchievementTab tab)
    {
        super.registerStat();
        tab.add(this);
        
        if (this.displayColumn < tab.minDisplayColumn)
        {
        	tab.minDisplayColumn = this.displayColumn;
        }

        if (this.displayRow < tab.minDisplayRow)
        {
        	tab.minDisplayRow = this.displayRow;
        }

        if (this.displayColumn > tab.maxDisplayColumn)
        {
        	tab.maxDisplayColumn = this.displayColumn;
        }

        if (this.displayRow > tab.maxDisplayRow)
        {
        	tab.maxDisplayRow = this.displayRow;
        }
        return this;
    }

    /**
     * Returns whether or not the StatBase-derived class is a statistic (running counter) or an achievement (one-shot).
     */
    public boolean isAchievement()
    {
        return true;
    }

    /**
     * Returns the fully description of the achievement - ready to be displayed on screen.
     */
    public String getDescription()
    {
        return this.statStringFormatter != null ? this.statStringFormatter.formatString(StatCollector.translateToLocal(this.achievementDescription)) : StatCollector.translateToLocal(this.achievementDescription);
    }

    /**
     * Defines a string formatter for the achievement.
     */
    public Achievement setStatStringFormatter(IStatStringFormat par1IStatStringFormat)
    {
        this.statStringFormatter = par1IStatStringFormat;
        return this;
    }

    /**
     * Special achievements have a 'spiked' (on normal texture pack) frame, special achievements are the hardest ones to
     * achieve.
     */
    public boolean getSpecial()
    {
        return this.isSpecial;
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
