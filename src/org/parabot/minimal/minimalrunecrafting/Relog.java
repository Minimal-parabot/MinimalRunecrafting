package org.parabot.minimal.minimalrunecrafting;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.input.Keyboard;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.Loader;

import java.awt.event.KeyEvent;

public class Relog implements Strategy
{
    @Override
    public boolean activate()
    {
        return !Loader.getClient().isLoggedIn();
    }

    @Override
    public void execute()
    {
        MinimalRunecrafting.status = "Possible dc";

        Time.sleep(new SleepCondition()
        {
            @Override
            public boolean isValid()
            {
                return Loader.getClient().isLoggedIn();
            }
        }, 3000);

        if (!Loader.getClient().isLoggedIn())
        {
            MinimalRunecrafting.status = "Logging in";

            Keyboard.getInstance().clickKey(KeyEvent.VK_ENTER);

            Time.sleep(new SleepCondition()
            {
                @Override
                public boolean isValid()
                {
                    return Loader.getClient().isLoggedIn();
                }
            }, 5000);

            if (Loader.getClient().isLoggedIn())
            {
                MinimalRunecrafting.status += "..";

                Time.sleep(4000);
            }
        }
    }
}