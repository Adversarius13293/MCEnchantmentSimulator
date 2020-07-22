package adver.sarius.mc.enchsim;

import java.util.EnumSet;
import java.util.function.Function;

public enum Enchantment {

    PROTECTION(false, 10, mel -> {
        if (isBetween(34, 54, mel)) {
            return 4;
        } else if (isBetween(23, 34, mel)) {
            return 3;
        } else if (isBetween(12, 23, mel)) {
            return 2;
        } else if (isBetween(1, 12, mel)) {
            return 1;
        } else {
            return -1;
        }
    }),
    FIRE_PROTECTION(false, 5, mel -> {
        if (isBetween(34, 42, mel)) {
            return 4;
        } else if (isBetween(26, 34, mel)) {
            return 3;
        } else if (isBetween(18, 26, mel)) {
            return 2;
        } else if (isBetween(10, 18, mel)) {
            return 1;
        } else {
            return -1;
        }
    }),
    FEATHER_FALLING(false, 5, mel -> {
        if (isBetween(23, 29, mel)) {
            return 4;
        } else if (isBetween(17, 23, mel)) {
            return 3;
        } else if (isBetween(11, 17, mel)) {
            return 2;
        } else if (isBetween(5, 11, mel)) {
            return 1;
        } else {
            return -1;
        }
    }),
    BLAST_PROTECTION(false, 2, mel -> {
        if (isBetween(29, 37, mel)) {
            return 4;
        } else if (isBetween(21, 29, mel)) {
            return 3;
        } else if (isBetween(13, 21, mel)) {
            return 2;
        } else if (isBetween(5, 13, mel)) {
            return 1;
        } else {
            return -1;
        }
    }),
    PROJECTILE_PROTECTION(false, 5, mel -> {
        if (isBetween(21, 27, mel)) {
            return 4;
        } else if (isBetween(15, 21, mel)) {
            return 3;
        } else if (isBetween(9, 15, mel)) {
            return 2;
        } else if (isBetween(3, 9, mel)) {
            return 1;
        } else {
            return -1;
        }
    }),
    RESPIRATION(false, 2, mel -> {
        if (isBetween(30, 60, mel)) {
            return 3;
        } else if (isBetween(20, 50, mel)) {
            return 2;
        } else if (isBetween(10, 40, mel)) {
            return 1;
        } else {
            return -1;
        }
    }),
    AQUA_AFFINITY(false, 2, mel -> {
        if (isBetween(1, 41, mel)) {
            return 1;
        } else {
            return -1;
        }
    }),
    THORNS(false, 1, mel -> {
        if (isBetween(50, 81, mel)) {
            return 3;
        } else if (isBetween(30, 71, mel)) {
            return 2;
        } else if (isBetween(10, 61, mel)) {
            return 1;
        } else {
            return -1;
        }
    }),
    DEPTH_STRIDER(false, 2, mel -> {
        if (isBetween(30, 45, mel)) {
            return 3;
        } else if (isBetween(20, 35, mel)) {
            return 2;
        } else if (isBetween(10, 25, mel)) {
            return 1;
        } else {
            return -1;
        }
    }),
    FROST_WALKER(true, 2, mel -> {
        if (isBetween(20, 35, mel)) {
            return 2;
        } else if (isBetween(10, 25, mel)) {
            return 1;
        } else {
            return -1;
        }
    }),
    CURSE_OF_BINDING(true, 1, mel -> {
        if (isBetween(25, 50, mel)) {
            return 1;
        } else {
            return -1;
        }
    }),
    SHARPNESS(false, 10, mel -> {
        if (isBetween(45, 65, mel)) {
            return 5;
        } else if (isBetween(34, 54, mel)) {
            return 4;
        } else if (isBetween(23, 43, mel)) {
            return 3;
        } else if (isBetween(12, 32, mel)) {
            return 2;
        } else if (isBetween(1, 21, mel)) {
            return 1;
        } else {
            return -1;
        }
    }),
    SMITE(false, 5, mel -> {
        if (isBetween(37, 57, mel)) {
            return 5;
        } else if (isBetween(29, 49, mel)) {
            return 4;
        } else if (isBetween(21, 41, mel)) {
            return 3;
        } else if (isBetween(13, 33, mel)) {
            return 2;
        } else if (isBetween(5, 25, mel)) {
            return 1;
        } else {
            return -1;
        }
    }),
    BANE_OF_ATHROPODS(false, 5, mel -> {
        if (isBetween(37, 57, mel)) {
            return 5;
        } else if (isBetween(29, 49, mel)) {
            return 4;
        } else if (isBetween(21, 41, mel)) {
            return 3;
        } else if (isBetween(13, 33, mel)) {
            return 2;
        } else if (isBetween(5, 25, mel)) {
            return 1;
        } else {
            return -1;
        }
    }),
    KNOCKBACK(false, 5, mel -> {
        if (isBetween(25, 71, mel)) {
            return 2;
        } else if (isBetween(5, 61, mel)) {
            return 1;
        } else {
            return -1;
        }
    }),
    FIRE_ASPECT(false, 2, mel -> {
        if (isBetween(30, 71, mel)) {
            return 2;
        } else if (isBetween(10, 61, mel)) {
            return 1;
        } else {
            return -1;
        }
    }),
    LOOTING(false, 2, mel -> {
        if (isBetween(33, 81, mel)) {
            return 3;
        } else if (isBetween(24, 71, mel)) {
            return 2;
        } else if (isBetween(15, 61, mel)) {
            return 1;
        } else {
            return -1;
        }
    }),
    SWEEPING_EDGE(false, 2, mel -> {
        if (isBetween(23, 38, mel)) {
            return 3;
        } else if (isBetween(14, 29, mel)) {
            return 2;
        } else if (isBetween(5, 20, mel)) {
            return 1;
        } else {
            return -1;
        }
    }),
    POWER(false, 10, mel -> {
        if (isBetween(41, 56, mel)) {
            return 5;
        } else if (isBetween(31, 46, mel)) {
            return 4;
        } else if (isBetween(21, 36, mel)) {
            return 3;
        } else if (isBetween(11, 26, mel)) {
            return 2;
        } else if (isBetween(1, 16, mel)) {
            return 1;
        } else {
            return -1;
        }
    }),
    PUNCH(false, 2, mel -> {
        if (isBetween(32, 57, mel)) {
            return 2;
        } else if (isBetween(12, 37, mel)) {
            return 1;
        } else {
            return -1;
        }
    }),
    FLAME(false, 2, mel -> {
        if (isBetween(20, 50, mel)) {
            return 1;
        } else {
            return -1;
        }
    }),
    INFINITY(false, 1, mel -> {
        if (isBetween(20, 50, mel)) {
            return 1;
        } else {
            return -1;
        }
    }),
    EFFICIENCY(false, 10, mel -> {
        if (isBetween(41, 101, mel)) {
            return 5;
        } else if (isBetween(31, 91, mel)) {
            return 4;
        } else if (isBetween(21, 81, mel)) {
            return 3;
        } else if (isBetween(11, 71, mel)) {
            return 2;
        } else if (isBetween(1, 61, mel)) {
            return 1;
        } else {
            return -1;
        }
    }),
    SILK_TOUCH(false, 1, mel -> {
        if (isBetween(15, 61, mel)) {
            return 1;
        } else {
            return -1;
        }
    }),
    FORTUNE(false, 2, mel -> {
        if (isBetween(33, 81, mel)) {
            return 3;
        } else if (isBetween(24, 71, mel)) {
            return 2;
        } else if (isBetween(15, 61, mel)) {
            return 1;
        } else {
            return -1;
        }
    }),
    LUCK_OF_THE_SEA(false, 2, mel -> {
        if (isBetween(33, 81, mel)) {
            return 3;
        } else if (isBetween(24, 71, mel)) {
            return 2;
        } else if (isBetween(15, 61, mel)) {
            return 1;
        } else {
            return -1;
        }
    }),
    LURE(false, 2, mel -> {
        if (isBetween(33, 81, mel)) {
            return 3;
        } else if (isBetween(24, 71, mel)) {
            return 2;
        } else if (isBetween(15, 61, mel)) {
            return 1;
        } else {
            return -1;
        }
    }),
    UNBREAKING(false, 5, mel -> {
        if (isBetween(21, 81, mel)) {
            return 3;
        } else if (isBetween(13, 71, mel)) {
            return 2;
        } else if (isBetween(5, 61, mel)) {
            return 1;
        } else {
            return -1;
        }
    }),
    MENDING(true, 2, mel -> {
        if (isBetween(25, 75, mel)) {
            return 1;
        } else {
            return -1;
        }
    }),
    CURSE_OF_VANISHING(true, 1, mel -> {
        if (isBetween(25, 50, mel)) {
            return 1;
        } else {
            return -1;
        }
    }),
    CHANNELING(false, 1, mel -> {
        if (isBetween(25, 50, mel)) {
            return 1;
        } else {
            return -1;
        }
    }),
    IMPALING(false, 2, mel -> {
        if (isBetween(33, 53, mel)) {
            return 5;
        } else if (isBetween(25, 45, mel)) {
            return 4;
        } else if (isBetween(17, 37, mel)) {
            return 3;
        } else if (isBetween(9, 29, mel)) {
            return 2;
        } else if (isBetween(1, 21, mel)) {
            return 1;
        } else {
            return -1;
        }
    }),
    LOYALTY(false, 5, mel -> {
        if (isBetween(26, 50, mel)) {
            return 3;
        } else if (isBetween(19, 50, mel)) {
            return 2;
        } else if (isBetween(12, 50, mel)) {
            return 1;
        } else {
            return -1;
        }
    }),
    RIPTIDE(false, 2, mel -> {
        if (isBetween(31, 50, mel)) {
            return 3;
        } else if (isBetween(24, 40, mel)) {
            return 2;
        } else if (isBetween(17, 30, mel)) {
            return 1;
        } else {
            return -1;
        }
    }),
    MULTISHOT(false, 2, mel -> {
    	if (isBetween(20, 50, mel)) {
            return 1;
        } else {
            return -1;
        }
    }),
    PIERCING(false, 10, mel -> {
    	if (isBetween(31, 50, mel)) {
            return 4;
        } else if (isBetween(21, 50, mel)) {
            return 3;
        } else if (isBetween(11, 50, mel)) {
            return 2;
        } else if (isBetween(1, 50, mel)) {
            return 1;
        } else {
            return -1;
        }
    }),
    QUICK_CHARGE(false, 5, mel -> {
        if (isBetween(52, 50, mel)) {
            return 3;
        } else if (isBetween(32, 50, mel)) {
            return 2;
        } else if (isBetween(12, 50, mel)) {
            return 1;
        } else {
            return -1;
        }
    });

