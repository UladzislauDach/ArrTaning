public class Example implements Comparable<Example> {
    int firstNumber;
    int secondNumber;

    public Example(int firstNumber, int secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    @Override
    public int compareTo(Example example){
     return this.firstNumber - example.firstNumber;
    }

    @Override
    public String toString() {
        return "Решите пример: " + firstNumber +
                " * " + secondNumber +
                " = ";
    }
}
