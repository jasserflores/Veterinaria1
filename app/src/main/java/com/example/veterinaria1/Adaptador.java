package com.example.veterinaria1;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {
    ArrayList<Registro> lista;
    daoRegistro dao;
    Registro c;
    Activity a;
    int id = 0;

    public Adaptador(Activity a, ArrayList<Registro> lista, daoRegistro dao) {
        this.lista = lista;
        this.a = a;
        this.dao = dao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int i) {
        c = lista.get(i);
        return null;
    }

    @Override
    public long getItemId(int i) {
        c = lista.get(i);
        return c.getId();
    }

    @Override
    public View getView(int posicion, View view, ViewGroup viewGroup) {
        View v = view;
        if (v == null) {
            LayoutInflater li = (LayoutInflater) a.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = li.inflate(R.layout.item, null);

            c = lista.get(posicion);
            TextView nombre = v.findViewById(R.id.Nombre);
            TextView telefono = v.findViewById(R.id.Telefono);
            TextView ciudad = v.findViewById(R.id.Ciudad);
            TextView email = v.findViewById(R.id.Email);
            TextView tipo = v.findViewById(R.id.Tipo);
            Button editar = v.findViewById(R.id.btn_Editar);
            Button eliminar = v.findViewById(R.id.btn_Eliminar);
            nombre.setText(c.getNombre());
            telefono.setText(c.getTelefono());
            email.setText(c.getEmail());
            tipo.setText(c.getTipo());
            ciudad.setText(c.getCiudad());
            editar.setTag(posicion);
            eliminar.setTag(posicion);

            editar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = Integer.parseInt(view.getTag().toString());
                    final Dialog dialog = new Dialog(a);
                    dialog.setTitle("Editar Registro");
                    dialog.setCancelable(true);
                    dialog.setContentView(R.layout.dialogo);
                    dialog.show();
                    final EditText nombre = dialog.findViewById(R.id.et_Nombre);
                    final EditText telefono = dialog.findViewById(R.id.et_Telefono);
                    final EditText ciudad = dialog.findViewById(R.id.et_Ciudad);
                    final EditText email = dialog.findViewById(R.id.et_Email);
                    final EditText tipo = dialog.findViewById(R.id.et_Tipo);
                    Button guardar = dialog.findViewById(R.id.btn_agregar);
                    Button cancelar = dialog.findViewById(R.id.btn_Cancelar);
                    c = lista.get(pos);
                    setId(c.getId());
                    nombre.setText(c.getNombre());
                    telefono.setText(c.getTelefono());
                    ciudad.setText(c.getCiudad());
                    email.setText(c.getEmail());
                    tipo.setText(c.getTipo());
                    guardar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            try {
                                c = new Registro(getId(), nombre.getText().toString(),
                                        telefono.getText().toString(),
                                        ciudad.getText().toString(),
                                        email.getText().toString(),
                                        tipo.getText().toString());
                                dao.editar(c);
                                lista = dao.verTodo();
                                notifyDataSetChanged();
                                dialog.dismiss();
                            } catch (Exception e) {
                                     e.printStackTrace(); // Imprime el rastreo de la pila para obtener más detalles.
                                     Toast.makeText(a, "Error al agregar datos: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }


                    }
                    });
                    cancelar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();
                        }
                    });
                }

            });

            eliminar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = Integer.parseInt(view.getTag().toString());
                    c = lista.get(posicion);
                    setId(c.getId());
                    AlertDialog.Builder del = new AlertDialog.Builder(a);
                    del.setMessage("Estas Seguro de eliminar");
                    del.setCancelable(false);
                    del.setPositiveButton("SI", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dao.Eliminar(getId());
                            lista = dao.verTodo();
                            notifyDataSetChanged();
                        }
                    });
                    del.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    del.show();
                }
            });
        }
        return v;
    }
}