import java.io.Serializable;

public abstract class SportsClub implements Serializable {

    private String Name_of_Club;
    private   String Location_of_Club;
    private int Points;
    private int sport_clubID;

    	public SportsClub() {

    }
    	public SportsClub (String Name_of_Club, String Location_of_Club,  int sport_clubID){
        this.Location_of_Club = Location_of_Club;
        this.Name_of_Club= Name_of_Club;

        this.sport_clubID = sport_clubID;
    }
        public abstract int points_cal();

        public String getName_of_Club() { return Name_of_Club; }

        public String getLocation_of_Club() { return Location_of_Club; }

        public int getSport_clubID() { return sport_clubID; }


    public void setName_of_Club(String name_of_Club) {
        this.Name_of_Club = name_of_Club;
    }

    public void setLocation_of_Club(String location_of_Club) {
            this.Location_of_Club = location_of_Club; }

        public void setSport_clubID(int sport_clubID) {
            this.sport_clubID = sport_clubID; }

    @Override
    public String toString() {
        return "SportsClub{" +
                "Name_of_Club='" + Name_of_Club + '\'' +
                ", Location_of_Club='" + Location_of_Club + '\'' +
                ", Points=" + Points +
                ", sport_clubID=" + sport_clubID +
                '}';
    }
}
