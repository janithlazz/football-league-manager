import java.io.IOException;

public interface LeagueManager {
    void write_list() throws IOException;

    void readFile() throws IOException, ClassNotFoundException;


    void write_data_of_match()throws IOException;

    void read_data_of_match()throws IOException,ClassNotFoundException;

    void ADD_Played_Match(Match newMatch);

    public void addNewFootBallClub (FootballClub footballClub);
    public void deleteFootballClub (String FootballClub_Name);
    public void clubStatistics (String FootballClub_Name);
    public void displayPremierLeagueTable();
}
