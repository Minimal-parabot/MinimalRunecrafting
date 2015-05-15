package org.parabot.minimal.minimalrunecrafting;

import org.parabot.core.ui.Logger;
import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.SceneObjects;
import org.rev317.min.api.wrappers.SceneObject;

public class Runecraft implements Strategy
{
    private final Altar altar;

    private final int RUNE_ESSENCE;

    public Runecraft(Altar altar, int RUNE_ESSENCE)
    {
        this.altar = altar;
        this.RUNE_ESSENCE = RUNE_ESSENCE;
    }

    private SceneObject runeAltar;

    @Override
    public boolean activate()
    {
        for (SceneObject so : SceneObjects.getAllSceneObjects())
        {
            if (so.getId() == altar.getId()
                    && Inventory.getCount(RUNE_ESSENCE) > 0)
            {
                runeAltar = so;

                return true;
            }
        }

        return false;
    }

    @Override
    public void execute()
    {
        Logger.addMessage("Runecrafting", true);

        runeAltar.interact(0);

        Time.sleep(new SleepCondition()
        {
            @Override
            public boolean isValid()
            {
                return Inventory.getCount(RUNE_ESSENCE) == 0;
            }
        }, 2000);
    }
}