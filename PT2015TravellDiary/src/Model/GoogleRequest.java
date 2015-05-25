package Model;

import com.google.maps.DirectionsApi;
import com.google.maps.DirectionsApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.DirectionsRoute;
import com.google.maps.model.Distance;
import com.google.maps.model.GeocodingResult;


public abstract class GoogleRequest {
     
	public static double[] getGeoCodeOfCity(String city){
		GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyAX_jIvr80zpJkNgrmdoimePB0BVzn3vRQ");
		GeocodingResult[] results = null;
		double[] tmp = new double[2];
		try {
			results = GeocodingApi.geocode(context,
			    city).await();
			tmp[0] = results[0].geometry.location.lng;
			tmp[1] = results[0].geometry.location.lat;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tmp;
	}
	
	public static long getDistanceBetweenCities(String city1, String city2){
		System.out.println("getdistance");
		GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyAX_jIvr80zpJkNgrmdoimePB0BVzn3vRQ");
		Distance dis = new Distance();
		DirectionsApiRequest re = DirectionsApi.getDirections(context, city1, city2);
		long meter = 0;
		DirectionsRoute[] result;
		try {
			result = re.await();
			meter = result[0].legs[0].distance.inMeters;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return meter;
	}
	
}
