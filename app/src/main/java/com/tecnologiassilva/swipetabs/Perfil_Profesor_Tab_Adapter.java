package com.tecnologiassilva.swipetabs;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.tecnologiassilva.swipetabs.fragments.Fragment_seccion1;
import com.tecnologiassilva.swipetabs.fragments.Fragment_seccion2;

/**
 * Created by Sergio on 8/8/2016.
 */

public class Perfil_Profesor_Tab_Adapter extends FragmentPagerAdapter {

    int numeroDeSecciones;
    private Context context;

    public Perfil_Profesor_Tab_Adapter(FragmentManager fm, int numeroDeSeciones, Context context) {

        super(fm);
        this.numeroDeSecciones= numeroDeSeciones;
        this.context = context;
    }

    /**
     * Return the Fragment associated with a specified position.
     *
     * @param position
     */
    @Override
    public Fragment getItem(int position) {

        // recibimos la posición por parámetro y en función de ella devolvemos el Fragment correspondiente a esa sección.
        switch (position) {

            case 0: // siempre empieza desde 0
                return new Fragment_seccion2();

            case 1:
                return new Fragment_seccion1();

            case 2:
                return  new Fragment_seccion2();

            // si la posición recibida no se corresponde a ninguna sección
            default:
                return null;
        }
    }


    @Override
    public CharSequence getPageTitle(int position) {

        // recibimos la posición por parámetro y en función de ella devolvemos el titulo correspondiente.
        switch (position) {

            case 0: // siempre empieza desde 0, la primera Tab es 0
                return "Comentarios";
            case 1:
                return "Preguntas";

            case 2:
                return "Materias";

            // si la posición recibida no se corresponde a ninguna sección
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return numeroDeSecciones;
    }
}
