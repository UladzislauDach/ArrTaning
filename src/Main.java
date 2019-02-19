import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //Для проверки остаточных знаний учеников после летних каникул, учитель младших классов решил начинать
        // каждый урок с того, чтобы задавать каждому ученику пример из таблицы умножения, но в классе 15 человек,
        // а примеры среди них не должны повторяться. В помощь учителю напишите программу, которая будет выводить
        // на экран 15 случайных примеров из таблицы умножения (от 2*2 до 9*9, потому что задания по умножению
        // на 1 и на 10 — слишком просты). При этом среди 15 примеров не должно быть повторяющихся
        // (примеры 2*3 и 3*2 и им подобные пары считать повторяющимися).

        Random generator = new Random();
        int[][] example = new int[2][4];

        for (int i = 0, j = 2; i < example[0].length; i++, j += 2) {
            example[0][i] = j;
        }

        for (int i = 0, j = 3; i < example[0].length; i++, j += 2) {
            example[1][i] = j;
        }

        ArrayList<Example> examples = new ArrayList<>();
        int i = 0;

        loops:
        while (i < 15) {
            int first = example[0][generator.nextInt(4)];
            int second = example[1][generator.nextInt(4)];
            for (Example ex : examples) {
                if (ex.firstNumber * ex.secondNumber == first * second) {
                    continue loops;
                }
            }
            examples.add(new Example(first, second));
            i++;
        }


        examples.sort(Example::compareTo);

        for (Example ex : examples) {
            System.out.println(ex.toString());
        }
    }
}
