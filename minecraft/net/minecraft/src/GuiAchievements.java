package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import net.minecraft.client.Minecraft;

public class GuiAchievements extends GuiScreen
{	
	/** The top x coordinate of the achievement map */
    private static int guiMapTop;

    /** The left y coordinate of the achievement map */
    private static int guiMapLeft;

    /** The bottom x coordinate of the achievement map */
    private static int guiMapBottom;

    /** The right y coordinate of the achievement map */
    private static int guiMapRight;
    protected int achievementsPaneWidth = 256 -4;
    protected int achievementsPaneHeight = 202 -16;

    /** The current mouse x coordinate */
    protected int mouseX = 0;

    /** The current mouse y coordinate */
    protected int mouseY = 0;
    protected double field_74117_m;
    protected double field_74115_n;

    /** The x position of the achievement map */
    protected double guiMapX;

    /** The y position of the achievement map */
    protected double guiMapY;
    protected double field_74124_q;
    protected double field_74123_r;

    /** Whether the Mouse Button is down or not */
    private int isMouseButtonDown = 0;
    private StatFileWriter statFileWriter;
    
    AchievementsCore ac = AchievementsCore.getInstance();
	List<AchievementTab> tabList = AchievementTabList.tabList;
	private static int tabIndex = 0;
	private static int page = 1;
	private final int MAX_TABS = 9;  // Maximum tabs per page.
	private static final int yShiftGUI = 8;
	private static final int widthCorrection = -4;

    public GuiAchievements(StatFileWriter par1StatFileWriter)
    {
        this.statFileWriter = par1StatFileWriter;
        short var2 = 141;
        short var3 = 141;
        this.field_74117_m = this.guiMapX = this.field_74124_q = (double)(AchievementList.openInventory.displayColumn * 24 - var2 / 2 - 12);
        this.field_74115_n = this.guiMapY = this.field_74123_r = (double)(AchievementList.openInventory.displayRow * 24 - var3 / 2);
    }

    /**
     * Adds the buttons (and other controls) to the screen in question.
     */
    public void initGui()
    {
        this.buttonList.clear();
        setupTabMap();
    }

    /**
     * Fired when a control is clicked. This is the equivalent of ActionListener.actionPerformed(ActionEvent e).
     */
    protected void actionPerformed(GuiButton button)
    {
        if (button.id == 1)
        {
            this.mc.displayGuiScreen((GuiScreen)null);
            this.mc.setIngameFocus();
        }

        super.actionPerformed(button);
    }

    /**
     * Fired when a key is typed. This is the equivalent of KeyListener.keyTyped(KeyEvent e).
     */
    protected void keyTyped(char par1, int par2)
    {
        if (par2 == this.mc.gameSettings.keyBindInventory.keyCode)
        {
            this.mc.displayGuiScreen((GuiScreen)null);
            this.mc.setIngameFocus();
        }
        else
        {
            super.keyTyped(par1, par2);
        }
    }

    /**
     * Draws the screen and all the components in it.
     */
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        if (Mouse.isButtonDown(0))
        {
            int guiLeft = (this.width - this.achievementsPaneWidth) / 2;
            int guiTop = (this.height - this.achievementsPaneHeight) / 2 + yShiftGUI;
            int mapLeft = guiLeft + 8;
            int mapTop = guiTop + 17;

            if ((this.isMouseButtonDown == 0 || this.isMouseButtonDown == 1) && mouseX >= mapLeft && mouseX < mapLeft + 224 && mouseY >= mapTop && mouseY < mapTop + 155)
            {
                if (this.isMouseButtonDown == 0)
                {
                    this.isMouseButtonDown = 1;
                }
                else
                {
                    this.guiMapX -= (double)(mouseX - this.mouseX);
                    this.guiMapY -= (double)(mouseY - this.mouseY);
                    this.field_74124_q = this.field_74117_m = this.guiMapX;
                    this.field_74123_r = this.field_74115_n = this.guiMapY;
                }

                this.mouseX = mouseX;
                this.mouseY = mouseY;
            }

            if (this.field_74124_q < (double)guiMapTop)
            {
                this.field_74124_q = (double)guiMapTop;
            }

            if (this.field_74123_r < (double)guiMapLeft)
            {
                this.field_74123_r = (double)guiMapLeft;
            }

            if (this.field_74124_q >= (double)guiMapBottom)
            {
                this.field_74124_q = (double)(guiMapBottom - 1);
            }

            if (this.field_74123_r >= (double)guiMapRight)
            {
                this.field_74123_r = (double)(guiMapRight - 1);
            }
        }
        else
        {
            this.isMouseButtonDown = 0;
        }

