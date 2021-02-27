package mcm.edu.ph.turn_based_game;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class GameScreen extends AppCompatActivity implements View.OnClickListener{


    int P1HP = 100;
    int P2HP = 350;
    int P1minDamage = 20;
    int P1maxDamage = 30;
    int P2minDamage = 5;
    int P2maxDamage = 10;
    int turnNumbers = 1;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button nextTurn = findViewById(R.id.btnNextTurn);

        TextView txtP1HP, txtP2HP, txtP1DPT, txtP2DPT;
        txtP1HP = findViewById(R.id.txtP1HP);
        txtP2HP = findViewById(R.id.txtP2HP);
        txtP1DPT = findViewById(R.id.txtP1DPT);
        txtP2DPT = findViewById(R.id.txtP2DPT);

        txtP1HP.setText(String.valueOf(this.P1HP));
        txtP2HP.setText(String.valueOf(this.P2HP));
        txtP1DPT.setText((P1minDamage)+ " ~ "+ (P1maxDamage));
        txtP2DPT.setText((P2minDamage)+ " ~ "+ (P2maxDamage));
        nextTurn.setOnClickListener(this);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v){

        Random random = new Random();

        int P1DPT = random.nextInt(P1maxDamage - P1minDamage)+ P1minDamage;
        int P2DPT = random.nextInt(P2maxDamage - P2minDamage)+ P2minDamage;

        TextView txtP1HP, txtP2HP, txtP1DPT, txtP2DPT, txtMsg;

        txtP1HP = findViewById(R.id.txtP1HP);
        txtP2HP = findViewById(R.id.txtP2HP);
        txtP1DPT = findViewById(R.id.txtP1DPT);
        txtP2DPT = findViewById(R.id.txtP2DPT);
        txtMsg = findViewById(R.id.txtMessage);

        Button BtnNext = findViewById(R.id.btnNextTurn);

        switch (v.getId()){
            case R.id.btnNextTurn:

                if (turnNumbers%2==1){
                    P2HP = P2HP - P1DPT;
                    txtMsg.setText("Soldier Dealt " +P1DPT+  "Damage to the Tank!");
                    turnNumbers++;
                    BtnNext.setText("Tank's Turn");
                }
                else{
                    P1HP = P1HP - P2DPT;
                    txtMsg.setText("Tank Dealt"  +P2DPT+  "Damage to the Soldier!");
                    turnNumbers++;
                    BtnNext.setText("Soldier's Turn");
                }
                txtP1HP.setText(String.valueOf(P1HP));
                txtP2HP.setText((String.valueOf(P2HP)));
                txtP1DPT.setText((P1minDamage)+ " ~ "+ (P1maxDamage));
                txtP2DPT.setText((P2minDamage)+ " ~ "+ (P2maxDamage));

                if (P1HP<=0){
                    txtMsg.setText("Tank Won!");
                    txtP1HP.setText("");
                    txtP2HP.setText("");
                    txtP1DPT.setText("");
                    txtP2DPT.setText("");
                    BtnNext.setText("And so it won, absolutely crushing the human");
                }
                else if (P2HP<=0){
                    txtMsg.setText("Soldier Won!");
                    txtP1HP.setText("");
                    txtP2HP.setText("");
                    txtP1DPT.setText("");
                    txtP2DPT.setText("");
                    BtnNext.setText("And so he won, somehow destroying a tank");
                }

                break;

        }


    }
}