package com.gendigital.gabypets.restAPI;

import com.gendigital.gabypets.db_modelo.PerfilInfo;

import java.util.ArrayList;

/**
 * Created by Gaby on 09/07/2016.
 */
public class API_model {
    ArrayList <PerfilInfo> listaInstagram;

    public ArrayList<PerfilInfo> getListaInstagram() {
        return listaInstagram;
    }

    public void setListaInstagram(ArrayList<PerfilInfo> listaInstagram) {
        this.listaInstagram = listaInstagram;
    }}
