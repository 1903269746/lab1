package OOP2;

public class Main2 {
    public void main2() {
        Input input = new Input();
        input.input("D:\\Code\\JavaProject\\SATest1\\txts\\input.txt");
        Shift shift = new Shift(input.getLineTxt());
        shift.shift();
        Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());
        alphabetizer.sort();
        Output output = new Output(alphabetizer.getKwicList());
        output.output("D:\\Code\\JavaProject\\SATest1\\txts\\output.txtt");

    }
}
