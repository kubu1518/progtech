package Model;

public class Location {
    private int LocId;
    private String LocName;
    private String longitude;
    private String latitude;
    
    
	public Location(int locId, String locName, String longitude,
			String latitude) {
		super();
		LocId = locId;
		LocName = locName;
		this.longitude = longitude;
		this.latitude = latitude;
	}


	public int getLocId() {
		return LocId;
	}


	public String getLocName() {
		return LocName;
	}


	public String getLongitude() {
		return longitude;
	}


	public String getLatitude() {
		return latitude;
	}


	@Override
	public String toString() {
		return LocName;
	}
    
    
	
    
    
 }



