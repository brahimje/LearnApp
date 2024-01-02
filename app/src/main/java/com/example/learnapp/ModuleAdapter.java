package com.example.learnapp;
import android.content.Context;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import java.util.List;

public class ModuleAdapter extends ArrayAdapter<Module> {

    private List<Module> modules;

    public ModuleAdapter(Context context, List<Module> modules) {
        super(context, 0, modules);
        this.modules = modules;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.module_list_item, parent, false);
        }

        Module module = getItem(position);

        if (module != null) {
            TextView acronymTextView = convertView.findViewById(R.id.acronymTextView);
            TextView nameTextView = convertView.findViewById(R.id.nameTextView);
            TextView creditTextView = convertView.findViewById(R.id.creditTextView);
            ConstraintLayout rootLayout = convertView.findViewById(R.id.rootLayout);

            if (acronymTextView != null) {
                acronymTextView.setText(module.getAcronym());
            }

            if (nameTextView != null) {
                nameTextView.setText(module.getName());
            }

            if (creditTextView != null) {
                creditTextView.setText(String.valueOf(module.getCredit()));
            }

            // Set background color of root layout based on conditions
            // Get the array of colors
            TypedArray itemColors = getContext().getResources().obtainTypedArray(R.array.item_colors);
            // Calculate the background color based on the position
            int backgroundColor = itemColors.getColor(position % itemColors.length(), 0);
            itemColors.recycle();
            rootLayout.setBackgroundColor(backgroundColor);

        }

        return convertView;
    }
}
