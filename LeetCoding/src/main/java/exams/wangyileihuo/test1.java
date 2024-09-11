package exams.wangyileihuo;

import java.util.*;

/**
 * @author wbq
 * @version 1.0
 * @title test1
 * @description
 * @create 2024/9/11 14:01
 */

public class test1 {
    public ArrayList<ArrayList<Long>> diff(ArrayList<Long> leftIds, ArrayList<String> leftValues, ArrayList<Long> rightIds, ArrayList<String> rightValues) {
        ArrayList<Long> add = new ArrayList<>(), update = new ArrayList<>();
        Map<Long, String> map = new HashMap<>();
        Set<Long> set = new HashSet<>();
        for (int i = 0; i < leftIds.size(); i++) {
            map.put(leftIds.get(i), leftValues.get(i));
            set.add(leftIds.get(i));
        }
        for (int i = 0; i < rightIds.size(); i++) {
            Long rightKey = rightIds.get(i);
            if (map.containsKey(rightKey)) {
                if (!map.get(rightKey).equals(rightValues.get(i))) {
                    update.add(rightKey);
                }
                set.remove(rightKey);
            } else {
                add.add(rightKey);
            }
        }
        ArrayList<Long> delete = new ArrayList<>(set);
        ArrayList<ArrayList<Long>> ans = new ArrayList<>();
        ans.add(add);
        ans.add(update);
        ans.add(delete);
        return ans;
    }
}
