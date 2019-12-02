package viceCity.models.guns;

public abstract class BaseGun implements Gun {

    private  static final String TOTAL_BULLET_ERROR_MESSAGE = "Total bullets cannot be below zero!";
    private  static final String BULLETS_PER_BARREL_ERROR_MESSAGE = "Bullets cannot be below zero!";
    private  static final String NAME_ERROR_MESSAGE = "Name cannot be null or whitespace!";

    private String name;
    private int bulletsPerBarrel;
    private int totalBullets;

    public BaseGun(String name, int bulletsPerBarrel, int totalBullets) {
        setName(name);
        setBulletsPerBarrel(bulletsPerBarrel);
        setTotalBullets(totalBullets);
    }

    private void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new NullPointerException(NAME_ERROR_MESSAGE);
        }
        this.name = name;
    }

    protected void setBulletsPerBarrel(int bulletsPerBarrel) {
        if (bulletsPerBarrel < 0 ){
            throw new IllegalArgumentException(BULLETS_PER_BARREL_ERROR_MESSAGE);
        }
        this.bulletsPerBarrel = bulletsPerBarrel;
    }

    protected void setTotalBullets(int totalBullets) {
        if (totalBullets < 0){
            throw new IllegalArgumentException(TOTAL_BULLET_ERROR_MESSAGE);
        }
        this.totalBullets = totalBullets;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getBulletsPerBarrel() {
        return this.bulletsPerBarrel;
    }

    @Override
    public boolean canFire() {
        if (this.totalBullets == 0) {
            return bulletsPerBarrel != 0;
        }
        return true;
    }

    @Override
    public int getTotalBullets() {
        return this.totalBullets;
    }

    @Override
    public abstract int fire();
    protected abstract void rechargeGun();

    boolean barrelIsEmpty() {
        return this.bulletsPerBarrel == 0;
    }

}
