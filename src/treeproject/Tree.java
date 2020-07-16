package treeproject;

import java.util.ArrayList;

public class Tree {

    ArrayList<Tree> childs = new ArrayList<Tree>();
    int level;
    String kategoriIsmi;
    Tree parent;
    ArrayList<String> essizKategori = new ArrayList<String>();

    public Tree(String kategoriIsmi) {
        this.kategoriIsmi = kategoriIsmi;

    }

    public void printTree(Tree root) {
        if (root == null) {
            return;
        }
        if (root.parent != null) {
            System.out.println("Ata: " + root.parent.kategoriIsmi);
        }
        System.out.println("===>" + root.kategoriIsmi + " -level " + root.level);
        for (int i = 0; i < root.childs.size(); i++) {
            printTree(root.childs.get(i));
        }
    }

    public void KategoriAra(Tree root, String aranan, String yeniKategori) {

        if (root == null) {
            return;
        }

        if (root.kategoriIsmi.equals(aranan)) {
            if (!essizKategori.contains(yeniKategori)) {
                root.KategoriEkle(root, aranan, yeniKategori);
                essizKategori.add(yeniKategori);
            } else {
                //System.out.println("Kategori var");
                return;
            }
        }

        for (int i = 0; i < root.childs.size(); i++) {
            KategoriAra(root.childs.get(i), aranan, yeniKategori);
        }

    }

    public void KategoriEkle(Tree node, String hedef, String yeniKat) {
        Tree gecici = new Tree(yeniKat);
        gecici.parent = node;
        if (gecici.parent != null) {
            gecici.level = node.level + 1;
        }
        node.childs.add(gecici);
    }

}
