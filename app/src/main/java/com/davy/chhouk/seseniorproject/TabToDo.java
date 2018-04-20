package com.davy.chhouk.seseniorproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class TabToDo extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab3_todo, container, false);

        ListView tasks = rootView.findViewById(R.id.tasks);

        ArrayList<String> todos = new ArrayList<>();
        todos.add("Write Proposal: 10th April 2018");
        todos.add("Submit Proposal: 17th April 2018 12:00 pm");
        todos.add("Create Slide: 20th April 2018");
        todos.add("Presentation Proposal: 25th April 2018 pm");

        ListAdapter datesAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, todos);
        tasks.setAdapter(datesAdapter);

        return rootView;
    }
}
