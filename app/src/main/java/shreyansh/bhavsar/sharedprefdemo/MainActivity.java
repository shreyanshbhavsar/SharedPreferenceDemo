package shreyansh.bhavsar.sharedprefdemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences("checkFirstRun",MODE_PRIVATE);
        final boolean check = preferences.getBoolean("isFirst",false);

        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if(!check)
                {

                    preferences.edit().putBoolean("isFirst",true).commit();
                    Intent intent = new Intent(MainActivity.this,SignUpActivity.class);
                    startActivity(intent);

                }
                else
                {
                    Intent intent = new Intent(MainActivity.this,SignInActivity.class);
                    startActivity(intent);

                }

            }
        },5000);

    }
}
