package com.example.p2ss14030;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class BdControladora {

    private static final String[] camposEquipo = new String[]{"codequipo", "nomequipo","escapitalino","jugadoreslocales","jugadoresestranjeros"};
    private static final String[] camposPais = new String[]{"codpais","nombpais","esdeSudamerica"};
    private static final String[] camposJugador = new String[]{"codequipo","codpais","codjugador","edadingreso","esExtranjero" };

    private final Context context;
    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;
    private static final String DROP_TABLE1 = "DROP TABLE IF EXISTS Equipo; ";
    private static final String DROP_TABLE2 = "DROP TABLE IF EXISTS Jugador; ";
    private static final String DROP_TABLE3 =  "DROP TABLE IF EXISTS  Pais ; ";

    public BdControladora(Context ctx) {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);

    }


    private static class DatabaseHelper extends SQLiteOpenHelper {

        private static final String BASE_DATOS = "ss14030.s3db";
        private static final int VERSION = 1;

        public DatabaseHelper(Context context) {

            super(context, BASE_DATOS, null, VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try {

                db.execSQL("CREATE TABLE Equipo (codequipo VARCHAR NOT NULL PRIMARY KEY," +
                        " nomequipo VARCHAR," +
                        " escapitalino REAL," +
                        " jugadoreslocales INTEGER," +
                        " jugadoresextran INTEGER);");
                db.execSQL("CREATE TABLE Pais (" +
                        " codpais VARCHAR NOT NULL PRIMARY KEY," +
                        " nommpais VARCHAR," +
                        " esdeSudamerica VARCHAR); ");
                db.execSQL(" CREATE TABLE Jugador (" +
                        " codequipo VARCHAR NOT NULL ," +
                        " codpais VARCHAR NOT NULL ," +
                        " codjugador VARCHAR ," +
                        " edadingreso REAL," +
                        " esExtranjero VARCHAR," +
                        " PRIMARY KEY(codequipo,codpais,codjugador));");
                Log.i("bda","bd creada");







            } catch (SQLException e) {
                Log.i("bd","no se creo");
                e.printStackTrace();
            }
        }

        @Override
        //  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub


//        }
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try {
                //Message.message(context,"OnUpgrade");
                db.execSQL(DROP_TABLE1);
                db.execSQL(DROP_TABLE2);
                db.execSQL(DROP_TABLE3);
                onCreate(db);
            } catch (Exception e) {
                //Message.message(context,""+e);
            }
        }

    }
    public void abrir() throws SQLException{
        db = DBHelper.getWritableDatabase();

        return;
    }

    public void cerrar(){
        DBHelper.close();
    }
