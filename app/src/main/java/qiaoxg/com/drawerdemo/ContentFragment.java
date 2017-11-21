package qiaoxg.com.drawerdemo;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ContentFragment extends Fragment {

    private TextView contentTv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View parentView = inflater.inflate(R.layout.fragment_content, container, false);
        contentTv = (TextView) parentView.findViewById(R.id.content_fragment);
        String content = getArguments().getString("content");
        contentTv.setText(content);
        return parentView;
    }
}
