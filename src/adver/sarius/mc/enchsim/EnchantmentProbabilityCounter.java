package adver.sarius.mc.enchsim;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class EnchantmentProbabilityCounter {

    private final List<List<String>> enchantments = new ArrayList<>(MCEnchantmentSimulator.runs);

    public EnchantmentProbabilityCounter() {
    }

    public void addEnchantment(Enchantment enchantment, int level, int itemIndex) {
        if (itemIndex < enchantments.size()) {
            enchantments.get(itemIndex).add(enchantment + Enchantment.levelToString(level));
        } else if (itemIndex == enchantments.size()) {
            enchantments.add(new ArrayList<>());
            enchantments.get(itemIndex).add(enchantment + Enchantment.levelToString(level));
        } else {
            throw new RuntimeException("Index too big.");
        }
    }

    public void removeRandomSecondEnchantment() {
        enchantments.forEach(list -> {
            if (list.size() > 1) {
                list.remove(MCEnchantmentSimulator.RANDOM.nextInt(list.size()));
            }
        });
    }

    public Map<String, Integer> getEnchantmentCounter() {
        Map<String, Integer> result = new HashMap<>();
        // TODO: Collector?
        enchantments.forEach(list -> list.forEach(s -> result.merge(s, 1, (old, add) -> old + add)));
        return result;
    }

    public Map<String, Integer> getEnchantmentCombinationCounter() {
        Map<String, Integer> result = new HashMap<>();
        // TODO: Collector?
        enchantments.forEach(list -> result.merge(list.stream().sorted().collect(Collectors.joining("+")), 1, (old, add) -> old + add));
        return result;
    }

    public Map<String, Integer> getFirstEnchantmentCounter() {
        Map<String, Integer> result = new HashMap<>();
        // TODO: Collector?
        enchantments.forEach(list -> result.merge(list.get(0), 1, (old, add) -> old + add));
        return result;
    }

    public Map<String, Float> getSortedProbabilities(Map<String, Integer> enchantmentCounter) {
        Map<String, Float> result = new LinkedHashMap<>();
        enchantmentCounter.entrySet().stream().sorted((a, b) -> b.getValue() - a.getValue()).forEach(entry -> result.put(entry.getKey(), entry.getValue() / (float) enchantments.size() * 100)); // TODO: Collector?
        return result;
    }

    public Map<Integer, Float> getChanceForMultipleEnchantment() {
        Map<Integer, Integer> tmp = new HashMap<>();
        Map<Integer, Float> result = new TreeMap<>();

        enchantments.forEach(list -> tmp.merge(list.size(), 1, (old, add) -> old + add));
        tmp.forEach((a, b) -> result.put(a, b / (float) enchantments.size() * 100));
        return result;
    }
}
