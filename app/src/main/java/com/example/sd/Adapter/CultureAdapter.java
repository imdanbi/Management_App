package com.example.sd.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.sd.Culture;
import com.example.sd.MainActivity;
import com.example.sd.R;

import org.w3c.dom.Text;

import java.util.List;

public class CultureAdapter extends BaseAdapter {

    private Context context;
    private List<Culture> cultureList;
    private Fragment parent;

    public CultureAdapter(Context context, List<Culture> cultureList, Fragment parent){
        this.context=context;
        this.cultureList = cultureList;
        this.parent = parent;
    }
    @Override
    public int getCount() {
        return cultureList.size();
    }

    @Override
    public Object getItem(int i) {
        return cultureList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = View.inflate(context, R.layout.culture, null);
        TextView courseGrade = (TextView) v.findViewById(R.id.courseGrade);
        TextView courseTitle = (TextView) v.findViewById(R.id.courseTitle);
        TextView courseArea = (TextView) v.findViewById(R.id.courseArea);

        courseTitle.setText(cultureList.get(i).getCourseTitle());
        courseGrade.setText(cultureList.get(i).getCourseGrade());
        courseArea.setText(cultureList.get(i).getCourseArea());
        return v;
    }
}
