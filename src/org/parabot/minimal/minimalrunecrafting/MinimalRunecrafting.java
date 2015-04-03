package org.parabot.minimal.minimalrunecrafting;

import org.parabot.environment.api.interfaces.Paintable;
import org.parabot.environment.api.utils.Timer;
import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Skill;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;

@ScriptManifest(author = "Minimal",
        category = Category.RUNECRAFTING,
        description = "An AIO Runecrafter for the PkHonor server",
        name = "Minimal Runecrafting",
        servers = { "PkHonor" },
        version = 1.2)

public class MinimalRunecrafting extends Script implements Paintable
{
    private final ArrayList<Strategy> strategies = new ArrayList<>();

    private Timer timer;

    private final Image IMG = getImage("http://i.imgur.com/wjyRylv.png");

    public static String status = "";

    public boolean showPaint = false;

    private final int STARTING_EXPERIENCE = Skill.RUNECRAFTING.getExperience();
    private final int STARTING_RUNES = Inventory.getCount(true, Altar.getRuneIds());
    private final int RUNE_ESSENCE = 1437;

    @Override
    public boolean onExecute()
    {
        Altar altar;

        MinimalRunecraftingGUI gui = new MinimalRunecraftingGUI();
        gui.setVisible(true);

        while (gui.isVisible())
        {
            sleep(500);
        }

        altar = gui.getAltar();

        timer = new Timer();

        showPaint = true;

        strategies.add(new Relog());
        strategies.add(new Runecraft(altar, RUNE_ESSENCE));
        strategies.add(new BankRunes(RUNE_ESSENCE));
        provide(strategies);
        return true;
    }

    @Override
    public void paint(Graphics g)
    {
        int expGained = Skill.RUNECRAFTING.getExperience() - STARTING_EXPERIENCE;
        int runesCrafted = Inventory.getCount(true, Altar.getRuneIds()) - STARTING_RUNES;

        g.setFont(new Font("Helvetica", Font.PLAIN, 14));
        g.setColor(new Color(31, 34, 50));

        if (showPaint)
        {
            g.drawImage(IMG, 550, 209, null);
            g.drawString("Time: " + timer.toString(), 560, 275);
            g.drawString("Exp(hr): " + getPerHour(expGained), 560, 331);
            g.drawString("Runes(hr): " + getPerHour(runesCrafted), 560, 387);
            g.drawString("Status: " + status, 560, 443);
        }
    }

    private Image getImage(String url)
    {
        try
        {
            return ImageIO.read(new URL(url));
        }
        catch(IOException e)
        {
            return null;
        }
    }

    private String formatNumber(double number)
    {
        DecimalFormat compact = new DecimalFormat("0.0");

        if (number >= 1000000)
        {
            return compact.format(number / 1000000) + "m";
        }
        else if (number >= 1000
                && number < 1000000)
        {
            return compact.format(number / 1000) + "k";
        }

        return "" + number;
    }

    private String getPerHour(int amount)
    {
        return formatNumber(amount) + "(" + formatNumber(timer.getPerHour(amount)) + ")";
    }
}