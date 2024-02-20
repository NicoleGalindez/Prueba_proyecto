package com.example.pruebaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.pruebaapp.databinding.ActivityMapsBinding
import com.google.android.gms.maps.model.LatLngBounds

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    private var latitud:Double = 0.0
    private var longitud:Double = 0.0
    private var title:String = "title"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        latitud = intent.getDoubleExtra("latitud",0.0)
        longitud = intent.getDoubleExtra("longitud",0.0)
        title = intent.getStringExtra("title").toString()





        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        //val cualquierLugar = LatLng(latitud,longitud)
       // mMap.addMarker(MarkerOptions().position(cualquierLugar).title(title))
        //val zoom = 15.0f
        //mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(cualquierLugar,zoom))

        val sydney = LatLng(38.8644000, -5.6174400)
        mMap.addMarker(MarkerOptions().position(sydney).title("sales desde campanario"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))

        val sydney2 = LatLng(2.4819705,  -76.5646031)
        mMap.addMarker(MarkerOptions().position(sydney2).title("estas pasando por la empresa de postobon "))



        val sydney3 = LatLng(2.4832482, -76.56177339999999) // Reemplazar latitud2 y longitud2 con las coordenadas de la segunda ubicación adicional
        mMap.addMarker(MarkerOptions().position(sydney3).title("estas pasando por el sena norte, ya casi llegas "))

        val sydney4 = LatLng(2.4779397, -76.5601072) // Reemplazar latitud2 y longitud2 con las coordenadas de la segunda ubicación adicional
        mMap.addMarker(MarkerOptions().position(sydney3).title("llegaste a tu destino -> La Paz"))



        val builder = LatLngBounds.Builder()
        builder.include(sydney)
        builder.include(sydney2)
        builder.include(sydney3)
        builder.include((sydney4))
        val bounds = builder.build()
        mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, 100))
    }
    }
