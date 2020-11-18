public class ZinseszinsRechner {

    public static void main(String[] args) {

        // initialisieren Startbetrag, Zinssatz.
        double startbetrag = 0;
        while(startbetrag < 1){
            startbetrag = SimpleIO.getInt("Bitte geben Sie den Startbetrag ein.");
        }
    
        double zinssatz = 0;
        while(zinssatz < 1){
            zinssatz = SimpleIO.getInt("Bitte geben Sie den Zinssatz als Prozentwert ein.");
        }

        // Waehlen Ziel oder Zeit?
        String wahlen = SimpleIO.getString("Bitte waehlen Sie aus: \nZiel : Berechnet die Zeit , bis ein gegebener Betrag angespart wurde . \nZeit : Berechnet den Betrag , der nach einer gegebenen Zeit angespart wurde .");

        if(wahlen.equals("Ziel")){  
            // Ziel wird berechnet.
            double zielbetrag = SimpleIO.getInt("Bitte geben Sie den Zielbetrag ein.");

            double dauer = (zielbetrag - startbetrag) / ( startbetrag * 0.01 * zinssatz );
            
            double ergibnisBetrag = startbetrag;
            
            int i = 0;
            while(i < dauer){

                ergibnisBetrag = ergibnisBetrag + ergibnisBetrag * 0.01 * zinssatz;
                i++;

            }

            SimpleIO.output("Es dauert " + dauer +" Jahre bei einem Zinssatz von " + zinssatz + "%, um von " + startbetrag + " auf den Betrag " + zielbetrag + " zu sparen . Nach dieser Zeit hat man " + ergibnisBetrag + ".", "Ergibnis");

        }else if(wahlen.equals("Zeit")){
            //Zeit wird berechnet.
            double dauer = SimpleIO.getInt("Bitte geben Sie den Zielzeit ein.");

            double zielbetrag = startbetrag;

            int i =0;
            while (i<dauer) {
                zielbetrag = zielbetrag + zielbetrag * 0.01 * zinssatz;
                i++;
            }

            SimpleIO.output("Es dauert " + dauer +" Jahre bei einem Zinssatz von " + zinssatz + "%, um von " + startbetrag + " auf den Betrag " + zielbetrag + " zu sparen.");
            
        }else{
            SimpleIO.output("Bitte geben Sie eine korrekte Antwort!", "Fehler");
        }


    }

}
