package ex2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {
        List<Produs> produse = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        Scanner inputFile = new Scanner(new File("produse.txt"));
        File fisier = new File("out.txt");
        FileWriter scrie = new FileWriter(fisier);
        while (inputFile.hasNextLine()) {
            String line = inputFile.nextLine();
            String[] parts = line.split(", ");
            String denumire = parts[0].trim();
            int pret = Integer.parseInt(parts[1].trim());
            int cantitate = Integer.parseInt(parts[2].trim());
            LocalDate dataExpirari = LocalDate.parse(parts[3].trim());
            Produs st = new Produs(denumire,pret,cantitate,dataExpirari);
            produse.add(st);
        }

        int opt = 0,nr;
        String denumire_prod;
        do {
            System.out.println("1. Afisare");
            System.out.println("2. Afisare produse expirate");
            System.out.println("3. Cumparare");
            System.out.println("4. Afisare cele mai ieftine produse");
            System.out.println("5. Salvare and stuff");
            System.out.print("6. Optiunea:");
            opt = scanner.nextInt();
            switch (opt) {
                case 1:
                    for (Produs st : produse)
                    {
                        st.afisare();
                    }
                    break;
                case 2:
                    for (Produs st : produse)
                    {
                        if (st.isExpired()){
                            st.afisare();
                        }
                    }
                    break;
                case 3:
                    System.out.print("Denumirea produsului dorit:");
                    denumire_prod = scanner.nextLine();
                    System.out.println("Nr de produse dorite:");
                    nr = scanner.nextInt();
                    for (Produs st : produse)
                    {
                        if (st.getDenumire().equals(denumire_prod))
                        {
                            st.Selling(nr);
                        }
                    }
                    break;
                case 4:
                    int min = Integer.MAX_VALUE;
                    for (Produs st : produse){
                        if (st.getPret() < min){
                            min = st.getPret();
                        }
                    }
                    for (Produs st : produse){
                        if (st.getPret() == min){
                            st.afisare();
                        }
                    }
                case 5:
                    System.out.println("Cantitatea:");
                    nr = scanner.nextInt();
                    for (Produs st : produse){
                        if (st.getCantitate() == nr){
                            scrie.write(st.getCantitate() + st.getDenumire() + st.getPret() + st.getData_expirari());
                        }
                    }

            }
        } while (true);

    }
}
