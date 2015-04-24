package com.roman.graphview;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class MainActivity extends ListActivity {

	// The Intent is used to issue that an operation should
	// be performed

	Intent intent;
	TextView betID;

	// The object that allows me to manipulate the database

	DBTools dbTools = new DBTools(this);

	// Called when the Activity is first called

	protected void onCreate(Bundle savedInstanceState) {
		// Get saved data if there is any

		super.onCreate(savedInstanceState);

		// Designate that activity_main.xml is the interface used
		
		setContentView(R.layout.activity_main);

		// Gets all the data from the database and stores it
		// in an ArrayList

		ArrayList<HashMap<String, String>> betsList =  dbTools.getAllBets();

		// Check to make sure there are contacts to display

		if(betsList.size()!=0) {
			
			// Get the ListView and assign an event handler to it
			
			ListView listView = getListView();
			listView.setOnItemClickListener(new OnItemClickListener() {
				
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
					
					// When an item is clicked get the TextView
					// with a matching checkId
					
					betID = (TextView) view.findViewById(R.id.betsIdEntryTextView);
					
					// Convert that contactId into a String
					
					String betIdValue = betID.getText().toString();	
					
					// Signals an intention to do something
					// getApplication() returns the application that owns
					// this activity
					
					Intent  theIndent = new Intent(getApplication(), EditBet.class);
					
					// Put additional data in for EditContact to use
					
					theIndent.putExtra("betId", betIdValue);
					
					// Calls for EditContact
					
					startActivity(theIndent); 
				}
			}); 
			
			// A list adapter is used bridge between a ListView and
			// the ListViews data
			
			// The SimpleAdapter connects the data in an ArrayList
			// to the XML file
			
			// First we pass in a Context to provide information needed
			// about the application
			// The ArrayList of data is next followed by the xml resource
			// Then we have the names of the data in String format and
			// their specific resource ids
			
			ListAdapter adapter = new SimpleAdapter( MainActivity.this, betsList, R.layout.bets_entry, new String[] { "betsID","homeSide", "awaySide"}, new int[] {R.id.betsIdEntryTextView, R.id.homeSideEntryTextView, R.id.awaySideEntryTextView});
			
			// setListAdapter provides the Cursor for the ListView
			// The Cursor provides access to the database data
			
			setListAdapter(adapter);
		}
	}
	
	// When showAddContact is called with a click the Activity 
	// NewContact is called
	
	public void showAddContact(View view) {
		Intent theIntent = new Intent(getApplication(), NewBet.class);
		startActivity(theIntent);
	}
}