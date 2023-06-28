package com.example.practical15;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewSwitcher;
public class MainActivity extends AppCompatActivity {
    private ImageSwitcher imageSwitcher;
    Button btnNext;
    // Array of Image IDs to Show In ImageSwitcher
    int imageIds[] = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.
            drawable.image5, R.drawable.image6, R.drawable.image7};
    int messageCount = imageIds.length;
    // to keep current Index of ImageID array
    int currentIndex = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // get The references
        btnNext = (Button) findViewById(R.id.buttonNext);
        imageSwitcher = (ImageSwitcher)
                findViewById(R.id.imageSwitcher);
        // Set the ViewFactory of the ImageSwitcher that will create ImageView object when asked
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            public View makeView() {
        // Create a new ImageView set it's properties
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                return imageView;
            }
        });
        // Declare the animations and initialize them
        Animation in =
                AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        Animation out =
                AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);
        // set the animation type to imageSwitcher
        imageSwitcher.setInAnimation(in);
        imageSwitcher.setOutAnimation(out);
        // ClickListener for NEXT button
        // When clicked on Button ImageSwitcher will switch between Images
        // The current Image will go OUT and next Image will come in with specified animation
        btnNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                currentIndex++;
              // If index reaches maximum reset it
                if (currentIndex == messageCount) currentIndex = 0;
                imageSwitcher.setImageResource(imageIds[currentIndex]);
            }
        });
    }
}
