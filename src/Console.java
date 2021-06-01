import java.io.IOException;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {
    static PremierLeagueManager premierLeagueManager = new PremierLeagueManager();

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        int userIn = 0;

        System.out.println("WELCOME TO PREMIER LEAGUE!");

        do {
            try{
                System.out.println("1. Add a new Club\n2.Add a new match\n3. Delete a Club\n4. Print statistics" +
                        "\n5. Print  Premier League Table\n6. Save file\n7. read file");
                System.out.println("Type in the required number or -1 to exit: ");
                System.out.println("____________________________________________");
                Scanner in = new Scanner(System.in);
                userIn = in.nextInt();

                if (userIn==1){addClub();}
                else if (userIn==2){ ADD_Played_Match();}
                else if (userIn==3){ delclub();}
                else if (userIn==4){
                    printstat();}
               else if (userIn==5){printtable();}
               else if (userIn==6){saveFile();}
               else if (userIn==7){readFile();}
                else if (userIn==8){
                   GUI.main(args);
                    break;
                }
                else if (userIn!=-1){throw new IllegalArgumentException();}
            }
            catch (IllegalArgumentException num){
                System.out.println("Please select one from the numbers mentioned above.");
            }
            catch (InputMismatchException letterIn){
                System.out.println("Only the above given integers allowed!");
            }

        }
        while (userIn != -1);
        System.exit(-1);
    }

    private static void ADD_Played_Match() {
        Scanner add_match = new Scanner(System.in);
        System.out.println("team 1 name");
        String name = add_match.next();
        System.out.println("team 2 name");
        String name2 = add_match.next();
        System.out.println("team 1 goals");
        int goals1 = add_match.nextInt();
        System.out.println("team 2 goals");
        int goals2 = add_match.nextInt();
        System.out.println("Day");
        int date = add_match.nextInt();
        System.out.println("Month");
        int Month = add_match.nextInt();
        System.out.println("Year");
        int Year = add_match.nextInt();

        Date date1 = new Date(date,Month,Year);
        Match match = new Match(name,name2,goals1,goals2,date1);
        premierLeagueManager.ADD_Played_Match(match);



    }


    private static void addClub() {
        System.out.println("Select the club Type: ");
        System.out.println("1. Football Club = 1 \n2.  University football club = 2\n3.  School football club = 3 ");
        System.out.print("Please Select one of the given numbers above: ");
        Scanner intIn = new Scanner(System.in);
        Scanner fclubIn = new Scanner(System.in);
        int type = intIn.nextInt();
        System.out.print("Enter the Foot ball Club Name: ");
        String FootballClub_Name = fclubIn.next();

        System.out.print("Enter the location of the club: ");
        String FootballClub_Location = fclubIn.next();

        System.out.println("Enter the sport club id: ");
        int FootballClub_id = fclubIn.nextInt();
        System.out.println("Enter the num_of_wins: ");
        int FootballClub_num_of_wins = fclubIn.nextInt();
        System.out.println("Enter the num_of_draws: ");
        int FootballClub_num_of_draws = fclubIn.nextInt();
        System.out.println("Enter the num_of_defeats: ");
        int FootballClub_num_of_defeats = fclubIn.nextInt();
        System.out.println("Enter the num_of_Goals_Received: ");
        int FootballClub_num_of_Goals_Received = fclubIn.nextInt();
        System.out.println("Enter the num_of_Goals_Scored: ");
        int FootballClub_num_of_Goals_Scored = fclubIn.nextInt();

        System.out.println("Enter the num_of_Matches: ");
        int FootballClub_num_of_Matches = fclubIn.nextInt();

        FootballClub newFootBallClub = null;
        University_Football_Club university_football_club = null;
        SportsClub sportsClub = null;
        switch (type){
            case 1:


                 sportsClub = new FootballClub(FootballClub_Name,FootballClub_Location,FootballClub_id,FootballClub_num_of_wins,FootballClub_num_of_draws,FootballClub_num_of_defeats,FootballClub_num_of_Goals_Received,FootballClub_num_of_Goals_Scored,FootballClub_num_of_Matches);

                break;
            case 2:
                Scanner uniIn = new Scanner(System.in);
                System.out.print("Enter the University Foot ball Club Name: ");
                String University_Name = uniIn.next();

                sportsClub = new University_Football_Club(FootballClub_Name,  FootballClub_Location,   FootballClub_id, FootballClub_num_of_wins,FootballClub_num_of_draws,FootballClub_num_of_defeats,FootballClub_num_of_Goals_Received,  FootballClub_num_of_Goals_Scored,FootballClub_num_of_Matches,University_Name);

                break;
            case 3:
                Scanner schIn = new Scanner(System.in);
                System.out.print("Enter the School Foot ball Club Name: ");
                String School_Name = schIn.next();
                sportsClub = new School_Football_Club(FootballClub_Name,FootballClub_Location,FootballClub_id,FootballClub_num_of_wins, FootballClub_num_of_draws,FootballClub_num_of_defeats,FootballClub_num_of_Goals_Received,FootballClub_num_of_Goals_Scored , FootballClub_num_of_Matches,School_Name);


                break;
        }
        premierLeagueManager.addNewFootBallClub((FootballClub) sportsClub);


    }

    private static void delclub() {
        Scanner del = new Scanner(System.in);
        System.out.println("Enter club name to delete");
        String name = del.next();
        premierLeagueManager.deleteFootballClub(name);
    }
    private static void printstat() {
        Scanner statisticprint = new Scanner(System.in);
        System.out.println("Enter club name to show statistics");
        String stat = statisticprint.next();
        premierLeagueManager.clubStatistics(stat);
    }
    private static void printtable() {

        premierLeagueManager.displayPremierLeagueTable();
    }
    private static void saveFile() throws IOException {
        premierLeagueManager.write_list();
    }
    private static void readFile() throws IOException, ClassNotFoundException {
        premierLeagueManager.readFile();
    }



}
