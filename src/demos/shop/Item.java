/** @author Eimutis Karčiauskas, KTU IF Programų inžinerijos katedra, 2018 09 23
 *
 * Tai yra demonstracinė Prekės klasė (jos objektai dedami į List)
 *************************************************************************** */
package demos.shop;

import java.util.Scanner;

public class Item {

    String name;
    String producer;
    int quantity;
    double unitPrice;

    // prekės konstruktorius - parametrų reikšmės perkeliamos į laukus
    public Item(String name, String producer, int quantity, double unitPrice) {
        this.name = name;         // žodelis this nurodo esamo objekto laukus
        this.producer = producer; // t.y. išsprendžia konfliktą tarp vardų
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    // metodas, kuris skaičiuoja išvestinę charakteristiką pagal laukų reikšmes
    public double totalPrice() {
        return unitPrice * quantity;
    }

    // suformuoja objektą iš duomenų eilutės, ją skaidydamas į atskiras dalis
    public static Item parse(String input) {
        Scanner scan = new Scanner(input);
        scan.useDelimiter(";");
        return new Item(scan.next(), scan.next(), scan.nextInt(), scan.nextDouble());
    }

    // objektą atvaizduoja tekstine eilute, tinkama lentelės formavimui
    @Override
    public String toString() {
        return String.format("| %-20s | %-10s | %3d | %8.2f |",
                name, producer, quantity, unitPrice);
    }
}
