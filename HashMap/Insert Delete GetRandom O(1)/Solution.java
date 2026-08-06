//380. Insert Delete GetRandom O(1)
import java.util.Random;
class RandomizedSet {

    Random hem;
    HashMap<Integer,Integer> map;
    ArrayList<Integer> list;

    public RandomizedSet() {
        
        hem = new Random();
        map = new HashMap<>();
        list = new ArrayList<>();

    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        list.add(val);
        map.put(val,list.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        int temp = list.get(list.size()-1);
        int idx = map.get(val);
        list.set(idx,temp);
        map.put(temp,idx);
        list.remove(list.size()-1);
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        
        return list.get(hem.nextInt(list.size()));
    }
}
