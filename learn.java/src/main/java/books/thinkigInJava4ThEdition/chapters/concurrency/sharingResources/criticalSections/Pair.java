package books.thinkigInJava4ThEdition.chapters.concurrency.sharingResources.criticalSections;

class Pair {
    private int x, y;

    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }

    Pair(){
        this(0,0);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    void incrementX(){
        x++;
    }

    void incrementY(){
        y++;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    class PairValueNotEqualException extends RuntimeException{
        PairValueNotEqualException(){
            super("Pair values not equalL " + Pair.this);
        }
    }

    void checkState(){
        if(x !=y){
            throw  new PairValueNotEqualException();
        }
    }
}
