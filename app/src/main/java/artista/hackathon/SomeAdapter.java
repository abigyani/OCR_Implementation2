package artista.hackathon;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SomeAdapter extends RecyclerView.Adapter<SomeAdapter.ViewHolder>{

    private Context context;

    SomeAdapter(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public SomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull SomeAdapter.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvCoinName, tvDelta, tvExc1, tvExc2, tvSome1, tvSome2, tvProfit;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCoinName = itemView.findViewById(R.id.tv_coin_name);
            tvDelta = itemView.findViewById(R.id.tv_delta);
            tvExc1 = itemView.findViewById(R.id.tv_binance);
            tvExc2 = itemView.findViewById(R.id.tv_ex2);
            tvSome1 = itemView.findViewById(R.id.tv_var1);
            tvSome2 = itemView.findViewById(R.id.tv_var2);
            tvProfit = itemView.findViewById(R.id.tv_profit);

        }
    }
}
