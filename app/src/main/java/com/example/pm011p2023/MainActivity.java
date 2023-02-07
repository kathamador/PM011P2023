package com.example.pm011p2023;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.viewmodel.CreationExtras;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pm011p2023.configuracion.SQLiteConexion;
import com.example.pm011p2023.transacciones.Transacciones;

public class MainActivity extends AppCompatActivity {

    //global
    EditText nombres, apellidos, correo, edad;
    Button btnagregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombres = (EditText) findViewById(R.id.nombres);
        apellidos = (EditText) findViewById(R.id.apellidos);
        edad = (EditText) findViewById(R.id.edad);
        correo = (EditText) findViewById(R.id.correo);

        btnagregar = (Button) findViewById(R.id.btnagregar);
        btnagregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AgregarPersonas();
            }
        });
    }

    private void AgregarPersonas(){
        try {
            //conexion a la db
            SQLiteConexion conexion = new SQLiteConexion(this, Transacciones.NameDatabase, null, 1);
            SQLiteDatabase db = conexion.getWritableDatabase();

            //valores
            ContentValues valores = new ContentValues();
            valores.put("nombres",nombres.getText().toString());
            valores.put("apellidos",apellidos.getText().toString());
            valores.put("edad",edad.getText().toString());
            valores.put("correo",correo.getText().toString());

            Long Resultado = db.insert(Transacciones.tablapersonas, "id", valores);
            Toast.makeText(this, Resultado.toString(), Toast.LENGTH_SHORT).show();
            ClearScreen();
        }
        catch (Exception ex) {
            Toast.makeText(this, "No se pudo insertar el dato", Toast.LENGTH_SHORT).show();
        }
    }

    private void ClearScreen(){
        nombres.setText(Transacciones.Empty);
        apellidos.setText(Transacciones.Empty);
        edad.setText(Transacciones.Empty);
        correo.setText(Transacciones.Empty);
    }

    private void MostrarCliente() {
        String mensaje = nombres.getText().toString() +
                " " + apellidos.getText().toString() +
                " | " + edad.getText().toString() + " años" +
                " | " + correo.getText().toString();

        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }
}