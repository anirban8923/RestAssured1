public class cricketers
{

    private String name;
    private String playingStyle;
    private int matches;

    private long  runs;
    private double averages ;

    public cricketers(String name, String playingStyle, int matches, long runs, double averages) {
        this.name = name;
        this.playingStyle = playingStyle;
        this.matches = matches;
        this.runs = runs;
        this.averages = averages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlayingStyle() {
        return playingStyle;
    }

    public void setPlayingStyle(String playingStyle) {
        this.playingStyle = playingStyle;
    }

    public int getMatches() {
        return matches;
    }

    public void setMatches(int matches) {
        this.matches = matches;
    }

    public long getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public double getAverages() {
        return averages;
    }

    public void setAverages(int averages) {
        this.averages = averages;
    }


}
