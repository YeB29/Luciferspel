import java.util.Scanner;

public class LuciferSpel {
    private final int start;
    private int aantal;
    private final LuciferAlgoritme algoritme;

    public LuciferSpel(int aantal, LuciferAlgoritme algoritme) {
        this.start = aantal;
        this.aantal = start;
        this.algoritme = algoritme;
    }

    private boolean afgelopen(){
        return aantal <= 0;
    }

    private void doeSpelerZet(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hoeveel lucifers wil je pakken?");
        int pakken = scanner.nextInt();
        pakken = Math.min(3,Math.max(1,pakken));
        aantal -= pakken;
        System.out.printf("De speler pakt %d lucifers%n", pakken);
    }

    public void doeComputerZet(){
        int pakken = algoritme.doeZet(aantal);
        aantal -=pakken;
        System.out.printf("De computer pakt %d lucifers%n", pakken);
    }

    public void startSpel(boolean spelerBegint) {
        boolean spelerAanBeurt = spelerBegint;
        while (!afgelopen()) {
            System.out.printf("Er liggen nog %d lucifers%n", aantal);
            if (spelerAanBeurt) {
                doeSpelerZet();

            }
            else {
                doeComputerZet();
            }
            spelerAanBeurt = !spelerAanBeurt;
        }
        if (spelerAanBeurt){
            System.out.println("Speler heeft gewonnen");
        }
        else{
            System.out.println("Computer heeft gewonnen");
        }
    }
}
