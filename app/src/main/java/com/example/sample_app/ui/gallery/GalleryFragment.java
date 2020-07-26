package com.example.sample_app.ui.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.sample_app.Home_screen;
import com.example.sample_app.Image_upload;
import com.example.sample_app.Login_screen;
import com.example.sample_app.R;
import com.example.sample_app.Second_screen;

import org.json.JSONObject;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    private EditText etusename, etpassword;
    private Button btn_submit;
    RequestQueue requestQueue;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        //  final TextView textView = root.findViewById(R.id.text_gallery);
        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //      textView.setText(s);
            }
        });

        etusename = root.findViewById(R.id.etPersonName);
        etpassword = root.findViewById(R.id.et_Password);
        btn_submit = root.findViewById(R.id.btn_submit);
        requestQueue = Volley.newRequestQueue(getActivity());
        VolleySeriveCall();

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             /*   try {
                    String str_username = etusename.getText().toString().trim();
                    String str_password = etpassword.getText().toString().trim();
                    Log.d("username", str_username + "\n" + str_password);

                }catch (Exception e){

                }
*/
                if (etusename.getText().toString().trim().length() == 0) {
                    etusename.setError("Please enter username");
                    etusename.requestFocus();

                } else if (etpassword.getText().toString().trim().length() == 0) {
                    etpassword.setError("Please enter password");
                    etpassword.requestFocus();
                } else {
                    Intent intent = new Intent(getActivity(), Image_upload.class);
                    startActivity(intent);
                }

            }
        });
        return root;
    }

    private void VolleySeriveCall() {

        String str_SErviice ="http://tscops.telangana.gov.in:8081/LogicShore.svc/TSDistricts";
        JsonObjectRequest j = new JsonObjectRequest(Request.Method.GET, str_SErviice, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("myresponse",response.toString());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(j);
    }

}