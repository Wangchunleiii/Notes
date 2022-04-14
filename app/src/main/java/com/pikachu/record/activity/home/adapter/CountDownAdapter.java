package com.pikachu.record.activity.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.pikachu.record.R;
import com.pikachu.record.sql.table.CountDown;
import com.pikachu.record.tool.ToolPublic;
import com.pikachu.record.tool.ToolTime;

public class CountDownAdapter extends BaseAdapter<CountDown> {

    public CountDownAdapter(Context context) {
        super(context);
    }

    @Override
    int getListId() {
        return R.id.id_home_main_scroll_recyclerView_countdown;
    }

    @Override
    protected Adapter<ViewHolder> getAdapter() {
        return new RecyclerView.Adapter<RecyclerView.ViewHolder>() {
            @NonNull
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View inflate = LayoutInflater.from(context).inflate(R.layout.home_main_list_countdown_ui, parent, false);
                return new ItemHolder(inflate);
            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

                ItemHolder itemHolder = (ItemHolder) holder;
                itemHolder.item.setText(tasks.get(position).getTitle());
                itemHolder.text.setText(tasks.get(position).getText());
                itemHolder.startTime.setText(tasks.get(position).getTime());

                itemHolder.delete.setOnClickListener(
                        v -> taskActivityItemOnclick.deleteOnClick(v, position, tasks.get(position)));

                itemHolder.complete.setOnClickListener(
                        v -> taskActivityItemOnclick.completeOnClick(v, position, tasks.get(position)));

                if (tasks.get(position).getIsAs()) {
                    itemHolder.isAs.setText(string2);
                    itemHolder.isAs.setTextColor(color2);

                    itemHolder.complete.setVisibility(View.GONE);
                    itemHolder.view.setVisibility(View.GONE);
                } else {
                    itemHolder.isAs.setText(string1);
                    itemHolder.isAs.setTextColor(color1);
                    itemHolder.view.setVisibility(View.VISIBLE);
                    itemHolder.complete.setVisibility(View.VISIBLE);
                }
                String restTime = ToolTime.getRestTime(tasks.get(position).getStopTime(), ToolPublic.TIME_DATA);
                if ("已过期".equals(restTime)) {
                    itemHolder.stopTime.setText("已过期");
//                    taskActivityItemOnclick.completeOnClick(null, position, tasks.get(position));
                } else {
                    itemHolder.stopTime.setText(ToolTime.getRestTime(tasks.get(position).getStopTime(), ToolPublic.TIME_DATA));
                }

                int i = random.nextInt(ToolPublic.MOOD_STR_TO_COLOR.size());
                itemHolder.cardView.setCardBackgroundColor(ToolPublic.MOOD_STR_TO_COLOR.get(i).color);

            }

            @Override
            public int getItemCount() {
                return tasks.size();
            }

            class ItemHolder extends RecyclerView.ViewHolder {

                public final TextView item;
                public final TextView text;
                public final TextView startTime;
                public final TextView isAs;
                public final TextView stopTime;
                public final TextView delete;
                public final TextView complete;
                private final CardView cardView;
                private final View view;

                public ItemHolder(@NonNull View itemView) {
                    super(itemView);
                    item = itemView.findViewById(R.id.id_home_main_list_textView_1);
                    text = itemView.findViewById(R.id.id_home_main_list_textView_2);
                    startTime = itemView.findViewById(R.id.id_home_main_list_textView_3);
                    isAs = itemView.findViewById(R.id.id_home_main_list_textView_4);
                    stopTime = itemView.findViewById(R.id.id_home_main_list_textView_5);
                    delete = itemView.findViewById(R.id.id_home_main_list_textView_6);
                    complete = itemView.findViewById(R.id.id_home_main_list_textView_7);
                    cardView = itemView.findViewById(R.id.id_home_main_list_cardView_1);
                    view = itemView.findViewById(R.id.id_home_main_list_view_1);
                }
            }


        };
    }


}
