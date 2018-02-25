package KaksiRR;

import java.util.ArrayList;


public class Toimintaluokka {

    private final ArrayList<Integer> ylaJoukkueet = new ArrayList<>();
    private final ArrayList<Integer> alaJoukkueet = new ArrayList<>();
    private final int joukkueidenMaara;
    private int kierrosLaskuri = 1;
    protected String toistettavaYhtMerkki = new String(new char[50]).replace("", "=");
    protected int parittomanLaskuri = 0;
 //=============================================================================================================================   

    public Toimintaluokka(int joukkueidenMaara) {
        this.joukkueidenMaara = joukkueidenMaara;
    }
//=============================================================================================================================

    public void JoukkueidenLuoja() {

        for (int i = 0; i < joukkueidenMaara / 2; i++) {
            ylaJoukkueet.add(i + 1);
            alaJoukkueet.add(i + 1 + (joukkueidenMaara / 2));
        }
        if (joukkueidenMaara % 2 == 1) {
            alaJoukkueet.add((joukkueidenMaara / 2), joukkueidenMaara);
        }
    }
//=============================================================================================================================

    public void OtteluidenTulostaja() {
        int j = joukkueidenMaara / 2;
     
        System.out.println("#" + kierrosLaskuri + " KIERROS");

        kierrosLaskuri++;
        
//=============================================================================================================================

        if (joukkueidenMaara % 2 == 1) {//Ensimmäiseksi varmistetaan parittomuus. 

            for (int i = 0; i < ylaJoukkueet.size(); i++) {//Tulostetaan puolet joukkueiden määrästä otteluita. 
                if (i % 2 == 0+parittomanLaskuri) {        // Tehdään vuorottelua vieras/koti puolelle. 
                    System.out.println("Joukkue " + ylaJoukkueet.get(i) + "  vs. Joukkue " + alaJoukkueet.get(i));
                } if(i % 2 == 1-parittomanLaskuri) {        // Tehdään vuorottelua vieras/koti puolelle.
                    System.out.println("Joukkue " + alaJoukkueet.get(i) + "  vs. Joukkue " + ylaJoukkueet.get(i));
                }
            }
            System.out.println("Joukkue " + alaJoukkueet.get(joukkueidenMaara / 2) + " lepää.\n");
//=============================================================================================================================

        } else {
            if (kierrosLaskuri % 2 == 0) {
                for (int i = 0; i < ylaJoukkueet.size(); i++) {//Tulostetaan puolet joukkueiden määrästä otteluita.

                    //tulostetaan ottelut "alaJoukkueet" perästä alkuun ja "ylaJoukkueet" alusta loppuun.
                    System.out.println("Joukkue " + alaJoukkueet.get(j - 1) + "  vs. Joukkue " + ylaJoukkueet.get(i));
                    j--;
                }
            } else {
                for (int i = 0; i < ylaJoukkueet.size(); i++) {
                    System.out.println("Joukkue " + ylaJoukkueet.get(i) + "  vs. Joukkue " + alaJoukkueet.get(j - 1));
                    j--;
                }
            }
        }
        
    }
//=============================================================================================================================


    public void otteluParienVaihtaja() {

        int tmp = ylaJoukkueet.get((joukkueidenMaara / 2) - 1);

        if (joukkueidenMaara % 2 == 1) {//parittomuus varmistetaan.

            ylaJoukkueet.add(0, alaJoukkueet.get(0));
            alaJoukkueet.remove(0);
            alaJoukkueet.add(joukkueidenMaara / 2, ylaJoukkueet.get(joukkueidenMaara / 2));//käytetään int jakolaskua hyväksi.
            ylaJoukkueet.remove(joukkueidenMaara / 2);
            
            System.out.println(toistettavaYhtMerkki);

        } else {

            ylaJoukkueet.add(1, alaJoukkueet.get((joukkueidenMaara / 2) - 1));
            ylaJoukkueet.remove(joukkueidenMaara / 2);
            alaJoukkueet.add(0, tmp);
            alaJoukkueet.remove((joukkueidenMaara / 2));

            System.out.println(toistettavaYhtMerkki);
        }
    }
}
