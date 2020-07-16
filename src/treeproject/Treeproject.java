package treeproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Treeproject {

    private static final String FILENAME = "D:\\PROLAB 4\\TreeProject\\rezervasyon.txt";

    public static String[] Okuma() {

        Tree t = new Tree("root");
        t.level = 0;
        BufferedReader br = null;
        FileReader fr = null;

        String[] kategoriler = new String[8000];
        try {

            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);

            String sCurrentLine;

            String kategori;

            while ((sCurrentLine = br.readLine()) != null) {

                String[] kelimeler = sCurrentLine.split(",");
                kategoriler = kelimeler;

                for (int i = 0; i < kelimeler.length; i++) {
                    if (i % 6 == 0 && i != 0) {//category
                        kategori = kelimeler[i];

                        kategoriler = kategori.split(":");
                        t.KategoriAra(t, "root", kategoriler[0]);
                        for (int j = 0; j < kategoriler.length - 1; j++) {
                            t.KategoriAra(t, kategoriler[j], kategoriler[j + 1]);
                        }
                    }
                }

            }

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (br != null) {
                    br.close();
                }

                if (fr != null) {
                    fr.close();
                }

            } catch (IOException ex) {

                ex.printStackTrace();

            }
        }
        t.printTree(t);
        Scanner s = new Scanner(System.in);
        int x = 1;
        while (x != 0) {
            System.out.println("Hangi Kategoriye ekleyeceksiniz?");
            String EkBaba = s.next();
            System.out.println("Ne ekleyeceksiniz?");
            String EkOgul = s.next();
            t.KategoriAra(t, EkBaba, EkOgul);
            System.out.println("Devam etmek için herhangi bir sayý girin.Çýkmak için '0' giriniz");
            x = s.nextInt();
        }
        t.printTree(t);
        return kategoriler;
    }

    public static void main(String[] args) {

        String[] Kategoriler = Okuma();

    }
}

