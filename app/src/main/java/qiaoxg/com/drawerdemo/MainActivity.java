package qiaoxg.com.drawerdemo;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity implements DrawerLayout.DrawerListener {

    @BindView(R.id.ly_content)
    FrameLayout mDrawerContent;
    @BindView(R.id.drawerLayout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.mine_information)
    RelativeLayout mineInformation;
    @BindView(R.id.profit_rl)
    RelativeLayout profitRl;
    @BindView(R.id.account_rl)
    RelativeLayout accountRl;
    @BindView(R.id.ly_leftView)
    LinearLayout lyLeftView;
    @BindView(R.id.title_tv)
    TextView titleTv;

    private ContentFragment mMineFragment, mHomeFragment, mMessageFragment;
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mDrawerLayout.addDrawerListener(this);
        mFragmentManager = getFragmentManager();
        mineInformation.performClick();
    }

    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {

    }

    @Override
    public void onDrawerOpened(View drawerView) {

    }

    @Override
    public void onDrawerClosed(View drawerView) {

    }

    @Override
    public void onDrawerStateChanged(int newState) {

    }

    @OnClick({R.id.mine_information, R.id.profit_rl, R.id.account_rl})
    public void onViewClicked(View view) {
        String textString = "";
        Bundle args = new Bundle();
        switch (view.getId()) {
            case R.id.mine_information:
                textString = "我的信息";
                args.putString("content", textString);
                mMineFragment = new ContentFragment();
                mMineFragment.setArguments(args);
                mFragmentManager.beginTransaction().replace(R.id.ly_content, mMineFragment).commit();
                break;
            case R.id.profit_rl:
                textString = "收益";
                args.putString("content", textString);
                mHomeFragment = new ContentFragment();
                mHomeFragment.setArguments(args);
                mFragmentManager.beginTransaction().replace(R.id.ly_content, mHomeFragment).commit();
                break;
            case R.id.account_rl:
                textString = "账户";
                args.putString("content", textString);
                mMessageFragment = new ContentFragment();
                mMessageFragment.setArguments(args);
                mFragmentManager.beginTransaction().replace(R.id.ly_content, mMessageFragment).commit();
                break;
        }
        titleTv.setText(textString);
        mDrawerLayout.closeDrawer(lyLeftView);
    }
}
