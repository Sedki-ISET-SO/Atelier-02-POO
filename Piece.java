public class Piece {

    private int numPiece;

    private String color;

    private Point position;

    public Piece(int numPiece, String color, Point position) {
        this.numPiece = numPiece;
        this.color = color;
        this.position = position;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }
}
