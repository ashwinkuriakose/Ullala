package com.example.ullala;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GenderFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GenderFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    public GenderFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GenderFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GenderFragment newInstance(String param1, String param2) {
        GenderFragment fragment = new GenderFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final Button btnMale,btnFemale;
        View view= inflater.inflate(R.layout.fragment_gender, container, false);
        btnMale=view.findViewById(R.id.btnMale);
        btnFemale=view.findViewById(R.id.btnFemale);

        btnMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnMale.setBackgroundColor(Color.RED);
                btnFemale.setBackground(getResources().getDrawable(R.drawable.text_input_bg));
            }
        });

        btnFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnFemale.setBackgroundColor(Color.RED);
                btnMale.setBackground(getResources().getDrawable(R.drawable.text_input_bg));
            }
        });

        return  view;

    }
}