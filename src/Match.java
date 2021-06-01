import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Match implements Serializable {
    private String Team_1_Name;
    private String Team_2_Name;
    private int Team_1_goals;
    private int Team_2_goals;
    private Date date;



    public Match(){

		}

	public Match(String team_1_Name, String team_2_Name, int team_1_goals, int team_2_goals, Date date) {
		Team_1_Name = team_1_Name;
		Team_2_Name = team_2_Name;
		Team_1_goals = team_1_goals;
		Team_2_goals = team_2_goals;
		this.date = date;
	}


	public String getTeam_1_Name() {
		return Team_1_Name;
	}

	public String getTeam_2_Name() {
		return Team_2_Name;
	}

	public int getTeam_1_goals() {
		return Team_1_goals;
	}

	public int getTeam_2_goals() {
		return Team_2_goals;
	}

	public Date getDate() {
		return date;
	}

	public void setTeam_1_Name(String team_1_Name) {
		Team_1_Name = team_1_Name;
	}

	public void setTeam_2_Name(String team_2_Name) {
		Team_2_Name = team_2_Name;
	}

	public void setTeam_1_goals(int team_1_goals) {
		Team_1_goals = team_1_goals;
	}

	public void setTeam_2_goals(int team_2_goals) {
		Team_2_goals = team_2_goals;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Match match = (Match) o;
		return Team_1_goals == match.Team_1_goals &&
				Team_2_goals == match.Team_2_goals &&
				Objects.equals(Team_1_Name, match.Team_1_Name) &&
				Objects.equals(Team_2_Name, match.Team_2_Name) &&
				Objects.equals(date, match.date);
	}

	@Override
	public int hashCode() {
		return Objects.hash(Team_1_Name, Team_2_Name, Team_1_goals, Team_2_goals, date);
	}

	@Override
	public String toString() {
		return "Match{" +
				"Team_1_Name='" + Team_1_Name + '\'' +
				", Team_2_Name='" + Team_2_Name + '\'' +
				", Team_1_goals=" + Team_1_goals +
				", Team_2_goals=" + Team_2_goals +
				", date=" + date +
				'}';
	}
}
