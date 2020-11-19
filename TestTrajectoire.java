import java.util.ArrayList;
import java.util.Scanner;

public class TestTrajectoire {

    public static void main(String[] args) {
        int choix = menu();
        while (choix == 1) {
            navigation();
            choix = menu();
        }
        System.out.println("Fin  programme");
    }

    private static void navigation() {
        ArrayList tab = new ArrayList();

        Point posInitiale = new Point(10, 15);
        //posInitiale.copy(posInitiale);
        Roi roi = new Roi(posInitiale);
        Echiquier echiquier = new Echiquier(8, 8);
        Boolean estFin = false;
        while (!estFin) {
            ArrayList deplacmentPossible = roi.deplacmentPossible(tab);
            ArrayList deplacmentRealisable = echiquier.deplacmentRealisable(deplacmentPossible);
            System.out.println("deplacmentPossible: " + deplacmentPossible.size());
            System.out.println("deplacmentRealisbale: " + deplacmentRealisable.size());
            Point positionProp = roi.choixDeplacement(deplacmentRealisable);
            roi.deplacer(positionProp);
            echiquier.misAJourEchiquier(roi.getPosRoi());
            if (echiquier.estFin()) {
                estFin = true;
            }
            System.out.println(echiquier.affiche());
        }
        /*int i=0;

        while (i < 10) {
            Point posProposer = roi.choisirDeplacement();
            roi.deplacer(posProposer);
            System.out.println(roi.affiche());
            i++;
        }*/
        System.out.println(roi.affiche());
        System.out.println("Fin itération");
    }

    private static int menu() {

        Scanner in = new Scanner(System.in);
        System.out.println("***** ***** ***** ***** ***** *****");
        System.out.println("1. Lancer la navigation");
        System.out.println("2. Quitter");
        int choix = in.nextInt();
        while (choix != 1 && choix != 2) {
            choix = in.nextInt();
        }
        return choix;
    }
}
