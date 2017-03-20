package com.example.zhou.daggertest.data.entity;

import com.chad.library.adapter.base.entity.SectionEntity;

/**
 * Created by zhou on 2017/3/17.
 */

public class NewStory extends SectionEntity<Story>{
    public NewStory(boolean isHeader, String header) {
        super(isHeader, header);
    }

    public NewStory(Story story) {
        super(story);
    }
}
