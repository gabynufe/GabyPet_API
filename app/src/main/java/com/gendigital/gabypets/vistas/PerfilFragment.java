package com.gendigital.gabypets.vistas;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gendigital.gabypets.R;
import com.gendigital.gabypets.adaptadores.PerfilAdapter;
import com.gendigital.gabypets.db_modelo.CuentaInstagram;
import com.gendigital.gabypets.db_modelo.PerfilInfo;
import com.gendigital.gabypets.presentadores.IPerfilPresentador;
import com.gendigital.gabypets.presentadores.PerfilPresentador;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Gaby on 07/07/2016.
 */
public class PerfilFragment extends Fragment implements IPerfilFragment {
    private RecyclerView rvLista;
    private ImageView imgPerfil;
    private TextView tvNombrePerfil;
    private IPerfilPresentador iPresentador;
    private Activity activity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);
        activity = getActivity();

        rvLista = (RecyclerView) v.findViewById(R.id.rvListaPerfil);
        imgPerfil = (ImageView) v.findViewById(R.id.imgPerfil);
        tvNombrePerfil = (TextView) v.findViewById(R.id.tvNombrePerfil);
        iPresentador = new PerfilPresentador(this, getContext());
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (CuentaInstagram.userPerfil != CuentaInstagram.userSelected) {
            // refrescar fragment
            Log.d("MainActivity", "Cuanta seleccionada cambio: refrescando fragment");
            CuentaInstagram.userPerfil = CuentaInstagram.userSelected;
            iPresentador = new PerfilPresentador(this, getContext());
            //do the data changes. In this case, I am refreshing the arrayList cart_list and then calling the listview to refresh.
            //getCartData();
            //lv1.setAdapter(new custom_list_one(this.getActivity(),cart_list));
        }
    }

    @Override
    public void generarLayout() {
        GridLayoutManager glm = new GridLayoutManager(getActivity(),3);
        glm.setOrientation(GridLayoutManager.VERTICAL);
        rvLista.setLayoutManager(glm);
        Picasso.with(activity)
                .load(PerfilInfo.userPicture)
                .placeholder(R.drawable.gato)
                .into(imgPerfil);
        tvNombrePerfil.setText(PerfilInfo.userFullName);
    }

    @Override
    public PerfilAdapter crearAdaptador(ArrayList<PerfilInfo> listaPerfil) {
        PerfilAdapter adaptador = new PerfilAdapter(listaPerfil, getActivity()  );
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(PerfilAdapter adaptador) {
        rvLista.setAdapter(adaptador);
    }
}
