import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class mayi {
    public static void main(String[] args) throws FileNotFoundException {
        Integer[] arr1 = {3,2,5,8,71,3,69,5,4,9,82,5,55,96,485,357};
        Integer[] arr2 = {3,2,5,8,71,3,69,5,4,9,82,5,55,96,485,357};
        Integer[] arr3 = {3,2,5,8,71,3,69,5,4,9,82,5,55,96,485,357};
        Integer[] arr4 = {3,2,5,8,71,3,69,5,4,9,82,5,55,96,485};
        Integer[] arr5 = {3,2,5,8,71,3,69,5,4,9,82,5,55,96,485,357};
        List<Integer> nums1 = new LinkedList<>();
        nums1.addAll(top(Arrays.asList(arr1),5));
        nums1.addAll(top(Arrays.asList(arr2),5));
        nums1.addAll(top(Arrays.asList(arr3),5));
        nums1.addAll(top(Arrays.asList(arr4),5));
        nums1.addAll(top(Arrays.asList(arr5),5));
        System.out.println(top(nums1,5));


    }
    public static <T extends Comparable<T>> List<T> top(List<T> list, int top){
        if (list == null){
            throw new RuntimeException("list is null!");
        }
        PriorityQueue<T> queue = new PriorityQueue<>(top);
        list.forEach(t -> {
            if (queue.size() < top){
                queue.add(t);
            }else if (queue.peek().compareTo(t) < 0){
                queue.poll();
                queue.add(t);
            }
        });
        LinkedList<T> arr = new LinkedList<>();
        while (!queue.isEmpty()){
            arr.addFirst(queue.poll());
        }
        return arr;
    }
}
