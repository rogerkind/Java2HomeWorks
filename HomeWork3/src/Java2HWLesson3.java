import java.util.*;

/**
 * 1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
 * Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
 * Посчитать сколько раз встречается каждое слово.
 *
 * 2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
 * В этот телефонный справочник с помощью метода add() можно добавлять записи.
 * С помощью метода get() искать номер телефона по фамилии.
 * Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
 * тогда при запросе такой фамилии должны выводиться все телефоны.
 */

public class Java2HWLesson3{


    public static void main(String[] args){
        String[] words = {"brown","red","black","yellow","red","green","yellow","red","green","black","red","green",};
        System.out.println(countWords(words));
        PhoneBook phBook = new PhoneBook();
        phBook.add("Doe",8800200300l);
        phBook.add("Doe",8800200100l);
        phBook.add("Doe",8800200200l);
        phBook.add("Johnson",8500500300l);
        phBook.add("Donovan",8600100300l);
        phBook.add("Sullivan",8700200300l);
        phBook.add("Sullivan",8800800800l);


        phBook.get("Sullivan");
        phBook.get("Doe");
        phBook.get("Johnson");


    }

    static Map<String, Integer> countWords(String[] words){
        Map<String,Integer> count = new TreeMap<>();
        boolean founded=false;
        Set<Map.Entry<String, Integer>> set = count.entrySet();
        for(int i = 0;i<words.length;i++){
            for(Map.Entry<String, Integer> o : set){
                if(o.getKey()==words[i]){
                    o.setValue(o.getValue()+1);
                    founded=true;
                }
            }
            if(!founded) count.put(words[i],1);

            founded =false;
        }
        return count;
    }
}

class PhoneBook{
    private Map<Long,String> book = new HashMap<>();


    public void add(String lastname,long number){
      book.put(number,lastname);
    }

    public void get(String lastname){
        List<Long> numbers = new ArrayList<>();
        Set<Map.Entry<Long,String>> set = book.entrySet();
        for(Map.Entry<Long,String> o:set){
            if (o.getValue()==lastname) numbers.add(o.getKey());
        }
        System.out.println("Searh results for "+lastname+":");
        for (long l:numbers)
            System.out.println(l);
    }

}
