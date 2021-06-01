import java.io.Serializable;
import java.util.Objects;

public class School_Football_Club extends FootballClub implements Serializable {
    	private String School_Name;




	public School_Football_Club(String school_Name) {
		School_Name = school_Name;
	}

	public School_Football_Club(String Name_of_Club, String Location_of_Club,  int sport_clubID, int num_of_wins, int num_of_draws, int num_of_defeats, int num_of_Goals_Received, int num_of_Goals_Scored, int num_of_Matches, String school_Name) {
		super(Name_of_Club, Location_of_Club,  sport_clubID, num_of_wins, num_of_draws, num_of_defeats, num_of_Goals_Received, num_of_Goals_Scored, num_of_Matches);
		School_Name = school_Name;
	}


	public String getSchool_Name() {
		return School_Name;
	}

	public void setSchool_Name(String school_Name) {
		School_Name = school_Name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		School_Football_Club that = (School_Football_Club) o;
		return Objects.equals(School_Name, that.School_Name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), School_Name);
	}

	@Override
	public String toString() {
		return "School_Football_Club{" +
				"School_Name='" + School_Name + '\'' +
				'}';
	}
}
