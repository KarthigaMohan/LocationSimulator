package domain;


public record Location(double latitude, double longitude){
    public String getLocationString(){
        return latitude + "," + longitude;
    }
}