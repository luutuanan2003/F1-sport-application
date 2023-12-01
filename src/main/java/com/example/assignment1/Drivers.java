package com.example.assignment1;


public class Drivers {
    private String name;
    private int points;
    private String info;
    private String team;

    public Drivers(String name, int points, String info, String team) {
        this.name = name;
        this.points = points;
        this.info = info;
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public int getPoints() {
        return points;
    }

    public String getInfo() {
        return info;
    }
}
