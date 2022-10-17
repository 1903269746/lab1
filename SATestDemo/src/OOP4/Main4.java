package OOP4;

import java.io.File;
import java.io.IOException;

public class Main4 {
    public  void main4() throws IOException {
        File inFile = new File("D:\\Code\\JavaProject\\SATest1\\txts\\input.txt");
        File outFile = new File("D:\\Code\\JavaProject\\SATest1\\txts\\output.txt");
        Pipe pipe1 = new Pipe();
        Pipe pipe2 = new Pipe();
        Pipe pipe3 = new Pipe();
        Input input = new Input(inFile, pipe1);
        Shift shift = new Shift(pipe1, pipe2);
        Alphabetizer alphabetizer  = new Alphabetizer(pipe2, pipe3);
        Output output = new Output(outFile,pipe3);
        input.transform();
        shift.transform();
        alphabetizer.transform();
        output.transform();

    }
}
