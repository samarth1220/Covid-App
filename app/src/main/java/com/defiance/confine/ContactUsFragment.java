package com.defiance.confine;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ContactUsFragment extends Fragment {

    private TextView feedback;
    private FirebaseUser user;
    private StringBuilder stringBuilder;
    private Button button;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact_us, container, false);

        feedback = view.findViewById(R.id.feedback);
        button = view.findViewById(R.id.send_feedback);
        stringBuilder = new StringBuilder();
        user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            stringBuilder.append("Hey ");
            stringBuilder.append(user.getDisplayName());
            stringBuilder.append(getString(R.string.feedback));
            stringBuilder.append("\nTeam Co-N-Fine");
            Log.wtf("stringbuilder", stringBuilder.toString());
            feedback.setText(stringBuilder.toString());
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback for CoNFine");
                intent.setData(Uri.parse("mailto:confineapp@googlegroups.com"));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        return view;
    }
}