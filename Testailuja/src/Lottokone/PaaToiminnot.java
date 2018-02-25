package Lottokone;

/*Tänne on koodattu lottokoneen päätoiminnot*/
import java.util.Random;

public class PaaToiminnot {

    static protected int riviMaara;
    static protected int arvontaKerrat;
    static protected int[][] tilasto = new int[5][1];//tilasto on voittojen tallentamista varten.
    private static final Random rng = new Random();

    public PaaToiminnot(int riviMaara, int arvontaKerrat) {
        PaaToiminnot.riviMaara = riviMaara;
        PaaToiminnot.arvontaKerrat = arvontaKerrat;

    }

    public void arvontaKone() {
        int[][] arvotutRivit;
        int[][] omatRivit = lottonumeroidenArpoja(7, riviMaara, 1);// Kutsutaan metodia ja saadaan takaisin lottorivi sortattuna.
        int temp, osumienMaara = 0, lisaNumero = 0;                // parametreina rivin koko, pelattavien rivien määrä ja jos 1 niin sortataan.

        for (int k = 0; k < arvontaKerrat; k++) { //Arvontakertojen loop.
            arvotutRivit = lottonumeroidenArpoja(8, 1, 0); // Kutsutaan metodia ja saadaan takaisin lottorivi ilman sorttausta. 8 siksi, että saadaan lisänumero.

            for (int j = 0; j < riviMaara; j++) {// Rivimäärän looppi.
                for (int i = 0; i < 8; i++) { //Tämä loop on rivien tarkastusta varten.

                    temp = ApuToiminnot.binaariEtsinta(omatRivit, arvotutRivit[0][i], j);//kutsutaan metodia, parametreinä omatrivit(sortattu),arvotunrivin i indeksi ja
                                                                                         // j siksi, että pysyy matriisissa oikealla rivillä.
                    if (temp != -1) {//BinaariEtsintä palautti jotain muuta kuin -1, niin saadaan tieto osumasta.
                        if (i == 7 && osumienMaara == 6) {//Etsitään osuuko lisänumero ja onko kuusi oikein.
                            lisaNumero++;
                            tilasto[4][0] += 1;//laitetaan suoraan tilastoon.
                            ApuToiminnot.lisaaja(omatRivit, osumienMaara, lisaNumero, j);//Lisätään rivi lajittelijaan.
                        }
                        if (6 >= i) {//estetään lisänumeron laskeminen varsinaiseksi osumaksi.
                            osumienMaara++;
                        }
                    }
                }
                if (osumienMaara >= 4 && lisaNumero == 0) {
                    tilasto[osumienMaara - 4][0] += 1;// laitetaan osumien määrä tilastoon. 4 oikein saa indeksin 0.
                    ApuToiminnot.lisaaja(omatRivit, osumienMaara, lisaNumero, j);
                }
                osumienMaara = 0;//nollataan uuden ennen uuden kierroksen alkua.
                lisaNumero = 0;
            }
        }
    }

    //Lottonumerot arvotaan täällä.
    public static int[][] lottonumeroidenArpoja(int numerojenMaara, int rivienMaara, int sorttaa) {

        int[][] rivi = new int[rivienMaara][numerojenMaara];
        int[][] sortattuRivi = new int[rivienMaara][numerojenMaara];
        boolean apu = true;
        int temp;

        for (int j = 0; j < rivienMaara; j++) {//rivien määrän looppi.
            for (int i = 0; i < numerojenMaara; i++) {

                temp = rng.nextInt(40) + 1;// haetaan randomisti numero 1-40.

                for (int k = -1; k < i; k++) {// lähtee -1 siksi, että ollaan i:tä jäljessä. Ei pyöritetä looppia turhaan.

                    if (temp == rivi[j][k + 1]) {
                        apu = false;
                        i--;//Jos duplikaatti löytyy, miinustetaan i:stä yksi, jotta saadaan täysirivi.
                        break;//katkastaan loop heti kun duplikaatti löytyy.
                    }
                }
                if (apu) {// jos duplikaattia ei löytynyt, laitetaan rivi eteenpäin.
                    rivi[j][i] = temp;
                }
                apu = true;
            }
            if (sorttaa == 1) {//Sortataan pelatut omat rivit.
                sortattuRivi = ApuToiminnot.lisaysLajittelu(rivi, j);//Saadaan sortattu rivi takaisin.
            }
        }
        if (sorttaa == 1) {//jos sortattu palautetaan sortatturivi.
            return sortattuRivi;
        } else {
            return rivi;//jos ei sortattu, palautetaan sorttaamaton rivi.
        }
    }
}
