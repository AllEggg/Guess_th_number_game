package maven.cource.project;

import java.util.Random;

public class Nigma {

    private int nigma;
    private int counter;

    public int getNigma() {
        if (counter == 0) {
            nigma = new Random().nextInt(1000);
            counter++;
        }
        return nigma;
    }


}
