package com.example.veterinaria1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class daoRegistro {

    SQLiteDatabase bd;

    ArrayList<Registro> lista = new ArrayList<Registro>();

    Registro c;

    Context ct;

    String nombreBD = "BDRegistro";

    String tabla = "create table if not exists Registro(id integer primary key autoincrement, nombre text, email text, telefono text, ciudad text, tipo text )";


    public daoRegistro(Context c){
        this.ct = c;
        bd = c.openOrCreateDatabase(nombreBD, Context.MODE_PRIVATE, null);
        bd.execSQL(tabla);
    }

    public boolean insertar(Registro c){
        ContentValues contenedor = new ContentValues();

        contenedor.put("nombre", c.getNombre());
        contenedor.put("telefono", c.getTelefono());
        contenedor.put("ciudad", c.getCiudad());
        contenedor.put("email", c.getEmail());
        contenedor.put("tipo", c.getTipo());
        return (bd.insert("registro", null, contenedor))>0;


    }

    public boolean Eliminar(int id){

        return (bd.delete("registro", "id="+id, null))>0;
    }

    public boolean editar(Registro c){

        ContentValues contenedor = new ContentValues();
        contenedor.put("nombre", c.getNombre());
        contenedor.put("telefono",c.getTelefono());
        contenedor.put("ciudad",c.getCiudad());
        contenedor.put("email", c.getEmail());
        contenedor.put("tipo", c.getTipo());
        return (bd.update("registro", contenedor, "id="+c.getId(),null))>0;

    }

    public ArrayList<Registro>verTodo(){

        lista.clear();
        Cursor cursor = bd.rawQuery("select * from registro", null);
        if (cursor!=null && cursor.getCount()>0){
            cursor.moveToFirst();
            do {
                lista.add(new Registro(cursor.getInt(0),
                        cursor.getString(1),cursor.getString(2),
                        cursor.getString(3),cursor.getString(4),
                        cursor.getString(5)));
            }while (cursor.moveToNext());
        }

        return lista;

    }

    public Registro verUno(int posicion) {
        Cursor cursor = bd.rawQuery("Select * from registro", null);
        cursor.moveToPosition(posicion);
        c = new Registro(cursor.getInt(0),
                cursor.getString(1),cursor.getString(2),
                cursor.getString(3),cursor.getString(4),
                cursor.getString(5));
        return c;
    }

}
