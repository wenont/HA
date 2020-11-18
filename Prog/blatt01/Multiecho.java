// T10

public class Multiecho{
    public static void main(String[] args) {
        

        int zahl = 0;
        while(zahl < 1){
            zahl = SimpleIO.getInt("Bitte gib eine Zahl ein!");
        }

        String wort = SimpleIO.getString("Bitte gib einen String ein!");

        String ausgabe = "";

        for(int i = 0; i < zahl; i++){
            ausgabe = ausgabe + wort;
        }

        SimpleIO.output(ausgabe, "Multiecho");

    }

}


