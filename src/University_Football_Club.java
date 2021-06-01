import java.io.Serializable;
import java.util.Objects;

	public class University_Football_Club  extends FootballClub implements Serializable {
    		private String University_Name;


    		public University_Football_Club(){

    		}

		public University_Football_Club(String Name_of_Club, String Location_of_Club,  int sport_clubID, int num_of_wins, int num_of_draws, int num_of_defeats, int num_of_Goals_Received, int num_of_Goals_Scored,  int num_of_Matches, String university_Name) {
			super(Name_of_Club, Location_of_Club,  sport_clubID, num_of_wins, num_of_draws, num_of_defeats, num_of_Goals_Received, num_of_Goals_Scored, num_of_Matches);
			University_Name = university_Name;
		}


		public String getUniversity_Name() {
			return University_Name;
		}

		public void setUniversity_Name(String university_Name) {
			University_Name = university_Name;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			if (!super.equals(o)) return false;
			University_Football_Club that = (University_Football_Club) o;
			return Objects.equals(University_Name, that.University_Name);
		}

		@Override
		public int hashCode() {
			return Objects.hash(super.hashCode(), University_Name);
		}

		@Override
		public String toString() {
			return "University_Football_Club{" +
					"University_Name='" + University_Name + '\'' +
					'}';
		}
	}
