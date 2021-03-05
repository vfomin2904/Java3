import javax.crypto.spec.OAEPParameterSpec;
import java.util.ArrayList;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        String[] arr = {"1", "2", "3"};
        String[] arr1 = swap(arr, 0, 2);

        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);
        }

        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();

        Box<Apple> appleBox = new Box<>();
        appleBox.add(apple1);
        appleBox.add(apple2);


        Box<Orange> orangeBox = new Box<>();
        orangeBox.add(orange1);
        orangeBox.add(orange2);

        Box<Apple> appleBox2 = new Box<>();
        appleBox2.add(apple1);
        appleBox2.add(apple2);

        appleBox.move(appleBox2);

    }

    public static <T> T[] swap(T[] arr, int i, int j){
        T buffer = arr[i];
        arr[i] = arr[j];
        arr[j] = buffer;
        return arr;
    }

    public static <T> ArrayList<T> toArrayList(T[] arr){
        return new ArrayList<>(Arrays.asList(arr));
    }
}
