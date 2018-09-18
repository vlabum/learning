package ru.vlabum.se.homework;

public class TestHomeWork1 {
    public static void main(String[] args) {

        Player[] players = new Player[4];
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player("Игрок " + i);
        }

        int[] relayRace = new int [3];
        for (int i = 0; i < relayRace.length; i++) {
            relayRace[i] = 1000;
        }

        Course c = new Course(relayRace);
        Team team = new Team("Mega", players);
        c.doIt(team);

        System.out.println("Состав команды:");
        team.printTeam();

        System.out.println("Прошли дистанцию:");
        team.printDoItPlayers();
    }
}
