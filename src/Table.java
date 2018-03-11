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

    private String[] headers = {
            "Godziny głosowania od - do",
            "Ilość kart wydanych przez komisję",
            "Ilość kart wrzuconych do urny",
            "Ilość kart - łącznie głosów nieważnych",
            "Ilość kart - głosów nieważnych - pustych, w ogóle niewypełnionych",
            "Ilość kart - głosów nieważnych - wypełnionych nieprawidłowo",
            "Ilość kart - głosów ważnych [ilość] [%]",
            "Ilość głosów na kandydata A [ilość] [%]",
            "Ilość głosów na kandydata B [ilość] [%]",
            "Ilość głosów na kandydata C [ilość] [%]",
            "Ilość głosów na kandydata D [ilość] [%]",
            "Ilość głosów na kandydata E [ilość] [%]",
            "Ilość głosów na kandydata F [ilość] [%]",
            "Ilość głosów na kandydata G [ilość] [%]"
    };

    private int[] numbersOfColumns = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};

    public void getHeaders() {
        for (int i = 0; i < headers.length; i++) {
            System.out.print(headers[i]);
        }
    }

    public void getNumbersOfColumns() {
        for (int i = 0; i < numbersOfColumns.length; i++) {
            System.out.println(numbersOfColumns[i]);
        }
    }

    private int[] hours7to8 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int[] hours8to9 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int[] hours9to10 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int[] hours10to11 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    public void countHour7to8(int two, int five, int six, int eight, int nine, int teen, int eleven, int twelve, int thirteen, int fourteen) {
        int forColSix = 0;
        hours7to8[0] = 0;
        hours7to8[1] = two;
        hours7to8[4] = five;
        hours7to8[5] = six;
        hours7to8[7] = eight;
        hours7to8[8] = nine;
        hours7to8[9] = teen;
        hours7to8[10] = eleven;
        hours7to8[11] = twelve;
        hours7to8[12] = thirteen;
        hours7to8[13] = fourteen;
        for (int i = 7; i <= 13; i++) {
            forColSix += hours7to8[i];
        }
        hours7to8[6] = forColSix;
        hours7to8[3] = hours7to8[4] + hours7to8[5];
        hours7to8[2] = hours7to8[3] + hours7to8[6];
    }

    public void countHour8to9(int two, int five, int six, int eight, int nine, int teen, int eleven, int twelve, int thirteen, int fourteen) {
        int forColSix = 0;
        hours8to9[0] = 0;
        hours8to9[1] = two;
        hours8to9[4] = five;
        hours8to9[5] = six;
        hours8to9[7] = eight;
        hours8to9[8] = nine;
        hours8to9[9] = teen;
        hours8to9[10] = eleven;
        hours8to9[11] = twelve;
        hours8to9[12] = thirteen;
        hours8to9[13] = fourteen;
        for (int i = 7; i <= 13; i++) {
            forColSix += hours8to9[i];
        }
        hours8to9[6] = forColSix;
        hours8to9[3] = hours8to9[4] + hours8to9[5];
        hours8to9[2] = hours8to9[3] + hours8to9[6];
    }

    public void countHour9to10(int two, int five, int six, int eight, int nine, int teen, int eleven, int twelve, int thirteen, int fourteen) {
        int forColSix = 0;
        hours9to10[0] = 0;
        hours9to10[1] = two;
        hours9to10[4] = five;
        hours9to10[5] = six;
        hours9to10[7] = eight;
        hours9to10[8] = nine;
        hours9to10[9] = teen;
        hours9to10[10] = eleven;
        hours9to10[11] = twelve;
        hours9to10[12] = thirteen;
        hours9to10[13] = fourteen;
        for (int i = 7; i <= 13; i++) {
            forColSix += hours9to10[i];
        }
        hours9to10[6] = forColSix;
        hours9to10[3] = hours9to10[4] + hours9to10[5];
        hours9to10[2] = hours9to10[3] + hours9to10[6];
    }

    public void countHour10to11(int two, int five, int six, int eight, int nine, int teen, int eleven, int twelve, int thirteen, int fourteen) {
        int forColSix = 0;
        hours10to11[0] = 0;
        hours10to11[1] = two;
        hours10to11[4] = five;
        hours10to11[5] = six;
        hours10to11[7] = eight;
        hours10to11[8] = nine;
        hours10to11[9] = teen;
        hours10to11[10] = eleven;
        hours10to11[11] = twelve;
        hours10to11[12] = thirteen;
        hours10to11[13] = fourteen;
        for (int i = 7; i <= 13; i++) {
            forColSix += hours10to11[i];
        }
        hours10to11[6] = forColSix;
        hours10to11[3] = hours10to11[4] + hours10to11[5];
        hours10to11[2] = hours10to11[3] + hours10to11[6];
    }

    public void getHour7to8() {
        for (int i = 0; i < hours7to8.length; i++) {
//            System.out.println(numbersOfColumns[i] + ": " + hours7to8[i]);
            System.out.format(numbersOfColumns[i] + ": " + hours7to8[i]);
        }
    }

    public void getHour8to9() {
        for (int i = 0; i < hours8to9.length; i++) {
            System.out.println(numbersOfColumns[i] + ": " + hours8to9[i]);
        }
    }

    public void getHour9to10() {
        for (int i = 0; i < hours9to10.length; i++) {
            System.out.println(numbersOfColumns[i] + ": " + hours9to10[i]);
        }
    }

    public void getHour10to11() {
        for (int i = 0; i < hours10to11.length; i++) {
            System.out.println(numbersOfColumns[i] + ": " + hours10to11[i]);
        }
    }

    public void countFrequency(int index) {
        int frequency = 0;
        int i =9;
    }
}