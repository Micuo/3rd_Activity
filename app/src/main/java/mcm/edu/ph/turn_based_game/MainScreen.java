package mcm.edu.ph.turn_based_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainScreen extends AppCompatActivity {

    private Button Start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        Start = (Button) findViewById(R.id.btnStart);
        Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityMain();
            }
        });
    }

    public void openActivityMain(){
        Intent intent = new Intent(this, GameScreen.class);
        startActivity(intent);
    }
}