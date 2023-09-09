package sockthing.better_achievements;

import btw.AddonHandler;
import btw.BTWAddon;

import btw.block.BTWBlocks;
import issame.achievements_core.achievements.AchievementTab;

public class BetterAchievements extends BTWAddon {
    private BetterAchievements() {
        super("Better Achievements", "2.0.0", "BA");
    }

    @Override
    public void initialize() {
        AddonHandler.logMessage(this.getName() + " Version " + this.getVersionString() + " Initializing...");
        Achievements.setupAchievements();
        AddonHandler.logMessage(this.getName() + " Initialization Complete.");
    }
}
