package com.example.myappprintemps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import Objetos.DiseñoFlores;
import Objetos.Flores;

public class CatalogoActivity extends AppCompatActivity {

    FrameLayout framearreglo1;
    Button btnverPrecios;
    Button btncerrararr, btnvc;
    ScrollView scrollcata;


    CheckBox unaDocena, dosDocena;
    Spinner spflores;
    Spinner spdiseño;
    TextView resultado;
    RatingBar rb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo);

        framearreglo1=(FrameLayout) findViewById(R.id.framearreglo1);
        btnverPrecios=(Button) findViewById(R.id.btnVerPrecios);

        scrollcata=(ScrollView)findViewById(R.id.scrollCata);
        btncerrararr=(Button) findViewById(R.id.btnCerrarFrame);
        btnvc=(Button) findViewById(R.id.btnvolvercatalago);

        spflores = (Spinner) findViewById(R.id.spflores);
        spdiseño = (Spinner) findViewById(R.id.spDiseño);
        unaDocena = (CheckBox) findViewById(R.id.unaDocena);
        dosDocena = (CheckBox) findViewById(R.id.dosDocenas);
        resultado = (TextView) findViewById(R.id.textresultado);
        rb = (RatingBar) findViewById(R.id.RB);

        //construyo objetos
        Flores flo = new Flores();
        DiseñoFlores dflo = new DiseñoFlores();

        //construyo arrayAdapter
        ArrayAdapter adaptFlores = new ArrayAdapter(this, android.R.layout.simple_list_item_1,flo.getTipos() );
        ArrayAdapter adaptDiseño = new ArrayAdapter(this, android.R.layout.simple_list_item_1,dflo.getTipos() );

        //la paso el adaptador a mi spinner
        spflores.setAdapter(adaptFlores);
        spdiseño.setAdapter(adaptDiseño);
    }

    public void calcular(View view) { //boton calcular
        Flores flo = new Flores();
        DiseñoFlores dflo = new DiseñoFlores();
        rb.setNumStars(5);

        ///// para arreglos/////7
        if (spdiseño.getSelectedItem() == dflo.getTipos()[0]) {  //arreglo

            if(spflores.getSelectedItem() == flo.getTipos()[0]){ //rosas
                if (unaDocena.isChecked() && dosDocena.isChecked()) { //si selciona los dos
                    resultado.setText("Por favor seleccione solo una cantidad de docenas");

                } else if(unaDocena.isChecked()) { //UnaDocena
                    resultado.setText("Costo de Arrego floral: " + dflo.getPrecios()[0] +"\n"+ "Costo de Rosas (c/u) es: " + flo.getPrecio()[0] +"\n"+ "El total es de: "+ flo.calcular_PrecioTotal1Docena(flo.getPrecio()[0],dflo.getPrecios()[0]));
                    rb.setRating(3);//pinta estrellas
                }else if(dosDocena.isChecked()) { //DosDocena
                    resultado.setText("Costo de Arrego floral: " + dflo.getPrecios()[0] +"\n"+ "Costo de Rosas (c/u) es: " + flo.getPrecio()[0] +"\n"+ "El total es de: "+ flo.calcular_PrecioTotal2Docena(flo.getPrecio()[0],dflo.getPrecios()[0]));
                    rb.setRating(3);//pinta estrellas
                }
            }else if(spflores.getSelectedItem() == flo.getTipos()[1]){ //Margaritas
                if (unaDocena.isChecked() && dosDocena.isChecked()) { //si selciona los dos
                    resultado.setText("Por favor seleccione solo una cantidad de docenas");

                } else if(unaDocena.isChecked()) { //UnaDocena
                    resultado.setText("Costo de Arrego floral: " + dflo.getPrecios()[0] +"\n"+ " Costo de Margaritas (c/u) es: " + flo.getPrecio()[1] +"\n"+ "El total es de: "+ flo.calcular_PrecioTotal1Docena(flo.getPrecio()[1],dflo.getPrecios()[0]));
                    rb.setRating(3);//pinta estrellas
                }else if(dosDocena.isChecked()) { //DosDocena
                    resultado.setText("Costo de Arrego floral: " + dflo.getPrecios()[0] +"\n"+ " Costo de Margaritas (c/u) es: " + flo.getPrecio()[1] +"\n"+ "El total es de: "+ flo.calcular_PrecioTotal2Docena(flo.getPrecio()[1],dflo.getPrecios()[0]));
                    rb.setRating(3);//pinta estrellas
                }
            }else if(spflores.getSelectedItem() == flo.getTipos()[2]) { //Gladiolos
                if (unaDocena.isChecked() && dosDocena.isChecked()) { //si selciona los dos
                    resultado.setText("Por favor seleccione solo una cantidad de docenas");

                } else if (unaDocena.isChecked()) { //UnaDocena
                    resultado.setText("Costo de Arrego floral: " + dflo.getPrecios()[0] +"\n"+ " El costo de Gladiolos (c/u) es: " + flo.getPrecio()[2] +"\n"+ "El total es de: " + flo.calcular_PrecioTotal1Docena(flo.getPrecio()[2], dflo.getPrecios()[0]));
                    rb.setRating(3);//pinta estrellas
                } else if (dosDocena.isChecked()) { //DosDocena
                    resultado.setText("Costo de Arrego floral: " + dflo.getPrecios()[0] +"\n"+ " El costo de Gladiolos (c/u) es: " + flo.getPrecio()[2] +"\n"+ "El total es de: " + flo.calcular_PrecioTotal2Docena(flo.getPrecio()[2], dflo.getPrecios()[0]));
                    rb.setRating(3);//pinta estrellas
                }
            }else if(spflores.getSelectedItem() == flo.getTipos()[3]) { //Lirios
                if (unaDocena.isChecked() && dosDocena.isChecked()) { //si selciona los dos
                    resultado.setText("Por favor seleccione solo una cantidad de docenas");

                } else if (unaDocena.isChecked()) { //UnaDocena
                    resultado.setText("Costo de Arrego floral: " + dflo.getPrecios()[0] +"\n"+ " El costo de Lirios (c/u) es: " + flo.getPrecio()[3] +"\n"+ "El total es de: " + flo.calcular_PrecioTotal1Docena(flo.getPrecio()[3], dflo.getPrecios()[0]));
                    rb.setRating(3);//pinta estrellas
                } else if (dosDocena.isChecked()) { //DosDocena
                    resultado.setText("Costo de Arrego floral: " + dflo.getPrecios()[0] +"\n"+ " El costo de Lirios (c/u) es: " + flo.getPrecio()[3] +"\n"+ "El total es de: " + flo.calcular_PrecioTotal2Docena(flo.getPrecio()[3], dflo.getPrecios()[0]));
                    rb.setRating(3);//pinta estrellas
                }
            }else if(spflores.getSelectedItem() == flo.getTipos()[4]) { //Tulipanes
                if (unaDocena.isChecked() && dosDocena.isChecked()) { //si selciona los dos
                    resultado.setText("Por favor seleccione solo una cantidad de docenas");

                } else if (unaDocena.isChecked()) { //UnaDocena
                    resultado.setText("Costo de Arrego floral: " + dflo.getPrecios()[0] +"\n"+ " El costo de Tulipanes (c/u) es: " + flo.getPrecio()[4] +"\n"+ "El total es de: " + flo.calcular_PrecioTotal1Docena(flo.getPrecio()[4], dflo.getPrecios()[0]));
                    rb.setRating(3);//pinta estrellas
                } else if (dosDocena.isChecked()) { //DosDocena
                    resultado.setText("Costo de Arrego floral: " + dflo.getPrecios()[0] +"\n"+ " El costo de Tulipanes (c/u) es: " + flo.getPrecio()[4] +"\n"+ "El total es de: " + flo.calcular_PrecioTotal2Docena(flo.getPrecio()[4], dflo.getPrecios()[0]));
                    rb.setRating(3);//pinta estrellas
                }
            }
            ////// para caja de flores /////
        }else if (spdiseño.getSelectedItem() == dflo.getTipos()[1]) {  //cajas

            if(spflores.getSelectedItem() == flo.getTipos()[0]){ //rosas
                if (unaDocena.isChecked() && dosDocena.isChecked()) { //si selciona los dos
                    resultado.setText("Por favor seleccione solo una cantidad de docenas");

                } else if(unaDocena.isChecked()) { //UnaDocena
                    resultado.setText("Costo de Caja de flores: " + dflo.getPrecios()[1] +"\n"+ " El costo de Rosas (c/u) es: " + flo.getPrecio()[0] +"\n"+ "El total es de: "+ flo.calcular_PrecioTotal1Docena(flo.getPrecio()[0],dflo.getPrecios()[1]));
                    rb.setRating(4);//pinta estrellas
                }else if(dosDocena.isChecked()) { //DosDocena
                    resultado.setText("Costo de Caja de flores: " + dflo.getPrecios()[1] +"\n"+ " El costo de Rosas (c/u) es: " + flo.getPrecio()[0] +"\n"+ "El total es de: "+ flo.calcular_PrecioTotal2Docena(flo.getPrecio()[0],dflo.getPrecios()[1]));
                    rb.setRating(4);//pinta estrellas
                }

            }else if(spflores.getSelectedItem() == flo.getTipos()[1]){ //Margaritas
                if (unaDocena.isChecked() && dosDocena.isChecked()) { //si selciona los dos
                    resultado.setText("Por favor seleccione solo una cantidad de docenas");

                } else if(unaDocena.isChecked()) { //UnaDocena
                    resultado.setText("Costo de Caja de flores: " + dflo.getPrecios()[1] +"\n"+ " El costo de Rosas (c/u) es: " + flo.getPrecio()[1] +"\n"+ "El total es de: "+ flo.calcular_PrecioTotal1Docena(flo.getPrecio()[1],dflo.getPrecios()[1]));
                    rb.setRating(4);//pinta estrellas
                }else if(dosDocena.isChecked()) { //DosDocena
                    resultado.setText("Costo de Caja de flores " + dflo.getPrecios()[1] +"\n"+ " El costo de Rosas (c/u) es: " + flo.getPrecio()[1] +"\n"+ "El total es de: "+ flo.calcular_PrecioTotal2Docena(flo.getPrecio()[1],dflo.getPrecios()[1]));
                    rb.setRating(4);//pinta estrellas
                }
            }else if(spflores.getSelectedItem() == flo.getTipos()[2]) { //Gladiolos
                if (unaDocena.isChecked() && dosDocena.isChecked()) { //si selciona los dos
                    resultado.setText("Por favor seleccione solo una cantidad de docenas");

                } else if (unaDocena.isChecked()) { //UnaDocena
                    resultado.setText("Costo de Caja de flores: " + dflo.getPrecios()[1] +"\n"+ " El costo de Gladiolos (c/u) es: " + flo.getPrecio()[2] +"\n"+ "El total es de: " + flo.calcular_PrecioTotal1Docena(flo.getPrecio()[2], dflo.getPrecios()[1]));
                    rb.setRating(4);//pinta estrellas
                } else if (dosDocena.isChecked()) { //DosDocena
                    resultado.setText("Costo de Caja de flores: " + dflo.getPrecios()[1] +"\n"+ " El costo de Gladiolos (c/u) es: " + flo.getPrecio()[2] +"\n"+ "El total es de: " + flo.calcular_PrecioTotal2Docena(flo.getPrecio()[2], dflo.getPrecios()[1]));
                    rb.setRating(4);//pinta estrellas
                }
            }else if(spflores.getSelectedItem() == flo.getTipos()[3]) { //Lirios
                if (unaDocena.isChecked() && dosDocena.isChecked()) { //si selciona los dos
                    resultado.setText("Por favor seleccione solo una cantidad de docenas");

                } else if (unaDocena.isChecked()) { //UnaDocena
                    resultado.setText("Costo de Caja de flores: " + dflo.getPrecios()[1] +"\n"+ " El costo de Lirios (c/u) es: " + flo.getPrecio()[3] +"\n"+ "El total es de: " + flo.calcular_PrecioTotal1Docena(flo.getPrecio()[3], dflo.getPrecios()[1]));
                    rb.setRating(4);//pinta estrellas
                } else if (dosDocena.isChecked()) { //DosDocena
                    resultado.setText("Costo de Caja de flores: " + dflo.getPrecios()[1] +"\n"+ " El costo de Lirios (c/u) es: " + flo.getPrecio()[3] +"\n"+ "El total es de: " + flo.calcular_PrecioTotal2Docena(flo.getPrecio()[3], dflo.getPrecios()[1]));
                    rb.setRating(4);//pinta estrellas
                }
            }else if(spflores.getSelectedItem() == flo.getTipos()[4]) { //Tulipanes
                if (unaDocena.isChecked() && dosDocena.isChecked()) { //si selciona los dos
                    resultado.setText("Por favor seleccione solo una cantidad de docenas");

                } else if (unaDocena.isChecked()) { //UnaDocena
                    resultado.setText("Costo de Caja de flores: " + dflo.getPrecios()[1] +"\n"+ " El costo de Tulipanes (c/u) es: " + flo.getPrecio()[4] +"\n"+ "El total es de: " + flo.calcular_PrecioTotal1Docena(flo.getPrecio()[4], dflo.getPrecios()[1]));
                    rb.setRating(4);//pinta estrellas
                } else if (dosDocena.isChecked()) { //DosDocena
                    resultado.setText("Costo de Caja de flores: " + dflo.getPrecios()[1] +"\n"+ " El costo de Tulipanes (c/u) es: " + flo.getPrecio()[4] +"\n"+ "El total es de: " + flo.calcular_PrecioTotal2Docena(flo.getPrecio()[4], dflo.getPrecios()[1]));
                    rb.setRating(4);//pinta estrellas
                }
            }
            ///////// ramos /////////////////
        }else if (spdiseño.getSelectedItem() == dflo.getTipos()[2]) {  //ramos

            if(spflores.getSelectedItem() == flo.getTipos()[0]){ //rosas
                if (unaDocena.isChecked() && dosDocena.isChecked()) { //si selciona los dos
                    resultado.setText("Por favor seleccione solo una cantidad de docenas");

                } else if(unaDocena.isChecked()) { //UnaDocena
                    resultado.setText("Costo de Ramo de Flores: " + dflo.getPrecios()[2] +"\n"+ " El costo de Rosas (c/u) es: " + flo.getPrecio()[0] +"\n"+ "El total es de: "+ flo.calcular_PrecioTotal1Docena(flo.getPrecio()[0],dflo.getPrecios()[2]));
                    rb.setRating(5);//pinta estrellas
                }else if(dosDocena.isChecked()) { //DosDocena
                    resultado.setText("Costo de Ramo de Flores: " + dflo.getPrecios()[2] +"\n"+ " El costo de Rosas (c/u) es: " + flo.getPrecio()[0] +"\n"+ "El total es de: "+ flo.calcular_PrecioTotal2Docena(flo.getPrecio()[0],dflo.getPrecios()[2]));
                    rb.setRating(5);//pinta estrellas
                }

            }else if(spflores.getSelectedItem() == flo.getTipos()[1]){ //Margaritas
                if (unaDocena.isChecked() && dosDocena.isChecked()) { //si selciona los dos
                    resultado.setText("Por favor seleccione solo una cantidad de docenas");

                } else if(unaDocena.isChecked()) { //UnaDocena
                    resultado.setText("Costo de Ramo de Flores: " + dflo.getPrecios()[2] +"\n"+ " El costo de Margaritas (c/u) es: " + flo.getPrecio()[1] +"\n"+ "El total es de: "+ flo.calcular_PrecioTotal1Docena(flo.getPrecio()[1],dflo.getPrecios()[2]));
                    rb.setRating(5);//pinta estrellas
                }else if(dosDocena.isChecked()) { //DosDocena
                    resultado.setText("Costo de Ramo de Flores: " + dflo.getPrecios()[2] +"\n"+ " El costo de Margaritas (c/u) es: " + flo.getPrecio()[1] +"\n"+ "El total es de: "+ flo.calcular_PrecioTotal2Docena(flo.getPrecio()[1],dflo.getPrecios()[2]));
                    rb.setRating(5);//pinta estrellas
                }
            }else if(spflores.getSelectedItem() == flo.getTipos()[2]) { //Gladiolos
                if (unaDocena.isChecked() && dosDocena.isChecked()) { //si selciona los dos
                    resultado.setText("Por favor seleccione solo una cantidad de docenas");

                } else if (unaDocena.isChecked()) { //UnaDocena
                    resultado.setText("Costo de Ramo de Flores: " + dflo.getPrecios()[2] +"\n"+ " El costo de Gladiolos (c/u) es: " + flo.getPrecio()[2] +"\n"+ "El total es de: " + flo.calcular_PrecioTotal1Docena(flo.getPrecio()[2], dflo.getPrecios()[2]));
                    rb.setRating(5);//pinta estrellas
                } else if (dosDocena.isChecked()) { //DosDocena
                    resultado.setText("Costo de Ramo de Flores: " + dflo.getPrecios()[2] +"\n"+ " El costo de Gladiolos (c/u) es: " + flo.getPrecio()[2] +"\n"+ "El total es de: " + flo.calcular_PrecioTotal2Docena(flo.getPrecio()[2], dflo.getPrecios()[2]));
                    rb.setRating(5);//pinta estrellas
                }
            }else if(spflores.getSelectedItem() == flo.getTipos()[3]) { //Lirios
                if (unaDocena.isChecked() && dosDocena.isChecked()) { //si selciona los dos
                    resultado.setText("Por favor seleccione solo una cantidad de docenas");

                } else if (unaDocena.isChecked()) { //UnaDocena
                    resultado.setText("Costo de Ramo de Flores: " + dflo.getPrecios()[2] +"\n"+ " El costo de Lirios (c/u) es: " + flo.getPrecio()[3] +"\n"+ "El total es de: " + flo.calcular_PrecioTotal1Docena(flo.getPrecio()[3], dflo.getPrecios()[2]));
                    rb.setRating(5);//pinta estrellas
                } else if (dosDocena.isChecked()) { //DosDocena
                    resultado.setText("Costo de Ramo de Flores: " + dflo.getPrecios()[2] +"\n"+ " El costo de Lirios (c/u) es: " + flo.getPrecio()[3] +"\n"+ "El total es de: " + flo.calcular_PrecioTotal2Docena(flo.getPrecio()[3], dflo.getPrecios()[2]));
                    rb.setRating(5);//pinta estrellas
                }
            }else if(spflores.getSelectedItem() == flo.getTipos()[4]) { //Tulipanes
                if (unaDocena.isChecked() && dosDocena.isChecked()) { //si selciona los dos
                    resultado.setText("Por favor seleccione solo una cantidad de docenas");

                } else if (unaDocena.isChecked()) { //UnaDocena
                    resultado.setText("Costo de Ramo de Flores: " + dflo.getPrecios()[2] +"\n"+ " El costo de Tulipanes (c/u) es: " + flo.getPrecio()[4] +"\n"+ "El total es de: " + flo.calcular_PrecioTotal1Docena(flo.getPrecio()[4], dflo.getPrecios()[2]));
                    rb.setRating(5);//pinta estrellas
                } else if (dosDocena.isChecked()) { //DosDocena
                    resultado.setText("Costo de Ramo de Flores: " + dflo.getPrecios()[2] +"\n"+ " El costo de Tulipanes (c/u) es: " + flo.getPrecio()[4] +"\n"+ "El total es de: " + flo.calcular_PrecioTotal2Docena(flo.getPrecio()[4], dflo.getPrecios()[2]));
                    rb.setRating(5);//pinta estrellas
                }
            }
        }
    }



    public void Mostrarframearreglo1(View view){
        btnverPrecios.setVisibility(View.INVISIBLE);
        scrollcata.setVisibility(View.INVISIBLE);

        framearreglo1.setVisibility(View.VISIBLE);
    }


    public void Ocultar(View view){
        btnverPrecios.setVisibility(View.VISIBLE);
        scrollcata.setVisibility(View.VISIBLE);

        framearreglo1.setVisibility(View.INVISIBLE);
    }

    public void VolverCata(View view){
        Intent c = new Intent(CatalogoActivity.this,HomeActivity.class);
        startActivity(c);
        finish();
    }
}