package com.example.soldesk_paul.clipboardtest_1;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ClipboardTest_1 extends AppCompatActivity {
    private EditText editText_inputVoca;
    private Button button_SearchVoca, button_AddVoca;

    private ClipboardManager myClipboard;
    private ClipData myClip;

    Intent intent = getIntent();     // Intro.java로 부터 받은 Intent 값 얻기
    String intentVoca = intent.getStringExtra("intentVoca");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clipboard_test_1);

        editText_inputVoca = (EditText)findViewById(R.id.editText_inputVoca);    // activity_clipboard_test_1.xml 의 editText_inputVoca 을 매치 한다.
        button_SearchVoca = (Button)findViewById(R.id.button_SearchVoca);        // activity_clipboard_test_1.xml 의 button_SearchVoca 을 매치 한다.
        button_AddVoca = (Button)findViewById(R.id.button_AddVoca);             // activity_clipboard_test_1.xml 의 button_AddVoca 을 매치 한다.
        myClipboard = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);

        editText_inputVoca.setText(intentVoca);  // Intent를 통해 가져온 값을 EditView에 setText함.


        // 단어검색버튼 이벤트 발생
        button_SearchVoca.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {   // 클릭되어 지면실행. intro 에서 받아온 클릭보드 데이터를 세팅.
                String voca;   // 변수 선언
                voca = editText_inputVoca.getText().toString();  // text 변수에 (EditText)ed1의 텍스트값을 가져와 담는다.

                myClip = ClipData.newPlainText("text", voca); // text 변수에 있는 텍스트를 "text"로 맵핑한 주소값을 myClip에 담는다.
                myClipboard.setPrimaryClip(myClip);      // 클립 보드에 myClip 의 주소 값을 담는다.  단어검색으로 이 값사용.

                ClipData abc = myClipboard.getPrimaryClip();
                ClipData.Item item = abc.getItemAt(0);

                String text = item.getText().toString();

                Toast.makeText(getApplicationContext(), "단어검색으로",Toast.LENGTH_SHORT).show();
            }
        });
/*
            @Override      // 기존 함수 백업 클립 보드에 담아오는 방식.
            public void onClick(View v) {   // 클릭되어 지면
                String voca;   // 변수 선언
                voca = editText_inputVoca.getText().toString();  // text 변수에 (EditText)ed1의 텍스트값을 가져와 담는다.

                myClip = ClipData.newPlainText("text", voca); // text 변수에 있는 텍스트를 "text"로 맵핑한 주소값을 myClip에 담는다.
                myClipboard.setPrimaryClip(myClip);      // 클립 보드에 myClip 의 주소 값을 담는다.  단어검색으로 이 값사용.

                ClipData abc = myClipboard.getPrimaryClip();
                ClipData.Item item = abc.getItemAt(0);

                String text = item.getText().toString();




                Toast.makeText(getApplicationContext(), "Text Copied",Toast.LENGTH_SHORT).show();
            }
        });
*/

        button_AddVoca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipData abc = myClipboard.getPrimaryClip();     // 클립보드에 있는 데이터를 abc변수에 담는다.
                ClipData.Item item = abc.getItemAt(0);          //

                String text = item.getText().toString();    // 단어장에 추가할 단어의 String 타입 text 변수  이것을 넘겨 DB에 저장.

                /*sqlite3 의 쿼리문을 작성할 부분.
                *
                *
                * */

                Toast.makeText(getApplicationContext(), "단어장에 추가되었습니다",Toast.LENGTH_SHORT).show();
            }
        });
    }

   /* @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/
}
