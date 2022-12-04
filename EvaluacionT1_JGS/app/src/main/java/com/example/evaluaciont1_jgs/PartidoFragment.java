package com.example.evaluaciont1_jgs;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PartidoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PartidoFragment extends Fragment {




    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "fecha";
    private static final String ARG_PARAM2 = "fase";
    private static final String ARG_PARAM3 = "pais1";
    private static final String ARG_PARAM4 = "golesPais1";
    private static final String ARG_PARAM5 = "pais2";
    private static final String ARG_PARAM6 = "golesPais2";

    // TODO: Rename and change types of parameters
    private static String fecha;
    private static String fase;
    private static String pais1;
    private static String golesPais1;
    private static String pais2;
    private static String golesPais2;

/*
    TextView tvFecha;
    TextView tvFase;
    TextView tvPais1;
    TextView tvGolesPais1;
    TextView tvPais2;
    TextView tvGolesPais2;
*/
    public PartidoFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static PartidoFragment newInstance(String fecha, String fase,String pais1, int golesPais1 ,String pais2, int golesPais2) {
        PartidoFragment fragment = new PartidoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, fecha);
        args.putString(ARG_PARAM2, fase);
        args.putString(ARG_PARAM3, pais1);
        args.putInt(ARG_PARAM4, golesPais1);
        args.putString(ARG_PARAM5, pais2);
        args.putInt(ARG_PARAM6, (golesPais2));
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            fecha = getArguments().getString(ARG_PARAM1);
            fase = getArguments().getString(ARG_PARAM2);
            pais1 = getArguments().getString(ARG_PARAM3);
            golesPais1 = String.valueOf(getArguments().getInt(ARG_PARAM4));
            pais2 = getArguments().getString(ARG_PARAM5);
            golesPais2 = String.valueOf(getArguments().getInt(ARG_PARAM6));
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_partido, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        ((TextView) view.findViewById(R.id.fechaFragment)).setText(fecha);
        ((TextView) view.findViewById(R.id.faseFragment)).setText(fase);
        ((TextView) view.findViewById(R.id.equipo1Fragment)).setText(pais1);
        ((TextView) view.findViewById(R.id.golesEquipo1Fragment)).setText(golesPais1);
        ((TextView) view.findViewById(R.id.equipo2Fragment)).setText(pais2);
        ((TextView) view.findViewById(R.id.golesEquipo2Fragment)).setText(golesPais2);
        
        /*

        De esta forma no funciona
        tvFecha.findViewById(R.id.fechaFragment);
        tvFase.findViewById(R.id.faseFragment);
        tvPais1.findViewById(R.id.equipo1Fragment);
        tvGolesPais1.findViewById(R.id.golesEquipo1Fragment);
        tvPais2.findViewById(R.id.equipo2Fragment);
        tvGolesPais2.findViewById(R.id.golesEquipo2Fragment);


        tvFecha.setText(fecha);
        tvFase.setText(fase);
        tvPais1.setText(pais1);
        tvGolesPais1.setText(golesPais1);
        tvPais2.setText(pais2);
        tvGolesPais2.setText(golesPais2);


         */
    }
}