package Classes;

public class Slot {

    private Peg peg;

    public Slot() {
        this.peg = null;
    }

    public void setPeg(Peg peg) {
        this.peg = peg;
    }

    public Peg getPeg() {
        return peg;
    }
}
