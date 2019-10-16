package arena;

public class Weapon {
    private int size;
    private int solidity;
    private int sharpness;

    public Weapon(int size, int solidity, int sharpness) {
        this.size = size;
        this.solidity = solidity;
        this.sharpness = sharpness;
    }

    public int getSize() {
        return size;
    }

    public int getSolidity() {
        return solidity;
    }

    public int getSharpness() {
        return sharpness;
    }
}
