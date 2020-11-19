import java.util.ArrayList;

public class Roi {

    private Point posRoi;

    private Point[] trajectoire = new Point[1000];

    private int nbDeplacement;

    public Roi(Point p) {
        posRoi = p;
        trajectoire[nbDeplacement] = new Point(p.getPosX(), p.getPosY());
        nbDeplacement++;
    }

    public Roi(int x, int y) {
        posRoi = new Point(x, y);
    }

    public Roi() {
        posRoi = new Point();
    }

    public void deplacer(int dx, int dy) {
        posRoi.deplacer(dx, dy);
        trajectoire[this.nbDeplacement] = new Point(posRoi.getPosX(), posRoi.getPosY());
        this.nbDeplacement++;
    }

    public void deplacer(Point posProposer) {
        deplacer(posProposer.getPosX(), posProposer.getPosY());
    }

    public String affiche() {
        String ch = " Position: " + posRoi.afficher();
        for (int i = 0; i < this.nbDeplacement; i++)
            ch = ch + " " + trajectoire[i].afficher();
        return ch;

    }

    public void copy(Roi r) {
        posRoi.copy(r.posRoi);
    }

    public static void copy(Roi r1, Roi r2) {
        // r1.posRobot.copy(r2.posRobot);
        Point.copy(r1.posRoi, r2.posRoi);
    }

    public Point choisirDeplacement() {
        Point p = null;
        int indice = (int) (Math.random() * 8);
        switch (indice) {
            case 0:
                p = new Point(0, -1);
                break;
            case 1:
                p = new Point(-1, -1);
                break;
            case 2:
                p = new Point(-1, 0);
                break;
            case 3:
                p = new Point(-1, 1);
                break;
            case 4:
                p = new Point(0, 1);
                break;
            case 5:
                p = new Point(1, 1);
                break;
            case 6:
                p = new Point(1, 0);
                break;
            case 7:
                p = new Point(1, -1);
                break;
        }
        return p;
    }

    public Point getPosRoi() {
        return posRoi;
    }

    public void setPosRoi(Point posRoi) {
        this.posRoi = posRoi;
    }

    public Point choixDeplacement(ArrayList depPropRobotRoi) {
        if (depPropRobotRoi.size() == 0)
            return null;
        int indice = (int) (Math.random() * depPropRobotRoi.size());
        return (Point) depPropRobotRoi.get(indice);
    }

    public ArrayList deplacmentPossible(ArrayList listDep) {
        ArrayList nouList = new ArrayList();
        Echiquier echiquier = new Echiquier();
        int [][]tab = echiquier.gettDeux();
        for (int i = 0; i < listDep.size(); i++) {
            Point point = (Point) listDep.get(i);
            if (point.getPosX() > 0 && point.getPosX() < 8
                    && point.getPosY() > 0 && point.getPosY() > 8 && tab[point.getPosX()][point.getPosY()] != -1) {
                nouList.add(point);
            }
        }
        return nouList;
    }
}
