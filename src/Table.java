import java.io.PrintStream;

public class Table {

    int nrAlbumu;
    int naplywLudziRano(int godzina) {
        return (nrAlbumu/470)*godzina-(7-godzina)*(7-godzina);
    }

    int naplywLudziPoPoludniu(int godzina) {
        return (nrAlbumu/470)*(15-godzina)-(8-godzina)*(8-godzina);
    }

    int dlugoscKolejkiDoUrny;
    int dlugoscKolejkiDoParawanow;
    int dlugoscKolejkiDoKomisji;
    int przepustowoscUrny = 0;
    int przepustowoscParawanow = 0;
    int przepustowoscKomisji = 0;

    void kolejkaDoUrny(int iloscLudzi) {
        dlugoscKolejkiDoUrny = 0;
        int czasOperacyjny = 15;
        przepustowoscUrny = 3600/czasOperacyjny;

        if ((iloscLudzi-przepustowoscUrny) > 0) {
            dlugoscKolejkiDoUrny = iloscLudzi - przepustowoscUrny;
        }
        int czasOczekiwania = dlugoscKolejkiDoUrny*czasOperacyjny;

        if (dlugoscKolejkiDoUrny > 0) {
            System.out.println("Kolejka do czytnika wyniesie " + dlugoscKolejkiDoUrny + " osób.");
            System.out.println("Ostatnia osoba do czytnika poczeka " + (czasOczekiwania - czasOperacyjny) + " sekund, co daje około " + ((czasOczekiwania - czasOperacyjny) / 60 ) + " minut.");
        }
    }

    void kolejkaDoParawanow(int iloscLudzi) {
        dlugoscKolejkiDoParawanow = 0;
        int czasOperacyjny = 50;
        przepustowoscParawanow = 3600/czasOperacyjny*4;

        if ((iloscLudzi-przepustowoscParawanow) > 0) {
            dlugoscKolejkiDoParawanow = iloscLudzi - przepustowoscParawanow;
        }
        int czasOczekiwania = dlugoscKolejkiDoParawanow*czasOperacyjny;

        if (dlugoscKolejkiDoParawanow > 0) {
            System.out.println("Kolejka do parawanów wyniesie " + dlugoscKolejkiDoParawanow + " osób.");
            System.out.println("Ostatnia osoba do parawanów poczeka " + (czasOczekiwania - czasOperacyjny) + " sekund, co daje  około " + ((czasOczekiwania - czasOperacyjny) / 60) +  " minut.");
        }
    }

    void kolejkaDoKomisji(int iloscLudzi) {
        dlugoscKolejkiDoKomisji = 0;
        int czasOperacyjny = 55;
        przepustowoscKomisji = 3600/czasOperacyjny*5;

        if ((iloscLudzi-przepustowoscKomisji) > 0) {
            dlugoscKolejkiDoKomisji = iloscLudzi - przepustowoscKomisji;
        }
        int czasOczekiwania = dlugoscKolejkiDoKomisji*czasOperacyjny;

        if (dlugoscKolejkiDoKomisji > 0) {
            System.out.println("Kolejka do komisji wyniesie " + dlugoscKolejkiDoKomisji + " osób.");
            System.out.println("Ostatnia osoba do komisji poczeka " + (czasOczekiwania - czasOperacyjny) + " sekund, co daje około " + ((czasOczekiwania - czasOperacyjny) / 60) + " minut.");
        }
    }
}