/**
 * Objekte dieser Klasse repreesentieren die Verfuegbarkeit eines bestimmten Produkts
 */
public class Product {
    /**
     * Name vom Product
     */
    private String name;

    /**
     * Verfuegbarkeit des Produkts als Regionalware fuer jeden Monat des Jahres. true steht fuer verfuegbar, false fuer unverfuegbar.
     */
    private boolean[] verfuegbarAlsRegionalware;

    /**
     * Verfuegbarkeit des Produkts als Importware fuer jeden Monat des Jahres. true steht fuer verfuegbar, false fuer unverfuegbar.
     */
    private boolean[] verfuegbarAlsImportware;

    /**
     * Lese Name des Produkts
     * @return Name des Produkts
     */
    public String getName() {
        return this.name;
    }

    /**
     * Initialisiere eine neue Produkt-Klasse mit entsprechenden Attributen
     * @param name Name vom Product
     * @param verfuegbarAlsRegionalware Verfuegbarkeit einer Regionalware im Form von Boolean-Array
     * @param verfuegbarAlsImportware Verfuegbarkeit einer Importware im Form von Boolean-Array
     */
    public Product(String name, boolean[] verfuegbarAlsRegionalware, boolean[] verfuegbarAlsImportware){
        this.name = name;
        this.verfuegbarAlsRegionalware = verfuegbarAlsRegionalware;
        this.verfuegbarAlsImportware = verfuegbarAlsImportware;
    }

    /**
     * Initialisiere eine neue Produkt-Klasse. Im zweiten und dritten Parameter steht eine 1 fuer die Verfuegbarkeit in diesem Monat und eine 0 fuer dessen Unverfuegbarkeit.
     * @param name Name vom Product
     * @param verfuegbarAlsRegionalware Verfuegbarkeit einer Regionalware im Form von String
     * @param verfuegbarAlsImportware Verfuegbarkeit einer Importware im Form von String
     */
    public Product(String name, String verfuegbarAlsRegionalware, String verfuegbarAlsImportware){
        this.name = name;
        this.verfuegbarAlsRegionalware = BooleanStringHelper.parse(verfuegbarAlsRegionalware, '1');
        this.verfuegbarAlsImportware= BooleanStringHelper.parse(verfuegbarAlsImportware, '1');
    }

    /**
     * Pruefe, ob das Produkt als Regionalware verfuegbar ist.
     * @param product geprueftes Produkt
     * @return ein String enthaelt ein R fuer die Monate, in denen das Produkt als Regionalware verfuegbar ist und ein Leerzeichen fuer alle anderen Monate.
     */
    public String stringifyIsRegional(Product product){
        return BooleanStringHelper.stringify(product.verfuegbarAlsRegionalware, 'R', ' ');
    }

    /**
     * Pruefe, ob das Produkt als Importware verfuegbar ist.
     * @param product geprueftes Produkt
     * @return ein String enthaelt ein R fuer die Monate, in denen das Produkt als Importware verfuegbar ist und ein Leerzeichen fuer alle anderen Monate.
     */
    public String stringifyIsImported(Product product){
        return BooleanStringHelper.stringify(product.verfuegbarAlsImportware, 'L', ' ');
    }
}
