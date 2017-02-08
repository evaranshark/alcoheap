package evarancorp.alcoheap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

import static evarancorp.alcoheap.R.id.activity_help;
import static evarancorp.alcoheap.R.id.activity_main;
import static evarancorp.alcoheap.R.id.item1;

public class MainActivity extends Activity {
    private Random rn;
    private ImageButton mImageView;
    private TextView myTW;
    private MenuItem hButton;
    private Animation mEnlargeAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rn = new Random();
        myTW = (TextView)findViewById(R.id.textView);

        mImageView = (ImageButton)findViewById(R.id.imageView);
        // подключаем файл анимации
        mEnlargeAnimation = AnimationUtils.loadAnimation(this, R.anim.enlarge);

        // при запуске начинаем с эффекта увеличения
        mImageView.startAnimation(mEnlargeAnimation);
        mImageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                myTW.setText(R.string.def_text);
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_bar, menu);
        return true;

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == item1){
            Intent intent = new Intent(MainActivity.this, help.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void OnClick(View view) {

        String[] drinks = getResources().getStringArray(R.array.drink_titles);
        String choice = drinks[rn.nextInt(drinks.length)];
        myTW.setText(choice);
    }

}
