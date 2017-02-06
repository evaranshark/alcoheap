package evarancorp.alcoheap;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends Activity {
    Random rn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rn = new Random();
    }

    public void OnClick(View view) {

        TextView myTW = (TextView)findViewById(R.id.textView);
        String[] drinks = getResources().getStringArray(R.array.drink_titles);
        String choice = drinks[rn.nextInt(drinks.length)];
        myTW.setText(choice);
    }
}