    // dirty hack to fill in self-referencing conflicts
    static {
        // always add itself as conflict and create EnumSet this way
        EnumSet.allOf(Enchantment.class).forEach(ench -> ((Enchantment) ench).conflicts = EnumSet.of(ench));

        PROTECTION.getConflicts().add(FIRE_PROTECTION);
        PROTECTION.getConflicts().add(BLAST_PROTECTION);
        PROTECTION.getConflicts().add(PROJECTILE_PROTECTION);
        FIRE_PROTECTION.getConflicts().add(PROTECTION);
        FIRE_PROTECTION.getConflicts().add(BLAST_PROTECTION);
        FIRE_PROTECTION.getConflicts().add(PROJECTILE_PROTECTION);
        BLAST_PROTECTION.getConflicts().add(PROTECTION);
        BLAST_PROTECTION.getConflicts().add(FIRE_PROTECTION);
        BLAST_PROTECTION.getConflicts().add(PROJECTILE_PROTECTION);
        PROJECTILE_PROTECTION.getConflicts().add(PROTECTION);
        PROJECTILE_PROTECTION.getConflicts().add(FIRE_PROTECTION);
        PROJECTILE_PROTECTION.getConflicts().add(BLAST_PROTECTION);

        SHARPNESS.getConflicts().add(BANE_OF_ATHROPODS);
        SHARPNESS.getConflicts().add(SMITE);
        BANE_OF_ATHROPODS.getConflicts().add(SHARPNESS);
        BANE_OF_ATHROPODS.getConflicts().add(SMITE);
        SMITE.getConflicts().add(SHARPNESS);
        SMITE.getConflicts().add(BANE_OF_ATHROPODS);

        CHANNELING.getConflicts().add(RIPTIDE);
        RIPTIDE.getConflicts().add(CHANNELING);
        RIPTIDE.getConflicts().add(LOYALTY);
        LOYALTY.getConflicts().add(RIPTIDE);

        SILK_TOUCH.getConflicts().add(FORTUNE);
        FORTUNE.getConflicts().add(SILK_TOUCH);

        DEPTH_STRIDER.getConflicts().add(FROST_WALKER);
        FROST_WALKER.getConflicts().add(DEPTH_STRIDER);

        MENDING.getConflicts().add(INFINITY);
        INFINITY.getConflicts().add(MENDING);
        
        MULTISHOT.getConflicts().add(PIERCING);
        PIERCING.getConflicts().add(MULTISHOT);
    }
    public static final EnumSet<Enchantment> ENCHANTMENTS_GENERAL = EnumSet.of(UNBREAKING, MENDING, CURSE_OF_VANISHING);
    public static final EnumSet<Enchantment> ENCHANTMENTS_TOOL = EnumSet.of(EFFICIENCY, SILK_TOUCH, FORTUNE);
    public static final EnumSet<Enchantment> ENCHANTMENTS_ARMOR = EnumSet.of(PROTECTION, FIRE_PROTECTION, BLAST_PROTECTION, PROJECTILE_PROTECTION, CURSE_OF_BINDING);
    public static final EnumSet<Enchantment> ENCHANTMENTS_ALL = EnumSet.allOf(Enchantment.class);

