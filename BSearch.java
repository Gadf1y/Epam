public class BSearch {

        static int bsearch(int[] array, int num)
        {
            //Задаём левый и правый элементы, а также переменную для хранения позиции среднего элемента
            int left = 0;
            int right = array.length;
            int mid;

            //Проверяем, что левый элемент меньше правого (иначе продолжать нет смысла)
            while (left <= right)
            {
                mid = left + (right - left) / 2; //середина массива

                if (array[mid] == num) //нашли!
                    return mid;

                if (array[mid] > num)
                    right = mid-1;
                else
                    left = mid+1;
            }

            return -999; //В ТЗ не указано, что именно требуется вернуть в случае отсутствия элемента в массиве
                        //
        }

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,3,5,7,9,10,70,80,90};

        System.out.println("========");

        int res = bsearch(arr, 3);
        System.out.println(res);

    }


}
