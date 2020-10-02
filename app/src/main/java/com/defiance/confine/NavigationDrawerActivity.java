package com.defiance.confine;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.shrikanthravi.customnavigationdrawer2.data.MenuItem;
import com.shrikanthravi.customnavigationdrawer2.widget.SNavigationDrawer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NavigationDrawerActivity extends AppCompatActivity {

    private SNavigationDrawer sNavigationDrawer;
    private Class fragmentClass;
    public static Fragment fragment;
    public static Map<String, String> map = new HashMap<>();
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private FirebaseUser mUser = FirebaseAuth.getInstance().getCurrentUser();
    private GoogleSignInClient signInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer2);
        if (getSupportActionBar() != null)
            getSupportActionBar().hide();

        if (mUser != null) {
            DocumentReference docRef = db.collection("Users").document(mUser.getEmail());
            docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if (task.isSuccessful()) {
                        DocumentSnapshot documentSnapshot = task.getResult();
                        if (documentSnapshot.exists()) {
                            Log.wtf("firestore data", "DocumentSnapshot data: " + documentSnapshot.getData());
                            for (String key : documentSnapshot.getData().keySet()) {
                                map.put(key, documentSnapshot   .get(key).toString());
                            }
                            Log.wtf("firestore data", map.toString());
                        }
                        else {
                            Log.wtf("firestore data", "No Such Document");
                        }
                    }
                    else {
                        Log.wtf("firestore data", "get failed with ", task.getException());
                    }
                }
            });

        }


        sNavigationDrawer = findViewById(R.id.navigationDrawer);
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("Home", R.drawable.ic_baseline_home_24));
        menuItems.add(new MenuItem("Diet Plan", R.drawable.diet));
        menuItems.add(new MenuItem("Helpline", R.drawable.helpline));
        menuItems.add(new MenuItem("Contact Us", R.drawable.contact));
        menuItems.add(new MenuItem("Sign Out", R.drawable.logout));
        Log.wtf("MAP", map.toString());


        sNavigationDrawer.setMenuItemList(menuItems);
        sNavigationDrawer.setAppbarColor(R.color.nav_head);
        sNavigationDrawer.setNavigationDrawerBackgroundColor(R.color.nav_head);
        fragmentClass = AssesmentFormFragment.class;
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .setCustomAnimations(
                            android.R.anim.fade_in,
                            android.R.anim.fade_out
                    )
                    .add(R.id.frameLayout, fragment)
                    .commit();
        }

        sNavigationDrawer.setOnMenuItemClickListener(new SNavigationDrawer.OnMenuItemClickListener() {
            @Override
            public void onMenuItemClicked(int position) {
                switch (position) {
                    case 0:
                        fragmentClass = AssesmentFormFragment.class;
                        break;
                    case 1:
                            fragmentClass = DietPlanFragment.class;
                        break;
                    case 2:
                        fragmentClass = HelpLineFragment.class;
                        break;
                    case 3:
                        fragmentClass = ContactUsFragment.class;
                        break;
                    case 4:
                        signInClient = GoogleSignIn.getClient(NavigationDrawerActivity.this,     LoginActivity.gso);
                        signInClient.signOut()
                                .addOnCompleteListener(NavigationDrawerActivity.this, new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                                    }
                                });
                        break;
                }
            }
        });

        sNavigationDrawer.setDrawerListener(new SNavigationDrawer.DrawerListener() {
            @Override
            public void onDrawerOpening() {

            }

            @Override
            public void onDrawerClosing() {
                try {
                    fragment = (Fragment) fragmentClass.newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                if (fragment != null) {
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager
                            .beginTransaction()
                            .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                            .replace(R.id.frameLayout, fragment)
                            .commit();
                }
            }

            @Override
            public void onDrawerOpened() {

            }

            @Override
            public void onDrawerClosed() {


            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }
}