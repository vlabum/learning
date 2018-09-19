package ru.vlabum.se.homework;

/**
 *
 * 2. Добавить класс Team, который будет содержать название команды, массив из четырех участников
 * (в конструкторе можно сразу указыватьвсех участников ), метод для вывода информации о членах команды,
 * прошедших дистанцию, метод вывода информации обо всех членах команды.
 */

public class Team {

    private Player[] players;
    public Player[] getPlayers() {
        return players;
    }

    private String nameTeam;

    /**
     * Инициация команды
     * @param   nameTeam
     *          имя команды
     * @param   players
     *          массив участников, не ограничиваю четырьмя участниками
     */
    public Team(String nameTeam, Player[] players) {
        this.nameTeam = nameTeam;
        this.players = players;
    }


    /**
     * Выводим информацию обо всех членах команды
     */
    public void printTeam() {
        System.out.println("Команда " + nameTeam + ":");
        for (Player p : players) {
            System.out.println(p);
        }
    }

    /**
     * Выводим информацию об игроках, прошедших дистанцию
     */
    public void printDoItPlayers() {
        for (Player p : players) {
            if (p.getIsDoIt())
                System.out.println(p);
        }
    }
}
