
package ohtu;

public class Player {
    private String name;
    private String nationality;
    private int assists;
    private int goals;
    private int penalties;
    private String team;
    private int games;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public String getNationality() {
        return nationality;
    }
    public int getScore() {
        return goals + assists;
    }

    @Override
    public String toString() {
        //return String.join(", ", nationality, name, team, "goals: " + goals, "assists: " + assists, "penalties: " + penalties, "games: " + games);
        return String.join("\t", team, goals + " + " + assists + "", " = " + getScore());
    }
      
}
