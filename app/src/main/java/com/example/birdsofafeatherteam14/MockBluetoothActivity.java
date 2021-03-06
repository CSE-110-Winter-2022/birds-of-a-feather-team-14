package com.example.birdsofafeatherteam14;

import static com.example.birdsofafeatherteam14.Utilities.showAlert;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.birdsofafeatherteam14.model.db.AppDatabase;

import java.util.ArrayList;

public class MockBluetoothActivity extends AppCompatActivity {
    public ArrayList<String> messages = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mock_bluetooth);

        TextView uuidView = findViewById(R.id.uuid_plaintext);
        try {
            String currUserUUID = AppDatabase.singleton(getApplicationContext()).studentDAO().getCurrentUsers().get(0).uuid;
            uuidView.setText(currUserUUID);
        } catch (IndexOutOfBoundsException ex) {
            // don't set it
        }
    }

    public void onEnterMessageButtonClicked(View view) {
        EditText mock_message = findViewById(R.id.mock_message);
        messages.add(mock_message.getText().toString().replaceAll("\\n", "\n"));
        mock_message.setText("");
    }

    public void onBackToMainButtonClicked(View view) {
        Intent returnIntent = new Intent();
        returnIntent.putStringArrayListExtra("messages", messages);
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
    }
}