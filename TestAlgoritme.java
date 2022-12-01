import java.util.Random;

public class TestAlgoritme implements LuciferAlgoritme{

    @Override
    public int doeZet(int aantal) {
        Random rand = new Random();
        return rand.nextInt(3) + 1;
    }
}
