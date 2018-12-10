package interview.nespresso;

class Clipper extends Ship {

    Clipper(final long displacement, final int masts) {
        this(displacement, masts, 0);
    }

    Clipper(final long displacement, final int masts, final int cannon) {
        super(displacement, masts, cannon);
        this.speedPenalty -= 20 * this.speedPenalty / 100;
    }
}
