package xhj.zime.com.draganddraw;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public abstract class SingleFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutRes());
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);
        if (fragment == null){
            fm.beginTransaction()
                    .add(R.id.fragment_container,createFragment())
                    .commit();
        }
    }

    protected abstract Fragment createFragment();

    @LayoutRes
    public int getLayoutRes() {
        return R.layout.activity_fragment;
    }
}
