import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    /*集合覆盖问题*/
    public static void main(String[] args) {
        HashSet<String> h1=new HashSet<>();
        h1.add("北京");
        h1.add("上海");
        h1.add("广州");
        h1.add("深圳");
        HashSet<String> h2=new HashSet<>();
        h2.add("苏州");
        h2.add("杭州");
        h2.add("上海");
        HashSet<String> h3=new HashSet<>();
        h3.add("广州");
        h3.add("深圳");
        h3.add("佛山");
        HashSet<String> h4=new HashSet<>();
        h4.add("苏州");
        h4.add("南京");
        HashSet<String> h5=new HashSet<>();
        h5.add("北京");
        h5.add("南京");
        HashMap<String,HashSet<String>> allCollection=new HashMap<>();
        allCollection.put("k1",h1);
        allCollection.put("k2",h2);
        allCollection.put("k3",h3);
        allCollection.put("k4",h4);
        allCollection.put("k5",h5);
        HashSet<String> city=new HashSet<>();
        ArrayList<String> listname=new ArrayList<>();
        for (HashSet<String> value : allCollection.values()) {
            city.addAll(value);
        }
        String aim=null;
        System.out.println(city);
        /*遍历集合*/
        while(!city.isEmpty()) {
 aim=null;
            /*寻找一个和剩余城市交集最大的集合*/
            for (String s : allCollection.keySet()) {
                HashSet<String> strings = allCollection.get(s);
                  /*取当前集合与剩余城市的交集*/
                strings.retainAll(city);
                if (aim==null||strings.size()>allCollection.get(aim).size()){
                    aim=s;
                }

            }
            /*将交集最多的城市从城市集合中减去*/
            city.removeAll(allCollection.get(aim));
            listname.add(aim);
            allCollection.remove(aim);
        }
        System.out.println(listname);

    }
}