        this.drawDefaultBackground();
        this.genAchievementBackground(mouseX, mouseY, partialTicks);
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        this.drawTitle();
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
    }

    /**
     * Called from the main game loop to update the screen.
     */
    public void updateScreen()
    {
        this.field_74117_m = this.guiMapX;
        this.field_74115_n = this.guiMapY;
        double var1 = this.field_74124_q - this.guiMapX;
        double var3 = this.field_74123_r - this.guiMapY;

        if (var1 * var1 + var3 * var3 < 4.0D)
        {
            this.guiMapX += var1;
            this.guiMapY += var3;
        }
        else
        {
            this.guiMapX += var1 * 0.85D;
            this.guiMapY += var3 * 0.85D;
        }
    }

    /**
     * Draws the "Achievements" title at the top of the GUI.
     */
    protected void drawTitle()
    {
        int guiLeft = (this.width - this.achievementsPaneWidth) / 2;
        int guiTop = (this.height - this.achievementsPaneHeight) / 2 + yShiftGUI;
        //BAM: CHANGED
//        this.fontRenderer.drawString("Achievements", guiLeft + 15, guiTop + 5, 4210752);
        this.fontRenderer.drawString(StatCollector.translateToLocal("gui.achievements"), guiLeft + 15, guiTop + 5, 4210752);
    }

    protected void genAchievementBackground(int mouseX, int mouseY, float par3)
    {
        int windowX = MathHelper.floor_double(this.field_74117_m + (this.guiMapX - this.field_74117_m) * (double)par3);
        int windowY = MathHelper.floor_double(this.field_74115_n + (this.guiMapY - this.field_74115_n) * (double)par3);

        if (windowX < guiMapTop)
        {
            windowX = guiMapTop;
        }

        if (windowY < guiMapLeft)
        {
            windowY = guiMapLeft;
        }

        if (windowX >= guiMapBottom)
        {
            windowX = guiMapBottom - 1;
        }

        if (windowY >= guiMapRight)
        {
            windowY = guiMapRight - 1;
        }
        
        int guiLeft = (this.width - this.achievementsPaneWidth) / 2;
        int guiTop = (this.height - this.achievementsPaneHeight) / 2 + yShiftGUI;
        
        AchievementTab tab = null;
        if (!tabList.isEmpty()) {
        	tab = tabList.get(this.tabIndex);
        }
        
        this.genAchievementTabBackground(tab, windowX, windowY);
        
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glDepthFunc(GL11.GL_LEQUAL);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        
        this.drawAchievementConnections(tab, windowX, windowY);
        
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        this.drawRect(guiLeft - 16, guiTop, guiLeft + 6, guiTop + 16*10, 0xFF000000);
        GL11.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glDisable(GL11.GL_BLEND);
        
        RenderHelper.enableGUIStandardItemLighting();
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glEnable(GL11.GL_COLOR_MATERIAL);
        
        Achievement achievementHovered = this.renderAchievements(tab, windowX, windowY, mouseX, mouseY);
        
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glEnable(GL11.GL_BLEND); 
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA); //BAM: ADDED
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        
        this.renderFrame(tab, par3);
        this.renderHoveredAchievement(achievementHovered, mouseX, mouseY);

        // Render page buttons.
        this.mc.renderEngine.bindTexture("/btwmodtex/fcguitrading.png");
        this.renderPageButtons(mouseX, mouseY);
        
        if (tab != null) {
	        // Render the selected tab in front of the window.
	        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	        tab = tabList.get(this.tabIndex);
	        this.mc.renderEngine.bindTexture("/gui/allitems.png");
	        this.renderAchievementTab(tab);
	        
	        // Render tab text if hovered.
	        for (int i = 0; i < this.tabList.size(); i++) {
	        	tab = tabList.get(i);
	        	if (this.isMouseOverTab(tab, mouseX, mouseY)) {
	        		this.setHoverText(tab, mouseX, mouseY);
	        		break;
	        	}
	        }
        }

        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glEnable(GL11.GL_LIGHTING);
        RenderHelper.disableStandardItemLighting();
    }

    protected void genAchievementTabBackground(AchievementTab tab, int windowX, int windowY) {
    	int guiLeft = (this.width - this.achievementsPaneWidth) / 2;
        int guiTop = (this.height - this.achievementsPaneHeight) / 2 + yShiftGUI;
        int xShift = guiLeft + 16 + widthCorrection;
        int yShift = guiTop + 17;
    	this.zLevel = 0.0F;
        GL11.glDepthFunc(GL11.GL_GEQUAL);
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0F, 0.0F, -200.0F);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glEnable(GL11.GL_COLOR_MATERIAL);
        this.mc.renderEngine.bindTexture("/terrain.png");
        int mapWidth = (windowX + 288) % 16 + widthCorrection;
        int mapHeight = (windowY + 288) % 16;
        Random random = new Random();
        
        for (int i = 0; i * 16 - mapHeight < 155; ++i)
        {
            for (int x1 = 0; x1 * 16 - mapWidth < 224; ++x1)
            {
            	Icon icon = Block.dirt.getIcon(0, 0);
            	if (tab != null) {
            		icon = tab.genAchievementIcon(x1, i, windowX, windowY);
            	}
        		this.drawTexturedModelRectFromIcon(xShift + x1 * 16 - mapWidth, yShift + i * 16 - mapHeight, icon, 16, 16);
            }
        }
    }
    
    protected void drawAchievementConnections(AchievementTab tab, int windowX, int windowY) {
    	if (tab == null) { return; }
    	
    	int guiLeft = (this.width - this.achievementsPaneWidth) / 2;
        int guiTop = (this.height - this.achievementsPaneHeight) / 2 + yShiftGUI;
        int xShift = guiLeft + 16 + widthCorrection;
        int yShift = guiTop + 17;
        
        for (int i = 0; i < tab.achievementList.size(); ++i) {
            Achievement achievement = tab.achievementList.get(i);
            if (shouldHide(achievement)) { continue; }
            
            for (Achievement parent : achievement.parentAchievements) {
            	if (parent == null || (achievement.tab != parent.tab)) { continue; }
                
            	int x1 = achievement.displayColumn * 24 - windowX + 11 + xShift;
                int y1 = achievement.displayRow * 24 - windowY + 11 + yShift;
                
                int x2 = parent.displayColumn * 24 - windowX + 11 + xShift;
                int y2 = parent.displayRow * 24 - windowY + 11 + yShift;
                
                boolean hasUnlocked = ac.hasUnlocked(mc.thePlayer, achievement);
                boolean canUnlock = ac.canUnlock(mc.thePlayer, achievement);
                
                int flash = 255; // Math.sin((double)(Minecraft.getSystemTime() % 600L) / 600.0D * Math.PI * 2.0D) > 0.6D ? 255 : 130;
                int color = -16777216;

                if (hasUnlocked) {
                    color = -9408400;
                }
                else if (canUnlock) {
                    color = 65280 + (flash << 24);
                }

                this.drawHorizontalLine(x1, x2, y1, color);
                this.drawVerticalLine(x2, y1, y2, color);
            }
        }
    }
    
    protected Achievement renderAchievements(AchievementTab tab, int windowX, int windowY, int mouseX, int mouseY) {
    	if (tab == null) { return null; }
    	
    	int guiLeft = (this.width - this.achievementsPaneWidth) / 2;
        int guiTop = (this.height - this.achievementsPaneHeight) / 2 + yShiftGUI;
        int xShift = guiLeft + 16 + widthCorrection;
        int yShift = guiTop + 17;
        
        RenderItem renderItem = new RenderItem();
        int stringWidth;
        int tooltipY;
        Achievement achievementHovered = null;

        for (int x1 = 0; x1 < tab.achievementList.size(); ++x1) {
            Achievement achievement = tab.achievementList.get(x1);
            if (shouldHide(achievement)) { continue; }
            int x2 = achievement.displayColumn * 24 - windowX;
            int y2 = achievement.displayRow * 24 - windowY;

            if (x2 >= -24 && y2 >= -24 && x2 <= 224 && y2 <= 155) {
                float brightness;

                if (ac.hasUnlocked(mc.thePlayer, achievement)) {
                    brightness = 1.0F;
                    GL11.glColor4f(brightness, brightness, brightness, 1.0F);
                } else if (ac.canUnlock(mc.thePlayer, achievement)) {
                	//BAM: CHANGED
                    brightness = 1.0F;//Math.sin((double)(Minecraft.getSystemTime() % 600L) / 600.0D * Math.PI * 2.0D) < 0.6D ? 0.6F : 0.8F;
                    GL11.glColor4f(brightness, brightness, brightness, 1.0F);
                } else {
                    brightness = 0.3F;
                    GL11.glColor4f(brightness, brightness, brightness, 1.0F);
                }

                this.mc.renderEngine.bindTexture(String.format("/achievement/shape/%s.png", achievement.frameSet));
                stringWidth = xShift + x2;
                tooltipY = yShift + y2;
                //BAM: CHANGED
//                this.drawTexturedModalRect(stringWidth - 2, tooltipY - 2, achievement.u, achievement.v, 26, 26);
                

                //BAM: ADDED
                if (ac.hasUnlocked(mc.thePlayer, achievement))
                {
                	this.drawTexturedModalRect(stringWidth - 2, tooltipY - 2, achievement.u, achievement.v + 26, 26, 26);
                }
                else
                {
                	this.drawTexturedModalRect(stringWidth - 2, tooltipY - 2, achievement.u, achievement.v, 26, 26);
                }
                //END BAM

                if (!ac.canUnlock(mc.thePlayer, achievement)) {
                    float borderBrightness = 0.1F;
                    GL11.glColor4f(borderBrightness, borderBrightness, borderBrightness, 1.0F);
                    renderItem.renderWithColor = false;
                }

                //BAM: CHANGED
//                GL11.glEnable(GL11.GL_LIGHTING);
//                GL11.glEnable(GL11.GL_CULL_FACE);
//                renderItem.renderItemAndEffectIntoGUI(this.mc.fontRenderer, this.mc.renderEngine, achievement.theItemStack, stringWidth + 3, tooltipY + 3);
//                GL11.glDisable(GL11.GL_LIGHTING);
                
                
                //BAM: ADDED
                GL11.glDisable(GL11.GL_LIGHTING);
                renderItem.zLevel = 100.0F;
                GL11.glEnable(GL11.GL_LIGHTING);
              	GL11.glEnable(GL12.GL_RESCALE_NORMAL);
                renderItem.renderItemAndEffectIntoGUI(this.fontRenderer, this.mc.renderEngine, achievement.theItemStack, stringWidth + 3, tooltipY + 3);
                renderItem.renderItemOverlayIntoGUI(this.fontRenderer, this.mc.renderEngine, achievement.theItemStack, stringWidth + 3, tooltipY + 3);
                GL11.glDisable(GL11.GL_LIGHTING);
                renderItem.zLevel = 0.0F;
                //END BAM
                
                if (!ac.canUnlock(mc.thePlayer, achievement)) {
                    renderItem.renderWithColor = true;
                }

                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

                if (mouseX >= xShift && mouseY >= yShift && mouseX < xShift + 224 && mouseY < yShift + 155 && mouseX >= stringWidth && mouseX <= stringWidth + 22 && mouseY >= tooltipY && mouseY <= tooltipY + 22) {
                    achievementHovered = achievement;
                }
            }
        }
		return achievementHovered;
    }
    
    protected void renderFrame(AchievementTab tab, float par3) {
    	int guiLeft = (this.width - this.achievementsPaneWidth) / 2;
        int guiTop = (this.height - this.achievementsPaneHeight) / 2 + yShiftGUI;
        
        // Render all non-selected tabs behind the window.
        if (tab != null) {
	        for (int i = 0; i < tabList.size(); ++i) {
	        	if (i != this.tabIndex) {
		            tab = tabList.get(i);
		            this.mc.renderEngine.bindTexture("/gui/allitems.png");
		            this.renderAchievementTab(tab);
	        	}
	        }
        }
        
        // Render frame.
        this.mc.renderEngine.bindTexture("/achievement/achievementscore_bg.png");
        this.drawTexturedModalRect(guiLeft, guiTop, 0, 0, this.achievementsPaneWidth, this.achievementsPaneHeight);
        GL11.glPopMatrix();
        this.zLevel = 0.0F;
        GL11.glDepthFunc(GL11.GL_LEQUAL);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        super.drawScreen(mouseX, mouseY, par3);
    }
    
    protected void renderHoveredAchievement(Achievement achievementHovered, int mouseX, int mouseY) {
    	if (achievementHovered != null)
        {
            String name = StatCollector.translateToLocal(achievementHovered.getName());
            String description = achievementHovered.getDescription();
            int x2 = mouseX + 12;
            int y2 = mouseY - 4;

            if (ac.canUnlock(mc.thePlayer, achievementHovered))
            {
                int stringWidth = Math.max(this.fontRenderer.getStringWidth(name), 120);
                int tooltipY = this.fontRenderer.splitStringWidth(description, stringWidth);

                if (ac.hasUnlocked(mc.thePlayer, achievementHovered))
                {
                    tooltipY += 12;
                }

                this.drawGradientRect(x2 - 3, y2 - 3, x2 + stringWidth + 3, y2 + tooltipY + 3 + 12, -1073741824, -1073741824);
                this.fontRenderer.drawSplitString(description, x2, y2 + 12, stringWidth, -6250336);

                if (ac.hasUnlocked(mc.thePlayer, achievementHovered))
                {
                    this.fontRenderer.drawStringWithShadow(StatCollector.translateToLocal("achievement.taken"), x2, y2 + tooltipY + 4, -7302913);
                }
            }
            else
            {
                int stringWidth = Math.max(this.fontRenderer.getStringWidth(name), 120);
                
                int lockedIndex = 0;
                for (int i = 0; i < achievementHovered.parentAchievements.length; i++) {
                	if (!ac.hasUnlocked(mc.thePlayer, achievementHovered.parentAchievements[i])) {
                		lockedIndex = i;
                		break;
                	}
                }
                
                String requiredDesc = StatCollector.translateToLocalFormatted("achievement.requires", new Object[] {StatCollector.translateToLocal(achievementHovered.parentAchievements[lockedIndex].getName())});
                int flash = this.fontRenderer.splitStringWidth(requiredDesc, stringWidth);
                this.drawGradientRect(x2 - 3, y2 - 3, x2 + stringWidth + 3, y2 + flash + 12 + 3, -1073741824, -1073741824);
                this.fontRenderer.drawSplitString(requiredDesc, x2, y2 + 12, stringWidth, -9416624);
            }

            this.fontRenderer.drawStringWithShadow(name, x2, y2, ac.canUnlock(mc.thePlayer, achievementHovered) ? (achievementHovered.getSpecial() ? -128 : -1) : (achievementHovered.getSpecial() ? -8355776 : -8355712));
        }
    }
    
    /**
     * Returns true if this GUI should pause the game when it is displayed in single-player
     */
    public boolean doesGuiPauseGame()
    {
        return true;
    }
    
    /**
     * Renders passed achievement tab into the screen.
     */
    protected void renderAchievementTab(AchievementTab tab)
    {	
    	if ((tab.getIndex() + 1) > MAX_TABS * page || (tab.getIndex() + 1) <= MAX_TABS * (page - 1)) {
    		return;
    	}
        
    	int guiLeft = (this.width - this.achievementsPaneWidth) / 2;
        int guiTop = (this.height - this.achievementsPaneHeight) / 2 + yShiftGUI;
        
        int i = tab.getIndex() % MAX_TABS;
        int j = 28;
        if (i == 0) {
        	j = 0;
        } else if (i + 1 == MAX_TABS) {
        	j = 5 * 28;
        }
        
        int k = 0;
        int l = (int) Math.round(guiLeft + 28 * i);
        int i1 = guiTop -28;
        byte j1 = 32;

        if (tab.getIndex() == tabIndex)
        {
            k += 32;
        }
        
        GL11.glDisable(GL11.GL_LIGHTING);
        this.drawTexturedModalRect(l, i1, j, k, 28, j1);
        this.zLevel = 100.0F;
        RenderItem renderItem = new RenderItem();
        renderItem.zLevel = 100.0F;
        l += 6;
        i1 += 9;
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        ItemStack itemstack = new ItemStack(tab.getIconItem());
        renderItem.renderItemAndEffectIntoGUI(this.fontRenderer, this.mc.renderEngine, itemstack, l, i1);
        renderItem.renderItemOverlayIntoGUI(this.fontRenderer, this.mc.renderEngine, itemstack, l, i1);
        GL11.glDisable(GL11.GL_LIGHTING);
        renderItem.zLevel = 0.0F;
        this.zLevel = 0.0F;
    }
    
    /**
     * Renders achievement page buttons into the screen.
     */
    protected void renderPageButtons(int mouseX, int mouseY)
    {
    	int guiLeft = (this.width - this.achievementsPaneWidth) / 2;
        int guiTop = (this.height - this.achievementsPaneHeight) / 2 + yShiftGUI;
        
        int buttonShift = 1;
        int leftPos = guiLeft - 10 - buttonShift;
        int rightPos = guiLeft + this.achievementsPaneWidth + buttonShift;
        
        int yPos = guiTop - 18;
        
        GL11.glDisable(GL11.GL_LIGHTING);
        if (page > 1)
        {
        	int u = 177;
        	if (this.isMouseOverLeftButton(mouseX, mouseY)) {
        		u = 189;
        	}
        	this.drawTexturedModalRect(leftPos, yPos, u, 21, 10, 15);
        }
        if (tabList.size() > MAX_TABS * page)
        {
        	int u = 177;
        	if (this.isMouseOverRightButton(mouseX, mouseY)) {
        		u = 189;
        	}
        	this.drawTexturedModalRect(rightPos, yPos, u, 2, 10, 15);
        }
    }
    
    private void setupTabMap() {
    	if (tabList.isEmpty()) {
            this.guiMapTop = 0;
            this.guiMapLeft = 0;
            this.guiMapBottom = 0;
            this.guiMapRight = 0;
    	} else {
	    	AchievementTab tab = tabList.get(this.tabIndex);
	    	
	    	/** The top x coordinate of the achievement map */
	        this.guiMapTop = tab.minDisplayColumn * 24 - 112;
	
	        /** The left y coordinate of the achievement map */
	        this.guiMapLeft = tab.minDisplayRow * 24 - 112;
	
	        /** The bottom x coordinate of the achievement map */
	        this.guiMapBottom = tab.maxDisplayColumn * 24 - 77;
	
	        /** The right y coordinate of the achievement map */
	        this.guiMapRight = tab.maxDisplayRow * 24 - 77;
    	}
    }

    private void setCurrentTab(AchievementTab tab) {
		this.tabIndex = tab.getIndex();
		this.setupTabMap();
		
		short var2 = 141;
        short var3 = 141;
        this.field_74117_m = this.guiMapX = this.field_74124_q = (double)(AchievementList.openInventory.displayColumn * 24 - var2 / 2 - 12);
        this.field_74115_n = this.guiMapY = this.field_74123_r = (double)(AchievementList.openInventory.displayRow * 24 - var3 / 2);
	}
    
    private void switchPage(int direction) {
    	if (direction > 0 && tabList.size() > MAX_TABS * page) {
    		page++;
    	} else if (direction < 0 && page > 1) {
    		page--;
    	}
    }
    
    /**
     * Called when the mouse is moved or a mouse button is released.  Signature: (mouseX, mouseY, state) state==-1 is
     * mouseMove, state==0 or state==1 is mouseUp
     */
    protected void mouseMovedOrUp(int mouseX, int mouseY, int state)
    {
    	int guiLeft = (this.width - this.achievementsPaneWidth) / 2;
        int guiTop = (this.height - this.achievementsPaneHeight) / 2 + yShiftGUI;
        
        if (state == 0)
        {
        	if (this.isMouseOverLeftButton(mouseX, mouseY)) {
        		this.switchPage(-1);
        		return;
        	}
        	if (this.isMouseOverRightButton(mouseX, mouseY)) {
        		this.switchPage(1);
        		return;
        	}
	        for (int tabIter = 0; tabIter < this.tabList.size(); ++tabIter)
	        {
	            AchievementTab tab = this.tabList.get(tabIter);
	
	            if (this.isMouseOverTab(tab, mouseX, mouseY))
	            {
	                this.setCurrentTab(tab);
	                return;
	            }
	        }
        }

        super.mouseMovedOrUp(mouseX, mouseY, state);
    }

    /**
     * Handles mouse input.
     */
    public void handleMouseInput()
    {
        super.handleMouseInput();
        this.switchPage(-Mouse.getEventDWheel());
    }
    
	private void setHoverText(AchievementTab tab, int mouseX, int mouseY)
	{
        String name = StatCollector.translateToLocal(tab.getName());
        int x2 = mouseX + 12;
        int y2 = mouseY - 4;

        int stringWidth = Math.max(this.fontRenderer.getStringWidth(name), 15);
        
        this.drawGradientRect(x2 - 3, y2 - 3, x2 + stringWidth + 3, y2 + 12, -1073741824, -1073741824);

        this.fontRenderer.drawStringWithShadow(name, x2, y2, -1);
	}

	protected boolean isMouseOverTab(AchievementTab tab, int mouseX, int mouseY)
    {
		if ((tab.getIndex() + 1) > MAX_TABS * page || (tab.getIndex() + 1) <= MAX_TABS * (page - 1)) {
    		return false;
    	}
		
		int guiLeft = (this.width - this.achievementsPaneWidth) / 2;
        int guiTop = (this.height - this.achievementsPaneHeight) / 2 + yShiftGUI;
        
		mouseX -= guiLeft;
        mouseY -= guiTop;
        
        int i = tab.getIndex() % MAX_TABS;
        int j = (int) (27.5 * i);
        byte k = 0;

        if (i > 0)
        {
            j += i;
        }

        int k1 = k - 32;

        return mouseX >= j && mouseX <= j + 28 && mouseY >= k1 && mouseY <= k1 + 32;
    }
	
	protected boolean isMouseOverLeftButton(int mouseX, int mouseY)
    {
    	int guiLeft = (this.width - this.achievementsPaneWidth) / 2;
        int guiTop = (this.height - this.achievementsPaneHeight) / 2 + yShiftGUI;
        
        int buttonShift = 0;
        int leftPos = guiLeft - 14 - buttonShift;
        int yPos = guiTop - 18;
        
        return mouseX >= leftPos && mouseX <= leftPos + 10 && mouseY >= yPos && mouseY <= yPos + 15 && page > 1;
    }
	
	protected boolean isMouseOverRightButton(int mouseX, int mouseY)
    {
    	int guiLeft = (this.width - this.achievementsPaneWidth) / 2;
        int guiTop = (this.height - this.achievementsPaneHeight) / 2 + yShiftGUI;
        
        int buttonShift = 0;
        int rightPos = guiLeft + this.achievementsPaneWidth + buttonShift;
        int yPos = guiTop - 18;
        
        return mouseX >= rightPos && mouseX <= rightPos + 10 && mouseY >= yPos && mouseY <= yPos + 15 && tabList.size() > MAX_TABS * page;
    }
	
	// Recursively check if any of the parents are hidden, and if so we want to hide this achievement as well.
	private boolean shouldHide(Achievement achievement) {
		if (achievement == null || ac.hasUnlocked(mc.thePlayer, achievement)) {
			return false;
		} else if (achievement.isHidden) {
			return true;
		} else {
			for (Achievement parent : achievement.parentAchievements) {
				if (shouldHide(parent)) {
					return true;
				}
			}
		}
		return false;
	}
}