

public class DelTwinStr {
    static String delTwins(String str) {


        str = str.replaceAll("[^а-яА-Я a-zA-Z]", ""); //Удаление лишних знаков
        String[] substr = str.split(" "); //Разделение строки, разделитель - пробел
        int len = substr.length;     //Подсчёт общего количества слов

        int resLen = (int) len; //Заранее вычисляем длинну промежуточного массива

        for (int i = 0; i < len - 1; i++) { //Берём первый элемент массива

            boolean isTwin = false;  //Заводим внутренний переключатель

            if (substr[i] != null) {

                for (int j = i + 1; j < len; j++) { //Обходим последующие элементы

                    if (substr[i].equals(substr[j])) {

                        isTwin = true; //В случае равенства присваеваем значение true переключателю

                        substr[j] = null;  //И заменяем j на null и идём дальше
                        resLen--; //Размер промежуточного массива уменьшится


                    }

                }
            }
            if (isTwin == true) { //После завершения цикла смотрим на состояние переключателя

                substr[i] = null; //И в случае, если были обнаружены повторяющиеся элементы, помечаем i как null
                resLen--; //Размер промежуточного массива уменьшится

            }

        }

        String[] resArr = new String[resLen]; //Создаём промежуточный массив, куда попадут результаты без null
        int position = 0; //позиция элемента в массиве resArr

        //Переписываем элементы из массива substr в массив resArr, исключая элементы null
        for (int i = 0; i < len; i++) {
            if (substr[i] != null) {
                resArr[position] = substr[i];
                position++;
            }


        }
        //И преобразуем его в строку
        return String.join(" ", resArr);

    }

    public static void main(String[] args) {

        String s = "Wabba labba dub dub!";

        System.out.println(delTwins(s));


    }
}