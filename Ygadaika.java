import java.util.Scanner;

public class Ygadaika {
    public static void main(String[] args) {
        String da = "Да";
        Scanner in = new Scanner(System.in);
        System.out.println("Ваше число четное?");
        String Vopros1 = in.next();
        System.out.println("Понял.");

        if (da.contains(Vopros1)) {
            System.out.println("А на 4 делится?");
            String Vopros2 = in.next();
            System.out.println("Принял.");
            if (da.contains(Vopros2)){
                System.out.println("Ваше число является ответом на выражение 4 умножить на 2?");
                String Vopros3 = in.next();
                System.out.println("Я догадался :).");
                if (da.contains(Vopros3))
                    System.out.println("Вы загадали число... Барабанная дробь... ВОСЕМЬ");
                else
                    System.out.println("Это было просто. Ваше число ЧЕТЫРЕ");
            }
            else {
                System.out.println("Ваше число простое?");
                String Vopros4 = in.next();
                System.out.println("Я почти у цели!");
                if (da.contains(Vopros4))
                    System.out.println("Вы загадали число ДВА! Я опять выиграл.");
                else {
                    System.out.println("Тогда ваше число делится на 3. Да?");
                    String Vopros5 = in.next();
                    System.out.println("Ха-ха.");
                    if (da.contains(Vopros5))
                        System.out.println("Это было не просто... Но я знаю ответ) Вы загадали число ШЕСТЬ");
                    else
                        System.out.println("Помучили вы меня, это число ДЕСЯТЬ");
                }

            }

        }// нечетные 1 3
        else{
            System.out.println("Если умножить ваше число на два, то полученное число будет больше или равно десяти?");
            String Vopros6 = in.next();
            System.out.println("Обработал.");
            if (da.contains(Vopros6)){
                System.out.println("Ваше число составное?");
                String Vopros7 = in.next();
                System.out.println("Окей...");
                if (da.contains(Vopros7))
                    System.out.println("Ха.. опять я выиграл, ваше число... ДЕВЯТЬ!");
                else {
                    System.out.println("Если умножить ваше число на два получится четырнадцать?");
                    String Vopros8 = in.next();
                    System.out.println("Так... ну посмотрим.");
                    if (da.contains(Vopros8))
                        System.out.println("Хех, проще простого. Ответ СЕМЬ");
                    else
                        System.out.println("Ну это легкотня. Ваше число ПЯТЬ");
                }
            }
            else{
                System.out.println("Если умножить ваше число само на себя то ответ будет число один?");
                String Vopros9 = in.next();
                System.out.println("Усвоил.");
                if (da.contains(Vopros9))
                    System.out.println("Эх... опять я выиграл. Ответ ОДИН.");
                else
                    System.out.println("И опять ты проиграл. Ответ ТРИ.");
            }
        }
    }
}
