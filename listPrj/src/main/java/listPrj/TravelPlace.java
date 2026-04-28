package listPrj;

public class TravelPlace {
    private int id;
    private double latitude;
    private double longitude;
    private String content;

    public TravelPlace(int id, double latitude, double longitude, String content) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.content = content;
    }

    // Getter & Setter
    public int getId() { return id; }
    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }
    public String getContent() { return content; }

    public void setId(int id) { this.id = id; }
    public void setLatitude(double latitude) { this.latitude = latitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }
    public void setContent(String content) { this.content = content; }

	@Override
	public String toString() {
		return "TravelPlace [id=" + id + ", latitude=" + latitude + ", longitude=" + longitude + ", content=" + content
				+ "]";
	}
    
    
    
}
