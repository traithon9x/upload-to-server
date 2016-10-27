package listview.hoangtk.trankhanhhoang.uploadtoserver;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by root on 10/21/16.
 */

public class Camera extends Activity {
    Uri pathurl;
    ImageView showimg;
    Button btquaylai,btupload;
    Bitmap bitmap;
    private static final String TEMP_IMAGE_NAME = "tempImage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera);
        showimg=(ImageView)findViewById(R.id.imageview);

        Intent pickimg = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        pickimg.putExtra("return-data", true);
        pickimg.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(ImagePicker.getTemporalFile(this)));
        startActivityForResult(pickimg,100);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bitmap = ImagePicker.getImageFromResult(this, requestCode, resultCode, data);
        if (bitmap != null) {
            showimg.setImageBitmap(bitmap);
        }
    }

    public void quaylai(View view) {
        Intent obj = new Intent(this,MainActivity.class);
        startActivity(obj);
    }
}
