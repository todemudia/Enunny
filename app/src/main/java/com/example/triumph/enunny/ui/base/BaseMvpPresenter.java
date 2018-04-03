package com.example.triumph.enunny.ui.base;

/**
 * Created by triumph on 25/03/2018.
 * Each presenter must implement this interface
 *
 * @param <V> View for the presenter
 */
public interface BaseMvpPresenter<V extends BaseView> {

    /**
     * Called when view attached to presenter
     *
     * @param view
     */
    void onAttach(V view);

    /**
     * Called when view is detached from presenter
     */
    void onDetach();

    /**
     * @return true if view is attached to presenter
     */
    boolean isAttached();
}
