package ru.netology;
import java.util.Map;

// Для работы с корзиной создадим отдельный класс
// и перенесем туда то, что принадлежит корзине
public class Basket {
    protected Map<String, Integer> prices;
    protected Purchase[] purchases; // перенесли поле с покупками из класса Purchase

    public Basket(Map<String, Integer> prices) {
        this.prices = prices;
        this.purchases = new Purchase[prices.size()];
    }

    public void addPurchase(String title, int count) { // перенесли добавление 1 покупки из класса Purchase
        for (int i = 0; i < purchases.length; i++) {
            if (purchases[i] == null) {
                purchases[i] = new Purchase(title, count);
                return;
            }
            if (purchases[i].title.equals(title)) {
                purchases[i].count += count;
                return;
            }
        }
    }

    public long sum() {   // переносим суммирование из класса Purchase
        long sum = 0;
        System.out.println("КОРЗИНА:");
        for (int i = 0; i < purchases.length; i++) {
            Purchase purchase = purchases[i];
            if (purchase == null) continue;
            System.out.println("\t" + purchase.title + " " + purchase.count + " шт. в сумме " + (purchase.count * prices.get(purchase.title)) + " руб.");
            sum += purchase.count * prices.get(purchase.title);
        }
        return sum;
    }
}