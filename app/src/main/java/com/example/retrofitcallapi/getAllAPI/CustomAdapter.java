package com.example.retrofitcallapi.getAllAPI;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.retrofitcallapi.R;

import java.util.List;

public class CustomAdapter extends BaseAdapter {

    private List<ImagesResponse> imagesResponseList;
    private Context context;
    private LayoutInflater layoutInflater;

    public CustomAdapter(List<ImagesResponse> imagesResponseList, Context context) {
        this.imagesResponseList = imagesResponseList;
        this.context = context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return imagesResponseList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = layoutInflater.inflate(R.layout.row_grid_item, viewGroup, false);

        }

        ImageView imgItem;
        TextView tvId_item, tvngayThang_item, tvnoiDung_item;
        imgItem = view.findViewById(R.id.img_item);

//        tvId_item = view.findViewById(R.id.tvId_item);
//        tvngayThang_item = view.findViewById(R.id.tvngayThang_item);
//        tvnoiDung_item = view.findViewById(R.id.tvnoiDung_item);
//
//        tvId_item.setText(imagesResponseList.get(i).getId());
//        tvngayThang_item.setText(imagesResponseList.get(i).getNgayThang());
//        tvnoiDung_item.setText(imagesResponseList.get(i).getNoiDung());

        GlideApp.with(context)
                .load(imagesResponseList.get(i).getLinkAnh())
                .into(imgItem);

        return view;
    }
}
