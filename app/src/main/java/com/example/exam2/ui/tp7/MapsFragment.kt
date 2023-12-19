package com.example.exam2.ui.tp7

import android.content.Intent
import android.net.Uri
import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.exam2.R
import com.example.exam2.databinding.FragmentMapsBinding

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsFragment : Fragment(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: FragmentMapsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMapsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment =
            childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sousse and move the camera
        val sousse = LatLng(35.82, 10.64)
        mMap.addMarker(MarkerOptions().position(sousse).title("Marker in Sousse"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sousse))

        val tunis = LatLng(36.8, 10.17)
        mMap.addMarker(MarkerOptions().position(tunis).title("Marker in Tunis"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(tunis))

        mMap.mapType = GoogleMap.MAP_TYPE_NORMAL

        mMap.setOnMapClickListener { latLng ->
            // Display a Toast with the latitude and longitude
            Toast.makeText(
                requireContext(),
                "Latitude: ${latLng.latitude}, Longitude: ${latLng.longitude}",
                Toast.LENGTH_SHORT
            ).show()
        }

        mMap.setOnMarkerClickListener { marker ->
            val cityName = marker.title ?: "Unknown City"
            val wikipediaUrl = "https://fr.wikipedia.org/wiki/$cityName"

            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(wikipediaUrl))
            requireContext().startActivity(intent)

            true // Consume the click event
        }
    }
}