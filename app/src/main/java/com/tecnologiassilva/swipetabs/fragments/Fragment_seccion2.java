package com.tecnologiassilva.swipetabs.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tecnologiassilva.swipetabs.R;
import com.tecnologiassilva.swipetabs.Recycler.RecyclerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_seccion2 extends Fragment {


    public Fragment_seccion2() {
        // Required empty public constructor
    }


    private RecyclerAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_seecion2, container, false);


        //Capture the recyclerView

        RecyclerView recyclerView = (RecyclerView)
                view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        recyclerView.setHasFixedSize(true);

        //Create the Adapter
        mAdapter = new RecyclerAdapter(this.getContext(),recyclerView);

        //Binding
        recyclerView.setAdapter(mAdapter);


        return view;
    }

}
