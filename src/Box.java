import java.util.ArrayList;

public class Box <T extends Fruit>{
    private ArrayList<T> list;

    Box(){
        list = new ArrayList<>();
    }

    public void add(T obj){
        list.add(obj);
    }

    public float getWeight(){
        float total = 0.0f;
        for(int i = 0; i < list.size(); i++){
            total += list.get(i).getWeight();
        }
        return total;
    }

    public boolean compare(Box<? extends Fruit> box){
        return (Math.abs(this.getWeight() - box.getWeight()) < 0.00001f);
    }

    public void move(Box<T> box){
        if(this.list.size()>0){
            T fruit  = this.list.get(0);
            this.list.remove(0);
            box.add(fruit);
        }
    }

}
