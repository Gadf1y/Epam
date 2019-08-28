

//Самая сложная задача. По условиям, нельзя использовать библиотеки, поэтому для её решения пришлось сперва реализовать стек при помощи массива

class Stack {
    int maxSize;

    char[] stackArray;

    int top;

    public Stack(int max) {
        maxSize = max;
        stackArray = new char[maxSize];
        top = -1;
    }

    public void push(char j) {
        stackArray[++top] = j;
    }

    public char pop() {
        return stackArray[top--];
    }

    public boolean isEmpty() {
        return (top == -1);
    }
}



public class CheckBrackets {
    private String brackets;

    public CheckBrackets(String in) { //Конструктор
        brackets = in;
    }

    public boolean check(String brackets) {
        int sizeOfStack = brackets.length();
        Stack theStack = new Stack(sizeOfStack);
        boolean b = true;

        for (int j = 0; j < brackets.length(); j++)
        {
            char ch = brackets.charAt(j);
            switch (ch) {
                case '{': //Сравниваем с открывающими скобками
                case '[':
                case '(':
                    theStack.push(ch); // Если скобка открывающая, то заносим её в стек
                    break;

                case '}': // Сравниваем с закрывающими скобками
                case ']':
                case ')':
                    if (theStack.isEmpty()==false){ // Правильная скоб. последовательность не может начинаться с закрывающей скобки
                                                    // поэтому проверяем стек на наличие в нём элементов

                        char chx = theStack.pop(); // Если элементы есть, то извлекаем из стека верхний и проверяем
                        if ((ch == '}' && chx != '{') || (ch == ']' && chx != '[') //соответствует ли он закрывающей скобке ch
                                || (ch == ')' && chx != '('))
                            b = false;
                    } else
                        // если изначально пусто
                        b = false;
                    break;

            }
        }
        if (theStack.isEmpty()==false) { //если остались элементы
            b=false;
        }
return b;
    }

    public static void main(String[] args) {
        String input = "{()()())}"; //Проверяем строку
        CheckBrackets theChecker = new CheckBrackets(input);
        boolean b = theChecker.check(input); //В сучае правильной последовательности получаем true в случае неправильной false
        System.out.println(b);
    }

}





    