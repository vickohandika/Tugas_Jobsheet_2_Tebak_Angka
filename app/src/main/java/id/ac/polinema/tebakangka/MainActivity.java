package id.ac.polinema.tebakangka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

	//  TODO: deklarasikan variabel di sini
	Button guess_button, reset_button;
	EditText number_input;
	int min= 1;
	int max = 100;
	int randomNumber = initRandomNumber();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// TODO: bind layout di sini
		guess_button = findViewById(R.id.guess_button);
		reset_button = findViewById(R.id.reset_button);
		number_input = findViewById(R.id.number_input);
		reset_button.setEnabled(false);
	}

	// TODO: generate angka random di sini
	private int initRandomNumber() {
		int random = (int) (Math.random() * ((max-min)+1)) + min;
		return random;
	}

	public void handleGuess(View view) {
		// TODO: Tambahkan logika untuk melakukan pengecekan angka
		if(number_input.getText().toString().equals("")){
			Toast.makeText(this, "Isi angka tebakan angks", Toast.LENGTH_SHORT).show();
		}
		else{
			int a = Integer.parseInt(number_input.getText().toString());

			if(a > max){
				Toast.makeText(this, "Tebakan lebih dari 100", Toast.LENGTH_SHORT).show();
			}
			else if(a < min){
				Toast.makeText(this, "Tebakan kurang dr 1", Toast.LENGTH_SHORT).show();
			}
			else if(a < randomNumber){
				Toast.makeText(this, "Tebakkan anda terlalu kecil", Toast.LENGTH_SHORT).show();
			}
			else if(a > randomNumber){
				Toast.makeText(this, "tebakkan anda terlalu besar", Toast.LENGTH_SHORT).show();
			}
			else{
				Toast.makeText(this, "benar", Toast.LENGTH_SHORT).show();
				guess_button.setEnabled(false);
				reset_button.setEnabled(true);
			}
		}


	}

	public void handleReset(View view) {
		// TODO: Reset tampilan
		number_input.setText("");
		reset_button.setEnabled(false);
		guess_button.setEnabled(true);
		randomNumber = initRandomNumber();
	}
}
