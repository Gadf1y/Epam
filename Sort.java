import java.util.Arrays;

public class Sort {

    private static int array[];

    public static void sort(int[] arr) {

        if (arr == null || arr.length == 0) { //Проверка количества элементов массива
            return;
        }
        array = arr;
        quickSort(0, array.length-1);
    }


            //Тут мы определим крайние элементы
    private static void quickSort(int left, int right) {

        int i = left;
        int j = right;
        // и найдём середину массива
        int mid = array[left+(right-left)/2];

        //На каждой итерации мы будем продвигаться влево до тех пор, пока не найдем элемент больше чем mid

        while (i <= j) {

            while (array[i] < mid) { i++; } while (array[j] > mid) {
                j--;         // Двигаемся вправо, пока не найдем элемент меньше, чем mid
            }
            if (i <= j) {
                exchange(i, j);
                //Сдвинуть указатели
                i++;
                j--;
            }
        }
        // рекурсивно вызываем метод быстрой сортировки
        if (left < j)
            quickSort(left, j);
        if (i < right)
            quickSort(i, right);
    }

    private static void exchange(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    //Проверка
    public static void main(String[] args) {
        int[] x = { -1, 11, 4, 7, 3, 5, 10, 12, 0 };

        System.out.println(Arrays.toString(x));
        sort(x);
        System.out.println(Arrays.toString(x));
    }
}