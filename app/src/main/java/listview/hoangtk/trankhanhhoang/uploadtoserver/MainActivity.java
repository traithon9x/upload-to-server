package listview.hoangtk.trankhanhhoang.uploadtoserver;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {
    private static final String TEMP_IMAGE_NAME = "tempImage";
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageview);
    }

    public void chonanh(View view) {
        // Intent newintent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivity(new Intent(this, Gallery.class));
    }

    public void truycapcamera(View view) {
        startActivity(new Intent(this, Camera.class));

    }


    public void chonanhasd(View view) {
       // ImagePicker.pickImage(this);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Bitmap bitmap = ImagePicker.getImageFromResult(this, requestCode, resultCode, data);
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
        }
    }
}
