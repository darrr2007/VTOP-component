package com.example.vtop;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;


public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id.toolbar); // Ignore red line errors
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav,R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MyInfoFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_myinfo);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.nav_payment) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new OnlinePaymentsFragment()).commit();
        } else if (itemId == R.id.nav_myinfo) {
            showPopupDialog(item.getActionView());
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


    private void navigateToNewActivity(String selectedItem) {
        Intent intent;
        switch (selectedItem) {
            case "Enter Details":
                intent = new Intent(HomeActivity.this, EnterDetailsActivity.class);
                break;
            case "Profile":
                intent = new Intent(HomeActivity.this, ProfileActivity.class);
                break;
            case "Your Credentials":
                intent = new Intent(HomeActivity.this, CredentialsActivity.class);
                break;
            case "Dayboarder Info":
                intent = new Intent(HomeActivity.this, DayboarderInfoActivity.class);
                break;
            case "Acknowledgment View":
                intent = new Intent(HomeActivity.this, AcknowledgmentActivity.class);
                break;
            case "Student Bank Info":
                intent = new Intent(HomeActivity.this, BankInfoActivity.class);
                break;
            case "VITOL Credentials":
                intent = new Intent(HomeActivity.this, VitolCredentialsActivity.class);
                break;
            case "Compre Exam Credentials":
                intent = new Intent(HomeActivity.this, CompreCredentialsActivity.class);
                break;
            case "LMS Credentials":
                intent = new Intent(HomeActivity.this, LMSCredentialsActivity.class);
                break;
            case "Hostel Counseling OTP":
                intent = new Intent(HomeActivity.this, HostelCounselingOTPActivity.class);
                break;
            case "Test 1":
                intent = new Intent(HomeActivity.this, Test1Activity.class);
                break;
            default:
                return; // Do nothing if no matching activity found
        }
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void showPopupDialog(View anchorView) {
        dialogBuilder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.popup_layout, null);
        listView = view.findViewById(R.id.list_view);

        final String[] options = {"Enter Details","Profile", "Your Credentials", "Dayboarder Info", "Acknowledgment View", "Student Bank Info",
                "VITOL Credentials", "Compre Exam Credentials", "LMS Credentials", "Hostel Counseling OTP", "Test 1"};

        ArrayAdapter<String> adapter = new CustomArrayAdapter(this, options);
        listView.setAdapter(adapter);

        dialogBuilder.setView(view);
        dialog = dialogBuilder.create();
        dialog.setTitle("My Info");

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String selectedItem = options[position];
                Toast.makeText(HomeActivity.this, selectedItem, Toast.LENGTH_SHORT).show();
                dialog.dismiss();

                navigateToNewActivity(selectedItem); // Call navigateToNewActivity with the selected item
            }
         });

        dialog.show();
    }

    private class CustomArrayAdapter extends ArrayAdapter<String> {

        public CustomArrayAdapter(Context context, String[] options) {
            super(context, android.R.layout.simple_list_item_1, options);
        }

        @Override
        public View getView(int position, View convertView, android.view.ViewGroup parent) {
            View view = super.getView(position, convertView, parent);

            // Set the background color to grey when the item is hovered

            view.setOnHoverListener(new View.OnHoverListener() {
                @Override
                public boolean onHover(View v, MotionEvent event) {
                    if (event.getAction() == MotionEvent.ACTION_HOVER_ENTER) {
                        view.setBackgroundColor(Color.LTGRAY);
                    } else if (event.getAction() == MotionEvent.ACTION_HOVER_EXIT) {
                        view.setBackgroundColor(Color.TRANSPARENT);
                    }
                    return false;
                }
            });




            return view;

        }
    }
}
