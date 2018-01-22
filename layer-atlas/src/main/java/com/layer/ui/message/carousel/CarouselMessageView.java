package com.layer.ui.message.carousel;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.ViewGroup;

import com.layer.ui.message.container.EmptyMessageContainer;
import com.layer.ui.message.container.MessageContainer;
import com.layer.ui.message.container.StandardMessageContainer;
import com.layer.ui.message.view.MessageView;

public class CarouselMessageView extends MessageView<CarouselMessageModel> {
    private RecyclerView mRecyclerView;
    private MessageViewerRecyclerViewAdapter mAdapter;
    private CarouselMessageModel mModel;

    public CarouselMessageView(Context context) {
        this(context, null, 0);
    }

    public CarouselMessageView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CarouselMessageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mRecyclerView = new RecyclerView(context, attrs, defStyleAttr);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context,
                LinearLayoutManager.HORIZONTAL, false));
        mRecyclerView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));

        addView(mRecyclerView);
        mAdapter = new MessageViewerRecyclerViewAdapter(context);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void setMessageModel(CarouselMessageModel model) {
        mModel = model;
        mAdapter.setMessage(model.getCarouselItemModels());
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public Class<? extends MessageContainer> getContainerClass() {
        return EmptyMessageContainer.class;
    }
}
