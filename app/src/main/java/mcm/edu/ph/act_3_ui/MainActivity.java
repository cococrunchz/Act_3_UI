package mcm.edu.ph.act_3_ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int turnNumber = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hero lillian = new hero();
        lillian.minDMG =50;
        lillian.maxDMG =80;
        lillian.HP = 1000;
        lillian.SP = 500;
        lillian.next = 0;

        ghost boo = new ghost();
        boo.ghostMinDMG = 90;
        boo.ghostMaxDMG = 100;
        boo.ghostHP = 1000;
        boo.ghostSP = 0;

        TextView txtHP, txtSP, txtghostHP, txtghostType;
        Button btnAttack;

        txtHP = findViewById(R.id.hpDisplay);
        txtSP = findViewById(R.id.spDisplay);
        txtghostHP = findViewById(R.id.ghostHp);
        txtghostType = findViewById(R.id.ghostType);

        btnAttack = findViewById(R.id.btnAtk);

        txtHP.setText(String.valueOf(lillian.HP));
        txtSP.setText((lillian.minDMG)+ " ~ "+ (lillian.maxDMG));
        txtghostHP.setText(String.valueOf(boo.ghostHP));
        txtghostType.setText("BOO");

        btnAttack.setOnClickListener(this);
    }
    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View view){

        TextView txtmessage;
        txtmessage = findViewById(R.id.txtmessage);

        Random random = new Random();
        hero lillian = new hero();
        ghost boo = new ghost();

        lillian.minDMG =50;
        lillian.maxDMG =80;
        lillian.HP = 1000;
        lillian.next = 0;
        lillian.turnNumber = 1;

        boo.ghostMinDMG = 90;
        boo.ghostMaxDMG = 100;
        boo.ghostHP = 1000;
        boo.ghostULT = 0.0;
        boo.turnNumber = 1;

        TextView txtHP, txtSP, txtghostHP;
        txtHP = findViewById(R.id.hpDisplay);
        txtSP = findViewById(R.id.spDisplay);
        txtghostHP = findViewById(R.id.ghostHp);

        lillian.holyspritz = random.nextInt(lillian.maxDMG - lillian.minDMG) + lillian.minDMG;
        boo.attack = random.nextInt(boo.ghostMaxDMG - boo.ghostMinDMG) + boo.ghostMinDMG;



        switch (view.getId()){
            case R.id.btnAtk:

                if (turnNumber%2 ==1) {
                    boo.ghostHP = boo.ghostHP - lillian.holyspritz;
                    txtmessage.setText("Mister Boo dealt " + lillian.holyspritz + " damage!");
                    turnNumber++;
                }
                else{
                    lillian.HP = lillian.HP - boo.attack;
                    txtmessage.setText("Lilllia dealt " + boo.attack + " damage!");
                    turnNumber++;
                }
                txtHP.setText(String.valueOf(lillian.HP));
                txtSP.setText(String.valueOf(lillian.SP));
                txtghostHP.setText(String.valueOf(boo.ghostHP));

                if (lillian.HP <= 0) {
                    txtmessage.setText("The hero was victorious!");
                    txtHP.setText("");
                    txtghostHP.setText("");
                    txtmessage.setText("Congratulations, You won!");
                }
                break;


        }

    }
}