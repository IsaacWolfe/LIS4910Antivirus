package com.antivirus.lis4910.iwolfe.lis4910antivirus;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class listActivity extends AppCompatActivity {

    ListView privacyIssueListView;
    String[] issueApplications;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Resources res= getResources();
        privacyIssueListView = findViewById(R.id.privacyIssueListView);
        issueApplications = res.getStringArray(R.array.issueApplications);

        privacyIssueListView.setAdapter(new ArrayAdapter<String>(this, R.layout.issue_applications_detail, issueApplications));
    }
}