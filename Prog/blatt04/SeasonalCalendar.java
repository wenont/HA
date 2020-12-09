public class SeasonalCalendar {

    /**
     * alle Produkte, über die der Saisonkalender Informationen enthalten soll
     */
    Product[] products;

    /**
     * Initialisiere eine neue SeasonalCalendar-Klasse mit entsprechenden Attributen
     * @param products Attribut von SeasonalCalender
     */
    public SeasonalCalendar(Product[] products){
        this.products = products;
    }

    /**
     * Gebe die Laenge des Namens des Produkts zurueckgibt, welches im Attribut gespeichert ist und unter allen im Attribut gespeicherten Produkten den laengsten Produktnamen hat.
     * @return die Laenge des laengsten Produktnamens
     */
    public int getLongestProductName(){
        int longestName = 0;
        for (Product product : products) {
            if(product.getName().length() > longestName){
                longestName = product.getName().length();
            }
        }
        return longestName;
    }

    /**
     * Haenge uebergebene char-Parameter an uebergebem String an, bis dieser die Laenge des uebergebenen int-Parameters hat.
     * @param paddedString angehaengter String
     * @param i forderte Laenge
     * @param pad benutzter Charakter beim Anhang
     * @return
     */
    public String pad(String paddedString, int i, char pad){
        if(paddedString.length() < i) {
            StringBuilder builder = new StringBuilder(paddedString);
            int n = i - paddedString.length();
            while(n > 0){
                builder.append(pad);
                n--;
            }
            return builder.toString();
        }
        return paddedString;
    }

    /**
     * Schreibe einen String aus ' ' mit bestimmter Laenge
     * @param n die Laenge von Blank
     * @return String aus Blank
     */
    public static String blankGenerater(int n){
        StringBuilder builder = new StringBuilder();
        for(int i = 1; i <= n; i++){
            builder.append(' ');
        }
        return builder.toString();
    }

    /**
     * eine lesbare Repräsentation des Saisonkalenders
     */
    public String stringify(){
        StringBuilder builder = new StringBuilder();
        builder.append(SeasonalCalendar.blankGenerater(this.getLongestProductName() + 2));       
        builder.append("JFMAMJJASOND\r\n");

        for (Product product : products) {
            builder.append(product.getName() + ": ");
            builder.append(SeasonalCalendar.blankGenerater(this.getLongestProductName() - product.getName().length()));       
            builder.append(product.stringifyIsRegional(product) + "\r\n");
            builder.append(SeasonalCalendar.blankGenerater(this.getLongestProductName() + 2));
            builder.append(product.stringifyIsImported(product) + "\r\n");
        }

        return builder.toString();
    }

}
