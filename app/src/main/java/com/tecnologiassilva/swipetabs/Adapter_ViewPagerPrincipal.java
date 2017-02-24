package com.tecnologiassilva.swipetabs;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.tecnologiassilva.swipetabs.fragments.Fragment_seccion1;
import com.tecnologiassilva.swipetabs.fragments.Fragment_seccion2;
import com.tecnologiassilva.swipetabs.fragments.Fragment_seccion3;
import com.tecnologiassilva.swipetabs.fragments.Fragment_seccion4;

/**
 * Created by Sergio on 8/4/2016.
 */

public class Adapter_ViewPagerPrincipal extends FragmentPagerAdapter {

    int numeroDeSecciones;
    private Context context;

    public Adapter_ViewPagerPrincipal(FragmentManager fm, int numeroDeSeciones,Context context) {

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
                return new Fragment_seccion1();

            case 1:
                return new Fragment_seccion2();

            case 2:
                return new Fragment_seccion3();

            case 3:
                return new Fragment_seccion4();


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
                return "Poplular";
            case 1:
                return "Ranking";
            case 2:
                return "Materia";

            case 3:
                return "Pre Horario";
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
