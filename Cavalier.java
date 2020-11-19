import java.util.ArrayList;

public class Cavalier extends Piece {
    public Cavalier(int laPiece, String color, Point pos) {
        super(laPiece, color, pos);
    }
    public ArrayList deplacmentPossible() {
        ArrayList list = new ArrayList();
        int x = super.getPosition().getPosX();
        int y = super.getPosition().getPosY();
        for (int i = -2; i <= 2; i++) {
            for (int j = -2; j <= 2; j++) {
                if ((Math.abs(i) == 2 && Math.abs(j) == 1) || Math.abs(i) == 1 && Math.abs(j) == 2) {
                    list.add(new Point(x + i, y + j));
                }
            }
        }
        return list;
    }
}
