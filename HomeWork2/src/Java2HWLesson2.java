/**
 * Class for running Home Work 2
 * 1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4,
 * при подаче массива другого размера необходимо бросить исключение ArrayIndexOutOfBoundsException.
 * <p>
 * 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
 * Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
 * должно быть брошено соответствующее исключение, с детализацией в какой именно ячейке лежат неверные данные.
 * <p>
 * 3. В методе main() вызвать полученный метод, обработать возможные исключения, и вывести результат расчета.
 * <p>
 * 4* Задание повышенной сложности: двухмерный массив необходимо прочитать из текстового файла, вместо стандартных
 * создать и использовать свои исключения (MyArraySizeException и MyArrayDataException).
 *
 * @author Slava Bugakov
 * @version 0.0.1 dated 01 Sept 2017
 */

public class Java2HWLesson2{

    public static void main(String[] args){
        String[][] arr = {{"1", "2", "3", "4"}, {"5", "3", "7", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15", "16", "5"}};
        System.out.println(arr.length);
        System.out.println(arr[0].length);
        try{
            System.out.println("Total of array is: " + Java2HWLesson2.totalArrayValues(arr));
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }catch(NumberFormatException e){
            System.out.println(e.getMessage());
        }
    }

    static int totalArrayValues(String[][] arr) throws ArrayIndexOutOfBoundsException, NumberFormatException{
        int total = 0;
        if(arr.length == 4){
            for(int i = 0; i < arr.length; i++)
                for(int j = 0; j < arr.length; j++){
                    if(arr[i].length == 4){
                        try{
                            total += Integer.parseInt(arr[i][j]);
                        }catch(NumberFormatException e){
                            throw new NumberFormatException("Is not a number in cell[" + i + "," + j + "]");
                        }
                    }else throw new ArrayIndexOutOfBoundsException("Array should be 4x4");

                }

        }else throw new ArrayIndexOutOfBoundsException("Array should be 4x4");

        return total;
    }

}
