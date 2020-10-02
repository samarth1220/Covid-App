package com.defiance.confine;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

public class HelpLineFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    private String[] states = {
            "Select your state or Territory...",
            "Andaman and Nicobar",
            "Andhra Pradesh",
            "Arunachal Pradesh",
            "Assam",
            "Bihar",
            "Chandigarh",
            "Chhattisgarh",
            "Dadra and Nagar Haveli",
            "Daman and Diu",
            "Delhi",
            "Goa",
            "Gujarat",
            "Haryana",
            "Himachal Pradesh",
            "Jammu and Kashmir",
            "Jharkhand",
            "Karnataka",
            "Kerala",
            "Ladakh",
            "Lakshadweep",
            "Maharashtra",
            "Manipur",
            "Meghalaya",
            "Mizoram",
            "Madhya Pradesh",
            "Nagaland",
            "Odisha",
            "Puducherry",
            "Punjab",
            "Rajasthan",
            "Sikkim",
            "Tamil Nadu",
            "Telengana",
            "Tripura",
            "Uttar Pradesh",
            "Uttarakhand",
            "West Bengal"
    };
    private Spinner spinner;
    private String number = "000";
    private Button call;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_help_line, container, false);

        call = view.findViewById(R.id.call_helpline);
        spinner = view.findViewById(R.id.helpline_spinner);
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_dropdown_item, states);
        spinner.setAdapter(adapter);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    callNumber();
                }
                else {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        requestPermissions(new String[] {Manifest.permission.CALL_PHONE}, 1);
                    }
                }
            }
        });


        return  view;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                callNumber();
            } else {
            }
            return;
        }
    }

    private void callNumber() {
        if (TextUtils.equals(number, "000"))
            Toast.makeText(getActivity(), "Select your region from the dropdown menu", Toast.LENGTH_LONG).show();
        else
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + number)));
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch (i) {
            case 1:
                number = "03192-232102";
                break;
            case 2:
                number = "0866-2410978";
                break;
            case 3:
                number = "104";
                break;
            case 4:
                number = "104";
                break;
            case 5:
                number = "0612-2217681";
                break;
            case 6:
                number = "0172-2752038";
                break;
            case 7:
                number = "0771-282113";
                break;
            case 8:
                number = "0260-2642106";
                break;
            case 9:
                number = "0260-2630304 ";
                break;
            case 10:
                number = "011-22307145";
                break;
            case 11:
                number = "079-23251900";
                break;
            case 12:
                number = "079-23251900";
                break;
            case 13:
                number = "0172-2545938";
                break;
            case 14:
                number = "0177-2628940";
                break;
            case 15:
                number = "0191-2549676";
                break;
            case 16:
                number = "0651-2282201";
                break;
            case 17:
                number = "080-46848600";
                break;
            case 18:
                number = "0471-2552056";
                break;
            case 19:
                number = "01982-256462";
                break;
            case 20:
                number = "04896-263742";
                break;
            case 21:
                number = "022-22024535";
                break;
            case 22:
                number = "1800-345-3818";
                break;
            case 23:
                number = "0364-2224100";
                break;
            case 24:
                number = "102";
                break;
            case 25:
                number = "0755-2411180";
                break;
            case 26:
                number = "0370-2291122";
                break;
            case 27:
                number = "0674-2534177";
                break;
            case 28:
                number = "0413-2253407";
                break;
            case 29:
                number = "104";
                break;
            case 30:
                number = "0141-2225000";
                break;
            case 31:
                number = "03592-284444";
                break;
            case 32:
                number = "0471-2552056";
                break;
            case 33:
                number = "040-23286100";
                break;
            case 34:
                number = "0381-2315879";
                break;
            case 35:
                number = "0522-2237515";
                break;
            case 36:
                number = "104";
                break;
            case 37:
                number = "033-23412600";
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}