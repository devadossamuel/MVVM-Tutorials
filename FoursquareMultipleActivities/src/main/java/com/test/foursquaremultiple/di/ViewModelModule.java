package com.test.foursquaremultiple.di;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.test.foursquaremultiple.viewmodel.VenueDetailViewModel;
import com.test.foursquaremultiple.viewmodel.VenueSearchViewModel;
import com.test.foursquaremultiple.viewmodel.VenueViewModelFactory;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(VenueSearchViewModel.class)
    public abstract ViewModel bindVenueSearchViewModel(VenueSearchViewModel venueListViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(VenueDetailViewModel.class)
    public abstract ViewModel bindVenueDetailViewModel(VenueDetailViewModel venueDetailViewModel);

    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(VenueViewModelFactory factory);
}
