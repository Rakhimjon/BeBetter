package shaishav.com.bebetter.Fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import shaishav.com.bebetter.R;
import shaishav.com.bebetter.Utils.Constants;

/**
 * A simple {@link Fragment} subclass.
 */
public class IntroThird extends Fragment {


    public IntroThird() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.intro_third, container, false);
        EditText editText = (EditText)rootView.findViewById(R.id.goal);
        editText.getBackground().mutate().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
        editText.setImeOptions(EditorInfo.IME_ACTION_DONE);

        SharedPreferences preferences = getActivity().getSharedPreferences(Constants.PREFERENCES, Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = preferences.edit();

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                int min = Integer.parseInt(editable.toString());
                editor.putInt(Constants.GOAL,min);
                editor.commit();

            }
        });

        return rootView;
    }

}
