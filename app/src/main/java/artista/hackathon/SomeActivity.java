package artista.hackathon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SomeActivity extends AppCompatActivity {

    TextView tvCoinName, tvDelta, tvExc1, tvExc2, tvSome1, tvSome2, tvProfit;
    String name, delta, exc1, exc2, some1, some2, profit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_some);

        tvCoinName = findViewById(R.id.tv_coin_name);
        tvDelta = findViewById(R.id.tv_delta);
        tvExc1 = findViewById(R.id.tv_binance);
        tvExc2 = findViewById(R.id.tv_ex2);
        tvSome1 = findViewById(R.id.tv_var1);
        tvSome2 = findViewById(R.id.tv_var2);
        tvProfit = findViewById(R.id.tv_profit);

        setData(name, delta, exc1, exc2, some1, some2, profit);
    }

    private void setData(String name, String delta, String exc1, String exc2, String some1, String some2, String profit) {
        tvCoinName.setText(name);
        tvDelta.setText(name);
        tvCoinName.setText(name);
        tvExc1.setText(name);
        tvExc2.setText(name);
        tvSome1.setText(name);
        tvSome2.setText(name);
        tvProfit.setText(profit);
    }


}
