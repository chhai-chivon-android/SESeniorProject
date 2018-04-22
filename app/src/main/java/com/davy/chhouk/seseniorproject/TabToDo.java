package com.davy.chhouk.seseniorproject;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.davy.chhouk.seseniorproject.model.Todo;
import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static android.app.Activity.RESULT_OK;

public class TabToDo extends Fragment {
    final ArrayList<Todo> todos = new ArrayList<>();
    ArrayList<String> todosString = new ArrayList<>();
    ListAdapter datesAdapter;
    ListView tasks;
    CompactCalendarView compactCalendarView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.tab3_todo, container, false);

        final TextView calenderTitle = rootView.findViewById(R.id.calendarDate);
        Date date = new Date();
        calenderTitle.setText((date.getMonth() + 1) + "/" + (date.getYear() + 1900));

        compactCalendarView = rootView.findViewById(R.id.compactcalendar_view);

        tasks = rootView.findViewById(R.id.tasks);

        Todo task1 = new Todo("Write Proposal", new Date(2018, 04, 10), "Mr. Member 1");
        Todo task2 = new Todo("Submit Proposal", new Date(2018, 04, 17, 12, 00), "Mr. Member 2 & Mr. Member 1");
        Todo task3 = new Todo("Create Slide", new Date(2018, 04, 20), "Mr. Member 2");
        Todo task4 = new Todo("Present Proposal", new Date(2018, 04, 25, 13, 00), "Mr. Member 1 & Mr. Member 2");

        todos.add(task1);
        todos.add(task2);
        todos.add(task3);
        todos.add(task4);

        for (Todo task : todos) {
            todosString.add(task.getStringTodo());

            Event event = new Event(Color.GREEN, task.getMillis(), task.getTitle());
            compactCalendarView.addEvent(event);
        }

        datesAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, todosString);
        tasks.setAdapter(datesAdapter);

        compactCalendarView.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {
                for (Todo task: todos) {
                    String dateTask = "" + task.getDateTime().getYear() + task.getDateTime().getMonth() + task.getDateTime().getDate();
                    String dateClickedString = "" + (dateClicked.getYear() + 1900) + (dateClicked.getMonth() + 1) + dateClicked.getDate();
                    if (dateClickedString.equalsIgnoreCase(dateTask)) {
                        Toast.makeText(getActivity().getApplicationContext(), task.getStringTodo(), Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {
                calenderTitle.setText((firstDayOfNewMonth.getMonth() + 1) + "/" + (firstDayOfNewMonth.getYear() + 1900));
            }
        });

        Button addButton = rootView.findViewById(R.id.add_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addTodoIntent = new Intent(getActivity(), AddTODOActivity.class);
                startActivityForResult(addTodoIntent, 1);
            }
        });

        return rootView;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // In fragment class callback
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                Todo newTodo = new Todo();
                newTodo.setTitle(data.getStringExtra("title"));
                newTodo.setWho(data.getStringExtra("who"));
//                Date datetime = new Date();
//                datetime.setDate(data.getIntExtra("day", 22));
//                datetime.setMonth(data.getIntExtra("month", 4));
//                datetime.setYear(data.getIntExtra("year", 2018));
//                datetime.setHours(data.getIntExtra("hour", 12));
//                datetime.setDate(data.getIntExtra("minute", 0));
//                datetime.setSeconds(0);

                String myDate = data.getIntExtra("year", 2018) + "/" + data.getIntExtra("month", 1) + "/" + data.getIntExtra("day", 1) + " " + data.getIntExtra("hour", 1) + ":" + data.getIntExtra("minute", 1) +
                        ":00";
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Date date = new Date();
                try {
                    date = sdf.parse(myDate);
                    date.setYear(date.getYear() + 1900);
                    date.setMonth(date.getMonth() + 1);
                } catch (Exception e) {
                    System.out.println(e);
                }

                System.out.println("RECEIVING: " + data.getIntExtra("year", 2018));
                System.out.println("RECEIVING: " + data.getIntExtra("month", 4));
                System.out.println("RECEIVING: " + data.getIntExtra("day", 22));
                System.out.println("RECEIVING: " + data.getIntExtra("hour", 12));
                System.out.println("RECEIVING: " + data.getIntExtra("minute", 0));

                newTodo.setDateTime(date);
                addNewTodotoAdapter(newTodo);
            }
        }
    }

    private void addNewTodotoAdapter(Todo newTodo) {
        todos.add(newTodo);
        todosString.add(newTodo.getStringTodo());
        tasks.requestLayout();
        Event event = new Event(Color.GREEN, newTodo.getMillis(), newTodo.getTitle());
        compactCalendarView.addEvent(event);
    }
}
