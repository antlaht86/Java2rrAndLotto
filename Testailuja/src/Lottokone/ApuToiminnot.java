package Lottokone;

import java.util.Arrays;

import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.TreeMap;
import static Lottokone.ApuToiminnot.riviLajittelija;
import static Lottokone.PaaToiminnot.arvontaKerrat;
import static Lottokone.PaaToiminnot.riviMaara;
import static Lottokone.PaaToiminnot.tilasto;

/*Tämä on jonkinlainen apuluokka*/
public class ApuToiminnot {

    static public TreeMap<Integer, String> riviLajittelija = new TreeMap<>();

    //Metodi lisää TreeMappii osumien perusteella esimerkkirivin. Huom, jos pelaat vain yhden Rivin ja esim 10000 arvontakertaa,
    //tulee joka voittoluokkaan sama rivi.
    static void lisaaja(int[][] omatRivit, int osumienMaara, int lisaNumero, int kuinkaMonesRivi) {

        if (osumienMaara >= 4) {
            String tmp = Arrays.toString(omatRivit[kuinkaMonesRivi]);
            if (lisaNumero == 1 && osumienMaara == 6) {
                riviLajittelija.putIfAbsent(7, tmp);
            }
            if (osumienMaara == 7 && lisaNumero == 0) {
                riviLajittelija.putIfAbsent(8, tmp);
            }
            if (osumienMaara <= 6 && lisaNumero == 0) {
                riviLajittelija.putIfAbsent(osumienMaara, tmp);
            }
        }
    }

    //tulostetaan osumat ja todennäköisyydet.
    public static void tulostaOsumatJaTodNak() {
        System.out.println("voittojen yhteenveto:\n");
        System.out.format("Yhteensä 7 oikein rivejä on: %d. Todennäköisyys tälle on %3f%%%n", tilasto[3][0],
                (double) tilasto[3][0] / (riviMaara * arvontaKerrat) * 100);
        System.out.format("Yhteensä 6+1 oikein rivejä on: %d. Todennäköisyys tälle on %3f%%%n", tilasto[4][0],
                (double) tilasto[4][0] / (riviMaara * arvontaKerrat) * 100);
        System.out.format("Yhteensä 6 oikein rivejä on: %d. Todennäköisyys tälle on %3f%%%n", tilasto[2][0],
                (double) tilasto[2][0] / (riviMaara * arvontaKerrat) * 100);
        System.out.format("Yhteensä 5 oikein rivejä on: %d. Todennäköisyys tälle on %3f%%%n", tilasto[1][0],
                (double) tilasto[1][0] / (riviMaara * arvontaKerrat) * 100);
        System.out.format("Yhteensä 4 oikein rivejä on: %d. Todennäköisyys tälle on %3f%%%n", tilasto[0][0],
                (double) tilasto[0][0] / (riviMaara * arvontaKerrat) * 100);
        System.out.format("%nYhteensä pelasit %d riviä%n%n", riviMaara * arvontaKerrat);

    }

    //Java-ohjelmointi kirjaa lukiessani, sain käsityksen, että tämä olisi hyvä sorttaaja lyhyille taulukoille.
    public static int[][] lisaysLajittelu(int[][] taulukko, int kuinkaMonesRivi) {

        int temp;
        for (int i = 1; i < taulukko[kuinkaMonesRivi].length; i++) {
            for (int j = i; j > 0; j--) {
                if (taulukko[kuinkaMonesRivi][j] < taulukko[kuinkaMonesRivi][j - 1]) {
                    temp = taulukko[kuinkaMonesRivi][j];
                    taulukko[kuinkaMonesRivi][j] = taulukko[kuinkaMonesRivi][j - 1];
                    taulukko[kuinkaMonesRivi][j - 1] = temp;
                }
            }
        }
        return taulukko;
    }
//Samaisessa kirjassa sanottiin, että tämä olisi nopea haku järjestetylle taulukolle.

    public static int binaariEtsinta(int taulukko[][], int etsittava, int kuinkaMonesRivi) {
        int eka = 0, viimeinen, keski;
        viimeinen = taulukko[kuinkaMonesRivi].length - 1;
        while (eka <= viimeinen) {
            keski = (eka + viimeinen) / 2;
            if (taulukko[kuinkaMonesRivi][keski] == etsittava) {
                return keski;
            } else if (taulukko[kuinkaMonesRivi][keski] < etsittava) {
                eka = keski + 1;
            } else {
                viimeinen = keski - 1;
            }
        }
        return -1;
    }
//Metodissa tulostetaan ensimmäiset voittot per voittoluokka. Eli kun ensimmäistä kertaa voittaa esim 4 oikein, se rivi tulostetaan.
    public static void tulostaRiviLajittelija() {

        
        NavigableMap<Integer, String> tmp = riviLajittelija.descendingMap();//Vaihdetaan rivien järjestystä.
        for (Entry<Integer, String> entry : tmp.entrySet()) {//Tulostetaan lista.
            Integer key = entry.getKey();
            String value = entry.getValue();
            if (key == 7) {
                System.out.println("Rivillä: " + value + " on 6+1 oikein.");
            } else if (key == 8) {
                System.out.println("Rivillä: " + value + " on 7 oikein.");
            } else {
                System.out.println("Rivillä: " + value + " on " + key + " oikein.");
            }
            
        }
        System.out.println("\n === Tervetuloa pelaamaan uudestaan! === ");

    }
}
