package Tests;

import MainLogic.Game;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @org.junit.jupiter.api.Test
    void getCurrentSpaceshipSelection() {
        assertNull(Game.instance().getCurrentSpaceshipSelection());
    }

    @org.junit.jupiter.api.Test
    void isReturnToShipSelection() {
    }

    @org.junit.jupiter.api.Test
    void setCurrentSpaceshipSelection() {
    }

    @org.junit.jupiter.api.Test
    void setReturnToShipSelection() {
    }

    @org.junit.jupiter.api.Test
    void getMainInput() {
        assertNotNull(Game.instance().getMainInput());
    }

    @org.junit.jupiter.api.Test
    void instance() {
        assertNotNull(Game.instance());
    }

    @org.junit.jupiter.api.Test
    void main() {

    }

    @org.junit.jupiter.api.Test
    void endGame() {
    }

    @org.junit.jupiter.api.Test
    void chooseSpaceship() {
    }

    @org.junit.jupiter.api.Test
    void cont() {
    }

    @org.junit.jupiter.api.Test
    void checkGameOverStatus() {
    }
}