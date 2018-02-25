package Lottokone;

import java.util.Scanner;

/*Tämä ohjelma on tehty veikkauksen lottokonetta mukaillen. Sillä erotuksella, että tässä huomioidaan
vain 4,5,6,6+1 ja 7 oikein tulokset. Ohjelmalla on tarkoitus pelata suuria määriä rivejä/arvontakertoja 
jotta saadaan voitoille suhteellisen luotettavat todennäköisyyden laskettua. Testattu miljardilla kerralla. 
Käyttäjältä kysytään rivimäärät ja arvontakerrat. Rivit arvotaan ja tarkastetaan duplikaattien varalta. 
Ohjelma antaa pelata samalle ”lapulle” samoja rivejä. Vain omat rivit sortataan, koska loton tarkastuksessa
käytetään binaarihakua, jossa rivin täytyy olla järjestyksessä. Sorttauksessa käytetään lisäyslajittelua,
koska se on nopeampi pienillä elementti määrillä. Kun arvottuja rivejä ja pelattuja rivejä on verrattu, tulostetaan
niiden määrä taulukosta, ilmoitetaan käyttäjälle ja lasketaan todennäköisyydet. lopuksi myös näytetään käyttäjälle voittorivit, 
esimmäiset sellaiset per voittoluokka.

P.s Ohjelma olisi "mukavampi" käyttäjälle jos saisi seurata livearvontaa. Mutta koneestani loppui muisti ja elämästäni aika
miljardilla rivillä.
P.s.s Ohjelmaa on yritetty myös kommentoida muuttujien, metodien ja parametrien nimillä. Kommentointi on tehty myös minua itseäni
varten, eli vähän "tyhmiäkin" kohtia on kommentoitu.
*/

//Antti Lahtinen
public class Lottokone {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        kaynnistys(sc);

    }
//Täällä metodissa kysytään rivien määrä ja arvonta kerrat.

    private static void kaynnistys(Scanner sc) {

        int rivimaara, arvontaKerrat;

        System.out.println("Tervetuloa pelaamaan lottoa!\n\n"
                + "Valitse ensimmäiseksi pelattavien rivien määrä ja seuraavaksi arvontakertojen määrä.\n\n");

        System.out.print("Rivien määrä: ");
        rivimaara = sc.nextInt();
        System.out.print("Arvontojen määrä: ");
        arvontaKerrat = sc.nextInt();

        System.out.println("\n======================================================================================\n");
        PaaToiminnot toiminnot = new PaaToiminnot(rivimaara, arvontaKerrat);
        toiminnot.arvontaKone();
        ApuToiminnot.tulostaOsumatJaTodNak();
        System.out.println("Pelaamistasi riveistä esimerkki voittoja: \n");
        ApuToiminnot.tulostaRiviLajittelija();
    }
}
