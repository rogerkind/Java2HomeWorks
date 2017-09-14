import java.util.Arrays;

/**
 * 1. Необходимо написать два метода, которые делают следующее:
 * 1) Создают одномерный длинный массив, например:
 * static final int size = 10000000;
 * static final int h = size / 2;
 * float[] arr = new float[size];
 * 2) Заполняют этот массив единицами;
 * 3) Засекают время выполнения: long a = System.currentTimeMillis();
 * 4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
 * arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
 * 5) Проверяется время окончания метода System.currentTimeMillis();
 * 6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a);
 * <p>
 * Отличие первого метода от второго:
 * -Первый просто бежит по массиву и вычисляет значения.
 * -Второй разбивает массив на два массива, в двух потоках высчитывает новые значения
 * и потом склеивает эти массивы обратно в один.
 * <p>
 * По замерам времени:
 * Для первого метода надо считать время только на цикл расчета:
 * for (int i = 0; i < size; i++) {
 * arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
 * }
 * Для второго метода замеряете время разбивки массива на 2, просчета каждого из двух массивов и склейки.
 * <p>
 * PS: Усложнил класс для проверки влияния количества паралельных потоков вычисления на быстроту вычисления.
 *
 * @author Slava Bugakov
 * @version 0.0.2 dated 14 Sep 2017
 */

public class Java2HWLesson5{
    static final int SIZE = 10000000;
    static final int SPLIT = 2;

    public static void main(String[] args){
        System.out.println("Run with initial task params:");
        ArrayComputingCompare acc = new ArrayComputingCompare(SIZE, SPLIT);
        acc.runDirect();
        acc.runSplitAndTreads();
        System.out.println();
        System.out.println("Run with more parts division:");
        acc = new ArrayComputingCompare(SIZE, 3);
        acc.runDirect();
        acc.runSplitAndTreads();
        System.out.println();
    }
}

class ArrayComputingCompare implements Runnable{
    private int split;
    private int split_size;
    private int last_split_size;
    private float[] arr;
    private float[][] sparr;
    private Thread[] sptreads;

    ArrayComputingCompare(int size, int split){
        if(split > 1 && split <= size){
            this.split = split;
            split_size = size / split;
            last_split_size = split_size + (size % split);
            arr = new float[size];
            sparr = new float[split][];
            for(int i = 0; i < split; i++){
                if(i == (split - 1)) sparr[i] = new float[last_split_size];
                else sparr[i] = new float[split_size];
            }
        }else{
            throw new ArrayIndexOutOfBoundsException("split should be more then 1 and less or equal size");
        }
    }

    private void splitArray(){
        long a = System.currentTimeMillis();
        for(int i = 0; i < split; i++){
            if(i == (split - 1)) System.arraycopy(arr, i * split_size, sparr[i], 0, last_split_size);
            else System.arraycopy(arr, i * split_size, sparr[i], 0, split_size);
        }
        System.out.println("Split array took: " + (System.currentTimeMillis() - a) + " ms");
    }

    private void mergeArray(){
        long a = System.currentTimeMillis();
        for(int i = 0; i < split; i++){
            if(i == (split - 1)) System.arraycopy(sparr[i], 0, arr, i * split_size, last_split_size);
            else System.arraycopy(sparr[i], 0, arr, i * split_size, split_size);
        }
        System.out.println("Merge array took: " + (System.currentTimeMillis() - a) + " ms");
    }

    private void startTreads(){
        sptreads = new Thread[split];
        for(int i = 0; i < sptreads.length; i++){
            sptreads[i] = new Thread(this, Integer.toString(i));
            sptreads[i].start();
        }
    }

    private void killTreads(){
        for(int i = 0; i < sptreads.length; i++){
            try{
                sptreads[i].join();
            }catch(InterruptedException e){
            }
        }
    }

    public void runDirect(){
        Arrays.fill(arr, 1.0f);
        long a = System.currentTimeMillis();
        for(int i = 0; i < arr.length; i++)
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        System.out.println("Direct run for array size (" + arr.length + ") took: "
                + (System.currentTimeMillis() - a) + " ms");
    }

    public void runSplitAndTreads(){
        Arrays.fill(arr, 1.0f);
        long a = System.currentTimeMillis();
        splitArray();
        startTreads();
        killTreads();
        mergeArray();
        System.out.println("Run for array size (" + (arr.length) + ") divided by " + split + " total took: "
                + (System.currentTimeMillis() - a) + " ms");
    }

    @Override
    public void run(){
        long a = System.currentTimeMillis();
        int arrnum = Integer.parseInt(Thread.currentThread().getName());

        for(int i = 0; i < sparr[arrnum].length; i++)
            sparr[arrnum][i] = (float) (sparr[arrnum][i] * Math.sin(0.2f + (i + (arrnum * split_size)) / 5)
                    * Math.cos(0.2f + (i + (arrnum * split_size)) / 5)
                    * Math.cos(0.4f + (i + (arrnum * split_size)) / 2));

        System.out.println("Run for " + (arrnum + 1) + " part of array size (" + (sparr[arrnum].length)
                + ") took: " + (System.currentTimeMillis() - a) + " ms");
    }

}

