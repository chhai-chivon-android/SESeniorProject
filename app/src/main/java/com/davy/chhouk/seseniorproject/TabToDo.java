package com.davy.chhouk.seseniorproject;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.davy.chhouk.seseniorproject.model.Todo;
import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TabToDo extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.tab3_todo, container, false);

        CompactCalendarView compactCalendarView = rootView.findViewById(R.id.compactcalendar_view);

        ListView tasks = rootView.findViewById(R.id.tasks);

        ArrayList<Todo> todos = new ArrayList<>();
        Todo task1 = new Todo("Write Proposal", new Date(2018, 04, 10), "Mr. Member 1");
        Todo task2 = new Todo("Submit Proposal", new Date(2018, 04, 17, 12, 00), "Mr. Member 2 & Mr. Member 1");
        Todo task3 = new Todo("Create Slide", new Date(2018, 04, 20), "Mr. Member 2");
        Todo task4 = new Todo("Present Proposal", new Date(2018, 04, 25, 13, 00), "Mr. Member 1 & Mr. Member 2");
        todos.add(task1);
        todos.add(task2);
        todos.add(task3);
        todos.add(task4);

        ArrayList<String> todosString = new ArrayList<>();
        for (Todo task : todos) {
            todosString.add(task.getStringTodo());
            System.out.println("TODO DATE " + task.getMilli());
            System.out.println("TODO DATE " + task.getDateTime().getDate());
            System.out.println("TODO DATE " + task.getDateTime().getMonth());
            System.out.println("TODO DATE " + task.getDateTime().getYear());

            String myDate = task.getDateTime().getYear() + "/" + task.getDateTime().getMonth() + "/" + task.getDateTime().getDate() + " " + task.getDateTime().getHours() + ":" + task.getDateTime().getMinutes() +
                    ":" + task.getDateTime().getSeconds();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = task.getDateTime();
            try {
                date = sdf.parse(myDate);
            } catch (Exception e) {
                System.out.println(e);
            }
            long millis = date.getTime();
            System.out.println("MILLI " + millis);
            Event event = new Event(Color.GREEN, millis, task.getTitle());
            compactCalendarView.addEvent(event);
        }

        ListAdapter datesAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, todosString);
        tasks.setAdapter(datesAdapter);

        compactCalendarView.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {
                System.out.println("DataClicked" + dateClicked);
            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {

            }
        });

        return rootView;
    }
}
