package com.davy.chhouk.seseniorproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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
        projectTitle.setText("SE Senior Project".toUpperCase());

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

        FloatingActionButton fab = rootView.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
                emailIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                emailIntent.setType("vnd.android.cursor.item/email");
                emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[] {"coordinator@camt.info"});
                emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "SE Senior Project");
                emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "");
                startActivity(Intent.createChooser(emailIntent, "Email"));
            }
        });

        return rootView;
    }
}
