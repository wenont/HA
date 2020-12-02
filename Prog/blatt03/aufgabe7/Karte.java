public class Karte {
    Farbe farbe;
    Wert wert;

    @Override
    public String toString(){
        return farbe.toString() + wert.toString();
    }

    public static Karte neueKarte(Farbe f, Wert w){
        Karte newCard = new Karte();
        newCard.farbe = f;
        newCard.wert = w;       
        return newCard;
    }

    public static Karte neueKarte(String f, String w){

        Farbe f1;
        Wert w1;

        // KREUZ, PIK, HERZ, KARO;
        switch(f){
            case "KREUZ" -> {
                f1 = Farbe.KREUZ;
            }
            case "PIK" -> {
                f1 = Farbe.PIK;
            }
            case "HERZ" -> {
                f1 = Farbe.HERZ;
            }
            case "KARO" -> {
                f1 = Farbe.KARO;
            }
        }
        //  SEIBEN, ACHT, NEUN, ZEHN, BUBE, DAME, KOENIG, ASS;
        switch(w){
            case "SEIBEN" -> {
                w1 = Wert.SEIBEN;
            }
            case "ACHT" -> {
                w1 = Wert.ACHT;
            }
            case "NEUN" -> {
                w1 = Wert.NEUN;
            }
            case "ZEHN" -> {
                w1 = Wert.ZEHN;
            }
            case "BUBE" -> {
                w1 = Wert.BUBE;
            }
            case "DAME" -> {
                w1 = Wert.DAME;
            }
            case "KOENIG" -> {
                w1 = Wert.KOENIG;
            }
            case "ASS" -> {
                w1 = Wert.ASS;
            }
        }
        return neueKarte(f1, w1);
    }

    public static int kombinationen(){     
        int numberOfColor = Farbe.values().length;
        int numberOfValue = Wert.values().length;
        return numberOfColor * numberOfValue;
    }

    public static Karte[] skatblatt(){
        Karte[] blatt = new Karte[kombinationen()];
        int n = 0;

        for (Farbe farbe : Farbe.values()) {
            for (Wert wert : Wert.values()){
                blatt[n] = neueKarte(farbe, wert);
                n++; 
            }
        }
        return blatt;
    }

    public boolean bedient(Karte other){
        if(this.farbe == other.farbe || this.wert == other.wert || this.wert == Wert.BUBE){
            return true;
        }       
        return false;
    }

    public boolean bedienbar(Karte... karten){
        for (Karte karte1 : karten){
            for (Karte karte2 : karten){
                if(karte1 != karte2){
                    boolean i = karte1.bedient(karte2);
                    if(i){
                        return true;
                    }
                }
            }
        }
        return false;
    }




}
