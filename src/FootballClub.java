import java.io.Serializable;
import java.util.Objects;

public class FootballClub extends SportsClub implements Serializable,Comparable <FootballClub>{

    private int Num_of_wins;
    private int Num_of_draws;
    private int Num_of_defeats;
    private int Num_of_Goals_Received;
    private int Num_of_Goals_Scored;



    private int Num_of_Matches;

    	public FootballClub(){

    	}

	@Override
	public int points_cal() {
    		int points = 3*Num_of_wins+1*Num_of_draws;
		return points;

	}

	public FootballClub(String Name_of_Club, String Location_of_Club,  int sport_clubID, int num_of_wins, int num_of_draws, int num_of_defeats, int num_of_Goals_Received, int num_of_Goals_Scored, int num_of_Matches) {
		super(Name_of_Club, Location_of_Club,  sport_clubID);
		Num_of_wins = num_of_wins;
		Num_of_draws = num_of_draws;
		Num_of_defeats = num_of_defeats;
		Num_of_Goals_Received = num_of_Goals_Received;
		Num_of_Goals_Scored = num_of_Goals_Scored;

		Num_of_Matches = num_of_Matches;
	}

	public int get_Goal_Deference(){
    		return  Num_of_Goals_Scored-Num_of_Goals_Received; //Get goal deference
	}
	//Getter methods


	public int getNum_of_wins() {
		return Num_of_wins;
	}

	public int getNum_of_draws() {
		return Num_of_draws;
	}

	public int getNum_of_defeats() {
		return Num_of_defeats;
	}

	public int getNum_of_Goals_Received() {
		return Num_of_Goals_Received;
	}

	public int getNum_of_Goals_Scored() {
		return Num_of_Goals_Scored;
	}


	public int getNum_of_Matches() {
		return Num_of_Matches;
	}


	//Setter methods



	public void setNum_of_wins(int num_of_wins) {
		Num_of_wins = num_of_wins;
	}

	public void setNum_of_draws(int num_of_draws) {
		Num_of_draws = num_of_draws;
	}

	public void setNum_of_defeats(int num_of_defeats) {
		Num_of_defeats = num_of_defeats;
	}

	public void setNum_of_Goals_Received(int num_of_Goals_Received) {
		Num_of_Goals_Received = num_of_Goals_Received;
	}

	public void setNum_of_Goals_Scored(int num_of_Goals_Scored) {
		Num_of_Goals_Scored = num_of_Goals_Scored;
	}


	public void setNum_of_Matches(int num_of_Matches) {
		Num_of_Matches = num_of_Matches;
	}


	//equals and hash code


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		FootballClub that = (FootballClub) o;
		return Num_of_wins == that.Num_of_wins &&
				Num_of_draws == that.Num_of_draws &&
				Num_of_defeats == that.Num_of_defeats &&
				Num_of_Goals_Received == that.Num_of_Goals_Received &&
				Num_of_Goals_Scored == that.Num_of_Goals_Scored &&
				Num_of_Matches == that.Num_of_Matches;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Num_of_wins, Num_of_draws, Num_of_defeats, Num_of_Goals_Received, Num_of_Goals_Scored, Num_of_Matches);
	}

	@Override
	public int compareTo(FootballClub ob2) {
		if (this.points_cal()!=ob2.points_cal()){
			if (this.points_cal()>ob2.points_cal()){
				return 1;
			}
			else {
				return -1;
			}
		}
		else {
			if (this.get_Goal_Deference()>this.get_Goal_Deference()){
				return 1;
			}
			else {
				return -1;
			}
		}
	}

	@Override
	public String toString() {
		return "FootballClub{" +
				"Name_of_Club=" +getName_of_Club()+ "Sport_clubID=" +getSport_clubID()+"Location_of_Club=" +getLocation_of_Club()+


				"Num_of_wins=" + Num_of_wins +
				", Num_of_draws=" + Num_of_draws +
				", Num_of_defeats=" + Num_of_defeats +
				", Num_of_Goals_Received=" + Num_of_Goals_Received +
				", Num_of_Goals_Scored=" + Num_of_Goals_Scored +
				", Num_of_Matches=" + Num_of_Matches +
				'}';
	}
}

