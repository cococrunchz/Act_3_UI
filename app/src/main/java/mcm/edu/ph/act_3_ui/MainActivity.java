package mcm.edu.ph.act_3_ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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
        lillian.HP = 800;

        ghost boo = new ghost();
        boo.ghostMinDMG = 90;
        boo.ghostMaxDMG = 100;
        boo.ghostHP = 1000;

        TextView txtHP, txtDMG, txtghostHP, txtghostType;
        Button btnAttack;

        txtHP = findViewById(R.id.hpDisplay);
        txtDMG = findViewById(R.id.dmgDisplay);
        txtghostHP = findViewById(R.id.ghostHp);
        txtghostType = findViewById(R.id.ghostType);

        btnAttack = findViewById(R.id.btnAtk);

        txtHP.setText(String.valueOf(lillian.HP));
        txtDMG.setText((lillian.minDMG)+ " ~ "+ (lillian.maxDMG));
        txtghostHP.setText(String.valueOf(boo.ghostHP));
        txtghostType.setText("BOO");
        btnAttack.setText("START");

        btnAttack.setOnClickListener(this);

        ImageView lilliasmile = findViewById(R.id.lillia_smile);
        ImageView lilliasad = findViewById(R.id.lilliasad);

        lilliasmile.setVisibility(View.VISIBLE);
        lilliasad.setVisibility(View.INVISIBLE);


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
        lillian.HP = 800;


        boo.ghostMinDMG = 90;
        boo.ghostMaxDMG = 100;
        boo.ghostHP = 1000;


        TextView txtHP, txtDMG, txtghostHP;
        Button btnAttack;

        txtHP = findViewById(R.id.hpDisplay);
        txtDMG = findViewById(R.id.dmgDisplay);
        txtghostHP = findViewById(R.id.ghostHp);

        btnAttack = findViewById(R.id.btnAtk);


        int holyspritz = random.nextInt(lillian.maxDMG - lillian.minDMG) + lillian.minDMG;
        int ghostattack = random.nextInt(boo.ghostMaxDMG - boo.ghostMinDMG) + boo.ghostMinDMG;

        ImageView lilliasmile = findViewById(R.id.lillia_smile);
        ImageView lilliasad = findViewById(R.id.lilliasad);


        switch (view.getId()){
            case R.id.btnAtk:

                if (turnNumber%2 ==1) {
                    boo.ghostHP = boo.ghostHP - holyspritz;
                    txtmessage.setText("Mister Boo dealt " + holyspritz + " damage!");
                    btnAttack.setText("Ghost's turn");

                    lilliasmile.setVisibility(View.VISIBLE);
                    lilliasad.setVisibility(View.INVISIBLE);

                    turnNumber++;
                }
                else{
                    lillian.HP = lillian.HP - ghostattack;
                    txtmessage.setText("Lilllia dealt " + ghostattack + " damage!");
                    btnAttack.setText("Lillia's turn");
                    lilliasmile.setVisibility(View.INVISIBLE);
                    lilliasad.setVisibility(View.VISIBLE);
                    turnNumber++;
                }
                txtHP.setText(String.valueOf(lillian.HP));
                txtghostHP.setText(String.valueOf(boo.ghostHP));
                txtDMG.setText((lillian.minDMG)+ " ~ "+ (lillian.maxDMG));

                if (lillian.HP <= 0) {
                    txtmessage.setText("The hero was victorious!");
                    txtHP.setText("");
                    txtghostHP.setText("");
                }
                else if (boo.ghostHP <= 0){
                    txtmessage.setText("The ghost was victorious!");
                    txtHP.setText("");
                    txtghostHP.setText("");
                }
                break;


        }

    }
}