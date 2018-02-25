package Rajapinta;
/*Tässä tehtävässä yritetty miettiä millainen voisi olla pokeripelin hallintaa sopiva rajapinta.
*/
public interface IPokeriRajapinta {

    void korttiMaaraKadessa(int[] kortit, int maara); //Lisaa pelaajille kortit käteen pakasta jakaa sopivan määrän..

    void vaihdaKortti(int[] kortit, int indeksi); //Jos pelaaja haluaa vaihtaa kortit, poistaa kortin.

    void lisaaKortti(int[] kortit, int indeksi);//lisaa kortin pelaajan käteen pakasta.

    void naytaKortti(int[] kortit, int indeksi);//Näyttää kyseisen pelaajan indexin mukaisen kortin.

    void naytaKortit(int[] kortit, int indeksi);//Näyttää pelaajan käden.

    void laitaKorttiPoydalle(int[] kortit, int indeksi);//laitta kortin pöydälle.
    
    void laitaKortinPakanAlle(int[] kortit, int indeksi);//laittaa kortin pakan alle.

    void vertaaKasia(int[] kortit, int ideksi);//tarkistaa pelaajan käden ja vertaa niitä muihin.

}
