
package ohtu;

public class Player implements Comparable<Player> {
    private String name;
    private String team;
    private int goals;
    private int assists;
    private int penalties;
    private String nationality;
    private String birthday;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the team
     */
    public String getTeam() {
        return team;
    }

    /**
     * @param team the team to set
     */
    public void setTeam(String team) {
        this.team = team;
    }

    /**
     * @return the goals
     */
    public int getGoals() {
        return goals;
    }

    /**
     * @param goals the goals to set
     */
    public void setGoals(int goals) {
        this.goals = goals;
    }

    /**
     * @return the assists
     */
    public int getAssists() {
        return assists;
    }

    /**
     * @param assists the assists to set
     */
    public void setAssists(int assists) {
        this.assists = assists;
    }

    /**
     * @return the penalties
     */
    public int getPenalties() {
        return penalties;
    }

    /**
     * @param penalties the penalties to set
     */
    public void setPenalties(int penalties) {
        this.penalties = penalties;
    }

    /**
     * @return the nationality
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * @param nationality the nationality to set
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    /**
     * @return the birthday
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * @param birthday the birthday to set
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    
    public int getPoints() {
        return goals + assists;
    }

    @Override
    public String toString() {
        return String.format("%-20s", name) + " " + team + " " + String.format("%2d", goals) + " + " 
                + String.format("%2d", assists) + " = " + getPoints();
    }

    @Override
    public int compareTo(Player o) {
        return o.getPoints() - this.getPoints();
    }
      
}