//
//    public String eliminarEquipo(String codEquipo ){
//        String consulta="delete from Equipo where "
//        return
//    }
//
//    public String insertargrupo(String nombregrupo){
//
//
//        ContentValues grupo = new ContentValues();
//        grupo.put("idgrupo",1);
//        grupo.put("nombregrupo", nombregrupo);
//        Long guardado=db.insert("grupos", null, grupo);
//
//        return guardado.toString();
//    }
//    public String(String consulta){
//        String numero;
//        db.rawQuery(consulta,null);
//        return numero
//    }
    public void llenarbd(){

        db.execSQL("insert into Pais values ('arg1','argentina','1');");
        db.execSQL("insert into Pais values ('col','colombia','1');");
        db.execSQL("insert into Pais values ('nic','nicaragua','0');");
        db.execSQL("insert into Pais values ('sv','elsalvador','0');");

        db.execSQL("insert into Equipo values ('alia','alianza',1.5,5,5);");
        db.execSQL("insert into Equipo values ('bca','boca juniors',1.5,5,5);");
        db.execSQL("insert into Equipo values ('rm','real madrid',1.5,5,5);");

        db.execSQL("insert into Jugador values ('alia','sv','1',20,1);");
        db.execSQL("insert into Jugador values ('rm','arg','3',22,1);");
        db.execSQL("insert into Jugador values ('alia','sv','4',25,0);");
        db.execSQL("insert into Jugador values ('alia','sv','5',27,0);");


    }

    private boolean verificarIntegridad(Object dato, int relacion) throws SQLException{

        switch(relacion){

            case 1:
            {
                //verificar que al insertar nota exista carnet del alumno y el codigo de materia
                /*Nota nota = (Nota)dato;
                String[] id1 = {nota.getCarnet()};
                String[] id2 = {nota.getCodmateria()};
                abrir();
                Cursor cursor1 = db.query("alumno", null, "carnet = ?", id1, null, null, null);
                Cursor cursor2 = db.query("materia", null, "codmateria = ?", id2, null, null, null);
                if(cursor2.moveToFirst() && cursor1.moveToFirst()){
                    //Se encontraron datos ||
                    return true;
                }*/
                return false;
            }

            case 2:
            {
                //verificar que al modificar nota exista carnet del alumno, el codigo de materia y el ciclo
                /*Nota nota1 = (Nota)dato;
                String[] ids = {nota1.getCarnet(), nota1.getCodmateria(), nota1.getCiclo()};
                abrir();
                Cursor c = db.query("nota", null, "carnet = ? AND codmateria = ? AND ciclo = ?", ids, null, null, null);
                if(c.moveToFirst()){
                    //Se encontraron datos
                    return true;
                }*/
                return false;
            }

            case 3:
            {
                Pais pais = (Pais)dato;
                Cursor c=db.query(true, "pais", new String[] {
                        "codpais" }, "codpais='"+pais.getCodpais()+"'",null, null, null, null, null);
                if(c.moveToFirst())
                    return true;
                else
                    return false;
            }

            case 4:
            {
                Equipo equipo = (Equipo)dato;
                Cursor c=db.query(true, "equipo", new String[] {
                        "codequipo" }, "codequipo='"+equipo.getCodequipo()+"'",null, null, null, null, null);
                if(c.moveToFirst())
                    return true;
                else
                    return false;
            }

            case 5:
            {
                Jugador ju = (Jugador)dato;
                Cursor c=db.query(true, "jugador", new String[] {
                        "codjugador" }, "codjugador='"+ju.getCodjugador()+"'",null, null, null, null, null);
                if(c.moveToFirst())
                    return true;
                else
                    return false;
            }

            case 6:
            {
                //verificar que exista Materia
                /*Materia materia2 = (Materia)dato;
                String[] idm = {materia2.getCodmateria()};
                abrir();
                Cursor cm = db.query("materia", null, "codmateria = ?", idm, null, null, null);
                if(cm.moveToFirst()){
                    //Se encontro Materia
                    return true;
                }
                return false;*/
            }

            default:
                return false;

        }


    }

    public String insertar(Pais pais) {

        String regInsertados = "Registro Insertado Nº= ";
        long contador = 0;
        // verificar que no exista alumno
        if (verificarIntegridad(pais, 3)) {
            regInsertados = "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        } else {
            ContentValues pa = new ContentValues();

            pa.put("codpais", pais.getCodpais());
            pa.put("nommpais", pais.getNommpais());
            pa.put("esdeSudamerica", pais.getEsdeSudamerica());

            contador = db.insert("pais", null, pa);
            regInsertados = regInsertados + contador;
        }
        return regInsertados;
    }

    public String insertar(Equipo equipo) {

        String regInsertados = "Registro Insertado Nº= ";
        long contador = 0;
        // verificar que no exista alumno
        if (verificarIntegridad(equipo, 4)) {
            regInsertados = "Error al Insertar el registro, Registro Duplicado. ";
        } else {
            ContentValues pa = new ContentValues();

            pa.put("codequipo", equipo.getCodequipo());
            pa.put("nomequipo", equipo.getNomequipo());
            pa.put("escapitalino", equipo.getEscapitalino());
            pa.put("jugadoreslocales", equipo.getJugadoreslocales());
            pa.put("esExtranjero", equipo.getJugadoresextran());

            contador = db.insert("equipo", null, pa);
            regInsertados = regInsertados + contador;
        }
        return regInsertados;
    }

    public String insertar(Jugador ju) {

        String regInsertados = "Registro Insertado Nº= ";
        long contador = 0;
        // verificar que no exista alumno
        if (verificarIntegridad(ju, 5)) {
            regInsertados = "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        } else {
            ContentValues pa = new ContentValues();

            pa.put("codequipo", ju.getCodequipo());
            pa.put("codpais", ju.getCodpais());
            pa.put("codjugador", ju.getCodjugador());
            pa.put("edadingreso", ju.getEdadingreso());
            pa.put("jugadoresextran", ju.getEsExtranjero());

            contador = db.insert("equipo", null, pa);
            regInsertados = regInsertados + contador;
        }
        return regInsertados;
    }

}