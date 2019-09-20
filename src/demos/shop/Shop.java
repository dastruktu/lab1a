/** @author Eimutis Karčiauskas, KTU IF Programų inžinerijos katedra, 2018 09 23
 *
 * Tai yra demonstracinė Parduotuvės klasė (ji saugo objektus sąraše List)
 ****************************************************************************/
package demos.shop;

import java.util.*;

//==============================================
public class Shop {

    public String name; // čia parduotuvės vardas
    // dar gali būti registracijos kodas, metai, adresas, ...
    private List<Item> store; // esminis laukas - prekių sandėlys

    public Shop(String name) {
        this.name = name;
        store = new ArrayList<>(); // pradžioje prekių sąrašas yra tuščias
    }

    // metodas su kintamu parametrų skaičiumi (sąrašas nenaudojamas)
    // prekių objektai turi būti suformuoti išorėje
    public void addItems(Item... addedItems) {
        for (Item ai : addedItems) {
            store.add(ai);
        }
    }

    // metodas su tekstu (String), kuriame prekės surašytos atskirose eilutėse
    public void addItems(String itemsText) {
        for (String line : itemsText.split("\n")) {
            store.add(Item.parse(line));
        }
    }

    // metodas su tekstu (String), kuriame prekės surašytos atskirose eilutėse
    // parametras fillingOption: false = iš naujo (from zero) 
    //                           true = pratęsti pildymą (extend filling)
    public void addItems(String itemsText, boolean fillingOption) {
        if (!fillingOption) {
            store.clear();
        }
        addItems(itemsText);
    }

    // metodas su eilučių sąrašu, nes taip gražina Files.readAllLines
    public void addItems(List<String> itemStringList) {
        for (String inp : itemStringList) {
            store.add(Item.parse(inp));
        }
    }

    // ----- toliau formuojame užduotyje nurodytus metodus
    public int countUnits() {
        int count = 0;
        for (Item item : store) {
            count += item.quantity;
        }
        return count;
    }

    public double sumStorePrice() {
        double sum = 0;
        for (Item item : store) {
            sum += item.total();
        }
        return sum;
    }

    // randa prekę su didžiausia vieneto kaina
    public Item maxItemPrice() {
        double max = 0;
        Item itMax = null;
        for (Item it : store) {
            if (it.unitPrice > max) {
                max = it.unitPrice;
                itMax = it;
            }
        }
        return itMax;
    }

    // formuoja prekių tekstą, kurių kaina <= limit
    public String itemsPriceGE(double limit) {
        StringBuilder sb = new StringBuilder();
        for (Item it : store) {
            if (it.unitPrice >= limit) {
                sb.append(it).append('\n');
            }
        }
        return sb.toString();
    }

    // metodas formuoja gamintojų ir jų prekių kiekio sąrašą 
    // tai pradinis uždavinio sprendimo variantas, panaudojant tik List
    public String differentProducerCount() {
        List<String> producers = new ArrayList<>();
        List<Integer> prodCounts = new ArrayList<>();
        for (Item it : store) {
            int ind = producers.indexOf(it.producer);
            if (ind < 0) { // jei gamintojo sąraše dar nebuvo
                producers.add(it.producer);
                prodCounts.add(1);  // pradinė skaitliuko reikšmė 1
            } else {
                prodCounts.set(ind, prodCounts.get(ind) + 1);
            }
        }
        StringBuilder sb = new StringBuilder("Skirtingi gamintojai\n");
        int ind = 0;
        for (String prod : producers) {
            sb.append(String.format("| %2d | %-10s | %3d |",
                    ind + 1, prod, prodCounts.get(ind++)))
                    .append("\n");
        }
        return sb.toString();
    }

    // metodas print turi sąrašo parametrą, kad spausdintų ir kitus sąrašus
    public void print(List<Item> items) {
        System.out.println("::: prekių skaičius = " + items.size());
        // Antraštė pagal pvz. | Krepšinio_kamuolys   | Spalding   |  12 |    32,99 |
        System.out.println(":  Prekės pavadinmas   : Gamintojas : kiek: vnt.kaina:");
        for (Item d : items) {
            System.out.println(d);
        }
    }

    // spausdina išorėje nepasiekiamą sandėlio prekių sąrašą items
    public void print() {
        print(store);
    }

    // sudaromas parduotuvės ataskaitos tekstą
    public String fullReport(double limGE, double limLE) {
        Item maxItem = maxItemPrice();
        StringBuilder sb = new StringBuilder();
        sb.append("===== Parduotuvės " + name + " ATASKAITA\n")
                .append("----- Prekių skaičius yra : " + store.size() + "\n")
                .append("---- Vienetų skaičius yra : " + countUnits() + "\n")
                .append("Sandėlio prekių kaina yra : " + sumStorePrice() + "\n")
                .append("----- Brangiausia prekė:\n")
                .append((maxItem == null ? "nėra" : maxItem.toString()) + "\n")
                .append("----- Prekės, kurių kaina >= " + limGE + "\n")
                .append(itemsPriceGE(limGE));
        return sb.toString();
    }
}
