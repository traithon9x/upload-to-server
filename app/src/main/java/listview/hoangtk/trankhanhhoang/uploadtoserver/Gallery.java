package listview.hoangtk.trankhanhhoang.uploadtoserver;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by root on 10/21/16.
 */

public class Gallery extends Activity {
     Uri pathurl;
    ImageView showimg;
    Button btquaylai,btupload;
    Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery);
        showimg=(ImageView)findViewById(R.id.imageview);
        btquaylai=(Button)findViewById(R.id.quaylai);
        btupload=(Button)findViewById(R.id.btnupload);

        Intent pickIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(pickIntent, 100);
      //  finish();
        Intent obj = new Intent();
        obj.getStringExtra("data");    }

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