package ohtu.verkkokauppa;

import java.util.ArrayList;

public interface Lista {

    ArrayList<String> getTapahtumat();

    void lisaaTapahtuma(String tapahtuma);
    
}
