package adver.sarius.mc.enchsim;

import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * According to https://minecraft.gamepedia.com/Enchanting/Mechanics
 * 
 * @since March 2019, MC 1.13.2
 * @author Adversarius
 */
public class MCEnchantmentSimulator {

    public static final Random RANDOM = new Random();
    public static int runs = 5000000;
    // http://minecraft.tools/en/enchant.php --> similar values
    // https://www.vaelox.com/enchants/ --> only computes first enchantment? Still mostly different values

    private static int iteration;
    private static EnchantmentProbabilityCounter counter = new EnchantmentProbabilityCounter();

    // TODO: best level to get enchantment X
    public static void main(String[] args) {
        /////////////// input parameters:
        int bookshelfs = 15;
        Material material = Material.OTHER;
        ItemType item = ItemType.BOOK;
        int enchantmentTableSlot = 3;
        // optional, will override the slot config if >0
        // Enchantment Table 30. Fishing 30. Loot Chests 39. Villager Equipment 19. Villager Books uniformly random
        int fixedLevelCost = 0; 
        boolean allowTreasure = false;
        ///////////////
        for (iteration = 0; iteration < runs; iteration++) {
            int enchantmentLevel;

            if (fixedLevelCost > 0) {
                enchantmentLevel = fixedLevelCost;
            } else {
                int baseEnchantmentLevel = RANDOM.nextInt(8) + 1 + bookshelfs / 2 + RANDOM.nextInt(bookshelfs + 1);
                switch (enchantmentTableSlot) {
                    case 1:
                        enchantmentLevel = Math.max(baseEnchantmentLevel / 3, 1);
                        break;
                    case 2:
                        enchantmentLevel = (2 * baseEnchantmentLevel) / 3 + 1;
                        break;
                    case 3:
                        enchantmentLevel = Math.max(baseEnchantmentLevel, bookshelfs * 2);
                        break;
                    default:
                        throw new RuntimeException("Invalid slot used!");
                }
            }

            int enchantability = item.getEnchantability(material);
            if (enchantability < 0) {
                throw new RuntimeException("Invalid material used!");
            }
            int modifiedEnchantmentLevel = enchantmentLevel + 1 + RANDOM.nextInt(enchantability / 4 + 1) + RANDOM.nextInt(enchantability / 4 + 1);

            float bonus = 1 + (RANDOM.nextFloat() + RANDOM.nextFloat() - 1) * 0.15f;
            int finalEnchantmentLevel = Math.max(Math.round(modifiedEnchantmentLevel * bonus), 1);

            Set<Enchantment> matchingEnchantments = item.getAllowedEnchantments().stream()
                    .filter(ench -> ench.getHighestPower(finalEnchantmentLevel) > 0)
                    .filter(ench -> !ench.isTreasure() || allowTreasure)
                    .collect(Collectors.toSet());
            applyEnchantments(matchingEnchantments, finalEnchantmentLevel, finalEnchantmentLevel, 1);
        }
        System.out.println("Simulation for " + material + " " + item + " complete!");
        if (material == Material.OTHER && item == ItemType.BOOK) {
            counter.removeRandomSecondEnchantment();
            System.out.println("Removed Second Enchantments");
        }
        System.out.println(//"Probabilities for specific enchantments:" +
                counter.getSortedProbabilities(counter.getEnchantmentCounter()));
        System.out.println(//"Probabilities for enchantment combinations:"+
                counter.getSortedProbabilities(counter.getEnchantmentCombinationCounter()));
        System.out.println(//"Probabilities for the first applied enchantment:"+
                counter.getSortedProbabilities(counter.getFirstEnchantmentCounter()));
        System.out.println(//"Probabilities for multiple enchantments:"+
                counter.getChanceForMultipleEnchantment());
    }

    private static void applyEnchantments(Set<Enchantment> matchingEnchantments, int repeatingLevel, int finalEnchantmentLevel, int round) {
        if (matchingEnchantments.isEmpty()) {
            return;
        }
        int totalWeight = matchingEnchantments.stream().collect(Collectors.summingInt(Enchantment::getWeight));
        int pickAtWeight = RANDOM.nextInt(totalWeight);
        Enchantment pickedEnchantment = null;
        int pickedLevel;
        for (Enchantment ench : matchingEnchantments) {
            pickAtWeight -= ench.getWeight();
            if (pickAtWeight < 0) {
                pickedEnchantment = ench;
                pickedLevel = pickedEnchantment.getHighestPower(finalEnchantmentLevel);
                counter.addEnchantment(pickedEnchantment, pickedLevel, iteration);
                break;
            }
        }
        if (RANDOM.nextDouble() < (repeatingLevel + 1) / 50.) {
            matchingEnchantments.removeAll(pickedEnchantment.getConflicts());
            applyEnchantments(matchingEnchantments, repeatingLevel / 2, finalEnchantmentLevel, round + 1);
        }
    }
}
