package com.example.smart_00.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("선호도 투표");

        //배열선언==> 그림에 투표 카운트하기 위한 배열
        final int voteCount[] = new int[3];
        //배열에 값 초기화
        for (int i=0; i<3; i++){
            voteCount[i]=0;
        }

        //이미지 뷰 관련 배열 선언
        ImageView image[] = new ImageView[3];
        //이미지 뷰 id를 관리하기 위한 배열 ==> id찾기
        Integer ImageId[] = {R.id.iv1, R.id.iv2, R.id.iv3};
        //이미지 이름 관리하기 위한 배열
        final String imgName[] = {"독서하는소녀", "꽃장식모자소녀", "부채를 든소녀"};

        //각 이미지 뷰를 클릭했을때 처리하는 부분
        for(int i=0; i< ImageId.length; i++){
            final int index;
            index=i;
            //id찾기
            image[index] = (ImageView) findViewById(ImageId[index]);
            //기능 부여
            image[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    voteCount[index]++; //클릭할때마다 값 증가
                    Toast.makeText(getApplicationContext(), imgName[index] + ":총"
                            + voteCount[index] + "표", Toast.LENGTH_SHORT).show();
                }
            });
        }

        //투표 종료 버튼 ==> 기능 부여
        Button btnResult = (Button) findViewById(R.id.btnResult);
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(getApplicationContext(), ResultActivity.class);
                intent.putExtra("VoteCount", voteCount);
                intent.putExtra("ImageName", imgName);
                startActivity(intent);

            }
        });








    }
}
