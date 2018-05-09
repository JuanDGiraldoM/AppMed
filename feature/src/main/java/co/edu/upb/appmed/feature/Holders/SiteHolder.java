package co.edu.upb.appmed.feature.Holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import co.edu.upb.appmed.feature.R;

public class SiteHolder extends RecyclerView.ViewHolder {

    private View view;

    public SiteHolder(View itemView) {
        super(itemView);
        this.view = itemView;
    }

    public void setName(String name){
        TextView field = view.findViewById(R.id.txtName);
        field.setText(name);
    }

    public void setAddress(String address){
        TextView field = view.findViewById(R.id.txtAddress);
        field.setText(address);
    }

    public void setExtra(String extra){
        TextView field = view.findViewById(R.id.txtExtra);
        field.setText(extra);
    }
}
