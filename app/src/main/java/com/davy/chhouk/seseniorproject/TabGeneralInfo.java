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
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TabGeneralInfo extends Fragment {
    TextView projectTitle;
    TextView description;
    ArrayList<String> importantDates = new ArrayList<String>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab1_general_info, container, false);

        projectTitle = rootView.findViewById(R.id.project_title);
        projectTitle.setText("Project Name Sample".toUpperCase());

        description = rootView.findViewById(R.id.description);
        description.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.");

        ListView dates = rootView.findViewById(R.id.dates);

        importantDates.add("1st Proposal: April 17th, 2018");
        importantDates.add("2nd Proposal: April 25th, 2018");
        importantDates.add("1st Check-up confirmation: June 30th, 2018");
        importantDates.add("2st Check-up confirmation: July 31st, 2018");
        importantDates.add("1st Progress I Presentation: August 8th, 2018");
        importantDates.add("2st Progress I Presentation: August 22nd, 2018");
        importantDates.add("Final Progress Presentation: September 12th, 2018");
        importantDates.add("SE Show Pro: October 31st, 2018");

        ListAdapter datesAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, importantDates);
        dates.setAdapter(datesAdapter);

        return rootView;
    }
}
