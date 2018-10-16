/** @author Eimutis Karčiauskas, KTU IF Programų inžinerijos katedra, 2014 09 02
   *
   *  Tai yra demonstracinė krepšinio komandos taškų skaičiavimo klasė, 
   *    kurioje demonstruojami įvairūs masyvų apdorojimo metodai.
   *  Atkreipkite dėmesį į ciklo for-each panaudojimą.
   *  Panaudodami Refactor pakeiskite klasės vardą į E_Komanda !!!
   *  IŠBANDYKITE įvairius charakteristikų skaičiavimo metodus.
   *  SURAŠYKITE reikiamus veiksmus, neužbaigtiems metodams.
   *  PAPILDYKITE programą dar kitų komandų duomenimis.
   ****************************************************************************/

import java.util.Arrays;
public class E_MasyvaiPvz { 
    String pavadinimas;
    int[] taškai;  // komandos žaidėjų pelnyti taškai

    public E_MasyvaiPvz(String pavadinimas, int[] taškai) {
        this.pavadinimas = pavadinimas;
        this.taškai = taškai;
    }
    int sumaSenuStiliumi(){
        int n = taškai.length;
        int suma = 0;
        for (int i = 0; i < n; i++) {
            suma += taškai[i];
        }
        return suma;
    }
    int sumaForEachStiliumi(){
        int suma = 0;
        for (int a1: taškai) {
            suma += a1;
        }
        return suma;
    }
    int maxSenuStiliumi(){
        int n = taškai.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) 
            if(taškai[i] > max)
                max = taškai[i];
        return max;
    }
    int maxForEachStiliumi(){
        int max = Integer.MIN_VALUE;
        for (int a1: taškai)
            if(a1 > max)
                max = a1;
        return max;
    }    
    int kiekŽaidėjųPelnėTaškus(){
        // surašykite reikiamus veiksmus
        return 0;
    }
    double koksVidurkis(){
        // surašykite reikiamus veiksmus
        return 0.0;
    }
    // metodas, skirtas kitų metodų veikimui pademonstruoti
    String kasLaimėjo(E_MasyvaiPvz kita){
        // surašykite reikiamus veiksmus, kad sužinotume laimėjusią komandą
        // numatykite lygiųjų atvejį
        return "";
    }
    // panašio paskirties metodas, bet statinis
    static String kasLaimėjo(E_MasyvaiPvz pirma, E_MasyvaiPvz antra){
        // surašykite reikiamus veiksmus, kad sužinotume laimėjusią komandą
        // numatykite lygiųjų atvejį
        return "";
    }
    void ataskaita(){
        int žaidėjųSkaičius = taškai.length;
        int visoTaškų1 = sumaSenuStiliumi();
        int visoTaškų2 = sumaForEachStiliumi();
        int maxTaškai1 = maxSenuStiliumi();
        int maxTaškai2 = maxForEachStiliumi();
        System.out.println("****** Komandos " + pavadinimas + " ataskaita");
        System.out.println("Komandos žaidėjų skaičius " + žaidėjųSkaičius);
        System.out.println("Surinkti taškai " + Arrays.toString(taškai));
        System.out.println("Taškų suma Senu Stiliumi    " + visoTaškų1);
        System.out.println("Taškų suma ForEach Stiliumi " + visoTaškų2);
        System.out.println("Max taškų Senu Stiliumi    " + maxTaškai1);
        System.out.println("Max taškų ForEach Stiliumi " + maxTaškai2 + "\n");
        // papildykite naujai paskaičiuotomis charakteristikomis
    }
    public static void main(String[] args) {
        // suformuojame komandų žaidėjų surinktų taškų masyvus
        int[] mas1 = {5, 2, 12, 21, 26, 0, 0, 7, 2, 11, 17, 0};
        int[] mas2 = {44, 8, 0, 21, 26, 0, 0, 7}; 
        int[] ltuTšk = {}; 
        int[] usaTšk = {}; 
        E_MasyvaiPvz kom1 = new E_MasyvaiPvz("Sakalai", mas1);
        E_MasyvaiPvz kom2 = new E_MasyvaiPvz("Ereliai", mas2);
        kom1.ataskaita();
        kom2.ataskaita();
        System.out.println("Rungtynes laimėjo " +kom1.kasLaimėjo(kom2));
    }    
}
