public class Point {

    private int posX;

    private int posY;

    public Point(int x, int y) {
        posX = x;
        posY = y;
    }
    public Point(){

    }

    public void deplacer(int dx, int dy) {
        posX = posX + dx;
        posY = posY + dy;
    }

    public String afficher() {
        String ch = "(" + posX + "," + posY + ")";
        return ch;
    }

    public void copy(Point p){
        posX=p.posX;
        posY=p.posY;
    }
    public static void copy(Point pd, Point ps ) {
        pd.posX=ps.posX;
        pd.posY=ps.posY;
    }
    public int getPosX() {
        return posX;
    }
    public void setPosX(int x) {
        posX=x;
    }
    public int getPosY() {
        return posY;
    }
    public void setPosY(int y) {
        posY=y;
    }
}
