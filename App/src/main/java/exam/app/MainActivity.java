package exam.app;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;


public class MainActivity extends ActionBarActivity {

    ImageButton btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
    ImageButton[] btnArray;
    Bitmap[] imagenPartida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnArray = new ImageButton[9];
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
        DesordenameElPuzzle();
    }

    public Bitmap[] PartemeLaImagen(Bitmap image){
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(image, 240, 240, true);
        Bitmap[] imgs = new Bitmap[9];
        imgs[0] = Bitmap.createBitmap(scaledBitmap, 0, 0, 80 , 80);
        imgs[1] = Bitmap.createBitmap(scaledBitmap, 80, 0, 80, 80);
        imgs[2] = Bitmap.createBitmap(scaledBitmap,160, 0, 80,80);
        imgs[3] = Bitmap.createBitmap(scaledBitmap, 0, 80, 80, 80);
        imgs[4] = Bitmap.createBitmap(scaledBitmap, 80, 80, 80,80);
        imgs[5] = Bitmap.createBitmap(scaledBitmap, 160, 80,80,80);
        imgs[6] = Bitmap.createBitmap(scaledBitmap, 0, 160, 80,80);
        imgs[7] = Bitmap.createBitmap(scaledBitmap, 80, 160,80,80);
        imgs[8] = Bitmap.createBitmap(scaledBitmap, 160,160,80,80);
        return imgs;
    }

    public void DesordenameElPuzzle(){
        imagenPartida = PartemeLaImagen(BitmapFactory.decodeResource(getResources(),R.drawable.batman2));
        int i = 0;
        Integer[] indexes = GenerameUnAleatorio();
        for(ImageButton button : btnArray){
            button.setImageBitmap(imagenPartida[indexes[i]]);
            i++;
        }
    }

    public Integer[] GenerameUnAleatorio(){
        Integer[] arr = new Integer[9];
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




}
