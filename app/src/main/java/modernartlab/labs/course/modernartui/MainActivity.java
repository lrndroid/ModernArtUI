package modernartlab.labs.course.modernartui;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBar;
    TextView textView1,textView2,textView3,textView4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar = (SeekBar)findViewById(R.id.seekBar2);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChanged = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                //change the background color as the progress value changes
                progressChanged = progress;
                textView1.setBackgroundColor(getResources().getColor(R.color.color1)+progress);
                textView2.setBackgroundColor(getResources().getColor(R.color.color2)+progress);
                textView3.setBackgroundColor(getResources().getColor(R.color.color3)+progress);
                textView4.setBackgroundColor(getResources().getColor(R.color.color4)+progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getBaseContext(),"Progress value: " + progressChanged,Toast.LENGTH_SHORT ).show();

            }
        });

        textView1 = (TextView)findViewById(R.id.textView1);
        textView2 = (TextView)findViewById(R.id.textView2);
        textView3 = (TextView)findViewById(R.id.textView3);
        textView4 = (TextView)findViewById(R.id.textView4);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.moreinfo_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.info:
                createMOMADialog();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    private void createMOMADialog(){

       AlertDialog.Builder builder =new  AlertDialog.Builder(this, R.style.MyDialogTheme)
               .setMessage("Inspired by the works of artists s" +
               "uch as Piet Mondrian Ben Nicholson. \n \n Click here to learn more!")
               .setNegativeButton(R.string.not_now, new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialog, int which) {

           }
       })
       .setPositiveButton(R.string.Visit_MOMA, new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialog, int which) {
               Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.MoMA.org"));
               startActivity(intent);
           }
       });
        AlertDialog dialog = builder.show();
        TextView messageText = (TextView)dialog.findViewById(android.R.id.message);

/*        final Button positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
        final Button negativeButton = dialog.getButton(AlertDialog.BUTTON_NEGATIVE);
        LinearLayout.LayoutParams positiveButtonLL = (LinearLayout.LayoutParams) positiveButton.getLayoutParams();
        positiveButtonLL.gravity = Gravity.CENTER;
        positiveButton.setLayoutParams(positiveButtonLL);
        LinearLayout.LayoutParams negativeButtonLL = (LinearLayout.LayoutParams) negativeButton.getLayoutParams();
        negativeButtonLL.gravity = Gravity.CENTER;
        negativeButton.setLayoutParams(negativeButtonLL);*/
        messageText.setGravity(Gravity.CENTER);
        dialog.show();

    }
}
