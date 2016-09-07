package com.example.soldesk_paul.clipboardtest_1;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Created by soldesk_paul on 2016-09-07.
 */
public class Intro extends AppCompatActivity implements View.OnLongClickListener {

    private ClipboardManager introClipboard;
    private ClipData introClip;
    private TextView intro_textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro);

        introClipboard = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
        intro_textView = (TextView)findViewById(R.id.intro_textView);

        intro_textView.setOnLongClickListener(this);



    }

    @Override
    public boolean onLongClick(View view) {

        String clipText;    // 이전 TextView 본문의 Text를 담을 변수선언

        clipText = intro_textView.getText().toString();  // clipText에 이전TextView 객체인 intro_textView를 담음.

        int startIndex = intro_textView.getSelectionStart(); // startIndex 에 선택한 텍스트의 첫번째 인덱스값 설정
        int endIndex = intro_textView.getSelectionEnd();  // endIndex 에 선택한 텍스트의 마지막 인덱스 값 설정.

        clipText = clipText.substring(startIndex,endIndex);   // clipText에 첫번째와 마지막 인덱스 값 지정.
        //introClip = ClipData.newPlainText("introClip",clipText);  // 뷰에서 가져온 텍스트를 "introClip"에 주소 맵핑
        //introClipboard.setPrimaryClip(introClip);   // 클립 보드에 introClip의 주소 값을 담는다.

        //ntroClipboard.setText(clipText);   // 클립보드 객체인 introClipboard 에 clipText 값 설정. 클립보드에 선택된 값이 올라간다.

        Log.i("Clipboard success" ,clipText.toString());

        Intent intent = new Intent(getApplicationContext(),ClipboardTest_1.class);
        intent.putExtra("intentVoca",clipText);
        //intent.putExtra("intent_voca",introClipboard.toString());
        startActivity(intent);
        return true;
    }

    /*@Override
    public void onPrimaryClipChanged() {
        String clipText;    // 이전 TextView 본문의 Text를 담을 변수선언

        clipText = intro_textView.getText().toString();  // clipText에 이전TextView 객체인 intro_textView를 담음.

        int startIndex = intro_textView.getSelectionStart(); // startIndex 에 선택한 텍스트의 첫번째 인덱스값 설정
        int endIndex = intro_textView.getSelectionEnd();  // endIndex 에 선택한 텍스트의 마지막 인덱스 값 설정.

        clipText = clipText.substring(startIndex,endIndex);   // clipText에 첫번째와 마지막 인덱스 값 지정.
        introClipboard.setText(clipText);   // 클립보드 객체인 introClipboard 에 clipText 값 설정. 클립보드에 선택된 값이 올라간다.


        *//*Intent intent = new Intent(getApplicationContext(),ClipboardTest_1.class);
        intent.putExtra(introClipboard);

        startActivity(intent);*//*
    }*/
}

