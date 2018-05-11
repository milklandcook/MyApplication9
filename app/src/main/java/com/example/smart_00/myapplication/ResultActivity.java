package com.example.smart_00.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        setTitle("결과화면");

        // intent받은 값
        Intent intent = getIntent();
        int[] voteResult = intent.getIntArrayExtra("VoteCount");
        String[] imageName = intent.getStringArrayExtra("ImageName");

        //결과 표시하기위한 준비
        TextView[] tv= new TextView[imageName.length];
        RatingBar[] rbar = new RatingBar[imageName.length];

        //id찾기위한 준비
        Integer tvId[] = {R.id.tv1, R.id.tv2, R.id.tv3};
        Integer rbarId[] ={R.id.rbar1, R.id.rbar2, R.id.rbar3};
        //for문을 통해 찾기
        for(int i=0; i< voteResult.length; i++){
            tv[i]= (TextView) findViewById(tvId[i]);
            rbar[i]= (RatingBar) findViewById(rbarId[i]);
        }

        Button btnReturn = (Button) findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



        //결과찍기
        for(int i=0; i< voteResult.length; i++){
            tv[i].setText(imageName[i]); //그림 이름 찍기
            rbar[i].setRating((float) voteResult[i]);
        }

        //돌아가기
        //버튼 id찾기
        //버튼 클릭 이벤트 부여 ==> finish()
        //androidManifest.xml ==> 두번째꺼 코드 추가하기
        //별갯수는 xmL에서 numStars =숫자



    }
}
