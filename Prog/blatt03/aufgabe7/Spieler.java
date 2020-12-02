public class Spieler {
    Karte[] kartenhand;
    String name;
    double siegesquote;
    
    public String toString(){
        return this.name;
    }
    
    public static Spieler besterSpieler(Spieler... club){
        Spieler best;
        best = club[0];
        for(int n = 0; n < club.length-1; n++){
            if( club[n].siegesquote < club[n+1].siegesquote){
                best = club[n+1];
            }
        }
        return best;
    }

    public void kannBedienen(Karte k){
        int i = 0; //  Ich kann nicht bedienen!
        for(Karte k1 : this.kartenhand){
            if(k1.bedient(k)){
                i = 1; // Ich kann bedienen!
            }
        }

        if(i == 0){
            System.out.println(this.toString() + " kann nicht bedienen!");
        }else{
            System.out.println(this.toString() + " kann bedienen!");
        }
    }

    public Spieler(String name, double siegesquote){
        this.name = name;
        this.siegesquote = siegesquote;
    }
    public static void main(String[] args) {
        Spieler elisabeth = new Spieler("Elisabeth", 0.375);
        Spieler klaus = new Spieler("Klaus", 0.125);
        Spieler helmus = new Spieler("Helmus", 0.3875);
        Spieler erwin = new Spieler("Erwin", 0.1125);
        Spieler[] club = {elisabeth, klaus, helmus, erwin};
        Spieler bestSpieler = besterSpieler(club);

        Karte[] karten = new Karte[3];
        karten[0] = Karte.neueKarte("HERZ", "SIEBEN");
        karten[1] = Karte.neueKarte("HERZ", "NEUN");
        karten[2] = Karte.neueKarte("KARO", "KOENIG");

        bestSpieler.kartenhand = karten;
        Karte k = Karte.neueKarte("KARO", "BUBE");
        bestSpieler.kannBedienen(k);
    }
}
