package ru.vlabum.se.homework;

/**
 * 3. Добавить класс Course (полоса препятствий),
 * в котором будут находиться массив препятствий и метод,
 * который будет просить команду пройти всю полосу;
 */

public class Course {

    private int[] relayRace; // эстафета

    public Course(int[] relayRace) {
        this.relayRace = relayRace;
    }

    public void doIt(Team team) {
        for (Player p : team.getPlayers()) {
            int len = 0;
            for (int i = 0; i < relayRace.length; i++) {
                len += relayRace[i];
            }
            p.doIt(len);
        }
    }



}
