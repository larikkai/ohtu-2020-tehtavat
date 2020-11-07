package ohtu.verkkokauppa;

public interface Laitos {

    boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa);
    
}
