package org.parabot.minimal.minimalrunecrafting;

public enum Altar
{
    AIR_ALTAR("Air altar", 2478, 1, 557),
    MIND_ALTAR("Mind altar", 2479, 2, 559),
    WATER_ALTAR("Water altar", 2480, 5, 556),
    EARTH_ALTAR("Earth altar", 2481, 9, 558),
    FIRE_ALTAR("Fire altar", 2482, 14, 555),
    BODY_ALTAR("Body altar", 2483, 27, 560),
    COSMIC_ALTAR("Cosmic altar", 2484, 35, 565),
    CHAOS_ALTAR("Chaos altar", 2487, 40, 563),
    NATURE_ALTAR("Nature altar", 2486, 44, 562),
    LAW_ALTAR("Law altar", 2485, 54, 564),
    DEATH_ALTAR("Death altar", 2488, 65, 561),
    BLOOD_ALTAR("Blood altar", 7141, 77, 566),
    SOUL_ALTAR("Soul altar", 7138, 85, 567);

    private String name;
    private int id;
    private int level;
    private int runeId;

    Altar(String name, int id, int level, int runeId)
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
        int[] runeIds = new int[values().length];

        for (int i = 0; i < values().length; i++)
        {
            runeIds[i] = values()[i].getRuneId();
        }

        return runeIds;
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