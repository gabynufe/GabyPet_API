package com.gendigital.gabypets.vistas;

import com.gendigital.gabypets.adaptadores.PerfilAdapter;
import com.gendigital.gabypets.db_modelo.PerfilInfo;

import java.util.ArrayList;

/**
 * Created by Gaby on 07/07/2016.
 */
public interface IPerfilFragment {

    //public void onResume();

    public void generarLayout();

    public PerfilAdapter crearAdaptador(ArrayList<PerfilInfo> listaPerfil);

    public void inicializarAdaptadorRV(PerfilAdapter adaptador);
}
