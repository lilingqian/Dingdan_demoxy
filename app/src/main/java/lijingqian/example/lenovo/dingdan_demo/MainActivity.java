package lijingqian.example.lenovo.dingdan_demo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import lijingqian.example.lenovo.dingdan_demo.adaper.MyViewpagerAdapter;
import lijingqian.example.lenovo.dingdan_demo.fragment.FragmentFour;
import lijingqian.example.lenovo.dingdan_demo.fragment.FragmentOne;
import lijingqian.example.lenovo.dingdan_demo.fragment.FragmentThree;
import lijingqian.example.lenovo.dingdan_demo.fragment.FragmentTwo;
import lijingqian.example.lenovo.dingdan_demo.presenter.MyPresenter;

public class MainActivity extends AppCompatActivity {

    /**
     * 待支付
     */
    private RadioButton mRaido01;
    /**
     * 已支付
     */
    private RadioButton mRaido02;
    /**
     * 已取消
     */
    private RadioButton mRaido03;
    private RadioGroup mGroup;
    private ViewPager mViewpager;
    private MyPresenter myPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        myPresenter = new MyPresenter();

        mGroup.setOnCheckedChangeListener(myPresenter);
        List<Fragment> list = new ArrayList<>();
        list.add(new FragmentOne());
        list.add(new FragmentTwo());
        list.add(new FragmentThree());
        list.add(new FragmentFour());

        myPresenter.setToast(new MyPresenter.ContentListeren() {
            @Override
            public void setContent(int i) {
                switch (i){
                    default:break;
                    case 0:
                        mViewpager.setCurrentItem(0,true);

                        break;
                    case 1:
                        mViewpager.setCurrentItem(1,true);

                        break;
                    case 2:
                        mViewpager.setCurrentItem(2,true);

                        break;
                    case 3:
                        mViewpager.setCurrentItem(3,true);

                        break;
                }
            }
        });
        MyViewpagerAdapter myViewpagerAdapter = new MyViewpagerAdapter(getSupportFragmentManager(),list);


        mViewpager.setAdapter(myViewpagerAdapter);
    }

    private void initView() {
        mRaido01 = (RadioButton) findViewById(R.id.raido01);
        mRaido02 = (RadioButton) findViewById(R.id.raido02);
        mRaido03 = (RadioButton) findViewById(R.id.raido03);
        mGroup = (RadioGroup) findViewById(R.id.group);
        mViewpager = (ViewPager) findViewById(R.id.viewpager);

    }
}

