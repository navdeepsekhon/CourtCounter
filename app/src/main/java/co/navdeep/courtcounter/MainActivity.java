package co.navdeep.courtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((Button)findViewById(R.id.teamAPlusOneBtn)).setOnClickListener(new OnClickImpl("teamA", 1));
        ((Button)findViewById(R.id.teamAPlusTwoBtn)).setOnClickListener(new OnClickImpl("teamA", 2));
        ((Button)findViewById(R.id.teamAPlusThreeBtn)).setOnClickListener(new OnClickImpl("teamA", 3));

        ((Button)findViewById(R.id.teamBPlusOneBtn)).setOnClickListener(new OnClickImpl("teamB", 1));
        ((Button)findViewById(R.id.teamBPlusTwoBtn)).setOnClickListener(new OnClickImpl("teamB", 2));
        ((Button)findViewById(R.id.teamBPlusThreeBtn)).setOnClickListener(new OnClickImpl("teamB", 3));
    }

    public void resetScores(View view){
        ((TextView)findViewById(R.id.teamAScore)).setText("0");
        ((TextView)findViewById(R.id.teamBScore)).setText("0");
    }

    private void incrementTeamScore(String team, int score){
        team += "Score";
        TextView teamScoreView = findTextViewByIdString(team);
        int currentScore = Integer.parseInt(teamScoreView.getText().toString());
        currentScore += score;
        teamScoreView.setText(Integer.toString(currentScore));
    }

    private TextView findTextViewByIdString(String id){
        int teamScoreId = this.getResources().getIdentifier(id, "id", this.getPackageName());
        return (TextView)findViewById(teamScoreId);
    }

    private class OnClickImpl implements View.OnClickListener{
        String team;
        int score;
        public OnClickImpl(String team, int score){
            this.team = team;
            this.score = score;        
        }
        @Override
        public void onClick(View view){
            incrementTeamScore(team, score);
        }
    }
}