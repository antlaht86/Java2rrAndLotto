package KaksiRR;

import java.util.Scanner;

public class OtteluOhjelma {

    public static void main(String[] args) {

        aloittaja();

    }

    private static void aloittaja() {

        int apu = 1;

        Scanner sc = new Scanner(System.in);
        System.out.print("Tervetuloa otteluluohjeman luojaan.\n\n"
                          + "Joukkueiden maara: ");
        int pelit = sc.nextInt();

        System.out.println("\n");

        Toimintaluokka toiminta = new Toimintaluokka(pelit);
        
        if(pelit==1){System.out.println("Tarvitaan vähintään kaksi joukkuetta");}
        
        if (pelit == 2) {
            System.out.println("#1 KIERROS\nJoukkue 1 vs Joukkue 2\n\n"
                                + toiminta.toistettavaYhtMerkki + "\n\n"
                                + "#2 KIERROS\nJoukkue 2 vs Joukkue 1\n");
        }
        if (pelit > 2) {

            toiminta.JoukkueidenLuoja();

            if (pelit % 2 == 1) {
                apu--;
            }
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < pelit - apu; j++) {
                    toiminta.OtteluidenTulostaja();
                    toiminta.otteluParienVaihtaja();
                }
                toiminta.parittomanLaskuri++;
            }
        }
    }
}
