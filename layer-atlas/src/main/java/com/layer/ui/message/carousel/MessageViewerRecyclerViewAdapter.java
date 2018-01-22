package com.layer.ui.message.carousel;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.layer.ui.message.model.MessageModel;
import com.layer.ui.message.viewer.MessageViewer;

import java.util.List;

class MessageViewerRecyclerViewAdapter extends RecyclerView.Adapter<MessageViewerRecyclerViewAdapter.ViewHolder> {
    private Context mContext;
    private List<MessageModel> mMessageModels;

    public MessageViewerRecyclerViewAdapter(Context context) {
        mContext = context;
    }

    public List<MessageModel> getMessageModels() {
        return mMessageModels;
    }

    public void setMessage(List<MessageModel> messageModels) {
        mMessageModels = messageModels;
    }

    @Override
    public int getItemViewType(int position) {
        MessageModel model = mMessageModels.get(position);

        return model.getRendererType().getCanonicalName().hashCode();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MessageViewer messageViewer = new MessageViewer(mContext);
        messageViewer.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));


        return new ViewHolder(messageViewer);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MessageModel model = mMessageModels.get(position);
        holder.bind(model);
    }

    @Override
    public int getItemCount() {
        return mMessageModels != null ? mMessageModels.size() : 0;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        MessageViewer mMessageViewer;

        ViewHolder(MessageViewer root) {
            super(root);
            mMessageViewer = root;
        }

        void bind(MessageModel model) {
            mMessageViewer.setModel(model);
        }
    }
}
