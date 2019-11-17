package com.example.usuario.mispinturas;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent in = getIntent();
        int index = in.getIntExtra("com.example.usuario.ITEM_INDEX", -1);

        if (index > -1) {
            int pic = getImg(index);
            ImageView img = (ImageView) findViewById(R.id.imageView);
            scaleImg(img, pic);
        }
    }

    private int getImg(int index) {
        switch (index) {
            case 0:
                return R.drawable.lo_inexplicable;
            case 1:
                return R.drawable.planos_de_existencia;
            case 2:
                return R.drawable.hiperespacio;
            case 3:
                return R.drawable.otras_realidades;
            case 4:
                return R.drawable.cuerdas_cosmicas;
            case 5:
                return R.drawable.lo_que_vendra;
            case 6:
                return R.drawable.el_orden_implicado;
            case 7:
                return R.drawable.movimiento_cubista_irradiante;
            case 8:
                return R.drawable.un_ataque_a_los_sentidos;
            case 9:
                return R.drawable.imagenes_arcaicas;
            case 10:
                return R.drawable.ecologia;
            case 11:
                return R.drawable.otras_emanaciones_encienden;
            case 12:
                return R.drawable.visiones_oniricas;
            default:
                return -1;
        }
    }

    private void scaleImg(ImageView img, int pic) {

        Display screen = getWindowManager().getDefaultDisplay();
        BitmapFactory.Options options = new BitmapFactory.Options();

        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), pic, options);

        int imgWidth = options.outWidth;
        int screeWidth = screen.getWidth();

        if (imgWidth > screeWidth) {
            int ratio = Math.round((float) imgWidth / (float) screeWidth);
            options.inSampleSize = ratio;
        }

        options.inJustDecodeBounds = false;
        Bitmap bm = BitmapFactory.decodeResource(getResources(), pic, options);
        img.setImageBitmap(bm);
    }
}
