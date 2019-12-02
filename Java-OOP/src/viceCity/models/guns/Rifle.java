package viceCity.models.guns;

public class Rifle extends BaseGun {
    private static final int TOTAL_BULLETS = 500;
    private static final int BULLETS_PER_BARREL = 50;
    private static final int SHOOTING_BULLETS = 5;

    public Rifle(String name) {
        super(name, BULLETS_PER_BARREL, TOTAL_BULLETS);
    }

    @Override
    public int fire() {
        if (super.barrelIsEmpty()) {
            rechargeGun();
        }
        super.setBulletsPerBarrel(super.getBulletsPerBarrel() - SHOOTING_BULLETS);
        return SHOOTING_BULLETS;
    }

    @Override
    protected void rechargeGun() {
//        super.setTotalBullets(super.getTotalBullets() - BULLETS_PER_BARREL);
        super.setBulletsPerBarrel(BULLETS_PER_BARREL);
    }
}
