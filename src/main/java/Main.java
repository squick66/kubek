import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Klasa kl = new Klasa("dom");
        Klasa kl2 = new Klasa("dom2");
        //https://www.pracuj.pl/praca/rybnik;wp?pn=2 =>adres url dla oferty pracy w rybniku na pracuj.pl
      /*<span class="results-header__offer-count-text-number">1784</span>
        powyższy kod powstał przez:
        1. najechanie na liczbę ofert,
        2. prawy myszy => zbadaj
        3. skopiowanie konu klasy*/
        try {
            Document doc = Jsoup.connect("https://www.pracuj.pl/praca/rybnik;wp?pn=2").get();
            Elements element = doc.getElementsByClass("results-header__offer-count-text-number");
            System.out.println("Liczba ofert pracy w Rybniku to: " + element.get(0).text());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
