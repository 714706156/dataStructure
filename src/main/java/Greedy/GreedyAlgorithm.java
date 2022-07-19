package Greedy;

import java.util.*;

/**
 * @Author: yangkai
 * @Date: 2022/7/18 11:35
 */
public class GreedyAlgorithm {
    public static void main(String[] args) {
        HashMap<String, HashSet<String>> broadcasts = new HashMap<>();
        HashSet<String> hashSet1 = new HashSet<String>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");
        HashSet<String> hashSet2 = new HashSet<String>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");
        HashSet<String> hashSet3 = new HashSet<String>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");
        HashSet<String> hashSet4 = new HashSet<String>();
        hashSet4.add("上海");
        hashSet4.add("天津");
        HashSet<String> hashSet5 = new HashSet<String>();
        hashSet5.add("杭州");
        hashSet5.add("大连");
        broadcasts.put("k1",hashSet1);
        broadcasts.put("k2",hashSet2);
        broadcasts.put("k3",hashSet3);
        broadcasts.put("k4",hashSet4);
        broadcasts.put("k5",hashSet5);
        HashSet<String> all = new HashSet<String>();
        all.add("北京");all.add("上海");all.add("天津");all.add("广州");
        all.add("深圳");all.add("成都");all.add("杭州");all.add("大连");
        //存放选择的电台
        ArrayList<String> selects = new ArrayList<>();
        //存放遍历过程中遍历电台覆盖城市与还未覆盖城市的交集
        HashSet<String> tempSet = new HashSet<>();
        //maxKey是一次遍历包含最多未覆盖城市对应的电台,如果不为Null则会加入到selects中
        String maxKey=null;
        int maxLen=0;
        while (all.size()!=0){
            maxKey=null;
            maxLen=0;
            //遍历电台map
            for(String key:broadcasts.keySet()){
                tempSet.clear();
                HashSet<String> areas=broadcasts.get(key);
                tempSet.addAll(areas);
                //取两者的交集并赋给tempSet
                tempSet.retainAll(all);
                if(tempSet.size()>0 && (maxKey==null || tempSet.size()>maxLen)){
                    maxKey=key;
                    maxLen=tempSet.size();
                }

            }
            if(maxKey!=null){
                selects.add(maxKey);
                all.removeAll(broadcasts.get(maxKey));
            }

        }
        System.out.println(selects);
    }
}
