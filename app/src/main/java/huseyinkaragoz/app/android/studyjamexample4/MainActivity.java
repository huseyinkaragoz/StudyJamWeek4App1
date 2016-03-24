package huseyinkaragoz.app.android.studyjamexample4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nameInput;
    TextView nameOutput, genderOutput;
    CheckBox state;
    RadioGroup radioGroup;
    RadioButton men, women;
    Button submit;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameInput = (EditText) findViewById(R.id.edittext1);
        nameOutput = (TextView) findViewById(R.id.show_name);
        genderOutput = (TextView) findViewById(R.id.gender);
        state = (CheckBox) findViewById(R.id.cb);
        radioGroup = (RadioGroup) findViewById(R.id.radiogrup);
        men = (RadioButton) findViewById(R.id.cinsiyet1);
        women = (RadioButton) findViewById(R.id.cinsiyet2);
        submit = (Button) findViewById(R.id.submit_button);
        state.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    name = nameInput.getText().toString();
                    nameOutput.setText(name);
                }
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = radioGroup.getCheckedRadioButtonId();
                if (id == men.getId()) {
                    genderOutput.setText("Erkek");
                    Toast.makeText(getApplicationContext(), "Cinsiyet Erkek", Toast.LENGTH_SHORT).show();
                }
                else if (id == women.getId()) {
                    genderOutput.setText("Kadın");
                    Toast.makeText(getApplicationContext(), "Cinsiyet Kadın", Toast.LENGTH_SHORT).show();
                }else
                    Toast.makeText(getApplicationContext(), "Cinsiyet Belirtilmedi", Toast.LENGTH_SHORT).show();


            }
        });

    }
}
