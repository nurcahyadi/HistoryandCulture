package com.example.android.portfolio.BatikSurabaya;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.portfolio.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentInfoBatikmapsSurabaya3 extends Fragment implements OnMapReadyCallback {


    public FragmentInfoBatikmapsSurabaya3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info_batikmaps_jakarta1, container, false);
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {

        LatLng marker = new LatLng(-7.250445, 112.768845);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker,12));
        googleMap.addMarker(new MarkerOptions().title("Surabaya").position(marker));

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment fragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        fragment.getMapAsync(this);
    }

}
