package ru.vlabum.se.homework;

public class Player {

    private int maxDistance;
    public int getMaxDistance() {
        return maxDistance;
    }

    private String namePlayer;
    public String getNamePlayer() {
        return namePlayer;
    }

    private boolean isDoIt = false;
    public boolean getIsDoIt() {
        return isDoIt;
    }
    public void setDoIt(boolean isDoIt) {
        this.isDoIt = isDoIt;
    }

    /**
     * Игроки создаются с разбегом возможностей по дистанции от 2000 (условных метров), до 4000
     * @param   namePlayer
     *          Имя игрока
     */
    public Player(String namePlayer) {
        this.namePlayer = namePlayer;
        maxDistance = 2000 + (int)(Math.random() * 2000);
    }

    @Override
    public String toString() {
        return namePlayer + ", предельная дистанция: " + maxDistance;
    }

    public void doIt(int len) {
        this.isDoIt = (len <= maxDistance);
    }
}
