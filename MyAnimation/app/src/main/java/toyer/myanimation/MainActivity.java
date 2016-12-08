package toyer.myanimation;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity implements OnClickListener {
    private Button startFrameAnim;
    private Button startTransformAnim;
    private Button cancelAnim;
    private  Button alphaAnim;
    private  Button diffAnim;
    private ImageView animationView;

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startFrameAnim = (Button) findViewById(R.id.frameAnimationStart);
        startTransformAnim= (Button) findViewById(R.id.transformAnimationStart);
        cancelAnim = (Button) findViewById(R.id.cancelAnimation);
        alphaAnim = (Button) findViewById(R.id.alphaAnimation);
        animationView = (ImageView) findViewById(R.id.animationView);
        diffAnim = (Button) findViewById((R.id.diff_animation));


        startFrameAnim.setOnClickListener(this);
        startTransformAnim.setOnClickListener(this);
        cancelAnim.setOnClickListener(this);
        alphaAnim.setOnClickListener(this);
        diffAnim.setOnClickListener(this);
    }
    public void onClick(View v) {

        if (startFrameAnim.equals(v)) {
            animationView.setBackgroundResource(R.drawable.frame_anim);
            AnimationDrawable animation = (AnimationDrawable) animationView.getBackground();
            animation.start();
        }
        else if (startTransformAnim.equals(v)) {
            animationView.setBackgroundResource(R.drawable.blue);
            Animation transformAnimation = AnimationUtils.loadAnimation(this, R.anim.transform_anim);
            animationView.startAnimation(transformAnimation);
        }
        else if (cancelAnim.equals(v)) {
            animationView.setBackgroundColor(Color.WHITE);
            animationView.clearAnimation();
        }
        else if (alphaAnim.equals(v)) {
            animationView.setBackgroundResource(R.drawable.green);
            Animation mFadeOutAnimation = AnimationUtils.loadAnimation(this, R.anim.fadeoutalpha);
            animationView.startAnimation(mFadeOutAnimation);
        }
        else if (diffAnim.equals(v)) {
            animationView.setBackgroundResource(R.drawable.yellow);
            Animation differentAnimation = AnimationUtils.loadAnimation(this, R.anim.scaletranslaterotate);
            animationView.startAnimation(differentAnimation);
        }
    }
}