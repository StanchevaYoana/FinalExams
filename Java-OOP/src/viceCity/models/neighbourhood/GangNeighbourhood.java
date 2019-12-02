package viceCity.models.neighbourhood;

import viceCity.models.guns.Gun;
import viceCity.models.players.Player;

import java.util.Collection;

public class GangNeighbourhood implements Neighbourhood {
    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {
        mainPlayerShooting(mainPlayer, civilPlayers);
        civilPlayersShooting(mainPlayer, civilPlayers);
    }

    private void civilPlayersShooting(Player mainPlayer, Collection<Player> civilPlayers) {
        for (Player civilPlayer : civilPlayers) {
            if (!civilPlayer.isAlive()) {
                continue;
            }

            for (Gun gun : civilPlayer.getGunRepository().getModels()) {
                while (mainPlayer.isAlive() && gun.canFire()) {
                    mainPlayer.takeLifePoints(gun.fire());
                }

                if (!mainPlayer.isAlive()) {
                    break;
                }
            }

            if (!mainPlayer.isAlive()) {
                break;
            }
        }

    }

    private void mainPlayerShooting(Player mainPlayer, Collection<Player> civilPlayers) {
        for (Player civilPlayer : civilPlayers) {
            for (Gun gun : mainPlayer.getGunRepository().getModels()) {

                while (civilPlayer.isAlive() && gun.canFire()) {
                    civilPlayer.takeLifePoints(gun.fire());
                }
                if (!civilPlayer.isAlive()) {
                    break;
                }
            }

        }
    }
}
