package com.example.luwenjie02111.view.activity;

import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.example.luwenjie02111.R;
import com.example.luwenjie02111.model.bean.NewsBean;
import com.example.luwenjie02111.presenter.MainPresenter;
import com.example.luwenjie02111.view.adapter.NewsAdapter;
import com.example.luwenjie02111.view.interfaces.IMainView;

public class MainActivity extends BaseActivity implements IMainView<NewsBean>, SwipeRefreshLayout.OnRefreshListener {

    private RecyclerView recyclerView;
    private NewsAdapter newsAdapter;
    private MainPresenter mainPresenter;
    private int page = 1;
    private LinearLayoutManager linearLayoutManager;
    private ProgressBar progressBar;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected int bindView() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progress);
        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setOnRefreshListener(this);

    }

    @Override
    public void initData() {
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setLayoutManager(linearLayoutManager);
        newsAdapter = new NewsAdapter(this);
        recyclerView.setAdapter(newsAdapter);
        mainPresenter = new MainPresenter();
        mainPresenter.setView(this);
        mainPresenter.loadDataFromNet(page);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int visibleItemCount = linearLayoutManager.getChildCount();
                int totalItemCount = linearLayoutManager.getItemCount();
                int firstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                if (visibleItemCount + firstVisibleItemPosition >= totalItemCount) {
                    Log.e("myMessage", "firstVisibleItemPosition " + firstVisibleItemPosition);
                    //加载下一页
                    if (progressBar.getVisibility() != View.VISIBLE) {
                        loadMore();
                    }

                }

            }
        });
    }



    @Override
    public void onSuccess(final NewsBean newsBean) {
        progressBar.setVisibility(View.GONE);
        newsAdapter.setData(newsBean.getResults(), isRefreshing);
    }

    @Override
    public void onErr(String errMsg) {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.detachView();
    }

    private boolean isRefreshing;

    @Override
    public void onRefresh() {
        isRefreshing = true;
        page = 1;
        mainPresenter.loadDataFromNet(page);
        swipeRefreshLayout.setRefreshing(false);
    }

    private void loadMore() {
        isRefreshing = false;
        page++;
        mainPresenter.loadDataFromNet(page);
        progressBar.setVisibility(View.VISIBLE);
    }
}

