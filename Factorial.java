public class Factorial

{
    //Размер int слишком легко превысить, поэтому выбрал long
    public static long factorial(int n)
    {
        //Можно также добавить проверку на знак,
        //но в ТЗ не оговорено, как должна вести себя функция в случае отрицательного значения n, поэтому возвращаю 1
        if (n <= 1)
            return 1;

        else
            return n * factorial(--n);
    }

    //Проверка
    public static void main(String[] args)
    {
        System.out.println(factorial(8));
    }

}