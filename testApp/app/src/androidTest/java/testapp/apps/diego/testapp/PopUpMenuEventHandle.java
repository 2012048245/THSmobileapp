package testapp.apps.diego.testapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by User on 10/23/2015.
 */
//public class PopUpMenuEventHandle {}

public class PopUpMenuEventHandle extends Activity implements OnClickListener {
    LinearLayout layoutOfPopup;
    PopupWindow popupMessage;
    Button popupButton, insidePopupButton;
    TextView popupText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_page);
        init(); popupInit();
    }

    public void init() {
        popupButton = (Button) findViewById(R.id.popupbutton);
        popupText = new TextView(this);
        insidePopupButton = new Button(this);
        layoutOfPopup = new LinearLayout(this);
        insidePopupButton.setText("OK");
        popupText.setText("This is Popup Window.press OK to dismiss it.");
        popupText.setPadding(0, 0, 0, 20);
        layoutOfPopup.setOrientation(LinearLayout.HORIZONTAL);
        layoutOfPopup.addView(popupText);
        layoutOfPopup.addView(insidePopupButton);
    }

    public void popupInit() {
        popupButton.setOnClickListener((OnClickListener) this);
        insidePopupButton.setOnClickListener((OnClickListener) this);
        popupMessage = new PopupWindow(layoutOfPopup, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        popupMessage.setContentView(layoutOfPopup);
    }

    //@Override
    public void onClick(View v) {
        if (v.getId() == R.id.popupbutton) {
            popupMessage.showAsDropDown(popupButton, 0, 0);
        }
        else {
            popupMessage.dismiss();
        }
    }
}