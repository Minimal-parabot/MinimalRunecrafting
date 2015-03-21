package org.parabot.minimal.minimalrunecrafting;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.SceneObjects;
import org.rev317.min.api.wrappers.SceneObject;

public class BobsIsland implements Strategy
{
    private final int PORTAL_ID = 8987;

    public boolean activate()
    {
        return SceneObjects.getNearest(PORTAL_ID).length > 0;
    }

    public void execute()
    {
        for (SceneObject so : SceneObjects.getNearest(PORTAL_ID))
        {
            final SceneObject portal = so;

            portal.interact(0);

            Time.sleep(new SleepCondition()
            {
                @Override
                public boolean isValid()
                {
                    return portal.distanceTo() == 1;
                }
            }, 7500);

            if (portal.distanceTo() == 1)
            {
                Time.sleep(500);
            }

            if (SceneObjects.getNearest(PORTAL_ID).length == 0)
            {
                break;
            }
        }
    }
}