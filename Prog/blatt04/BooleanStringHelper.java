public class BooleanStringHelper{

    /**
     * Vergleiche alle Zeichen im uebergebenen String a mit dem uebergebenen Zeichen b nacheinander. 
     * Gebe ein boolean-Array c[] zurueck. c[i] ist true,  falls i-te Zeichen in a genau wie b ist.
     * @param word der uebergebene String
     * @param c das uebergebene Zeichen 
     * @return  das Ergebnis aus Parse im Form von einem boolean-Array
     */
    public static boolean[] parse(String word, char c){
        boolean[] result = new boolean[word.length()];
        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) == c){
                result[i] = true;
            } else {
                result[i] = false;
            }
        }
        return result;
    }

    /**
     * Konstruiere einen String, Ist der i-te Eintrag des übergebenen Arrays true, so steht an der i-ten Stelle des zurückgegebenen Strings das Zeichen, welches als erster char-Wert übergeben wurde. Falls false, dann steht der i-ten Stelle zweiter cher-Wert.
     * @param a das uebergebene Boolean-Array
     * @param c1 erster Zeichen
     * @param c2 zweiter Zeichen
     * @return
     */
    public static String stringify(boolean[] a, char c1, char c2){
        StringBuilder builder = new StringBuilder(""); 
        for(boolean n : a){
            if(n){
                builder.append(c1);
            }else {
                builder.append(c2);
            }
        }
        return builder.toString();
    }
}