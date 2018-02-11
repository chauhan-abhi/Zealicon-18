package com.example.abhi.jsshndemo.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.abhi.jsshndemo.R;


public class RegisterFragment extends Fragment {

    private EditText nameView, emailView, collegeView, contactView;
    private Button register;
    private Spinner yearView, branchView, courseView;

    /*String year="1",branch="CSE",course="btech";
    String yeararray[]={"1","2","3","4"};
    String brancharray[]={"CSE","IT","ME","ECE","EE","CE","IC","EEE"};
    String coursearray[]={"btech","mca","mba"};
    */
    private String name, email, college, contact, year, branch, course, token_id;

    private TextView mtitle;


    public static Fragment newInstance() {
        RegisterFragment fragment = new RegisterFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_register, container, false);


        //mtitle= view.findViewById(R.id.textViewTitle);


        //yeararray=getResources().getStringArray(R.array.year);
        //brancharray=getResources().getStringArray(R.array.branch);

        nameView = (EditText) view.findViewById(R.id.name);
        emailView = (EditText) view.findViewById(R.id.email);
        collegeView = (EditText) view.findViewById(R.id.college);
        contactView = (EditText) view.findViewById(R.id.contact);
        register = (Button) view.findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("App", "started");
                name = ((EditText) view.findViewById(R.id.name)).getText().toString();
                email = ((EditText) view.findViewById(R.id.email)).getText().toString();
                college = ((EditText) view.findViewById(R.id.college)).getText().toString();
                contact = ((EditText) view.findViewById(R.id.contact)).getText().toString();
                course = courseView.getSelectedItem().toString();
                branch = branchView.getSelectedItem().toString();
                year = yearView.getSelectedItem().toString();

                Log.v("Register Fragment", name + email + contact + year + branch);
                if (name.equals("") || email.equals("") || college.equals("") || contact.equals("") || course.equals("") || branch.equals("") || year.equals(""))
                    Toast.makeText(getActivity(), "Sorry..Please Enter All Fields", Toast.LENGTH_SHORT).show();
                else {
                    // post data to api
                    registertask();
                }

            }
        });

        courseView = view.findViewById(R.id.course);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(getActivity(),
                R.array.course, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        courseView.setAdapter(adapter1);

        branchView = view.findViewById(R.id.branch);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getActivity(),
                R.array.branch, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        branchView.setAdapter(adapter2);

        yearView = view.findViewById(R.id.year);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(getActivity(),
                R.array.year, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yearView.setAdapter(adapter3);
        return view;

    }


    void registertask() {

    }


}
