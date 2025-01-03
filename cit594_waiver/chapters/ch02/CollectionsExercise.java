package cit594_waiver.chapters.ch02;

import java.util.*;

public class CollectionsExercise {

    public Collection<Integer> exerciseOne(int[] nums) {
        List<Integer> l = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            l.add(nums[i]);
        }
        return l;
    }

    public Object exerciseTwo(int[] nums) {
        Map<Integer, Integer> counts = new TreeMap<>();
        for (int num : nums) {
            if (counts.containsKey(num)) {
                counts.put(num, counts.get(num) + 1);
            } else {
                counts.put(num, 0);
            }
        }
        return counts;
    }

    public int[] exerciseThree(int[] nums) {
        Set<Integer> uniqueNums = new HashSet<>();
        for (int num : nums) {
            uniqueNums.add(num);
        }

        int i = 0;
        int[] uniqueNumsArray = new int[uniqueNums.size()];
        for (int uniqueNum : uniqueNums) {
            uniqueNumsArray[i] = uniqueNum;
            i++;
        }
        return uniqueNumsArray;
    }

    public Collection<String> exerciseFour(String[] names) {
        Set<String> nameSet = new TreeSet<>();
        for (String name : names) {
            nameSet.add(name);
        }
        return nameSet;
    }
}
