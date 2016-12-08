package toyer.shtuchki;

import android.graphics.Color;
import android.widget.CheckBox;
import android.widget.*;
import android.widget.TabHost.OnTabChangeListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView.OnItemSelectedListener;

public class MainActivity extends AppCompatActivity {
    private CheckBox cb;
    private ImageView iv;
    private Switch mSwitch;
    private String[] data = {"М ну и что это ТАКОЕ", "Все супер, подписка!", "ВООБЩЕ НЕ ЗАЦЕПИЛО"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv = (ImageView)findViewById(R.id.imageView);
        cb = (CheckBox)findViewById(R.id.checkBox);
        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    iv.setImageResource(R.drawable.krasotisha);
                } else {
                    iv.setImageResource(R.drawable.white);
                }
            }
        });


        TabHost tabHost = (TabHost) findViewById(R.id.tabh);
        // инициализация
        tabHost.setup();
        TabHost.TabSpec tabSpec;

        // создаем вкладку и указываем тег
        tabSpec = tabHost.newTabSpec("tag1");
        // название вкладки
        tabSpec.setIndicator("Шаг 1");
        // указываем id компонента из FrameLayout, он и станет содержимым
        tabSpec.setContent(R.id.tab1);
        // добавляем в корневой элемент
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("tag2");
        tabSpec.setIndicator("Шаг 2");
        tabSpec.setContent(R.id.tab2);
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("tag3");
        tabSpec.setIndicator("Шаг 3");
        tabSpec.setContent(R.id.tab3);
        tabHost.addTab(tabSpec);

        tabHost.setCurrentTabByTag("tag1");


        mSwitch = (Switch) findViewById(R.id.switch1);
        mSwitch.setChecked(false);
        mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(getApplicationContext(), "новогоднее настроение включено", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "новогоднее настроение отключено", Toast.LENGTH_SHORT).show();
                }
            }
        });


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(adapter);
        // заголовок
        spinner.setPrompt("Title");
        // выделяем элемент
        spinner.setSelection(0);

        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                // показываем позиция нажатого элемента
                if(position == 1)
                    Toast.makeText(getBaseContext(), "Спасибо:)", Toast.LENGTH_SHORT).show();
                else if(position == 2)
                    Toast.makeText(getBaseContext(), "ДОСВИДАНИЯ", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

    }
}
