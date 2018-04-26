package com.example.triumph.enunny.di.components;

import com.example.triumph.enunny.di.PerActivity;
import com.example.triumph.enunny.di.modules.ActivityModule;
import com.example.triumph.enunny.ui.base.BaseActivity;
import com.example.triumph.enunny.ui.menu.MainMenuView;
import com.example.triumph.enunny.ui.play.PlayView;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(PlayView activity);
    void inject(MainMenuView activity);

}
