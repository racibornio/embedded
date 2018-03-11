import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        Table table = new Table();
        int kolejkaLacznie = 0;
        int zapasUrny;
        int zapasParawanow;
        int zapasKomisji;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Podaj numer indeksu...");
        table.nrAlbumu = Integer.parseInt(br.readLine());

        for (int licznikGodzin = 1; licznikGodzin <=7; licznikGodzin++) {
            System.out.println();
            System.out.println("W godzinie " + licznikGodzin + ". (" + (licznikGodzin+6) + "-" + (licznikGodzin+7) + ") przychodzi " + table.naplywLudziRano(licznikGodzin) + " ludzi.");

            table.kolejkaDoUrny(table.naplywLudziRano(licznikGodzin));
            kolejkaLacznie = kolejkaLacznie + table.dlugoscKolejkiDoUrny;
            if (kolejkaLacznie > 0) {
                System.out.println("Urna - kolejka łącznie: " + kolejkaLacznie);
            }
            zapasUrny = table.przepustowoscUrny - table.naplywLudziRano(licznikGodzin);
            if ((kolejkaLacznie > 0) && (table.naplywLudziRano(licznikGodzin) < table.przepustowoscUrny) ) {
                kolejkaLacznie -= zapasUrny;
                if (kolejkaLacznie > 0) {
                    System.out.println("Po rozładowaniu kolejka do urny wynosi " + kolejkaLacznie);
                }
            }

        }
        for (int licznikGodzin = 8; licznikGodzin <=14; licznikGodzin++) {
            System.out.println();
            System.out.println("W godzinie " + licznikGodzin + ". (" + (licznikGodzin+6) + "-" + (licznikGodzin+7) + ") przychodzi " + table.naplywLudziPoPoludniu(licznikGodzin) + " ludzi.");

            table.kolejkaDoUrny(table.naplywLudziPoPoludniu(licznikGodzin));
            kolejkaLacznie = kolejkaLacznie + table.dlugoscKolejkiDoUrny;
            if (kolejkaLacznie > 0) {
                System.out.println("Urna - kolejka łącznie: " + kolejkaLacznie);
            }
            zapasUrny = table.przepustowoscUrny - table.naplywLudziPoPoludniu(licznikGodzin);
            if ((kolejkaLacznie > 0) && (table.naplywLudziPoPoludniu(licznikGodzin) < table.przepustowoscUrny) ) {
                kolejkaLacznie -= zapasUrny;
                if (kolejkaLacznie > 0) {
                    System.out.println("Po rozładowaniu kolejka do urny wynosi " + kolejkaLacznie);
                }
                if (kolejkaLacznie <= 0) {
                    System.out.println("Kolejka do urny rozładowana.");
                }
            }
        }

        kolejkaLacznie = 0;
        for (int licznikGodzin = 1; licznikGodzin <=7; licznikGodzin++) {
            System.out.println();
            System.out.println("W godzinie " + licznikGodzin + ". (" + (licznikGodzin+6) + "-" + (licznikGodzin+7) + ") przychodzi " + table.naplywLudziRano(licznikGodzin) + " ludzi.");

            table.kolejkaDoParawanow(table.naplywLudziRano(licznikGodzin));
            kolejkaLacznie = kolejkaLacznie + table.dlugoscKolejkiDoParawanow;
            if (kolejkaLacznie > 0) {
                System.out.println("Parawany - kolejka łącznie: " + kolejkaLacznie);
            }
            zapasParawanow = table.przepustowoscParawanow - table.naplywLudziRano(licznikGodzin);
            if ((kolejkaLacznie > 0) && (table.naplywLudziRano(licznikGodzin) < table.przepustowoscParawanow) ) {
                kolejkaLacznie -= zapasParawanow;
                if (kolejkaLacznie > 0) {
                    System.out.println("Po rozładowaniu kolejka do parawanów wynosi " + kolejkaLacznie);
                }
            }

        }
        for (int licznikGodzin = 8; licznikGodzin <=14; licznikGodzin++) {
            System.out.println();
            System.out.println("W godzinie " + licznikGodzin + ". (" + (licznikGodzin+6) + "-" + (licznikGodzin+7) + ") przychodzi " + table.naplywLudziPoPoludniu(licznikGodzin) + " ludzi.");

            table.kolejkaDoParawanow(table.naplywLudziPoPoludniu(licznikGodzin));
            kolejkaLacznie = kolejkaLacznie + table.dlugoscKolejkiDoParawanow;
            if (kolejkaLacznie > 0) {
                System.out.println("Parawany - kolejka łącznie: " + kolejkaLacznie);
            }
            zapasParawanow = table.przepustowoscParawanow - table.naplywLudziPoPoludniu(licznikGodzin);
            if ((kolejkaLacznie > 0) && (table.naplywLudziPoPoludniu(licznikGodzin) < table.przepustowoscParawanow) ) {
                kolejkaLacznie -= zapasParawanow;
                if (kolejkaLacznie > 0) {
                    System.out.println("Po rozładowaniu kolejka do parawanów wynosi " + kolejkaLacznie);
                }
                if (kolejkaLacznie <= 0) {
                    System.out.println("Kolejka do parawanów rozładowana.");
                }
            }
        }

        kolejkaLacznie = 0;
        for (int licznikGodzin = 1; licznikGodzin <=7; licznikGodzin++) {
            System.out.println();
            System.out.println("W godzinie " + licznikGodzin + ". (" + (licznikGodzin+6) + "-" + (licznikGodzin+7) + ") przychodzi " + table.naplywLudziRano(licznikGodzin) + " ludzi.");

            table.kolejkaDoKomisji(table.naplywLudziRano(licznikGodzin));
            kolejkaLacznie = kolejkaLacznie + table.dlugoscKolejkiDoKomisji;
            if (kolejkaLacznie > 0) {
                System.out.println("Komisja - kolejka łącznie: " + kolejkaLacznie);
            }
            zapasKomisji = table.przepustowoscKomisji - table.naplywLudziRano(licznikGodzin);
            if ((kolejkaLacznie > 0) && (table.naplywLudziRano(licznikGodzin) < table.przepustowoscKomisji) ) {
                kolejkaLacznie -= zapasKomisji;
                if (kolejkaLacznie > 0) {
                    System.out.println("Po rozładowaniu kolejka do komisji wynosi " + kolejkaLacznie);
                }
            }

        }
        for (int licznikGodzin = 8; licznikGodzin <=14; licznikGodzin++) {
            System.out.println();
            System.out.println("W godzinie " + licznikGodzin + ". (" + (licznikGodzin+6) + "-" + (licznikGodzin+7) + ") przychodzi " + table.naplywLudziPoPoludniu(licznikGodzin) + " ludzi.");

            table.kolejkaDoKomisji(table.naplywLudziPoPoludniu(licznikGodzin));
            kolejkaLacznie = kolejkaLacznie + table.dlugoscKolejkiDoKomisji;
            if (kolejkaLacznie > 0) {
                System.out.println("Komisja - kolejka łącznie: " + kolejkaLacznie);
            }
            zapasKomisji = table.przepustowoscKomisji - table.naplywLudziPoPoludniu(licznikGodzin);
            if ((kolejkaLacznie > 0) && (table.naplywLudziPoPoludniu(licznikGodzin) < table.przepustowoscKomisji) ) {
                kolejkaLacznie -= zapasKomisji;
                if (kolejkaLacznie > 0) {
                    System.out.println("Po rozładowaniu kolejka do komisji wynosi " + kolejkaLacznie);
                }
                if (kolejkaLacznie <= 0) {
                    System.out.println("Kolejka do komisji rozładowana.");
                }
            }
        }



        /*
        table.countHour8to9(212, 4, 4, 33, 22, 11, 11, 11, 11, 11);
        table.getHour8to9();

        table.countHour9to10(322, 4, 3, 55, 66, 77, 88, 11, 11, 1);
        table.getHour9to10();

        table.countHour10to11(1, 2, 4, 5, 6, 8, 9, 80, 88, 65);
        table.getHour10to11();
        */
    }
}
