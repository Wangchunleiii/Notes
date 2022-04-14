package com.pikachu.record.activity.home.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.pikachu.record.R;
import com.pikachu.record.tool.ToolPublic;
import java.util.List;
import java.util.Random;

public abstract class BaseAdapter<T> {

    protected final Context context;
    protected final Activity activity;
    protected RecyclerView recyclerView;
    protected RecyclerView.Adapter<RecyclerView.ViewHolder> adapter;
    protected String string1;
    protected String string2;
    protected int color1;
    protected int color2;
    protected String string3;
    protected String string4;
    protected Random random;
    protected List<T> tasks;

    protected TaskActivityItemOnclick taskActivityItemOnclick=
    new TaskActivityItemOnclick(){
        @Override
        public void deleteOnClick(View view, int position, Object task) {
        }

        @Override
        public void completeOnClick(View view, int position, Object task) {
        }
    };


    public BaseAdapter(Context context) {
        this.context = context;
        activity = (Activity) context;
        findByView();
    }

    
    
    public interface TaskActivityItemOnclick{
        void deleteOnClick(View view,int position,Object task);
        void completeOnClick(View view,int position,Object task);
    }
    
    

    private void findByView() {
        recyclerView = activity.findViewById(getListId());
        string1 = context.getResources().getString(R.string.home_main_list_1);
        string2 = context.getResources().getString(R.string.home_main_list_6);
        color1 = context.getResources().getColor(R.color.color_fa);
        color2 = context.getResources().getColor(R.color.color_complete_1);
        string3 = context.getResources().getString(R.string.home_main_list_7);
        string4 = context.getResources().getString(R.string.home_main_list_8);
        random = new Random(1);//随机颜色
    }

    abstract int getListId();


    public void loadDataUpUi(List<T> tasks) {
        if (tasks.size()>ToolPublic.TASK_FRONT){
            this.tasks=tasks.subList(0,ToolPublic.TASK_FRONT);
        }else{
            this.tasks=tasks;
        }
        setRecyclerViewAdapter();
    }



    private void setRecyclerViewAdapter(){

        if (adapter==null){
            adapter = getAdapter();
            recyclerView.setAdapter(adapter);
            LinearLayoutManager ms= new LinearLayoutManager(context);
            ms.setOrientation(LinearLayoutManager.HORIZONTAL);
            recyclerView.setLayoutManager(ms);

        }else {
            recyclerView.post(() -> adapter.notifyDataSetChanged());

        }
    }

    protected abstract Adapter<ViewHolder> getAdapter();


    public void setTaskActivityItemOnclick(TaskActivityItemOnclick taskActivityItemOnclick) {
        this.taskActivityItemOnclick = taskActivityItemOnclick;
    }

}
