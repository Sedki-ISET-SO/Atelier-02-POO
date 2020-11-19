import java.util.ArrayList;

public class Echiquier {

    private int nbLignes;

    private Point posRoi;

    private Point posT;

    private int nbColones;

    private int [][]tDeux;

    private int nbObstacles = 7;

    public Echiquier(int nbLignes, int nbColones) {
        tDeux = new int[nbLignes][nbColones];
        this.nbLignes = nbLignes;
        this.nbColones = nbColones;
        this.tDeux = tDeux;
        //initialerEchiquier();
    }

    public Echiquier() {

    }

    void initialerEchiquier() {
        for (int i = 0; i < nbLignes; i++)
            for (int j = 0; j < nbColones; j++) {
                this.tDeux[i][j] = 0;
            }
        this.posRoi = new Point();
        tDeux[5][5] = 2;
        this.posT = new Point(5, 5);
        tDeux[3][2] = -1;
        tDeux[1][6] = -1;
        tDeux[2][4] = -1;
        tDeux[3][3] = -1;
        tDeux[4][2] = -1;
        tDeux[4][4] = -1;
        tDeux[5][2] = -1;
    }

    public String affiche() {
        String ch = "";
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColones; j++) {
                char car = '-';
                switch (tDeux[i][j]) {
                    case 0:
                        car = '-';
                        break;
                    case 1:
                        car = 'R';
                        break;
                    case 2:
                        car = 'T';
                        break;
                    case -1:
                        car = '#';
                        break;
                }
            }
        }
        return ch;
    }

    public int etatCase(int i, int j) {
        return tDeux[i][j];
    }

    public boolean estCaseBut(int i, int j) {
        if(tDeux[i][j] == 2) {
            return  true;
        }
        return false;
    }

    public boolean estCaseVide(int i, int j) {
        if(tDeux[i][j] == 0) {
            return  true;
        }
        return false;
    }

    public boolean estFin() {
        if(posRoi.getPosX() == posT.getPosX() && posRoi.getPosY() == posT.getPosY()) {
            return  true;
        }
        return false;
    }

    public ArrayList deplacmentRealisable(ArrayList listDep) {
        ArrayList tab = new ArrayList();
        for (int i = 0; i < listDep.size(); i++) {
            int x = posRoi.getPosX() + ((Point) listDep.get(i)).getPosX();
            int y = posRoi.getPosY() + ((Point) listDep.get(i)).getPosY();
            if (x >= 0 && x < nbLignes &&  y >= 0 && y < nbColones && tDeux[x][y] != -1) {
                tab.add(listDep.get(i));
            }
        }
        return tab;
    }

    public void misAJourEchiquier(Point point) {
        tDeux[posRoi.getPosX()][posRoi.getPosY()] = 0;
        posRoi.copy(point);
        tDeux[point.getPosX()][point.getPosY()] = 1;
    }

    public void setPosRoi(Point posRoi) {
        this.posRoi.copy(posRoi);
    }

    public int[][] gettDeux() {
        return tDeux;
    }
}
