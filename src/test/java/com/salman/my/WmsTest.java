package com.salman.my;

import java.util.*;
import java.util.stream.Stream;


/**
 * git
 */
public class WmsTest {

    public static void main(String[] args) {
        // 示例订单列表和货物位置信息
        List<Integer> orders = new ArrayList<>();
        orders.add(1);
        orders.add(2);
        orders.add(3);
        orders.add(4);
        orders.add(5);
        orders.add(6);
        orders.add(7);
        orders.add(8);
        orders.add(9);

        Map<Integer, String> itemLocations = new HashMap<>();
        itemLocations.put(1, "A区");
        itemLocations.put(2, "B区");
        itemLocations.put(3, "A区");
        itemLocations.put(4, "C区");
        itemLocations.put(5, "B区");
        itemLocations.put(6, "A区");
        itemLocations.put(7, "C区");
        itemLocations.put(8, "B区");
        itemLocations.put(9, "C区");

        // 执行波次拣选算法
        List<List<Integer>> result = wavePicking(orders, itemLocations);
        System.out.println(result);
    }

    public static List<List<Integer>> wavePicking(List<Integer> orders, Map<Integer, String> itemLocations){
        List<List<Integer>> wave=new ArrayList<>();
        TreeMap<String,List<Integer>> treeMap=new TreeMap<String,List<Integer>>(new Comparator<String>() {
            @Override
            public int compare(String c1, String c2) {
                return c1.compareTo(c2);
            }
        });
        itemLocations.forEach((k,v)->{
            if(treeMap.containsKey(v)){
                treeMap.get(v).add(k);
            }else{
                List<Integer> ordersItem=new ArrayList<>();
                ordersItem.add(k);
                treeMap.put(v,ordersItem);
            }

        });
        treeMap.forEach((k,v)->wave.add(v));

        return wave;
    }
}
