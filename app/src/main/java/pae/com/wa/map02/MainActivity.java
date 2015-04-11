package pae.com.wa.map02;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MainActivity extends ActionBarActivity {
    private static final LatLng Changmai=new LatLng(18.701224,98.789770);
    private static final LatLng Phuket= new LatLng(7.966598,98.359929);
    private static final LatLng Chonburi= new LatLng(13.357881, 100.998519);
    private static final LatLng Phanut= new LatLng(13.451984, 101.177313);
    private GoogleMap map;

    private void addMaker(){
        map.addMarker(new MarkerOptions()
        .position(Phanut)
                .title(getString(R.string.phanut_title))
                .snippet(getString(R.string.phanut_snippet))

                .icon(BitmapDescriptorFactory.fromResource(R.drawable.wat)));

        map.addMarker(new MarkerOptions()
                        .position(Chonburi)
                        .title(getString(R.string.chon_title))
                        .snippet(getString(R.string.chon_snippet))
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
        );


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MapFragment mapFragment = (MapFragment)getFragmentManager().findFragmentById(R.id.map);
        map = mapFragment.getMap();

        CameraPosition cameraPhanus = new CameraPosition.Builder()
                .target(Phanut)
                .zoom(10)
                .bearing(0)
                .tilt(0)
                .build();
        map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPhanus));
        addMaker();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.


        //noinspection SimplifiableIfStatement
       switch(item.getItemId()){
           case R.id.chiangmai_menu:
               map.moveCamera(CameraUpdateFactory.newLatLngZoom(Changmai,15));
               map.animateCamera(CameraUpdateFactory.zoomTo(10),2000,null);
               return true;
           case R.id.phuket_menu:
               CameraPosition cameraPosition = new CameraPosition.Builder()
                       .target(Phuket)
                       .zoom(15)
                       .bearing(270)
                       .tilt(30)
                       .build();
               map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
               return true;
           case R.id.Phanus_menu:
               CameraPosition cameraPhanus = new CameraPosition.Builder()
                       .target(Phanut)
                       .zoom(10)
                       .bearing(0)
                       .tilt(0)
                       .build();
               map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPhanus));
               addMaker();
           default:
               return super.onOptionsItemSelected(item);

       }


    }

}
