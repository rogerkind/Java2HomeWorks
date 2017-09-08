import java.util.*;

/**
 * 1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
 * Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
 * Посчитать сколько раз встречается каждое слово.
 * <p>
 * 2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
 * В этот телефонный справочник с помощью метода add() можно добавлять записи.
 * С помощью метода get() искать номер телефона по фамилии.
 * Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
 * тогда при запросе такой фамилии должны выводиться все телефоны.
 * @author Slava Bugakov
 * @version 0.0.2 dated 08 Sep 2017
 */

public class Java2HWLesson3{

    public static void main(String[] args){
        String[] words = {"brown", "red", "black", "yellow", "red", "green", "yellow", "red", "green", "black", "red", "green",};
        PhoneBook phBook = new PhoneBook();

        System.out.println(countWords(words));
        System.out.println();
        phBook.add("Doe", "8-800-200-300");
        phBook.add("Doe", "8-800-200-100");
        phBook.add("Doe", "8-800-200-200");
        phBook.add("Johnson", "8-500-500-300");
        phBook.add("Donovan", "8-600-100-300");
        phBook.add("Sullivan", "8-700-200-300");
        phBook.add("Sullivan", "8-800-800-800");

        phBook.get("Sullivan");
        phBook.get("Doe");
        phBook.get("Johnson");
        phBook.get("Petrov");

    }

    static Map<String, Integer> countWords(String[] words){
        Map<String, Integer> count = new TreeMap<>();
        boolean founded = false;
        Set<Map.Entry<String, Integer>> set = count.entrySet();
        for(int i = 0; i < words.length; i++){
            for(Map.Entry<String, Integer> o : set){
                if(o.getKey() == words[i]){
                    o.setValue(o.getValue() + 1);
                    founded = true;
                }
            }
            if(!founded) count.put(words[i], 1);
            founded = false;
        }
        return count;
    }
}

class PhoneBook{
    private Map<String, String> book = new HashMap<>();

    public void add(String lastname, String number){
        book.put(number, lastname);
    }

    public void get(String lastname){
        List<String> numbers = new ArrayList<>();

        Set<Map.Entry<String, String>> set = book.entrySet();
        for(Map.Entry<String, String> o : set)
            if(o.getValue() == lastname) numbers.add(o.getKey());

        if(numbers.size()<1){
            System.out.println("Phone book does not contain "+lastname);
            System.out.println();
        }
        else{
            System.out.println("Searh results for " + lastname + ":");
            for(String num : numbers)
                System.out.println(num);
            System.out.println();
        }
    }

}