package com.layer.ui.message.carousel;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import com.layer.ui.message.container.EmptyMessageContainer;
import com.layer.ui.message.container.MessageContainer;
import com.layer.ui.message.container.StandardMessageContainer;
import com.layer.ui.message.model.MessageModel;
import com.layer.ui.message.view.MessageView;
import com.layer.ui.message.viewer.MessageViewer;

public class CarouselMessageView extends MessageView<CarouselMessageModel> {
    private HorizontalScrollView mScrollView;
    private LinearLayout mLinearLayout;

    private CarouselMessageModel mModel;

    public CarouselMessageView(Context context) {
        this(context, null, 0);
    }

    public CarouselMessageView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CarouselMessageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mScrollView = new HorizontalScrollView(context, attrs, defStyleAttr);
        mScrollView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        mLinearLayout = new LinearLayout(context, attrs, defStyleAttr);
        mLinearLayout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        mLinearLayout.setOrientation(LinearLayout.HORIZONTAL);

        mScrollView.addView(mLinearLayout);
        addView(mScrollView);
    }

    @Override
    public void setMessageModel(CarouselMessageModel carouselMessageModel) {
        mModel = carouselMessageModel;
        mLinearLayout.removeAllViews();

        for (MessageModel model : carouselMessageModel.getCarouselItemModels()) {
            MessageViewer messageViewer = new MessageViewer(getContext());
            messageViewer.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            messageViewer.bindModelToView(model);

            mLinearLayout.addView(messageViewer);
        }
    }

    @Override
    public Class<? extends MessageContainer> getContainerClass() {
        return EmptyMessageContainer.class;
    }
}
