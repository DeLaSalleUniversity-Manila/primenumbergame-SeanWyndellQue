package wynsean.primenumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int number;
    private int totalscore;
    private boolean answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayRandomNumber();
    }

    public void onClickPrime(View view){
        answer = true;
        verifyAnswer();
        displayScore();
        displayRandomNumber();
    }

    public void onClickComposite(View view){
        answer = false;
        verifyAnswer();
        displayScore();
        displayRandomNumber();
    }

    private void verifyAnswer() {
        if (isPrime(number) == answer) {
            totalscore++;
            Toast.makeText(this, "Congratulations! You are correct!", Toast.LENGTH_SHORT).show();
        } else {
            totalscore = totalscore - 5;
            Toast.makeText(this, "You are wrong!", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isPrime(int value){
        for (int divisor = 2; divisor <= value/2; divisor++) {
            if (value % divisor == 0) {
                return false;
            }
        }
        return true;
    }

    private void displayRandomNumber(){
        TextView numberLabel = (TextView) findViewById(R.id.textViewNumber);
        Random randomGenerator = new Random();
        number = randomGenerator.nextInt(998) + 2;
        String strNumber = number + "";
        numberLabel.setText(strNumber);
    }

    private void displayScore(){
        TextView viewTotalScore = (TextView) findViewById(R.id.textViewTotalScore);
        TextView viewScore = (TextView) findViewById(R.id.textViewScore);
        String score = "";
        if (isPrime(number) == answer) {
            score = "Your score is 1.";
        }
        else score = "Your score is -5.";
        String strTotalScore = "Total Score: " + totalscore;
        viewScore.setText(score);
        viewTotalScore.setText(strTotalScore);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
