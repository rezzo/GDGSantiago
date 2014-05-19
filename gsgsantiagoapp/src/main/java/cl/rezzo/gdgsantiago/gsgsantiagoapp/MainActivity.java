package cl.rezzo.gdgsantiago.gsgsantiagoapp;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;


public class MainActivity extends Activity {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LocationManager milocManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        LocationListener milocListener = new MiLocationListener();
        milocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, milocListener);
    }

    public class MiLocationListener implements LocationListener{
        public void onLocationChanged(Location loc){
            Double latitude, longitude;
            latitude = loc.getLatitude();
            longitude = loc.getLongitude();
            String coordenadas = "Mis coordenadas son: " + "latitud = " + latitude + " longitud = " + longitude;
            Toast.makeText( getApplicationContext(),coordenadas,Toast.LENGTH_LONG).show();
        }

        public void onProviderDisabled(String provider){
            Toast.makeText( getApplicationContext(),"GPS desactivado :(",Toast.LENGTH_SHORT).show();
        }

        public void onProviderEnabled(String provider){
            Toast.makeText( getApplicationContext(),"GPS activo :)",Toast.LENGTH_SHORT).show();
        }

        public void onStatusChanged(String provider, int status, Bundle extras){
            Toast.makeText(getApplicationContext(), "oli", Toast.LENGTH_LONG).show();
        }
    }
}