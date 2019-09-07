package id.ac.polinema.tebakangka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

	//  TODO: deklarasikan variabel di sini
	Button guess_button, reset_button;
	EditText number_input;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// TODO: bind layout di sini

		guess_button = (Button) findViewById(R.id.guess_button);
		reset_button = (Button) findViewById(R.id.reset_button);
		number_input = (EditText) findViewById(R.id.number_input);

		guess_button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
//				Random r = new Random();
//				int randomInt = r.nextInt(100) + 1;
				int randomInt = 76;

				int angkaTebak = Integer.parseInt(number_input.getText().toString());

				if (randomInt == angkaTebak) {
					Toast.makeText(MainActivity.this, "SELAMAT ! Tebakan Anda Benar.", Toast.LENGTH_LONG).show();
					guess_button.setEnabled(false);
				} else if (randomInt < angkaTebak) {
					Toast.makeText(MainActivity.this, "Tebakan Anda Terlalu Besar !", Toast.LENGTH_LONG).show();
				} else if (randomInt > angkaTebak) {
					Toast.makeText(MainActivity.this, "Tebakan Anda Terlalu Kecil !", Toast.LENGTH_LONG).show();
				}

			}
		});

		reset_button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				guess_button.setEnabled(true);
				number_input.setText("");
				number_input.setFocusable(true);
			}
		});
	}

	// TODO: generate angka random di sini
	private void initRandomNumber() {

	}

	public void handleGuess(View view) {
		// TODO: Tambahkan logika untuk melakukan pengecekan angka
	}

	public void handleReset(View view) {
		// TODO: Reset tampilan
	}
}
