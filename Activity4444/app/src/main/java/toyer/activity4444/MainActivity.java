package toyer.activity4444;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.View;
import android.content.Intent;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Button close_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        close_button = (Button) findViewById(R.id.close_button);
        OnClickListener closeBtn = new OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        };
        close_button.setOnClickListener(closeBtn);
    }

    public void openNewActivity2(View view)
    {
        // Создаем объект Intent для вызова новой Activity
        Intent intent = new Intent(this, Second2.class);
        // запуск activity
        startActivity(intent);
    }

    public void openNewActivity3(View view)
    {
        Intent intent = new Intent(this, Activity3.class);
        startActivity(intent);
    }

    public void openNewActivity4(View view)
    {
        Intent intent = new Intent(this, Activity4.class);
        startActivity(intent);
    }

}
