package Games;

public class Game {
    private final String title;
    private final String achievements;
    private final String info;
    private  final String technicalInfo;

    public Game(final String title, final String achievements, final String info, final String ti) {
        this.title = title;
        this.achievements = achievements;
        this.info = info;
        this.technicalInfo = ti;
    }

    public String getTitle() {
        return title;
    }

    public String getAchievements() {
        return achievements;
    }

    public String getInfo() {
        return info;
    }

    public String getTechnicalInfo() {
        return technicalInfo;
    }
}
