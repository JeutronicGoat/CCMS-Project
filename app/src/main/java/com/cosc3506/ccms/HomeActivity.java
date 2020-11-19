package com.cosc3506.ccms;

import android.content.Intent;
import android.os.Bundle;

import com.cosc3506.ccms.data.model.Club;
import com.cosc3506.ccms.data.model.Event;
import com.cosc3506.ccms.data.model.User;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.View;
import android.widget.LinearLayout;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    ArrayList clubList = new ArrayList(Arrays.asList("Club1","Club2","Club3"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ///---For Testing

//        FirebaseDatabase rootNode = FirebaseDatabase.getInstance();
//        DatabaseReference reference = rootNode.getReference("Clubs");
//        String ID = "123";
//        double budget = 1.23;
//        double remainingFunds = .69;
//        String room = "4h";
//        String name = "FloorGang";
//        ArrayList<Event> events = new ArrayList<>();
//        String description = "19 year olds";
//        ArrayList<User> managers = new ArrayList<>();
////
//        Club club = new Club(ID, budget, room, name, events, description);
////
//        Event event = new Event(3, "name", "ree", "uno", "dos", "cuatro", 50, 4);


//        event.newEvent(event, club);
//        event.deleteEvent(event,club);
//
// events.add(event);
////        club.setEvents(events);
//        reference.child(ID).setValue(club);
//        reference = rootNode.getReference("Clubs/123/Events");
//        reference.child(String.valueOf(event.getID())).setValue(event);



        //TODO have the logged in User object

        //--PUT THIS IN CREATE CLUB
        /*
        int ID = XtextField.getText();
        float budget = XtextField.getText();
        String room = XtextField.getText();
        String name = XtextField.getText();
        ArrayList<Event> events = XtextField.getText();
        String description = XtextField.getText();

        Club club = new Club(ID, budget, room, name, description);
        user.createClub(club, user);
        */

        //Get the recycler view
        RecyclerView clubsView = findViewById(R.id.club_list);

        //Create the linear layout manager
        LinearLayoutManager manager = new LinearLayoutManager(clubsView.getContext());
        clubsView.setLayoutManager(manager);

        //Create and apply Adapter
        CustomAdapter customAdapter = new CustomAdapter(this,new Intent(
                this,ClubActivity.class),clubList);
        clubsView.setAdapter(customAdapter);

    }

    public void onClickSettings(View view) {
        startActivity(new Intent(HomeActivity.this,SettingsActivity.class));
    }

    public void onClickAddClub(View view) {
        startActivity(new Intent(HomeActivity.this,JoinCreateClubActivity.class));
    }
}