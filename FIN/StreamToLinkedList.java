import interfaces.CustomLinkedList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamToLinkedList {

    public static <T> CustomLinkedList<T> fromStream(Stream<T> stream) {
        CustomLinkedList<T> list = new CustomLinkedList<>();
        stream.reduce((first, second) -> {
            list.add(first);
            return second;
        });
        return list;
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);
        CustomLinkedList<Integer> list = fromStream(numbers.stream());
        list.printList();
    }
}
