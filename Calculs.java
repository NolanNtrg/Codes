import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;
public class Calculs {

    private static int saisieEntPosOuNul() {
        // { } =>
        // { résultat = un entier positif ou nul saisi par l'utilisateur }
        int n;
        Scanner lecteur = new Scanner(System.in);

        do {
            System.out.print("--> Saisie invalide, recommencez...\nEntrez un entier positif ou nul : ");
            n = lecteur.nextInt();
            lecteur.nextLine();
        } while (n < 0);

        return n;
    }

    private static int saisieEntMinMax(int min, int max) {
        // { 0 <= min <= max } => { résultat = entier compris entre min et max
        // saisi par l'utilisateur }
        int p;
        Scanner lecteur = new Scanner(System.in);

        do {
            System.out.print("--> Saisie invalide, recommencez...\nEntrez un entier compris entre " + min + " et " + max + " : ");
            p = lecteur.nextInt();
            lecteur.nextLine();
        } while (p < min | p > max);

        return p;
    }

    private static int factorielle(int n) {
        // { n >= 0 } => { résultat = factorielle de n (n!) }
        int resultat = 1;
        for (int i = 1; i <= n; i++ ) {
            resultat = resultat*i;
        }
        return resultat;
    }
    private static int combinaison(int n, int p) {
        // { 0 <= p <= n } =>
        // { résultat = nombre de sous-ensembles de p éléments que l'on peut
        // obtenir à partir d'un ensemble de n éléments
        // formule : n!/(p!*(n-p)!) }
        int nf = factorielle(n);
        int nc = nf/(factorielle(p)*factorielle(n-p));
        return nc;
    }

    private static int arrangement(int n, int p) {
        // { 0 <= p <= n } =>
        // { résultat = nombre de n-uplets ordonnés de p éléments que l'on
        // peut obtenir à partir d'un ensemble de n éléments
        // formule : n!/(n-p)! }
        int nf = factorielle(n);
        int na = nf/factorielle(n-p);
        return na;
    }

    private static void trianglePascal(int n) {
        // { n >= 0 } =>
        // { les lignes 0 à n du triangle de Pascal ont été affichées
        // de façon à ce que sur chaque ligne, les coefficients binomiaux
        // soient séparés par un espace }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(combinaison(i, j) + " ");
            }
            System.out.println("\n");
        }
        System.out.println();

    }

        public static void main(String[] args) {
        int n, p;
        Scanner lecteur = new Scanner(System.in);

        System.out.print("Entrez un entier positif ou nul : ");
        n = lecteur.nextInt();
        lecteur.nextLine();

        if (n < 0) {
            n = saisieEntPosOuNul();
        }

        System.out.print("Entrez un entier compris entre 0 et " + n + " : ");
        p = lecteur.nextInt();
        lecteur.nextLine();

        if (p < 0 | p > n) {
            p = saisieEntMinMax(0,n);
        }
        int nf = factorielle(n);

        System.out.println("------------------------\nFactorielle de " + n + " = " + nf + "\n------------------------");
        System.out.println("Nombre de sous-ensembles de " + p + " éléments parmi " + n + " éléments : " + combinaison(n, p) + "\n------------------------");
        System.out.println("Nombre de n-uplets ordonnés de " + p + " éléments parmi " + n + " éléments : " + arrangement(n, p) + "\n\n");
        System.out.println("------------------------------------------------\nLignes 0 à " + (n-1) + " du triangle de Pascal\n------------------------------------------------");
        trianglePascal(n);
    }

}
