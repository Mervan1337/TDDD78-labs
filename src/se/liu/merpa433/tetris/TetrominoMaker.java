package se.liu.merpa433.tetris;

public class TetrominoMaker {

    private int numberOfTypes = 7;

    public int getNumberOfTypes() {
        return this.numberOfTypes;
    }

    public Poly getPoly(int n) {
        switch (n){
            case 0:
                return getZ();
            case 1:
                return getT();
            case 2:
                return getS();
            case 3:
                return getO();
            case 4:
                return getI();
            case 5:
                return getJ();
            case 6:
                return getL();
            default:
                throw new IllegalArgumentException("Invalid index: " + n);
        }
    }
    public Poly getZ() {
        return new Poly(new SquareType[][] {
                {SquareType.Z, SquareType.Z, SquareType.EMPTY},
                {SquareType.EMPTY, SquareType.Z, SquareType.Z},
                {SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY}
        });
    }
    public Poly getT() {
        return new Poly(new SquareType[][] {
                { SquareType.EMPTY, SquareType.T, SquareType.EMPTY},
                { SquareType.T, SquareType.T, SquareType.T},
                { SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY}
        });
    }
    public Poly getS() {
        return new Poly(new SquareType[][] {
                {SquareType.EMPTY, SquareType.S, SquareType.S},
                {SquareType.S, SquareType.S, SquareType.EMPTY},
                {SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY}
        });
    }
    public Poly getO() {
        return new Poly(new SquareType[][] {
            { SquareType.O, SquareType.O },
            { SquareType.O, SquareType.O }
        });
    }

    public Poly getI() {
        return new Poly(new SquareType[][] {
            { SquareType.EMPTY, SquareType.I, SquareType.EMPTY, SquareType.EMPTY },
            { SquareType.EMPTY, SquareType.I, SquareType.EMPTY, SquareType.EMPTY },
            { SquareType.EMPTY, SquareType.I, SquareType.EMPTY, SquareType.EMPTY },
            { SquareType.EMPTY, SquareType.I, SquareType.EMPTY, SquareType.EMPTY }
        });
    }
    public Poly getJ() {
        return new Poly(new SquareType[][] {
                {SquareType.J, SquareType.EMPTY, SquareType.EMPTY},
                {SquareType.J, SquareType.J, SquareType.J},
                {SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY}
        });
    }
    public Poly getL() {
        return new Poly(new SquareType[][] {
                {SquareType.EMPTY, SquareType.EMPTY, SquareType.L},
                {SquareType.L, SquareType.L, SquareType.L},
                {SquareType.EMPTY, SquareType.EMPTY, SquareType.EMPTY}
        });
    }
}
