package org.parabot.minimal.minimalrunecrafting;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Game;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Menu;
import org.rev317.min.api.methods.SceneObjects;
import org.rev317.min.api.wrappers.SceneObject;

public class BankRunes implements Strategy
{
    private final int RUNE_ESSENCE;

    public BankRunes(int RUNE_ESSENCE)
    {
        this.RUNE_ESSENCE = RUNE_ESSENCE;
    }

    private SceneObject bankBooth;

    public final int BANK_BOOTH_ID = 2213;

    @Override
    public boolean activate()
    {
        for (SceneObject so : SceneObjects.getNearest(2213))
        {
            if (so != null)
            {
                bankBooth = so;

                return true;
            }
        }

        return false;
    }

    @Override
    public void execute()
    {
        if (Game.getOpenInterfaceId() != 23350)
        {
            MinimalRunecrafting.status = "Opening";

            bankBooth.interact(0);

            Time.sleep(new SleepCondition()
            {
                @Override
                public boolean isValid()
                {
                    return Game.getOpenInterfaceId() == 23350;
                }
            }, 2500);
        }

        if (Game.getOpenInterfaceId() == 23350)
        {
            MinimalRunecrafting.status = "Banking";

            Menu.sendAction(53, RUNE_ESSENCE - 1, 0, 5382);

            Time.sleep(new SleepCondition()
            {
                @Override
                public boolean isValid()
                {
                    return Inventory.getCount(RUNE_ESSENCE) > 0;
                }
            }, 1500);
        }
    }
}