    private final boolean isTreasure;
    private final int weight;
    private EnumSet<Enchantment> conflicts;
    // From wiki, but I will just return constants: The minimum values are all calculated using a linear function y = kx+m where y is the calculated minimum value, x is the current enchantment power level and k and m varies between different enchantments. The maximum values are all the minimum values plus a constant that varies for each enchantment. Except Trident enchantments?!
    private final Function<Integer, Integer> powerFunc;
    // TODO: implement sinceVersion attribute

    Enchantment(boolean isTreasure, int weight, Function<Integer, Integer> powerFunc) {
        this.isTreasure = isTreasure;
        this.weight = weight;
        this.powerFunc = powerFunc;
    }

    public int getHighestPower(int modifiedEnchantmentLevel) {
        return powerFunc.apply(modifiedEnchantmentLevel);
    }

    public boolean isTreasure() {
        return isTreasure;
    }

    public int getWeight() {
        return this.weight;
    }

    public EnumSet<Enchantment> getConflicts() {
        return conflicts;
    }

    private static boolean isBetween(int lower, int upper, int number) {
        return number >= lower && number <= upper;
    }

    public static String levelToString(int level) {
        switch (level) {
            case 1:
                return " I";
            case 2:
                return " II";
            case 3:
                return " III";
            case 4:
                return " IV";
            case 5:
                return " V";
            default:
                return " unknown";
        }
    }
}
