import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class PremierLeagueManager implements LeagueManager {
    
    ArrayList<FootballClub> Premier_league_football_club_list = new ArrayList<>();
    ArrayList<Match> Premier_league_match_list = new ArrayList<>();
    File file1 = new File ("Premier_league_List1.txt");
    File file2 = new File ("Premier_league_List2.txt");

    @Override
    public void write_list() throws IOException {
        FileOutputStream f_out = new FileOutputStream("Premier_league_List1.txt");
        ObjectOutputStream o = new ObjectOutputStream(f_out);

        for (SportsClub sportsClub :Premier_league_football_club_list){
            System.out.println(sportsClub);
            o.writeObject(sportsClub);
        }
        o.flush();
        f_out.close();
        o.close();

    }
    @Override
    public void readFile() throws IOException, ClassNotFoundException{

        FileInputStream f_input = new FileInputStream("Premier_league_List1.txt");
        ObjectInputStream o_int = new ObjectInputStream(f_input);

        for (; ;){
            try {
                FootballClub sportsClub = (FootballClub) o_int.readObject();
                Premier_league_football_club_list.add(sportsClub);
                System.out.println(sportsClub);

            }catch (EOFException e){
                break;
            }
        }
    }
    @Override
    public void write_data_of_match()throws IOException{
        FileOutputStream m_input_Str = new FileOutputStream("Premier_league_List2.txt");
        ObjectOutputStream m_output_str = new ObjectOutputStream(m_input_Str);
        for  (Match match :Premier_league_match_list ) {
            m_output_str.writeObject(match);
        }
        m_output_str.flush();
        m_output_str.close();
        m_input_Str.close();
    }
    @Override
    public void read_data_of_match()throws IOException,ClassNotFoundException{
        FileInputStream fis = new FileInputStream("Premier_league_List2.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        for (; ;){
            try {
                Match match = (Match) ois.readObject();
                Premier_league_match_list.add(match);
            }
            catch (EOFException e){
                break;
            }
        }
    }
    @Override
    public void ADD_Played_Match(Match newMatch) {
        Premier_league_match_list.add(newMatch);
        FootballClub team1 = null ;
        FootballClub team2 = null ;
        for (FootballClub footballClub : Premier_league_football_club_list){
            if (footballClub.getName_of_Club().equals(newMatch.getTeam_1_Name())){
                team1 = footballClub;
            }else if (footballClub.getName_of_Club().equals(newMatch.getTeam_2_Name())){
                team2 = footballClub;
            }
        }
        if (newMatch.getTeam_1_goals()>newMatch.getTeam_2_goals()){
            team1.setNum_of_wins(team1.getNum_of_wins()+1);
            team2.setNum_of_defeats(team2.getNum_of_defeats()+1);
            team1.setNum_of_Goals_Received(team1.getNum_of_Goals_Received()+newMatch.getTeam_2_goals());
            team1.setNum_of_Goals_Scored(team1.getNum_of_Goals_Scored()+newMatch.getTeam_1_goals());
            team2.setNum_of_Goals_Received(team2.getNum_of_Goals_Received()+newMatch.getTeam_1_goals());
            team2.setNum_of_Goals_Scored(team2.getNum_of_Goals_Scored()+newMatch.getTeam_2_goals());
            team1.setNum_of_Matches(team1.getNum_of_Matches()+1);
            team2.setNum_of_Matches(team2.getNum_of_Matches()+1);
            team1.points_cal();
        } else if (newMatch.getTeam_2_goals()>newMatch.getTeam_1_goals()){
            team2.setNum_of_wins(team2.getNum_of_wins()+1);
            team1.setNum_of_defeats(team1.getNum_of_defeats()+1);
            team2.setNum_of_Goals_Received(team2.getNum_of_Goals_Received()+newMatch.getTeam_1_goals());
            team1.setNum_of_Goals_Scored(team2.getNum_of_Goals_Scored()+newMatch.getTeam_2_goals());
            team1.setNum_of_Goals_Received(team1.getNum_of_Goals_Received()+newMatch.getTeam_2_goals());
            team2.setNum_of_Goals_Scored(team2.getNum_of_Goals_Scored()+newMatch.getTeam_2_goals());
            team1.setNum_of_Matches(team1.getNum_of_Matches()+1);
            team2.setNum_of_Matches(team2.getNum_of_Matches()+1);
            team2.points_cal();
        } else {
            team1.setNum_of_draws(team1.getNum_of_draws()+1);
            team1.setNum_of_Goals_Received(team1.getNum_of_Goals_Received()+newMatch.getTeam_2_goals());
            team1.setNum_of_Goals_Scored(team1.getNum_of_Goals_Scored()+newMatch.getTeam_1_goals());
            team1.points_cal();
            team1.setNum_of_Matches(team1.getNum_of_Matches()+1);
            team2.setNum_of_draws(team2.getNum_of_draws()+1);
            team2.setNum_of_Goals_Received(team2.getNum_of_Goals_Received()+newMatch.getTeam_1_goals());
            team2.setNum_of_Goals_Scored(team2.getNum_of_Goals_Scored()+newMatch.getTeam_2_goals());
            team2.points_cal();
            team2.setNum_of_Matches(team2.getNum_of_Matches()+1);
        }
    }



    @Override
    public void addNewFootBallClub(FootballClub footballClub) {
        Premier_league_football_club_list.add(footballClub);
        System.out.println("Football club added successfully");

    }

    @Override
    public void deleteFootballClub(String FootballClub_Name) {
        boolean deletionSuccessful = false;
        System.out.println("--------------------------------------------");
        //  Traverse through the Arraylist and delete the record if it matches the given input
        SportsClub toBeRemoved = null;
        for (SportsClub eachRecord : Premier_league_football_club_list) {

            if (eachRecord.getName_of_Club().equals(FootballClub_Name)) {

                System.out.println(" deletion successful.");


                //Premier_league_football_club_list.remove(eachRecord);
                toBeRemoved = eachRecord;
                deletionSuccessful = true;
            }
        }
        Premier_league_football_club_list.remove(toBeRemoved);
        //  Displays this message if the given input was not found in the DB
        if (!deletionSuccessful) {
            System.out.println("Given name could not be found.");
        }
        System.out.println("--------------------------------------------");


    }

    @Override
    public void clubStatistics(String FootballClub_Name) {
        System.out.println("__________________________________");
        SportsClub chosenClub = null;
        for (SportsClub eachRecord : Premier_league_football_club_list) {
            if (eachRecord.getName_of_Club().equals(FootballClub_Name)) {
                chosenClub = eachRecord;
                System.out.println(chosenClub);
            }

        }

    }


    @Override
    public void displayPremierLeagueTable() {
        Collections.sort(Premier_league_football_club_list, Collections.reverseOrder());
        System.out.println("________________________________________________________________________________________________________________________________________________________________________________________");
        System.out.printf("%15s %15s %20s %15s %15s %20s %25s %20s %15s %15s ","Name_of_club","sport_clubID","Location_of_club","Num_of_wins", "Num_of_draws", "Num_of_defeats", "Num_of_Goals_Received", "Num_of_Goals_Scored", "Num_of_points","Num_of_Matches");
        System.out.println();
        for (FootballClub eachRecord : Premier_league_football_club_list) {
            System.out.println("________________________________________________________________________________________________________________________________________________________________________________________");
            System.out.format("%10s %15s %15s %20s %15s %20s %20s %25s %15s %15s ",eachRecord.getName_of_Club() , eachRecord.getSport_clubID() , eachRecord.getLocation_of_Club() ,
                    eachRecord.getNum_of_wins() , eachRecord.getNum_of_draws()  , eachRecord.getNum_of_defeats() , eachRecord.getNum_of_Goals_Received()  ,
                    eachRecord.getNum_of_Goals_Scored() , eachRecord.points_cal() , eachRecord.getNum_of_Matches());
            System.out.println();
        }
    }


}


