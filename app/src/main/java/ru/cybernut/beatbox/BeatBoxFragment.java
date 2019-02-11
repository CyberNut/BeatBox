package ru.cybernut.beatbox;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.cybernut.beatbox.databinding.FragmentBeatBoxBinding;
import ru.cybernut.beatbox.databinding.ListItemSoundBinding;

public class BeatBoxFragment extends Fragment {

    private BeatBox beatBox;

    public static Fragment newInstance() {
        return new BeatBoxFragment();
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        FragmentBeatBoxBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_beat_box, container, false);

        binding.recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        binding.recyclerView.setAdapter(new SoundAdapter());

        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        beatBox = new BeatBox(getActivity());
    }

    private class SoundHolder extends RecyclerView.ViewHolder {
        private ListItemSoundBinding binding;

        public SoundHolder(ListItemSoundBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    private class SoundAdapter extends RecyclerView.Adapter<SoundHolder> {

        @NonNull
        @Override
        public SoundHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            ListItemSoundBinding binding = DataBindingUtil.inflate(inflater, R.layout.list_item_sound, parent, false);
            return new SoundHolder(binding);
        }

        @Override
        public void onBindViewHolder(@NonNull SoundHolder soundHolder, int i) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }
    }
}
