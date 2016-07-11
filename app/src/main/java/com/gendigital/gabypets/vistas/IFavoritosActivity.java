package com.gendigital.gabypets.vistas;

import com.gendigital.gabypets.adaptadores.FavoritosAdapter;
import com.gendigital.gabypets.db_modelo.PetInfo;

import java.util.ArrayList;

/**
 * Created by Gaby on 07/07/2016.
 */
public interface IFavoritosActivity {
    public void generarLayoutVertical();

    public FavoritosAdapter crearAdaptador(ArrayList<PetInfo> listaPets);

    public void inicializarAdaptadorRV(FavoritosAdapter adaptador);
}
