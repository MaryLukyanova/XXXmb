package toyer.imagefrominternet;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final String urlImagePath = "https://www.facebook.com/bangtan.official/photos/a.1487742587907665.1073742006.561348433880423/1487743147907609/?type=3&theater";
    final String urlImagePathShow = "https://www.facebook.com/bangtan.official/photos/...";

    TextView tv;
    ImageView iv;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView)findViewById(R.id.textView);
        iv = (ImageView)findViewById(R.id.imageView);
        b = (Button)findViewById(R.id.button);

        tv.setText(urlImagePathShow);

        iv.setImageResource(R.drawable.bts);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlImagePath));
                startActivity(browserIntent);
            }
        };
        b.setOnClickListener(onClickListener);

    }
}
