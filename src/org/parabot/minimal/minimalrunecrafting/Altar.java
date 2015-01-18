package org.parabot.minimal.minimalrunecrafting;

public class Altar
{
    public static final Altar AIR_ALTAR = new Altar("Air altar", 2478, 1, 557);
    public static final Altar MIND_ALTAR = new Altar("Mind altar", 2479, 2, 559);
    public static final Altar WATER_ALTAR = new Altar("Water altar", 2480, 5, 556);
    public static final Altar EARTH_ALTAR = new Altar("Earth altar", 2481, 9, 558);
    public static final Altar FIRE_ALTAR = new Altar("Fire altar", 2482, 14, 555);
    public static final Altar BODY_ALTAR = new Altar("Body altar", 2483, 27, 560);
    public static final Altar COSMIC_ALTAR = new Altar("Cosmic altar", 2484, 35, 565);
    public static final Altar CHAOS_ALTAR = new Altar("Chaos altar", 2487, 40, 563);
    public static final Altar NATURE_ALTAR = new Altar("Nature altar", 2486, 44, 562);
    public static final Altar LAW_ALTAR = new Altar("Law altar", 2485, 54, 564);
    public static final Altar DEATH_ALTAR = new Altar("Death altar", 2488, 65, 561);
    public static final Altar BLOOD_ALTAR = new Altar("Blood altar", 7141, 77, 566);
    public static final Altar SOUL_ALTAR = new Altar("Soul altar", 7138, 85, 567);

    private String name;
    private int id;
    private int level;
    private int runeId;

    public Altar(String name, int id, int level, int runeId)
    {
        this.name = name;
        this.id = id;
        this.level = level;
        this.runeId = runeId;
    }

    /**
     * Gets the name of the altar
     * @return name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Gets the id of the altar
     * @return id
     */
    public int getId()
    {
        return id;
    }

    /**
     * Gets the required level of the altar
     * @return level
     */
    public int getLevel()
    {
        return level;
    }

    /**
     * Gets the rune id for the altar
     * @return runeId
     */
    public int getRuneId()
    {
        return runeId;
    }

    /**
     * Gets all rune ids
     * @return runeIds
     */
    public static int[] getRuneIds()
    {
        int[] runeIds = new int[getAltars().length];

        for (int i = 0; i < getAltars().length; i++)
        {
            runeIds[i] = getAltars()[i].getRuneId();
        }

        return runeIds;
    }

    /**
     * Gets all the altars
     * @return altars
     */
    public static Altar[] getAltars()
    {
        return new Altar[] { AIR_ALTAR, MIND_ALTAR, WATER_ALTAR, EARTH_ALTAR, FIRE_ALTAR,
                             BODY_ALTAR, COSMIC_ALTAR, CHAOS_ALTAR, NATURE_ALTAR, LAW_ALTAR,
                             DEATH_ALTAR, BLOOD_ALTAR, SOUL_ALTAR };
    }

    /**
     * Overwrites the default toString method
     * @return the altar in a name(level) format
     */
    @Override
    public String toString()
    {
        return name + "(" + level + ")";
    }
}