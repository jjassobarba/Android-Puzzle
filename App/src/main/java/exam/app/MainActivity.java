package exam.app;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;


public class MainActivity extends ActionBarActivity implements View.OnClickListener{

    LinearLayout contenedor;
    ImageButton btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12;
    ImageButton[] btnArray;
    Bitmap[] imagenPartida;
    int seleccion = 0, cuentaSeleccionadas =0;
    ProgressBar pb1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contenedor = (LinearLayout) findViewById(R.id.container);
        contenedor.setBackgroundColor(Color.BLACK);
        pb1 = (ProgressBar) findViewById(R.id.pbProgreso);
        Rect bounds = pb1.getProgressDrawable().getBounds();
        pb1.setProgressDrawable(getResources().getDrawable(R.drawable.redprogressbar));
        pb1.getProgressDrawable().setBounds(bounds);
        pb1.setProgress(100);
        btnArray = new ImageButton[12];
        btn1 = (ImageButton) findViewById(R.id.btnImage1);
        btnArray[0] = btn1;
        btn2 = (ImageButton) findViewById(R.id.btnImage2);
        btnArray[1] = btn2;
        btn3 = (ImageButton) findViewById(R.id.btnImage3);
        btnArray[2] = btn3;
        btn4 = (ImageButton) findViewById(R.id.btnImage4);
        btnArray[3] = btn4;
        btn5 = (ImageButton) findViewById(R.id.btnImage5);
        btnArray[4] = btn5;
        btn6 = (ImageButton) findViewById(R.id.btnImage6);
        btnArray[5] = btn6;
        btn7 = (ImageButton) findViewById(R.id.btnImage7);
        btnArray[6] = btn7;
        btn8 = (ImageButton) findViewById(R.id.btnImage8);
        btnArray[7] = btn8;
        btn9 = (ImageButton) findViewById(R.id.btnImage9);
        btnArray[8] = btn9;
        btn10 = (ImageButton) findViewById(R.id.btnImage10);
        btnArray[9] = btn10;
        btn11 = (ImageButton) findViewById(R.id.btnImage11);
        btnArray[10] = btn11;
        btn12 = (ImageButton) findViewById(R.id.btnImage12);
        btnArray[11] = btn12;
        for(ImageButton button : btnArray){
            button.setOnClickListener(this);
        }
        DesordenameElPuzzle();
    }

    public Bitmap[] PartemeLaImagen(Bitmap image){
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(image, 240, 480, true);
        Bitmap[] imgs = new Bitmap[12];
        imgs[0] = Bitmap.createBitmap(scaledBitmap, 0, 0, 80 , 80);
        imgs[1] = Bitmap.createBitmap(scaledBitmap, 80, 0, 80, 80);
        imgs[2] = Bitmap.createBitmap(scaledBitmap,160, 0, 80,80);
        imgs[3] = Bitmap.createBitmap(scaledBitmap, 0, 80, 80, 80);
        imgs[4] = Bitmap.createBitmap(scaledBitmap, 80, 80, 80,80);
        imgs[5] = Bitmap.createBitmap(scaledBitmap, 160, 80,80,80);
        imgs[6] = Bitmap.createBitmap(scaledBitmap, 0, 160, 80,80);
        imgs[7] = Bitmap.createBitmap(scaledBitmap, 80, 160,80,80);
        imgs[8] = Bitmap.createBitmap(scaledBitmap, 160,160,80,80);
        imgs[9] = Bitmap.createBitmap(scaledBitmap, 0,320,80,80);
        imgs[10] = Bitmap.createBitmap(scaledBitmap, 80,320,80,80);
        imgs[11] = Bitmap.createBitmap(scaledBitmap, 160,320,80,80);
        return imgs;
    }

    public void DesordenameElPuzzle(){
        imagenPartida = PartemeLaImagen(BitmapFactory.decodeResource(getResources(),R.drawable.batmanandroid));
        int i = 0;
        Integer[] indexes = GenerameUnAleatorio();
        for(ImageButton button : btnArray){
            button.setImageBitmap(imagenPartida[indexes[i]]);
            i++;
        }
    }

    public Integer[] GenerameUnAleatorio(){
        Integer[] arr = new Integer[12];
        for(int i = 0; i < arr.length ; i++){
            arr[i] = i;
        }
        Collections.shuffle(Arrays.asList(arr));
        return arr;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnImage1:
                seleccion = 1;
                cuentaSeleccionadas++;
                if(cuentaSeleccionadas >= 2){
                    PintaloDeNegro();
                }
                btn1.setBackgroundColor(Color.GREEN);
                break;
            case R.id.btnImage2:
                seleccion = 2;
                cuentaSeleccionadas++;
                if(cuentaSeleccionadas >= 2){
                    PintaloDeNegro();
                }
                btn2.setBackgroundColor(Color.GREEN);
                break;
            case R.id.btnImage3:
                seleccion = 3;
                cuentaSeleccionadas++;
                if(cuentaSeleccionadas >= 2){
                    PintaloDeNegro();
                }
                btn3.setBackgroundColor(Color.GREEN);
                break;
            case R.id.btnImage4:
                seleccion = 4;
                cuentaSeleccionadas++;
                if(cuentaSeleccionadas >= 2){
                    PintaloDeNegro();
                }
                btn4.setBackgroundColor(Color.GREEN);
                break;
            case R.id.btnImage5:
                seleccion = 5;
                cuentaSeleccionadas++;
                if(cuentaSeleccionadas >= 2){
                    PintaloDeNegro();
                }
                btn5.setBackgroundColor(Color.GREEN);
                break;
            case R.id.btnImage6:
                seleccion = 6;
                cuentaSeleccionadas++;
                if(cuentaSeleccionadas >= 2){
                    PintaloDeNegro();
                }
                btn6.setBackgroundColor(Color.GREEN);
                break;
            case R.id.btnImage7:
                seleccion = 7;
                cuentaSeleccionadas++;
                if(cuentaSeleccionadas >= 2){
                    PintaloDeNegro();
                }
                btn7.setBackgroundColor(Color.GREEN);
                break;
            case R.id.btnImage8:
                seleccion = 8;
                cuentaSeleccionadas++;
                if(cuentaSeleccionadas >= 2){
                    PintaloDeNegro();
                }
                btn8.setBackgroundColor(Color.GREEN);
                break;
            case R.id.btnImage9:
                seleccion = 9;
                cuentaSeleccionadas++;
                if(cuentaSeleccionadas >= 2){
                    PintaloDeNegro();
                }
                btn9.setBackgroundColor(Color.GREEN);
                break;
            case R.id.btnImage10:
                seleccion = 10;
                cuentaSeleccionadas++;
                if(cuentaSeleccionadas >= 2){
                    PintaloDeNegro();
                }
                btn10.setBackgroundColor(Color.GREEN);
                break;
            case R.id.btnImage11:
                seleccion = 11;
                cuentaSeleccionadas++;
                if(cuentaSeleccionadas >= 2){
                    PintaloDeNegro();
                }
                btn11.setBackgroundColor(Color.GREEN);
                break;
            case R.id.btnImage12:
                seleccion = 12;
                cuentaSeleccionadas++;
                if(cuentaSeleccionadas >= 2){
                    PintaloDeNegro();
                }
                btn12.setBackgroundColor(Color.GREEN);
                break;
        }
        ValidaSeleccionadas();
    }

    private void ValidaSeleccionadas(){

        if(cuentaSeleccionadas >= 2){
            cuentaSeleccionadas = 0;
        }
    }

    private void PintaloDeNegro(){
        btn1.setBackgroundColor(Color.BLACK);
        btn2.setBackgroundColor(Color.BLACK);
        btn3.setBackgroundColor(Color.BLACK);
        btn4.setBackgroundColor(Color.BLACK);
        btn5.setBackgroundColor(Color.BLACK);
        btn6.setBackgroundColor(Color.BLACK);
        btn7.setBackgroundColor(Color.BLACK);
        btn8.setBackgroundColor(Color.BLACK);
        btn9.setBackgroundColor(Color.BLACK);
        btn10.setBackgroundColor(Color.BLACK);
        btn11.setBackgroundColor(Color.BLACK);
        btn12.setBackgroundColor(Color.BLACK);
    }
}
