package blueOrigin;

import blueOrigin.Spaceship;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class SpaceshipTests {

    private static final String INVALID_SPACESHIP_NAME = "      ";
    private static final int DEFAULT_CAPACITY = 2;
    private static final String NAME = "APOLO";
    private Spaceship spaceship;

    @Test
    public void shouldReturnCorrectName() {
        this.spaceship = new Spaceship(NAME, DEFAULT_CAPACITY);
        assertEquals(NAME, spaceship.getName());
    }

    @Test(expected = NullPointerException.class)
    public void setInvalidSpaceShipName() {
        this.spaceship = new Spaceship(INVALID_SPACESHIP_NAME, DEFAULT_CAPACITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setInvalidSpaceshipCapacity() {
        this.spaceship = new Spaceship(NAME, -DEFAULT_CAPACITY);
    }

    @Test(expected = NullPointerException.class)
    public void setInvalidSpaceshipNameAndCapacity() {
        this.spaceship = new Spaceship(INVALID_SPACESHIP_NAME, -DEFAULT_CAPACITY);
    }

    @Test
    public void shouldReturnCorrectSpaceshipCapacity() {
        this.spaceship = new Spaceship(NAME, DEFAULT_CAPACITY);
        assertEquals(DEFAULT_CAPACITY, spaceship.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldAddAstronautOverCapacity(){

        this.spaceship = new Spaceship(NAME,DEFAULT_CAPACITY);
        this.spaceship.add(new Astronaut("Ivan", 5.2));
        this.spaceship.add(new Astronaut("Stamen", 0.2));
        this.spaceship.add( new Astronaut("Petur", 15.2));

    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldAddAstronautIfHeAlreadyExist(){
        this.spaceship = new Spaceship(NAME,DEFAULT_CAPACITY);
        this.spaceship.add(new Astronaut("Ivan", 5.2));
        this.spaceship.add(new Astronaut("Ivan", 5.2));
    }

    @Test
    public void shouldRemoveAstronautFromSpaceShip(){
        this.spaceship = new Spaceship(NAME,DEFAULT_CAPACITY);
        this.spaceship.add(new Astronaut("Ivan", 5.2));
        this.spaceship.add( new Astronaut("Petur", 15.2));

        this.spaceship.remove("Ivan");

        assertEquals(DEFAULT_CAPACITY - 1, spaceship.getCount());
    }
}
