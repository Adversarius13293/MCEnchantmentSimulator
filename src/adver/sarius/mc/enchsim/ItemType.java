package adver.sarius.mc.enchsim;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.function.Function;

public enum ItemType {
    SWORD(mat -> {
        switch (mat) {
            case WOOD:
                return 15;
            case STONE:
                return 5;
            case IRON:
                return 14;
            case DIAMOND:
                return 10;
            case GOLD:
                return 22;
            case NETHERITE:
                return 15;
            default:
                return -1;
        }
    }),
    AXE(mat -> {
        switch (mat) {
            case WOOD:
                return 15;
            case STONE:
                return 5;
            case IRON:
                return 14;
            case DIAMOND:
                return 10;
            case GOLD:
                return 22;
            case NETHERITE:
                return 15;
            default:
                return -1;
        }
    }),
    PICKAXE(mat -> {
        switch (mat) {
            case WOOD:
                return 15;
            case STONE:
                return 5;
            case IRON:
                return 14;
            case DIAMOND:
                return 10;
            case GOLD:
                return 22;
            case NETHERITE:
                return 15;
            default:
                return -1;
        }
    }),
    SHOVEL(mat -> {
        switch (mat) {
            case WOOD:
                return 15;
            case STONE:
                return 5;
            case IRON:
                return 14;
            case DIAMOND:
                return 10;
            case GOLD:
                return 22;
            case NETHERITE:
                return 15;
            default:
                return -1;
        }
    }),
    HOE(mat -> { // hoe since 1.16
        switch (mat) {
            case WOOD:
                return 15;
            case STONE:
                return 5;
            case IRON:
                return 14;
            case DIAMOND:
                return 10;
            case GOLD:
                return 22;
            case NETHERITE:
                return 15;
            default:
                return -1;
        }
    }),
    BOW(mat -> {
        switch (mat) {
            case OTHER:
                return 1;
            default:
                return -1;
        }
    }),
    CROSSBOW(mat -> {
        switch (mat) {
            case OTHER:
                return 1;
            default:
                return -1;
        }
    }),
    FISHING_ROD(mat -> {
        switch (mat) {
            case OTHER:
                return 1;
            default:
                return -1;
        }
    }),
    TRIDENT(mat -> {
        switch (mat) {
            case OTHER:
                return 1;
            default:
                return -1;
        }
    }),
    HELMET(mat -> {
        switch (mat) {
            case LEATHER:
                return 15;
            case IRON:
                return 9;
            case CHAIN:
                return 12;
            case DIAMOND:
                return 10;
            case GOLD:
                return 25;
            case NETHERITE:
                return 15;
            case OTHER: // Turtle
                return 9;
            default:
                return -1;
        }
    }),
    CHESTPLATE(mat -> {
        switch (mat) {
            case LEATHER:
                return 15;
            case IRON:
                return 9;
            case CHAIN:
                return 12;
            case DIAMOND:
                return 10;
            case GOLD:
                return 25;
            case NETHERITE:
                return 15;
            default:
                return -1;
        }
    }),
    LEGGINGS(mat -> {
        switch (mat) {
            case LEATHER:
                return 15;
            case IRON:
                return 9;
            case CHAIN:
                return 12;
            case DIAMOND:
                return 10;
            case GOLD:
                return 25;
            case NETHERITE:
                return 15;
            default:
                return -1;
        }
    }),
    BOOTS(mat -> {
        switch (mat) {
            case LEATHER:
                return 15;
            case IRON:
                return 9;
            case CHAIN:
                return 12;
            case DIAMOND:
                return 10;
            case GOLD:
                return 25;
            case NETHERITE:
                return 15;
            default:
                return -1;
        }
    }),
    BOOK(mat -> {
        switch (mat) {
            case OTHER:
                return 1;
            default:
                return -1;
        }
    });
    // Hoe enchantable, but only with unbreaking. So I don't care

    static {
        EnumSet.allOf(ItemType.class).forEach(item -> ((ItemType) item).allowedEnchantments = EnumSet.copyOf(Enchantment.ENCHANTMENTS_GENERAL));
        // TODO: Move item-specific enchantments also to Enchantment.ENCHANTMENTS_XXX?
        SWORD.getAllowedEnchantments().addAll(Arrays.asList(Enchantment.SHARPNESS, Enchantment.BANE_OF_ATHROPODS, Enchantment.KNOCKBACK, Enchantment.SMITE, Enchantment.FIRE_ASPECT, Enchantment.LOOTING, Enchantment.SWEEPING_EDGE));
        AXE.getAllowedEnchantments().addAll(Enchantment.ENCHANTMENTS_TOOL);
        PICKAXE.getAllowedEnchantments().addAll(Enchantment.ENCHANTMENTS_TOOL);
        SHOVEL.getAllowedEnchantments().addAll(Enchantment.ENCHANTMENTS_TOOL);
        HOE.getAllowedEnchantments().addAll(Enchantment.ENCHANTMENTS_TOOL);
        BOW.getAllowedEnchantments().addAll(Arrays.asList(Enchantment.POWER, Enchantment.PUNCH, Enchantment.FLAME, Enchantment.INFINITY));
        CROSSBOW.getAllowedEnchantments().addAll(Arrays.asList(Enchantment.QUICK_CHARGE, Enchantment.MULTISHOT, Enchantment.PIERCING));
        FISHING_ROD.getAllowedEnchantments().add(Enchantment.LUCK_OF_THE_SEA);
        FISHING_ROD.getAllowedEnchantments().add(Enchantment.LURE);
        TRIDENT.getAllowedEnchantments().addAll(Arrays.asList(Enchantment.CHANNELING, Enchantment.IMPALING, Enchantment.LOYALTY, Enchantment.RIPTIDE));
        HELMET.getAllowedEnchantments().addAll(Enchantment.ENCHANTMENTS_ARMOR);
        HELMET.getAllowedEnchantments().add(Enchantment.AQUA_AFFINITY);
        HELMET.getAllowedEnchantments().add(Enchantment.RESPIRATION);
        CHESTPLATE.getAllowedEnchantments().addAll(Enchantment.ENCHANTMENTS_ARMOR);
        CHESTPLATE.getAllowedEnchantments().add(Enchantment.THORNS);
        LEGGINGS.getAllowedEnchantments().addAll(Enchantment.ENCHANTMENTS_ARMOR);
        BOOTS.getAllowedEnchantments().addAll(Enchantment.ENCHANTMENTS_ARMOR);
        BOOTS.getAllowedEnchantments().addAll(Arrays.asList(Enchantment.FEATHER_FALLING, Enchantment.DEPTH_STRIDER, Enchantment.FROST_WALKER));
        BOOK.getAllowedEnchantments().addAll(Enchantment.ENCHANTMENTS_ALL);
    }

    private EnumSet<Enchantment> allowedEnchantments;
    private final Function<Material, Integer> enchantabilityFunc;

    ItemType(Function<Material, Integer> enchantabilityFunc) {
        this.enchantabilityFunc = enchantabilityFunc;
    }

    ItemType() {
        this.enchantabilityFunc = mat -> {
            switch (mat) {
                case OTHER:
                    return 1;
                default:
                    return -1;
            }
        };
    }

    public int getEnchantability(Material material) {
        return enchantabilityFunc.apply(material);
    }

    public EnumSet<Enchantment> getAllowedEnchantments() {
        return this.allowedEnchantments;
    }
}
